package com.cookandroid.dsa_start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar

class FindIdActivity : AppCompatActivity(), View.OnClickListener {
    val idPhoneEt : EditText by lazy {
        findViewById<EditText>(R.id.idPhoneEt)
    }

    val idEmailEt : EditText by lazy {
        findViewById<EditText>(R.id.idEmailEt)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id)

        val findIdBtn = findViewById<Button>(R.id.findIdBtn)

        val findIdTb = findViewById<Toolbar>(R.id.findIdTb)
        setSupportActionBar(findIdTb)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findIdBtn.setOnClickListener(this)
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
            R.id.findIdTb -> {
                var idUserPhone = idPhoneEt.text.toString().toInt()
                var idUserEmail = idEmailEt.text.toString()

                //동적 텍스트뷰 생성
            }
        }
    }
}