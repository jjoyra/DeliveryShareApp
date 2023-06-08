package com.cookandroid.dsa_start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.widget.Toolbar

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    val signUpIdEt : EditText by lazy {
        findViewById(R.id.signUpIdEt)
    }

    val signUpPwEt : EditText by lazy {
        findViewById(R.id.signUpPwEt)
    }

    val signUpNameEt : EditText by lazy {
        findViewById(R.id.signUpNameEt)
    }

    val signUpNNameEt : EditText by lazy {
        findViewById(R.id.signUpNNameEt)
    }

    val signUpPhoneEt : EditText by lazy {
        findViewById(R.id.signUpPhoneEt)
    }

    val signUpEmailEt : EditText by lazy {
        findViewById(R.id.signUpEmailEt)
    }

    val wRb : RadioButton by lazy {
        findViewById(R.id.wRb)
    }

    val mRb : RadioButton by lazy {
        findViewById(R.id.mRb)
    }

    lateinit var userId : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val idChkBtn = findViewById<Button>(R.id.idChkBtn)
        val nNameChkBtn = findViewById<Button>(R.id.nNameChkBtn)
        val finishBtn = findViewById<Button>(R.id.finishBtn)

        val signUpTb = findViewById<Toolbar>(R.id.signUpTb)
        setSupportActionBar(signUpTb)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        idChkBtn.setOnClickListener(this)
        nNameChkBtn.setOnClickListener(this)
        finishBtn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.idChkBtn -> {
                userId = signUpIdEt.text.toString()
                var idChk =false

            }
            R.id.nNameChkBtn -> {
                var userNName = signUpNNameEt.text.toString()
                var nNameChk = false
            }
            R.id.finishBtn -> {
                var userPw = signUpPwEt.text.toString()
                var userName = signUpNameEt.text.toString()
                var userPhone = signUpPhoneEt.text.toString()
                var userEmail = signUpEmailEt.text.toString()

                val finishIntent = Intent(this, SetAddress::class.java)
                startActivity(finishIntent)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home -> {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item)
    }
}