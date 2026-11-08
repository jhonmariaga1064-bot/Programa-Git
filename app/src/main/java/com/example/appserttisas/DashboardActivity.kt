package com.example.appserttisas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        findViewById<Button>(R.id.btnConsultaPlaca).setOnClickListener {
            startActivity(Intent(this, ConsultaPlacaActivity::class.java))
        }
    }
}