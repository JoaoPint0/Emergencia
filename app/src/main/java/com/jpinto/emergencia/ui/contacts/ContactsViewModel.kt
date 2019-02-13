package com.jpinto.emergencia.ui.contacts

import androidx.lifecycle.ViewModel;
import com.jpinto.emergencia.repository.EmergencyRepository

class ContactsViewModel: ViewModel() {

    private val repository = EmergencyRepository().getInstance()

    val contacts = repository.getEmergencyContacts()
}
