package edu.uw.ischool.newart.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    // {{## BEGIN listView ##}}
    lateinit var lstItems : ListView
    val values = listOf("Moe", "Larry", "Curly")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lstItems = findViewById(R.id.lstItems)
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, android.R.id.text1, values)
        lstItems.adapter = adapter
    }
    // {{## END listView ##}}
}
