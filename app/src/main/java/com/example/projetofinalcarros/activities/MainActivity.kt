package com.example.projetofinalcarros.activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import com.example.projetofinalcarros.R
import com.example.projetofinalcarros.domain.TipoCarro
import com.example.projetofinalcarros.extensions.setupToolbar
import com.example.projetofinalcarros.extensions.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.include_toolbar.*
import org.jetbrains.anko.startActivity
import com.example.projetofinalcarros.activities.CarrosActivity as CarrosActivity1

class MainActivity :BaseActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toolbar
        setupToolbar(R.id.toolbar)

        //menulateral
        setUpNavDrawer()

        //Botao FAB(+)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()

        }


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

       //Configuraçap do menu lateral

    private  fun setUpNavDrawer(){

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val toogle = ActionBarDrawerToggle(this,drawer_layout, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toogle)
        nav_view.setNavigationItemSelectedListener(this)


    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }




    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_item_carros_todos -> {
                toast("Clicou em carros")
            }
            //Classicos
            R.id.nav_item_carros_classicos -> {
                startActivity<CarrosActivity1>("tipo" to TipoCarro.Classicos)
//                toast("Clicou em carros classicos")
//                val intent = Intent(context,CarrosActivity::class.java)
//                intent.putExtra("tipo",TipoCarro.Classicos)
//                startActivity(intent)
            }

            //esportivos
            R.id.nav_item_carros_esportivos -> {
                startActivity<CarrosActivity1>("tipo" to TipoCarro.Esportivos)
//                toast("Clicou em carros esportivos")
//                val intent = Intent(context,CarrosActivity1::class.java)
//                intent.putExtra("tipo",TipoCarro.Esportivos)
//                startActivity(intent)
            }

            //Luxo
            R.id.nav_item_carros_luxo -> {
                startActivity<CarrosActivity1>("tipo" to TipoCarro.Luxo)
//                toast("Clicou em carrosluxo")
//                val intent = Intent(context,CarrosActivity1::class.java)
//                intent.putExtra("tipo",TipoCarro.Luxo)
//                startActivity(intent)
           }


            R.id.nav_item_site_livro -> {
                toast("Clicou em site do Livro")
            }
            R.id.nav_item_settings -> {
                toast("Clicou em configurações")
            }
        }

        //fecha menu depois de tratar o evento

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true

    }




    }



