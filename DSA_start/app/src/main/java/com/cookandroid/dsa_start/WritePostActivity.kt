package com.cookandroid.dsa_start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelStore
import kotlin.math.max

class WritePostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_post)

        val writePostTb = findViewById<Toolbar>(R.id.writePostTb)
        setSupportActionBar(writePostTb)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val items = resources.getStringArray(R.array.optionArray)
        val myAdapter = ArrayAdapter(this, R.layout.spinner_layout, items)


        spinner.adapter = myAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when(position) {
                    0 -> {

                    }
                    1 -> {

                    }
                    2 -> {

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        val minBtn = findViewById<ImageButton>(R.id.minusBtn)
        val plusBtn = findViewById<ImageButton>(R.id.plusBtn)
        var number =2
        val maxText = findViewById<TextView>(R.id.maxText)

        minBtn.setOnClickListener{
            if (number > 2) {
                number--
                maxText.setText(number.toString())
            }
        }
        plusBtn.setOnClickListener{
            if (number < 4) {
                number++
                maxText.setText(number.toString())
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.write_post_tb, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.home -> {
                finish()
                return true
            }
            R.id.submitBtn -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }
}