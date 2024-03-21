package com.example.kpfk_ovi

import android.annotation.SuppressLint
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
        val para=findViewById<Button>(R.id.button_para)
        val teacher=findViewById<Button>(R.id.button_teacher)
        //val buttonAdd=findViewById<Button>(R.id.buttonAdd)
        val et=findViewById<EditText>(R.id.editText1)

        para.setOnClickListener{
            val intent = Intent(this, ParaActivity::class.java)
            startActivity(intent)
        }

        teacher.setOnClickListener{
            val intent = Intent(this, TeacherActivity::class.java)
            startActivity(intent)
        }


        button.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }
        var handler: Handler = Handler()
        handler.postDelayed({
            Toast.makeText(this, getString(R.string._3), Toast.LENGTH_SHORT).show()
        }, 1000)
        handler.postDelayed({
            Toast.makeText(this, getString(R.string._2), Toast.LENGTH_SHORT).show()
        }, 1000)
        handler.postDelayed({
            Toast.makeText(this, getString(R.string._1), Toast.LENGTH_SHORT).show()
        }, 1000)
        handler.postDelayed({
            Toast.makeText(this, getString(R.string.Welcome_), Toast.LENGTH_SHORT).show()
        }, 1000)

        button2.setOnClickListener{
            if(et.text.toString()== getString(R.string.calc)){
                val intent = Intent(this, CalculatorActivity::class.java)

                startActivity(intent)
            }
            if(et.text.toString()== getString(R.string.rec)){
                val intent = Intent(this, RecycleViewActivity::class.java)

                startActivity(intent)
            }
        }


        //recyclerView = findViewById(R.id.recyclerView)
        //recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ShopAdapter(dataSet)
        //recyclerView.adapter = adapter

        dataSet.addAll(arrayListOf(
            ShopModel("Shop 1", "Address 1", "1234567890", "9:00", "16:00"),
            ShopModel("Shop 2", "Address 2", "0987654321", "10:00", "17:00"),
            ShopModel("Shop 3", "Address 3", "0987654321", "10:00", "17:00"),
            ShopModel("Shop 4", "Address 4", "0987654321", "10:00", "17:00"),
            ShopModel("Shop 5", "Address 5", "0987654321", "10:00", "17:00")

        ))
       /* buttonAdd.setOnClickListener(){
            showAddShopDialog()
        }*/




    }


    @SuppressLint("NotifyDataSetChanged")
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
            .setTitle(getString(R.string.add_shop))
            .setPositiveButton("Add") { dialog, which ->

                val name = nameEditText.text.toString()
                val address = addressEditText.text.toString()
                val open = openEditText.text.toString()
                val close = closeEditText.text.toString()
                val phoneNumber = phoneNumberEditText.text.toString()



                dataSet.add(ShopModel(name, address, phoneNumber, open, close))
                adapter.notifyDataSetChanged()
            }
            .setNegativeButton("Cancel") { dialog, which ->

                dialog.cancel()
            }
            .show()
    }
}
