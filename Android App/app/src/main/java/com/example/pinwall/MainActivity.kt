package com.example.pinwall

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_post.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) { //beginning of the activity

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = FirebaseFirestore.getInstance()
        val posts = loadPosts(db)
        //val pinList = initializePinList(posts)

        addPostBttn.setOnClickListener {
            var intent = Intent(this, AddPostActivity::class.java) //move to add screen intent obj

            startActivity(intent)
        }

        updateLayout(posts)


    }

    fun updateLayout(posts: ArrayList<Post>) {
        rv_postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_postList.setHasFixedSize(true)
        rv_postList.adapter = ListAdapater(posts)
    }



    private fun loadPosts(db: FirebaseFirestore) : ArrayList<Post> {
        var posts = ArrayList<Post>()
        val TAG = "Message"

        db.collection("posts")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    val title = document.data.get("title").toString()
                    val text =document.data.get("text").toString()
                    val post = Post(title, text)
                    posts.add(post)
                    updateLayout(posts)
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
        return posts
    }
}
