package com.example.pinwall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_post.*
import kotlinx.android.synthetic.main.activity_main.*

class AddPostActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        var db = FirebaseFirestore.getInstance()


        ap_addBttn.setOnClickListener {
            var title = ap_titleBox.text.toString()
            var text = ap_contentBox.text.toString()
            addPost(db, title, text)
        }

        ap_cancelBttn.setOnClickListener {
            finish()
        }
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
        finish()
    }

}