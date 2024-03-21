package com.example.kpfk_ovi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ParaAdapter(private val dataSet: ArrayList<ParaModel>, val callback: (Int)->Unit): RecyclerView.Adapter<ParaAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val DOWTextView: TextView = view.findViewById(R.id.DOWTextView)
        val numberTextView: TextView = view.findViewById(R.id.numberTextView)

        val deleteImageView: ImageView = view.findViewById(R.id.deleteImageView)
        val updateImageView: ImageView = view.findViewById(R.id.updateImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.para_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.nameTextView.text = item.name
        holder.DOWTextView.text = item.DOW
        holder.numberTextView.text = item.number.toString()


        holder.deleteImageView.setOnClickListener(){
            dataSet.remove(item)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, dataSet.size)
        }

        holder.updateImageView.setOnClickListener(){
            callback(position)
        }



    }

    override fun getItemCount() = dataSet.size
}

