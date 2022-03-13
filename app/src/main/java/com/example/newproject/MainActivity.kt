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
        //tao mang du lieu
        val strList = ArrayList<String>()
        //tao adapter
        val adapterView = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strList)
        //gan adapter cho listview
        list.adapter =adapterView
        //tao Datetime format
        val formatter = DateTimeFormatter.ofPattern("hh:mm:ss a")
        //Set su kien cho button
        btnGetTime.setOnClickListener{
            //lay gio hien tai
            val current = LocalDateTime.now()
            val formatted = current.format(formatter)
            //gan du lieu cho TextView
            tvTime.text=formatted
            //them du lieu vao mang
            strList.add(formatted)
            //cap nhat adapter
            adapterView.notifyDataSetChanged()
        }
    }
}