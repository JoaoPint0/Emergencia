package com.jpinto.emergencia.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.jpinto.emergencia.Constants
import com.jpinto.emergencia.model.Contact

class EmergencyRepository {

    private val TAG = EmergencyRepository::class.simpleName
    private val db = FirebaseFirestore.getInstance()

    @Volatile
    private var instance: EmergencyRepository? = null

    fun getInstance(): EmergencyRepository = instance ?: instance ?: EmergencyRepository().also { instance = it }

    fun getEmergencyContacts(): LiveData<List<Contact>>{

        val contacts = MutableLiveData<List<Contact>>()

        db.collection(Constants.EMERGENCY_CONTACTS).get()
            .addOnSuccessListener { result ->

                val list = arrayListOf<Contact>()
                for (document in result) {
                    Log.d(TAG, document.id + " => " + document.data)
                    val contact = document.toObject(Contact::class.java)
                    list.add(contact)
                }
                contacts.value = list
            }.addOnFailureListener {
                Log.w(TAG, "Error getting documents.", it)
            }
        return contacts
    }
}