package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var tvImcRecup: TextView = findViewById(R.id.tvImcRecup)
        var result = intent.getFloatExtra("EXTRA_IMC", 0.1f)
        var tvClassific = findViewById<TextView>(R.id.tvClassific)

        tvImcRecup.text = result.toString()

        var classific = ""

        if(result < 18.5){
            classific = "Classificação: Magreza, procure um nutricionista."
        }else if(result >= 18.5f && result <= 24.9f){
            classific = "Classificação: Normal."
        }else if(result >= 25f && result <= 29.9f){
            classific = "Classificação: Sobrepeso, procure um nutricionista."
        }else if (result >= 30f && result <= 39.9f){
            classific = "Classificação: Obesidade, procure um nutricionista."
        }else{
            classific = "Classificação: Obesidade grave, procure um médio e um nutricionista."
        }

        tvClassific.text = classific

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}