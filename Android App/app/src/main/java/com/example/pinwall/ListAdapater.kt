package com.example.pinwall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapater(private val data: Array<Post>) :
    RecyclerView.Adapter<ListAdapater.MyHolder>() {

    class MyHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem)
    {
        var title: TextView = itemView.findViewById(R.id.title)
        var text: TextView = itemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.title.text = data[position].title
        holder.text.text = data[position].text
    }

}