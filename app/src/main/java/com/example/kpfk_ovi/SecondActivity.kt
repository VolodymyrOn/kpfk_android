package com.example.kpfk_ovi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

@Suppress("DEPRECATION")
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val button=findViewById<Button>(R.id.button)
        val button2=findViewById<Button>(R.id.button2)
        val et=findViewById<EditText>(R.id.editText1)
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

        button2.setOnClickListener{
            if(et.text.toString()=="calc"){
                val intent = Intent(this, CalculatorActivity::class.java)

            startActivity(intent)
        }}

    }
}