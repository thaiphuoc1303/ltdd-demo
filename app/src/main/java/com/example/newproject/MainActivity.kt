package com.example.newproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import java.io.Console
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // anh xa
        val btnGetTime : Button = findViewById(R.id.btnGetTime)
        val tvTime : TextView = findViewById(R.id.tvTime)
        val list : ListView = findViewById(R.id.list)

        val strList = ArrayList<String>()
        val adapterView = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strList)

        list.adapter =adapterView
        val formatter = DateTimeFormatter.ofPattern("hh:mm:ss a")
        btnGetTime.setOnClickListener{
            val current = LocalDateTime.now()
            val formatted = current.format(formatter)
            tvTime.text=formatted

            strList.add(formatted)
            strList.removeAt(0)
            adapterView.notifyDataSetChanged()
        }
    }
}