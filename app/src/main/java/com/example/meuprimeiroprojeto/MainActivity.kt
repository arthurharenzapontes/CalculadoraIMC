package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btCalcular: Button = findViewById(R.id.btCalcular)
        var edtPeso: EditText = findViewById(R.id.edtPeso)
        var edtAltura:EditText = findViewById(R.id.edtAltura)

        btCalcular.setOnClickListener {

                var alturaStr = edtAltura.text.toString()
                var pesoStr = edtPeso.text.toString()

            if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                var altura: Float = alturaStr.toFloat()
                var alturaFinal: Float = altura * altura
                var peso: Float = pesoStr.toFloat()
                var imc: Float = peso / alturaFinal


                if (imc < 18.5) {
                    println("Magro, procure um nutricionista.")
                } else if (imc >= 18.5f && imc <= 24.9f) {
                    println("Normal.")
                } else if (imc >= 25f && imc <= 29.9f) {
                    println("Sobrepeso, procure um nutricionista.")
                } else if (imc >= 30f && imc <= 39.9f) {
                    println("Obesidade, procure um nutricionista.")
                } else {
                    println("Obesidade grave, procure um médio e um nutricionista.")
                }

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_IMC", imc)
                    }
                startActivity(intent)
            }else{
                Toast.makeText(this, "Preencha os campos.", Toast.LENGTH_LONG).show()
            }

        }
    }
}