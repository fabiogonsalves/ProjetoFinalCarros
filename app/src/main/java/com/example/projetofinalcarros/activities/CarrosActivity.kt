package com.example.projetofinalcarros.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.projetofinalcarros.R
import com.example.projetofinalcarros.domain.TipoCarro
import com.example.projetofinalcarros.extensions.setupToolbar

class CarrosActivity : BaseActivity() {
    private var tipo: TipoCarro = TipoCarro.Classicos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)

        //configura toolbar
        setupToolbar(R.id.toolbar)

        //liga o up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //le o tipo dos argumentos
        this.tipo = intent.getSerializableExtra("tipo")as TipoCarro
        val s = context.getString((tipo.string))

        //mostra o tipo do carro da toolbar
        supportActionBar?.title =s


         // mostra o tipo do carro na tela
        val text = findViewById<TextView>(R.id.text)
        text.text = "Carros $s"
    }
}


