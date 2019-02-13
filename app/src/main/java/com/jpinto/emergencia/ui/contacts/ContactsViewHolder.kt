package com.jpinto.emergencia.ui.contacts

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getDrawable
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.jpinto.emergencia.R
import com.jpinto.emergencia.model.Contact
import kotlinx.android.synthetic.main.contact_view_item.view.*

class ContactsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(contact: Contact?) {
        if (contact == null) {
            val resources = itemView.resources
            view.name.text = resources.getString(R.string.loading)
        } else {
            showRepoData(contact)
        }
    }

    private fun showRepoData(contact: Contact) {

        setFavoriteIcon(contact.favorite)

        view.apply {
            name.text = contact.name
            number.text = contact.number.toString()
            call_number.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact.number.toString()))
                startActivity(it.context, intent, null)
            }
            favorite.setOnClickListener {
                contact.favorite = contact.favorite.not()
                setFavoriteIcon(contact.favorite)
            }
        }
    }

    private fun setFavoriteIcon(isFavorite: Boolean) {

        view.favorite.setImageDrawable(getDrawable(view.context, if(isFavorite) R.drawable.ic_star else R.drawable.ic_empty_star))
    }

    companion object {
        fun create(parent: ViewGroup): ContactsViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.contact_view_item, parent, false)
            return ContactsViewHolder(view)
        }
    }
}