package com.example.bootcampproject.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bootcampproject.entity.CRUDCevap
import com.example.bootcampproject.entity.SepetYemeklerCevap
import com.example.bootcampproject.entity.Yemekler
import com.example.bootcampproject.entity.YemeklerCevap
import com.example.bootcampproject.retrofit.ApiUtils
import com.example.bootcampproject.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository {
    private val yemeklerListesi: MutableLiveData<List<Yemekler>>
    private val yemeklerdaoInterface: YemeklerDaoInterface
    private val sepetListe: MutableLiveData<List<Yemekler>>


    init {
        yemeklerdaoInterface = ApiUtils.getYemeklerDaoInterface()
        yemeklerListesi = MutableLiveData()
        sepetListe = MutableLiveData()
    }

    fun yemekleriGetir(): MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }

    fun sepetGetir(): MutableLiveData<List<Yemekler>> {
        return sepetListe
    }

    fun tumYemekleriAl() {
        yemeklerdaoInterface.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                val liste = response.body().yemekler
                yemeklerListesi.value = liste
            }

            override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {}
        })

    }

    fun sepet(
        yemek_id: Int,
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int
    ) {
        yemeklerdaoInterface.sepeteYemekEkle(
            yemek_id,
            yemek_adi,
            yemek_resim_adi,
            yemek_fiyat,
            yemek_siparis_adet,
            "gizem_palaslioglu"
        )
            .enqueue(object : Callback<YemeklerCevap> {
                override fun onResponse(
                    call: Call<YemeklerCevap>,
                    response: Response<YemeklerCevap>
                ) {

                    //Log.e("Yemek", yemek_adi + " eklendi")
                }

                override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {
                    //Log.e("Yemek", "YEMEKLER EKLENEMEDİ")

                }

            })
    }

    fun sepettekileriGetir() {
        yemeklerdaoInterface.sepettekiYemekleriGetir("gizem_palaslioglu")
            .enqueue(object : Callback<SepetYemeklerCevap> {
                override fun onResponse(
                    call: Call<SepetYemeklerCevap>?,
                    response: Response<SepetYemeklerCevap>?
                ) {
                    val liste = response?.body()?.sepet_yemekler
                    sepetListe.value = liste
                }

                override fun onFailure(call: Call<SepetYemeklerCevap>?, t: Throwable?) {
                    println(t!!.localizedMessage)
                }


            })
    }

    fun sepettenSil(yemek_id: Int) {
        yemeklerdaoInterface.sepettenYemekSil(yemek_id).enqueue(object : Callback<CRUDCevap?> {
            override fun onResponse(call: Call<CRUDCevap?>, response: Response<CRUDCevap?>) {

            }

            override fun onFailure(call: Call<CRUDCevap?>, t: Throwable) {}
        })
    }


}
