package com.example.rocketsapi.network

import com.example.rocketsapi.ROCKETS_ENDPOINT
import com.example.rocketsapi.model.RocketsModel
import io.reactivex.Observable
import retrofit2.http.GET

interface Client {

    @GET(ROCKETS_ENDPOINT)
    fun getRocketsClient() : Observable<List<RocketsModel>>

}