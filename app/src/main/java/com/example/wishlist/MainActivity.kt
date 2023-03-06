package com.example.wishlist

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wislist.R

class MainActivity : AppCompatActivity(){

    private val items = mutableListOf<WishlistItem>()
    private lateinit var wishlistAdapter: WishlistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wishlistAdapter = WishlistAdapter(mutableListOf())
       // val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)

        val itemsRV = findViewById<View>(R.id.itemsRv) as RecyclerView

        wishlistAdapter = WishlistAdapter(items)
        itemsRV.adapter = wishlistAdapter
        itemsRV.layoutManager = LinearLayoutManager(this)
        //WishlistAdapter.setOnItemLongClickListener(this)
        val addButton = findViewById<Button>(R.id.addBtn)


        addButton.setOnClickListener {
            val price = findViewById<EditText>(R.id.etPrice).text.toString()
            val itemName = findViewById<EditText>(R.id.etName).text.toString()
            val link = findViewById<EditText>(R.id.etLink).text.toString()
            val item = WishlistItem(price, itemName, link)
            //items.add(item)
           wishlistAdapter.addItem(item)
          // wishlistAdapter.notifyDataSetChanged()

            findViewById<EditText>(R.id.etPrice).text.clear()
            findViewById<EditText>(R.id.etName).text.clear()
            findViewById<EditText>(R.id.etLink).text.clear()
        }


    }
  //  override fun onItemLongClick(position: Int) {
  //      items.removeAt(position)
   //     wishlistAdapter.notifyItemRemoved(position)
   // }
}
