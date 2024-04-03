package com.example.doggydog.model.entity

import com.google.gson.annotations.SerializedName

data class DogItem(
    @SerializedName("image_link")
    val imageLink:String,

    val playfulness: Int,
    val protectiveness: Int,
    val name: String,
    val trainability: Int
)
