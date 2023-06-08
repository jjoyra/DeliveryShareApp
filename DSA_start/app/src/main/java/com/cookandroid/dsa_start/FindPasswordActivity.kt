package com.cookandroid.dsa_start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar

class FindPasswordActivity : AppCompatActivity(), View.OnClickListener {
    val pwIdEt : EditText by lazy {
        findViewById(R.id.pwIdEt)
    }

    val pwEmailEt : EditText by lazy {
        findViewById(R.id.pwEmailEt)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_password)

        val getEmailBtn = findViewById<Button>(R.id.getEmailBtn)

        val findPwTb = findViewById<Toolbar>(R.id.findPwTb)
        setSupportActionBar(findPwTb)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getEmailBtn.setOnClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.getEmailBtn -> {
                var pwUserId = pwIdEt.text.toString()
                var pwUserEmail = pwEmailEt.text.toString()

                //동적 텍스트뷰 생성
            }
        }
    }
}