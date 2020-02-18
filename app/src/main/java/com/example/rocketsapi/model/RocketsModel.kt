package com.example.rocketsapi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RocketsModel (

    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("active")
    @Expose
    var active: Boolean,
    @SerializedName("stages")
    @Expose
    var stages: Int,
    @SerializedName("boosters")
    @Expose
    var boosters: Int,
    @SerializedName("cost_per_launch")
    @Expose
    var costPerLaunch: Int,
    @SerializedName("success_rate_pct")
    @Expose
    var successRatePct: Int,
    @SerializedName("first_flight")
    @Expose
    var firstFlight: String,
    @SerializedName("country")
    @Expose
    var country: String,
    @SerializedName("company")
    @Expose
    var company: String,
    @SerializedName("height")
    @Expose
    var height: Height,
    @SerializedName("diameter")
    @Expose
    var diameter: Diameter,
    @SerializedName("mass")
    @Expose
    var mass: Mass,
    @SerializedName("payload_weights")
    @Expose
    var payloadWeights: List<PayloadWeight>,
    @SerializedName("first_stage")
    @Expose
    var firstStage: FirstStage,
    @SerializedName("second_stage")
    @Expose
    var secondStage: SecondStage,
    @SerializedName("engines")
    @Expose
    var engines: Engines,
    @SerializedName("landing_legs")
    @Expose
    var landingLegs: LandingLegs,
    @SerializedName("flickr_images")
    @Expose
    var flickrImages: List<String>,
    @SerializedName("wikipedia")
    @Expose
    var wikipedia: String,
    @SerializedName("description")
    @Expose
    var description: String,
    @SerializedName("rocket_id")
    @Expose
    var rocketId: String,
    @SerializedName("rocket_name")
    @Expose
    var rocketName: String,
    @SerializedName("rocket_type")
    @Expose
    var rocketType: String
)

class CompositeFairing {
    @SerializedName("height")
    @Expose
    var height: Height_? = null
    @SerializedName("diameter")
    @Expose
    var diameter: Diameter_? = null
}

class Diameter {
    @SerializedName("meters")
    @Expose
    var meters: Double? = null
    @SerializedName("feet")
    @Expose
    var feet: Double? = null
}

class Diameter_ {
    @SerializedName("meters")
    @Expose
    var meters: Any? = null
    @SerializedName("feet")
    @Expose
    var feet: Double? = null
}

class Engines {
    @SerializedName("number")
    @Expose
    var number: Int? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("version")
    @Expose
    var version: String? = null
    @SerializedName("layout")
    @Expose
    var layout: Any? = null
    @SerializedName("isp")
    @Expose
    var isp: Isp? = null
    @SerializedName("engine_loss_max")
    @Expose
    var engineLossMax: Any? = null
    @SerializedName("propellant_1")
    @Expose
    var propellant1: String? = null
    @SerializedName("propellant_2")
    @Expose
    var propellant2: String? = null
    @SerializedName("thrust_sea_level")
    @Expose
    var thrustSeaLevel: ThrustSeaLevel_? = null
    @SerializedName("thrust_vacuum")
    @Expose
    var thrustVacuum: ThrustVacuum_? = null
    @SerializedName("thrust_to_weight")
    @Expose
    var thrustToWeight: Double? = null
}

class FirstStage {
    @SerializedName("reusable")
    @Expose
    var reusable: Boolean? = null
    @SerializedName("engines")
    @Expose
    var engines: Int? = null
    @SerializedName("fuel_amount_tons")
    @Expose
    var fuelAmountTons: Double? = null
    @SerializedName("burn_time_sec")
    @Expose
    var burnTimeSec: Any? = null
    @SerializedName("thrust_sea_level")
    @Expose
    var thrustSeaLevel: ThrustSeaLevel? = null
    @SerializedName("thrust_vacuum")
    @Expose
    var thrustVacuum: ThrustVacuum? = null
    @SerializedName("cores")
    @Expose
    var cores: Int? = null
}

class Height {
    @SerializedName("meters")
    @Expose
    var meters: Double? = null
    @SerializedName("feet")
    @Expose
    var feet: Double? = null
}


class Height_ {
    @SerializedName("meters")
    @Expose
    var meters: Any? = null
    @SerializedName("feet")
    @Expose
    var feet: Any? = null
}


class Isp {
    @SerializedName("sea_level")
    @Expose
    var seaLevel: Int? = null
    @SerializedName("vacuum")
    @Expose
    var vacuum: Int? = null
}

class LandingLegs {
    @SerializedName("number")
    @Expose
    var number: Int? = null
    @SerializedName("material")
    @Expose
    var material: String? = null
}


class Mass {
    @SerializedName("kg")
    @Expose
    var kg: Int? = null
    @SerializedName("lb")
    @Expose
    var lb: Int? = null
}

class PayloadWeight {
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("kg")
    @Expose
    var kg: Int? = null
    @SerializedName("lb")
    @Expose
    var lb: Int? = null
}

class Payloads {
    @SerializedName("option_1")
    @Expose
    var option1: String? = null
    @SerializedName("composite_fairing")
    @Expose
    var compositeFairing: CompositeFairing? = null
    @SerializedName("option_2")
    @Expose
    var option2: String? = null
}

class SecondStage {
    @SerializedName("reusable")
    @Expose
    var reusable: Boolean? = null
    @SerializedName("engines")
    @Expose
    var engines: Int? = null
    @SerializedName("fuel_amount_tons")
    @Expose
    var fuelAmountTons: Double? = null
    @SerializedName("burn_time_sec")
    @Expose
    var burnTimeSec: Any? = null
    @SerializedName("thrust")
    @Expose
    var thrust: Thrust? = null
    @SerializedName("payloads")
    @Expose
    var payloads: Payloads? = null
}

class Thrust {
    @SerializedName("kN")
    @Expose
    var kN: Int? = null
    @SerializedName("lbf")
    @Expose
    var lbf: Int? = null
}


class ThrustSeaLevel {
    @SerializedName("kN")
    @Expose
    var kN: Int? = null
    @SerializedName("lbf")
    @Expose
    var lbf: Int? = null
}


class ThrustSeaLevel_ {
    @SerializedName("kN")
    @Expose
    var kN: Int? = null
    @SerializedName("lbf")
    @Expose
    var lbf: Int? = null
}

class ThrustVacuum {
    @SerializedName("kN")
    @Expose
    var kN: Int? = null
    @SerializedName("lbf")
    @Expose
    var lbf: Int? = null
}

class ThrustVacuum_ {
    @SerializedName("kN")
    @Expose
    var kN: Int? = null
    @SerializedName("lbf")
    @Expose
    var lbf: Int? = null
}