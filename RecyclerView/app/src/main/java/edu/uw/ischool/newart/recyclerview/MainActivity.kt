package edu.uw.ischool.newart.recyclerview

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// This is our "data"
//val items = (1..50).toList().map { "Item #$it" }

data class Person(val firstName : String, val lastName : String, val age : Int)
val items = listOf(
        Person("Ted", "Neward", 50),
        Person("Michael", "Neward", 30),
        Person("Gandalf", "Stormcrow", 679),
        Person("Thorin", "Oakenshield", 84),
        Person("Bilbo", "Baggins", 101),
        Person("Bifur", "Erebor", 97),
        Person("Dori", "Erebor", 124),
        Person("Ori", "Erebor", 24),
        Person("Bombur", "Erebor", 83),
        Person("Gloin", "Erebor", 124),
        Person("Nori", "Erebor", 124),
        Person("Oin", "Erebor", 128),
        Person("Fili", "Erebor", 54),
        Person("Kili", "Erebor", 44),
        Person("Dwalin", "Erebor", 44),
        Person("Bofur", "Erebor", 64),
        Person("Balin", "Erebor", 145),
    )

// This is our per-row item UI
class ItemHolder(view: View): RecyclerView.ViewHolder(view) {
    var textField: TextView = view.findViewById(android.R.id.text1)
}

// This is our simplest-possible Recycler adapter
class ItemAdapter(val activity : Activity) : RecyclerView.Adapter<ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).
            inflate(android.R.layout.simple_list_item_1, parent, false))
    }
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.textField.text = "${items[position].firstName} ${items[position].lastName}"
        holder.textField.setOnClickListener {
            Toast.makeText(activity, "Clicked $position : ${items[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}

class MainActivity : AppCompatActivity() {
    lateinit var rvItems : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvItems = findViewById(R.id.rvItems)
        rvItems.layoutManager = LinearLayoutManager(this)
        rvItems.adapter = ItemAdapter(this)
    }
}