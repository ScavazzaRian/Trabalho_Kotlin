package com.example.trabalho

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.userhome)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        configurarBotaoComecar()

        val profileButton: View = findViewById(R.id.nav_profile)

        profileButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)

            startActivity(intent)
        }
    }
    
    private fun configurarBotaoComecar() {
        val btnComecar1 = findViewById<Button>(R.id.btn_comecar_1)
        val btnComecar2 = findViewById<Button>(R.id.btn_comecar_2)
        val btnComecar3 = findViewById<Button>(R.id.btn_comecar_3)
        val btnComecar4 = findViewById<Button>(R.id.btn_comecar_4)

        val botoesComIds = listOf(
            btnComecar1 to 1,
            btnComecar2 to 2,
            btnComecar3 to 3,
            btnComecar4 to 4
        )

        botoesComIds.forEach { (btn, id) ->
            btn.setOnClickListener {
                val intent = Intent(this, ExerciseActivity::class.java)
                intent.putExtra("exercise_id", id)
                startActivity(intent)
            }
        }
    }

}