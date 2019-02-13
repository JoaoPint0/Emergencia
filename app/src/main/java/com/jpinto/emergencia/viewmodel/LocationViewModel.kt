package com.jpinto.emergencia.viewmodel

import android.location.Address
import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class LocationViewModel : ViewModel() {

    val location: MutableLiveData<Location> = MutableLiveData()
    val address : MutableLiveData<Address>  = MutableLiveData()

    val coordinates = Transformations.map(location){if (it == null) "" else "Lat: ${it.latitude} Long: ${it.longitude}"}
    val street      = Transformations.map(address) {if (it == null) "" else "${it.thoroughfare} nº ${it.subThoroughfare}"}
    val city        = Transformations.map(address) {if (it == null) "" else "${it.subAdminArea}, ${it.adminArea}"}
    val country     = Transformations.map(address) {if (it == null) "" else it.countryName}
}
