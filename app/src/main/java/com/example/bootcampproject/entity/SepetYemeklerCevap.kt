package com.example.bootcampproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SepetYemeklerCevap(
    @SerializedName("sepet_yemekler")
    @Expose
    var sepet_yemekler: List<Yemekler>,
    @SerializedName("success")
    @Expose
    var success: Int
) {
}