package com.example.pinwall

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) { //beginning of the activity

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = FirebaseFirestore.getInstance()
        val pinList = initializePinList()

        //addPost(db, "hallo", "I just want to say hallo")
        //addPost(db, "ja", "I just want to say ja")

        rv_postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_postList.setHasFixedSize(true)
        rv_postList.adapter = ListAdapater(pinList)
    }

    private fun initializePinList(): ArrayList<Post> {
        return arrayListOf(
            Post(R.drawable.men, "Daeyoung", "Hello World!"),
            Post(R.drawable.women, "Yang Kyung", "你好，世界!"),
            Post(R.drawable.men, "Ivo Maag", "Hallo Welt"),
            Post(R.drawable.men, "Eunwoo", "안녕 세계!")
        )
    }

    private fun addPost(db: FirebaseFirestore, title: String, text: String) {
        val post: MutableMap<String, String> = HashMap()
        post["title"] = title
        post["text"] = text

        // Add a new document with a generated ID
        val TAG = "Message"
        db.collection("posts")
            .add(post)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    TAG,
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
            }
            .addOnFailureListener { e ->
                Log.w(
                    TAG,
                    "Error adding document",
                    e
                )
            }
    }
}