package com.example.kpfk_ovi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TeacherActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TeacherAdapter
    private val dataSet = arrayListOf<TeacherModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)
        val add=findViewById<Button>(R.id.button_add)
        val finish=findViewById<Button>(R.id.button_finish)

        finish.setOnClickListener{
            finish()
        }

        recyclerView = findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = TeacherAdapter(dataSet)
        recyclerView.adapter = adapter

        dataSet.addAll(arrayListOf(
            TeacherModel("Krasnychuk", "Ruslan", "Vitaliyovych" ),
            TeacherModel("Krasnychuk", "Victoriya", "Victorivna" ),
            TeacherModel("Kostyshyn", "Oksana", "Myhaylivna" )
        ))
        add.setOnClickListener(){
            showAddTeacherDialog()
        }


    }

    private fun showAddTeacherDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_add_teacher, null)
        val sEditText = dialogView.findViewById<EditText>(R.id.surnameEditText)
        val nEditText = dialogView.findViewById<EditText>(R.id.nameEditText)
        val pEditText = dialogView.findViewById<EditText>(R.id.patronimicEditText)

        builder.setView(dialogView)
            .setTitle("Add Teacher")
            .setPositiveButton("Add") { dialog, which ->
                // Отримуємо дані з полів вводу та додаємо новий елемент у список
                val surname = sEditText.text.toString()
                val name = nEditText.text.toString()
                val patronimic = pEditText.text.toString()


                // Додаємо новий елемент у список та оновлюємо RecyclerView
                dataSet.add(TeacherModel(surname, name, patronimic))
                adapter.notifyDataSetChanged()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                // Відміна додавання нового елементу
                dialog.cancel()
            }
            .show()
    }

    private fun showUpdateDialog(position: Int, teacherModel: TeacherModel) {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_add_teacher, null)

        val sEditText = dialogView.findViewById<EditText>(R.id.surnameEditText)
        val nEditText = dialogView.findViewById<EditText>(R.id.nameEditText)
        val pEditText = dialogView.findViewById<EditText>(R.id.patronimicEditText)

        // Встановлюємо існуючі значення в поля для вводу
        sEditText.setText(teacherModel.surname)
        nEditText.setText(teacherModel.name)
        pEditText.setText(teacherModel.patronimic)

        builder.setView(dialogView)
            .setTitle("Update Teacher")
            .setPositiveButton("Update") { dialog, which ->
                // Отримуємо оновлені дані з полів вводу
                val updatedSurname = sEditText.text.toString()
                val updatedName = nEditText.text.toString()
                val updatedPatronimic = pEditText.text.toString()

                // Оновлюємо елемент у списку
                val updatedTeacher = TeacherModel(updatedSurname, updatedName, updatedPatronimic)
                dataSet[position] = updatedTeacher
                adapter.notifyItemChanged(position)
            }
            .setNegativeButton("Cancel") { dialog, which ->
                // Відміна оновлення
                dialog.cancel()
            }
            .show()
    }

}