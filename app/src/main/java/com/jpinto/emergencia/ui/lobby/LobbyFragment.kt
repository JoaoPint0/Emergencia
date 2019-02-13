package com.jpinto.emergencia.ui.lobby

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jpinto.emergencia.databinding.LobbyFragmentBinding
import com.jpinto.emergencia.ui.contacts.ContactsListAdapter
import com.jpinto.emergencia.ui.contacts.ContactsViewModel
import com.jpinto.emergencia.viewmodel.LocationViewModel


class LobbyFragment : Fragment() {

    companion object {
        fun newInstance() = LobbyFragment()
    }
    private lateinit var locationViewModel: LocationViewModel
    private lateinit var contactsViewModel: ContactsViewModel
    private lateinit var binding: LobbyFragmentBinding
    private val adapter = ContactsListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = LobbyFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        locationViewModel = ViewModelProviders.of(activity!!).get(LocationViewModel::class.java)
        binding.viewmodel = locationViewModel

        //contacts_list.adapter = adapter
        //contacts_list.layoutManager = LinearLayoutManager(context)

        contactsViewModel = ViewModelProviders.of(this).get(ContactsViewModel::class.java)
        contactsViewModel.contacts.observe(this, Observer {
            adapter.setContacts(it)
        })
    }
}
