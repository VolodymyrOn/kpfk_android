package com.example.kpfk_ovi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class ParaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ParaAdapter
    private val dataSet = arrayListOf<ParaModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_para)

        val add=findViewById<Button>(R.id.button_add)
        val finish=findViewById<Button>(R.id.button_finish)

        finish.setOnClickListener{
            finish()
        }

        recyclerView = findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ParaAdapter(dataSet)
        recyclerView.adapter = adapter

        dataSet.addAll(arrayListOf(
            ParaModel("Основи маркетингу", "Середа", 5 ),
            ParaModel("ОКМ", "Четвер", 3 ),
            ParaModel("ОКМ", "Четвер", 4 )
        ))
        add.setOnClickListener(){
          //  showAddParaDialog()
        }
    }

    private fun showAddParaDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_add_para, null)
        val nEditText = dialogView.findViewById<EditText>(R.id.nameEditText)
        val dowEditText = dialogView.findViewById<EditText>(R.id.DOWEditText)
        val numEditText = dialogView.findViewById<EditText>(R.id.numberEditText)

        builder.setView(dialogView)
            .setTitle("Add Para")
            .setPositiveButton("Add") { dialog, which ->
                val name = nEditText.text.toString()
                val DOW = nEditText.text.toString()
                val number = numEditText.text.toString().toInt()


                dataSet.add(ParaModel(name, DOW, number))
                adapter.notifyDataSetChanged()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                // Відміна додавання нового елементу
                dialog.cancel()
            }
            .show()
    }
}




