package com.example.kpfk_ovi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class MenuActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ShopAdapter
    private val dataSet = arrayListOf<ShopModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val button=findViewById<Button>(R.id.button)
        val button2=findViewById<Button>(R.id.button2)
        val buttonAdd=findViewById<Button>(R.id.buttonAdd)
        val et=findViewById<EditText>(R.id.editText1)
        button.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }
        var handler: Handler = Handler()
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
            }
            if(et.text.toString()=="rec"){
                val intent = Intent(this, RecycleViewActivity::class.java)

                startActivity(intent)
            }
        }


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ShopAdapter(dataSet)
        recyclerView.adapter = adapter

        dataSet.addAll(arrayListOf(
            ShopModel("Shop 1", "Address 1", "1234567890", "9:00", "16:00"),
            ShopModel("Shop 2", "Address 2", "0987654321", "10:00", "17:00"),
            ShopModel("Shop 3", "Address 3", "0987654321", "10:00", "17:00"),
            ShopModel("Shop 4", "Address 4", "0987654321", "10:00", "17:00"),
            ShopModel("Shop 5", "Address 5", "0987654321", "10:00", "17:00")

        ))
        buttonAdd.setOnClickListener(){
            showAddShopDialog()
        }




    }


    private fun showAddShopDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_add_shop, null)
        val nameEditText = dialogView.findViewById<EditText>(R.id.nameEditText)
        val addressEditText = dialogView.findViewById<EditText>(R.id.addressEditText)
        val openEditText = dialogView.findViewById<EditText>(R.id.openEditText)
        val closeEditText = dialogView.findViewById<EditText>(R.id.closeEditText)
        val phoneNumberEditText = dialogView.findViewById<EditText>(R.id.phoneNumberEditText)

        builder.setView(dialogView)
            .setTitle("Add Shop")
            .setPositiveButton("Add") { dialog, which ->
                // Отримуємо дані з полів вводу та додаємо новий елемент у список
                val name = nameEditText.text.toString()
                val address = addressEditText.text.toString()
                val open = openEditText.text.toString()
                val close = closeEditText.text.toString()
                val phoneNumber = phoneNumberEditText.text.toString()


                // Додаємо новий елемент у список та оновлюємо RecyclerView
                dataSet.add(ShopModel(name, address, phoneNumber, open, close))
                adapter.notifyDataSetChanged()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                // Відміна додавання нового елементу
                dialog.cancel()
            }
            .show()
    }
}
