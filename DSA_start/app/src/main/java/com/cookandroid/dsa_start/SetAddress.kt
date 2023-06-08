package com.cookandroid.dsa_start

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.*
import java.io.IOException
import java.lang.reflect.InvocationTargetException
import java.util.*

 class SetAddress : AppCompatActivity() {
    //    val key = "F6AE73D1-0960-3558-9331-1A3439039BB2"
//    val url = "http://api.vworld.kr/req/address?service=address&request=getAddress&key=$key&point=좌표&format=xml&type=BOTH"
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    internal lateinit var mLocationRequest: LocationRequest
    var address = listOf("서울특별시", "중구", "명동")
    lateinit var addressTv : TextView
//    lateinit var setAdrRv : RecyclerView
    private val REQUEST_PERMISSION_LOCATION = 10
//    lateinit var filteredList : MutableList<AddressTable>
//    lateinit var adapter: MyAdapter
//    val AddressDB : AppDatabase by lazy {
//        Room.databaseBuilder(this, AppDatabase::class.java,"db").build()
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_address)

//        val assetManager = resources.assets
//        val inputStream = assetManager.open("AddressDB.txt")
//
//        inputStream.bufferedReader().readLines().forEach{
//            var token = it.split("\t")
//            var input = AddressTable(token[0].toLong(), token[1], token[2], token[3], token[4])
//            CoroutineScope(Dispatchers.Main).launch {
//                AddressDB.addressInterface().insert(input)
//            }
//        }
//
//        setAdrRv = findViewById(R.id.setAdrRv)
//        adapter = MyAdapter()
//        setAdrRv.adapter = adapter
//
//        filteredList = mutableListOf()

        addressTv = findViewById(R.id.addressText1)

        val findAdrBtn = findViewById<Button>(R.id.findAdrBtn)

        val adrTb = findViewById<Toolbar>(R.id.adrTb)
        setSupportActionBar(adrTb)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        mLocationRequest = LocationRequest.create().apply {
            interval = 40000
            priority = Priority.PRIORITY_HIGH_ACCURACY
        }

        if (checkPermissionForLocation(this)) {
            startLocationUpdates()
        }

        findAdrBtn.setOnClickListener{

        }

    }

    override fun onPause() {
        super.onPause()
        stopLocationUpdates()
    }

    private fun stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(mLocationCallback)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.adrTb -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "위치권한이 없습니다", Toast.LENGTH_SHORT).show()
            return
        }
        fusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper())
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            locationResult.lastLocation
            onLocationChanged(locationResult.lastLocation)
        }
    }

    private fun onLocationChanged(location : Location?) {
        var geocoder = Geocoder(this, Locale.KOREA)
        if (location != null) {
            try {
                val addrList = geocoder.getFromLocation(location.latitude, location.longitude, 3)
                val splitedAddr = addrList.get(0).getAddressLine(0).toString()
                address = splitedAddr.split(" ")
            } catch (e: IOException) {
                Toast.makeText(this, "null", Toast.LENGTH_SHORT).show()
            }

            var text = ""
            for (i in 1 until (address.size - 1)) {
                if (address[i].contains("-"))
                    break
                else
                    text += (address[i] + " ")
            }
            addressTv.text = text
        }
    }


//        AddressDB!!.addressInterface().searchDatabase(address[2]).observe(this, androidx.lifecycle.Observer {
//            filteredList.clear()
//            for (i in 0 until 11) {
//                filteredList.add(it[i])
//            }
//
//            adapter.setItems(filteredList)
//        })

//        if (address[4].contains("-"))
//            addressTv1.text = "${address[1]} ${address[2]} ${address[3]}"
//        else
//            addressTv1.text = "${address[1]} ${address[2]} ${address[3]} ${address[4]}"


    private fun checkPermissionForLocation(context : Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
            ) {
                true
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_PERMISSION_LOCATION)
                false
            }
        } else {
            true
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_LOCATION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationUpdates()
            } else {
                Toast.makeText(this, "권한이 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

}