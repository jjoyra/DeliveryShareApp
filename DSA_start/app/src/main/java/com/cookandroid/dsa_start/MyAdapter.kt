package com.cookandroid.dsa_start

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//class MyAdapter () :
//    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
//   private var items = mutableListOf<AddressTable>()

//    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val text = itemView.findViewById<TextView>(R.id.addressText)
//
//        fun bind(item : AddressTable) {
//            if (item.name4.isEmpty())
//                text.text = "${item.name1} ${item.name2} ${item.name3}"
//            else
//                text.text = "${item.name1} ${item.name2} ${item.name3} ${item.name4}"
//        }
//    }
//
//    override fun getItemCount(): Int = items.size
//
//
//    fun setItems(newItems : MutableList<AddressTable>) {
//        items = newItems
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val context = parent.context
//        val view = LayoutInflater.from(context).inflate(R.layout.set_address_view_holder, parent, false)
//        return MyViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.apply {
//            bind(items[position])
//        }
//    }

//}