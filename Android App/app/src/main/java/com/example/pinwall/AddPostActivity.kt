package com.example.pinwall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_post.*
import kotlinx.android.synthetic.main.activity_main.*

class AddPostActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        ap_addBttn.setOnClickListener {

        }

        ap_cancelBttn.setOnClickListener {
            finish()
        }
    }

}