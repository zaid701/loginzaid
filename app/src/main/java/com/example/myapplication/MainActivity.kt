package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db=openOrCreateDatabase("my_db",Context.MODE_PRIVATE,null)
        db.execSQL("CREATE TABLE IF NOT EXISTS user (fname TEXT,lname TEXT,email TEXT,pass TEXT);")
        button.setOnClickListener {
            if(!first.text.trim().length.equals(0)||!last.text.trim().length.equals(0)||!email.text.trim().length.equals(0)||!pass.text.trim().length.equals(0))
            db.execSQL("INSERT INTO user VALUES ('"+first.text.toString()+"','"+last.text.toString()+"','"+email.text.toString()+"','"+pass.text.toString()+"');")
            else
                Toast.makeText(this,"plss fill all field ",Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
            finish()
        }
    }
}