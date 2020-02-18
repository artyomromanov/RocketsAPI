package com.example.rocketsapi

interface PresenterContract {

    interface View {

        fun getData(active : Boolean) {}

        fun onDestroyCalled()
    }

    interface Network {

        fun callSuccess(rocketsList : List<RocketsModel>){}

        fun callFailure(t : Throwable)

    }

}