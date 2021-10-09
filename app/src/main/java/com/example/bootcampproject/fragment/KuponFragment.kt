package com.example.bootcampproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.bootcampproject.R
import com.example.bootcampproject.adapter.KuponAdapter
import com.example.bootcampproject.adapter.YemeklerAdapter
import com.example.bootcampproject.databinding.FragmentAnasayfaBinding
import com.example.bootcampproject.databinding.FragmentKuponBinding
import com.example.bootcampproject.entity.Kuponlar
import java.util.ArrayList

class KuponFragment : Fragment() {
    private lateinit var kuponListesi : ArrayList<Kuponlar>
    private lateinit var tasarim: FragmentKuponBinding
    private lateinit var adapter: KuponAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_kupon, container, false)
        kuponListesiOlustur()

        adapter = KuponAdapter(requireContext(),kuponListesi)
        tasarim.adapter=adapter
        tasarim.kuponToolbarBaslik = "Kuponlarım"
        return tasarim.root
    }
    private fun kuponListesiOlustur(){
        kuponListesi = ArrayList()

        val a1 = Kuponlar(1,"McDonald's Kuponu","İKİ KİŞİLİK FIRSAT MENÜSÜ 23.99 ₺","mcdonalds")
        val a2 = Kuponlar(2,"Burger King Kuponu","%10 WHOPPER JR.MENÜ İNDİRİMİ","burgerking")
        val a3 = Kuponlar(3,"Kahve Dünyası Kuponu","1 ADET ÜCRETSİZ İÇECEK","kahvedunyasi")
        val a4 = Kuponlar(4,"Köfteci Yusuf Kuponu","TEK KÖFTE BURGER MENÜ 15.99 ₺","kofteciyusuf")
        val a5 = Kuponlar(5,"Domino's Kuponu","1 ORTA BOY PİZZA ALANA,1 ORTA BOY PİZZA+KOLA HEDİYE","dominos")
        val a6 = Kuponlar(6,"Tavuk Dünyası Kuponu","IZGARA TAVUK+AYRAN MENÜ 23.99 ₺","tavukdunyasi")

        kuponListesi.add(a1)
        kuponListesi.add(a2)
        kuponListesi.add(a3)
        kuponListesi.add(a4)
        kuponListesi.add(a5)
        kuponListesi.add(a6)


    }
}