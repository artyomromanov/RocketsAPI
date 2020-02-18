package com.example.rocketsapi

interface NetworkClientInterface {

    fun retrieveData(active : Boolean)

    fun onDestroyCalled()

}