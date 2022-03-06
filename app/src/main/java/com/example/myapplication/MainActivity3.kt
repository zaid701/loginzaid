package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val s: String? =intent.getStringExtra("email")
        Toast.makeText(this,"wel-come $s",Toast.LENGTH_SHORT).show()
        textView7.text=s
        button4.setOnClickListener {
            finish()
        }
    }
}