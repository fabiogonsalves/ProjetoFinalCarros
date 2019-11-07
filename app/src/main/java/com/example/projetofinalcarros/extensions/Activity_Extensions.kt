package com.example.projetofinalcarros.extensions
import android.app.Activity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle


import androidx.appcompat.widget.Toolbar

import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

//findviewbyid + setonclicklistener
fun Activity.onClick(@IdRes viewId: Int, onClick:(v: android.view.View?)->Unit){
    val view = findViewById<View>(viewId)
    view.setOnClickListener {onClick(it)}
}

// mostra um toast
fun Activity.toast(message: CharSequence,length:Int = LENGTH_SHORT)= Toast.makeText(this, message,length).show()
fun Activity.toast(@StringRes message: Int, length: Int= Toast.LENGTH_SHORT)= Toast.makeText(this,message,length).show()

//configura toolbar
fun AppCompatActivity.setupToolbar(@IdRes id: Int, title:String? = null, upNavigation: Boolean = false): ActionBar {

    val toolbar =findViewById<Toolbar>(id)
    setSupportActionBar(toolbar)
    if (title != null){
        supportActionBar?.title = title
    }
    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)
    return supportActionBar!!
}
//Adiciona o fragmento no layout
fun AppCompatActivity.addFragment(@IdRes layoutId: Int, fragment: Fragment){

    fragment.arguments = intent.extras
    val ft = supportFragmentManager.beginTransaction()
    ft.add(layoutId, fragment)
    ft.commit()
}