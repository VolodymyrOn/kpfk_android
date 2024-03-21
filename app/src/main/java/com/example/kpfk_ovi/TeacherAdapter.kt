package com.example.kpfk_ovi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class TeacherAdapter(private val dataSet: ArrayList<TeacherModel>): RecyclerView.Adapter<TeacherAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val surnameTextView: TextView = view.findViewById(R.id.surnameTextView)
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val patronimicTextView: TextView = view.findViewById(R.id.patronimicTextView)

        val deleteImageView: ImageView = view.findViewById(R.id.deleteImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.teacher_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.surnameTextView.text = item.surname
        holder.nameTextView.text = item.name
        holder.patronimicTextView.text = item.patronimic


        holder.deleteImageView.setOnClickListener(){
            dataSet.remove(item)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, dataSet.size)
        }



    }

    override fun getItemCount() = dataSet.size
}
