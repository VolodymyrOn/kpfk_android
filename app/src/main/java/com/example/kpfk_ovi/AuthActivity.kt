package com.example.kpfk_ovi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        val reg=findViewById<Button>(R.id.button_reg)
        val auth=findViewById<Button>(R.id.button_auth)
        val et1=findViewById<EditText>(R.id.editTextText)
        val et2=findViewById<EditText>(R.id.editTextTextPassword)
        val sharedPreferences = getSharedPreferences(Const.MY_PREFS, Context.MODE_PRIVATE)
        val login = sharedPreferences.getString(Const.LOGIN, "")
        val password = sharedPreferences.getString(Const.PASSWORD, "")

        reg.setOnClickListener{
                val intent = Intent(this, RegistrationActivity::class.java)
                startActivity(intent)
            }

        auth.setOnClickListener{
            if(et1.text.toString()==""||et2.text.toString()==""){
                Toast.makeText(this, getString(R.string.clear_input_error), Toast.LENGTH_SHORT).show()
            }
            else if(login==et1.text.toString()&&password==et2.text.toString()){
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
            }
            else{
                Toast.makeText(this, getString(R.string.log_or_pass_error), Toast.LENGTH_SHORT).show()
            }
        }
    }
}