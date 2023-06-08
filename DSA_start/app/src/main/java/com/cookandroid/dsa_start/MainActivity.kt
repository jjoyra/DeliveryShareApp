package com.cookandroid.dsa_start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startBtn)
        startBtn.setOnClickListener(this)

        val loginText = findViewById<TextView>(R.id.loginText)
        loginText.setOnClickListener(this)

        val testBtn = findViewById<TextView>(R.id.testBtn)
        testBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.startBtn -> {
                val startIntent = Intent(this, SignUpActivity::class.java)
                startActivity(startIntent)
            }
            R.id.loginText -> {
                val loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
            }
            R.id.testBtn -> {
                val testIntent = Intent(this, WritePostActivity::class.java)
                startActivity(testIntent)
            }
        }
    }
}

