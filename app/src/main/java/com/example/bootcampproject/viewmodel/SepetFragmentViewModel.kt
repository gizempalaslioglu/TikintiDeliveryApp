package com.example.bootcampproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bootcampproject.entity.Yemekler
import com.example.bootcampproject.repo.YemeklerDaoRepository

class SepetFragmentViewModel : ViewModel() {
    val ydaor = YemeklerDaoRepository()
    var sepetListe = MutableLiveData<List<Yemekler>>()

    init {
        sepettekileriGetir()
        sepetListe = ydaor.sepetGetir()
    }

    fun sepet(
        yemek_id: Int,
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int
    ) {
        ydaor.sepet(yemek_id, yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet)
    }

    fun sepettekileriGetir() {
        ydaor.sepettekileriGetir()
    }

    fun sil(yemek_id: Int){
        ydaor.sepettenSil(yemek_id)
        sepetListe = ydaor.sepetGetir()
        ydaor.sepetGetir()


    }
}