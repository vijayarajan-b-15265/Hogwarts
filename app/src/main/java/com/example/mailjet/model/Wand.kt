package com.example.mailjet.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wand(
    @Json(name = "core")
    val core: String,
    @Json(name = "length")
    val length: Double?,
    @Json(name = "wood")
    val wood: String
)