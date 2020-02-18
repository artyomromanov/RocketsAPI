package com.example.rocketsapi

interface ViewInterface{

    fun displayData(rocketsList : List<RocketsModel>)

    fun showError(t : Throwable)

}