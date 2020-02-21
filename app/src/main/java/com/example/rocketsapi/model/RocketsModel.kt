package com.example.rocketsapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RocketsModel (

    @SerializedName("active")
    @Expose
    var active: Boolean,
    @SerializedName("country")
    @Expose
    var country: String,
    @SerializedName("company")
    @Expose
    var company: String,
    @SerializedName("first_stage")
    @Expose
    var firstStage: FirstStage,
    @SerializedName("rocket_name")
    @Expose
    var rocketName: String
)

data class FirstStage (
    @SerializedName("engines")
    @Expose
    var engines: Int? = null
)
