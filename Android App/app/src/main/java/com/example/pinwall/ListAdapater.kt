package com.example.pinwall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListAdapater(private val postList: ArrayList<Post>) :
    RecyclerView.Adapter<ListAdapater.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyHolder(view).apply {
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition
                val post: Post = postList.get(curPos)
                Toast.makeText(parent.context, "Title: ${post.title}, Content: ${post.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.title.text = postList[position].title
        holder.text.text = postList[position].text
    }


    class MyHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem)
    {
        var title: TextView = itemView.findViewById(R.id.tv_title)  //title
        var text: TextView = itemView.findViewById(R.id.tv_content)  //content
    }

}

