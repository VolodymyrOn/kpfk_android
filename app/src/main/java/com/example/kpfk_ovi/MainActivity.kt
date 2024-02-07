package com.example.kpfk_ovi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text_view=findViewById<TextView>(R.id.textView)
        val draw=findViewById<ImageView>(R.id.imageView1)
        draw.setOnClickListener{
            text_view.text="Bull"
        }

        text_view.setOnClickListener{
        if(text_view.text=="Bull"){
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }
            else{
                Toast.makeText(this, "Натисни на бика", Toast.LENGTH_SHORT).show()
            }
        }

    }
}