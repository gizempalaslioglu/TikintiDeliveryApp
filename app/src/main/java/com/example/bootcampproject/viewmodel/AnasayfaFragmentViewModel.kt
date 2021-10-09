package com.example.bootcampproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bootcampproject.entity.Yemekler
import com.example.bootcampproject.repo.YemeklerDaoRepository

class AnasayfaFragmentViewModel : ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    val ydaor = YemeklerDaoRepository()

    init {
        yemekleriYukle()
        yemeklerListesi = ydaor.yemekleriGetir()
    }

    fun yemekleriYukle() {
        ydaor.tumYemekleriAl()
    }
}