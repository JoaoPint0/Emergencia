package com.jpinto.emergencia.ui.contacts

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jpinto.emergencia.model.Contact

class ContactsListAdapter : RecyclerView.Adapter<ContactsViewHolder>() {

    private var contacts: List<Contact> = emptyList()

    fun setContacts(contacts: List<Contact>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {

        if (contacts.isNotEmpty()) {
            val payment = contacts[position]
            holder.bind(payment)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        return ContactsViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}