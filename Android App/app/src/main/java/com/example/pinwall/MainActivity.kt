package com.example.pinwall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.list_component.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        val postList = addDemoPosts()

        val listItems = arrayOfNulls<String>(postList.size)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0 until postList.size) {
            val post = postList[i]
            listItems[i] = post.title
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        pinList.adapter = adapter

    }



    fun addDemoPosts(): ArrayList<Post> {
        val postList = arrayListOf<Post>()
        postList.add(Post("hallo", "i bims"))
        postList.add(Post("hallo2", "i bims2"))
        postList.add(Post("hallo3", "i bims3"))
        return postList
    }



}