package com.example.rocketsapi

import io.reactivex.Observable
import retrofit2.http.GET

interface Client {

    @GET(ROCKETS_ENDPOINT)
    fun getRocketsClient() : Observable<List<RocketsModel>>

}