package com.example.bootcampproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bootcampproject.entity.Yemekler

class YemekDetayFragmentViewModel : ViewModel() {
    private val _sayac = MutableLiveData<Int>()
    val sayac: LiveData<Int>
        get() = _sayac

    init {
        _sayac.value = 1
    }

    fun sayacArtir() {
        _sayac.value = (_sayac.value?.plus(1))
    }

    fun sayacAzalt() {
        if ((_sayac.value!!) > 0) {
            _sayac.value = (_sayac.value)?.minus(1)
        }
    }

}