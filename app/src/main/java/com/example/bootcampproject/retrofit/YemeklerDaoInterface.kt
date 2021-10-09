package com.example.bootcampproject.retrofit


import com.example.bootcampproject.entity.CRUDCevap
import com.example.bootcampproject.entity.SepetYemeklerCevap
import com.example.bootcampproject.entity.Yemekler
import com.example.bootcampproject.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.*

interface YemeklerDaoInterface {
    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekler(): Call<YemeklerCevap>

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun sepeteYemekEkle(
        @Field("yemek_id") yemek_id: Int,
        @Field("yemek_adi") yemek_adi: String,
        @Field("yemek_resim_adi") yemek_resim_adi: String,
        @Field("yemek_fiyat") yemek_fiyat: Int,
        @Field("yemek_siparis_adet") yemek_siparis_adet: Int,
        @Field("kullanici_adi") kullanici_adi: String,
    ): Call<YemeklerCevap>

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun sepettekiYemekleriGetir(
        @Field("kullanici_adi") kullanici_adi: String,
    ): Call<SepetYemeklerCevap>

    @POST("/yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun sepettenYemekSil(
        @Field("yemek_id") yemek_id: Int,
    ): Call<CRUDCevap>



}