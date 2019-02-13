package com.jpinto.emergencia.model

data class Contact(val name: String, val number: Long, val importance: Int, val type: String, val subAdminArea: String, val adminArea: String, val country: String, var favorite: Boolean){

    constructor(): this ("", 0, 5, "", "", "", "", false)
}