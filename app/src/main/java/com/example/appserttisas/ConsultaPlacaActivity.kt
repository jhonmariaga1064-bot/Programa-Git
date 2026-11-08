package com.example.appserttisas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Vehiculo(
    val propietario: String,
    val marca: String,
    val modelo: String,
    val soat: String,
    val tecnomecanica: String,
    val multas: String
)

class ConsultaPlacaActivity : AppCompatActivity() {

    private val vehiculos = mapOf(
        "ABC123" to Vehiculo("Juan Pérez", "Chevrolet", "Spark 2019", "Vigente", "Vigente", "Sin multas"),
        "XYZ789" to Vehiculo("María Gómez", "Renault", "Logan 2017", "Vencido", "Vigente", "1 multa pendiente"),
        "DEF456" to Vehiculo("Carlos Ruiz", "Yamaha", "FZ 2020", "Vigente", "Vencida", "Sin multas")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_placa)

        val etPlaca = findViewById<EditText>(R.id.etPlaca)
        val btnConsultar = findViewById<Button>(R.id.btnConsultar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnConsultar.setOnClickListener {
            val placa = etPlaca.text.toString().trim().uppercase()

            if (placa.isEmpty()) {
                etPlaca.error = "Escriba la placa"
                return@setOnClickListener
            }

            val v = vehiculos[placa]
            tvResultado.text = if (v != null) {
                "Placa: $placa\n" +
                        "Propietario: ${v.propietario}\n" +
                        "Marca: ${v.marca}\n" +
                        "Modelo: ${v.modelo}\n" +
                        "SOAT: ${v.soat}\n" +
                        "Tecnomecánica: ${v.tecnomecanica}\n" +
                        "Multas: ${v.multas}"
            } else {
                "No se encontró ningún vehículo con la placa $placa"
            }
        }
    }
}