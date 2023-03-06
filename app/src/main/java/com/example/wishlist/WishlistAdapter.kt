package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.wislist.R


class WishlistAdapter (private val items: MutableList<WishlistItem>) : RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder>() {


    //private var onItemLongClickListener: OnItemLongClickListener? = null

    inner class WishlistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val priceTextView: TextView = itemView.findViewById<TextView>(R.id.priceText)
        val itemNameTextView: TextView = itemView.findViewById<TextView>(R.id.itemText)
        val linkTextView: TextView = itemView.findViewById<TextView>(R.id.linkText)


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistViewHolder {
            return WishlistViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.wishlist_item, parent, false)
            )
        }

        fun addItem(item: WishlistItem) {
            items.add(item)
            notifyItemInserted(items.size - 1)
        }

     //   fun removeItem(item: WishlistItem) {
    //        items.remove(item)
    //        notifyItemRemoved(items.size + 1)
     //   }


        override fun onBindViewHolder(holder: WishlistViewHolder, position: Int, ) {
            val newItem = items[position]
            // holder.itemView.apply {
            holder.priceTextView.text = newItem.price
            holder.itemNameTextView.text = newItem.itemName
            holder.linkTextView.text = newItem.link
           // holder.itemView.setOnLongClickListener(){
             //   fun boolean onLongClick (View view)
           // }
        }

        override fun getItemCount(): Int {
            return items.size
        }





    }
