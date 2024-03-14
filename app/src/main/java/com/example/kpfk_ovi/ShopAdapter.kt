package com.example.kpfk_ovi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent

class ShopAdapter(private val dataSet: ArrayList<ShopModel>): RecyclerView.Adapter<ShopAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val addressTextView: TextView = view.findViewById(R.id.addressTextView)
        val phoneNumberTextView: TextView = view.findViewById(R.id.phoneNumberTextView)
        val openTextView: TextView = view.findViewById(R.id.openTextView)
        val closeTextView: TextView = view.findViewById(R.id.closeTextView)
        val background: LinearLayout = view.findViewById(R.id.backgroundLinerLayout)
        val deleteImageView: ImageView = view.findViewById(R.id.deleteImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.nameTextView.text = item.name
        holder.addressTextView.text = item.address
        holder.phoneNumberTextView.text = item.phoneNumber
        holder.openTextView.text = item.open
        holder.closeTextView.text = item.close

        holder.deleteImageView.setOnClickListener(){
            dataSet.remove(item)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, dataSet.size)
        }



    }

    override fun getItemCount() = dataSet.size
}