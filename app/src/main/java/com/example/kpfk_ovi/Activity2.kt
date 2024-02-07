package com.example.kpfk_ovi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast

@Suppress("DEPRECATION")
class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener{
            finish()
        }
        var handler= Handler()
        handler.postDelayed({
            Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()
        }, 1000)
        handler.postDelayed({
            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
        }, 1000)
        handler.postDelayed({
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
        }, 1000)
        handler.postDelayed({
            Toast.makeText(this, "Вітаю", Toast.LENGTH_SHORT).show()
        }, 1000)
    }
}