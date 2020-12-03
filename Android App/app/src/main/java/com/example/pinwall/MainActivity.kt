package com.example.pinwall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) { //beginning of the activity

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = FirebaseFirestore.getInstance()


        val pinList = arrayListOf(
            Post(R.drawable.men, "Daeyoung", "Hello World!"),
            Post(R.drawable.women, "Yang Kyung", "你好，世界!"),
            Post(R.drawable.men, "Ivo Maag", "Hallo Welt"),
            Post(R.drawable.men, "Eunwoo", "안녕 세계!")

        )


        rv_postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_postList.setHasFixedSize(true)

        rv_postList.adapter = ListAdapater(pinList)
    }


}