package com.example.mycontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_view.view.*

class ContactAdapter(var items : ArrayList<Contact>, var clickedListener: OnContactClickedListener) : RecyclerView.Adapter<ContactViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        lateinit var contactViewHolder :ContactViewHolder
        // inflate layout
        contactViewHolder = ContactViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view, parent,false))
        return contactViewHolder
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
//        holder.contactName?.text = items.get(position).Name
//        holder.contactPhone?.text = items.get(position).PhoneNumber
//        holder.contactLogo.setImageResource(items.get(position).ProfileImage)

        holder.initialize(items.get(position),clickedListener)


    }

}

class ContactViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){
    var contactName = itemView.contactName
    var contactPhone = itemView.contactPhone
    var contactLogo = itemView.contactLogo

    fun initialize(items: Contact,action: OnContactClickedListener){
        contactName.text = items.Name
        contactPhone.text = items.PhoneNumber
        contactLogo.setImageResource(items.ProfileImage )

        itemView.setOnClickListener {
            action.onItemClicked(items,adapterPosition)
        }
    }
}

interface OnContactClickedListener{
    fun onItemClicked(items : Contact, position: Int )

}