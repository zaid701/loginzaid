package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.database.getStringOrNull
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val db=openOrCreateDatabase("my_db", Context.MODE_PRIVATE,null)
        button3.setOnClickListener {
            if(!first2.text.trim().length.equals(0)||!last2.text.trim().length.equals(0))
            {
                val c:Cursor=db.rawQuery("SELECT pass FROM user WHERE email='"+first2.text.toString()+"';",null)
                if(c.moveToFirst()) {
                    if (!last2.text.toString().equals(c.getString(0).toString()))
                        Toast.makeText(this, "invalid password", Toast.LENGTH_SHORT).show()
                    else {
                        Toast.makeText(this, "login", Toast.LENGTH_SHORT).show()
                        val iintent=Intent(this,MainActivity3::class.java)
                        iintent.putExtra("email",first2.text.toString())
                        startActivity(iintent)
                    }
                }else
                    Toast.makeText(this, "pls register", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this,"plss fill all field", Toast.LENGTH_SHORT).show()

        }
    }
}