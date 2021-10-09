package com.example.bootcampproject.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.bootcampproject.R
import com.example.bootcampproject.databinding.FragmentYemekDetayBinding
import com.example.bootcampproject.viewmodel.SepetFragmentViewModel
import com.example.bootcampproject.viewmodel.YemekDetayFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class YemekDetayFragment : Fragment() {
    private val viewModel: YemekDetayFragmentViewModel by viewModels()
    private lateinit var tasarim: FragmentYemekDetayBinding
    private val sepetViewModel: SepetFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yemek_detay, container, false)
        tasarim.anasayfaToolbarBaslik = "Ürün Detayları"

        val bundle: YemekDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemekNesnesi
        tasarim.yemekNesnesi = gelenYemek

        tasarim.yemekDetayViewModel = viewModel
        tasarim.lifecycleOwner = this

        val url = "http://kasimadalan.pe.hu/yemekler/resimler//${gelenYemek.yemek_resim_adi}"
        Picasso.get().load(url).into(tasarim.detayYemekResim)

        viewModel.sayac.observe(viewLifecycleOwner, Observer {
            println(it)
            gelenYemek.yemek_siparis_adet = it
        })

        tasarim.buttonSepet.setOnClickListener {
            sepetViewModel.sepet(
                gelenYemek.yemek_id,
                gelenYemek.yemek_adi,
                gelenYemek.yemek_resim_adi,
                gelenYemek.yemek_fiyat,
                gelenYemek.yemek_siparis_adet
            )

            Snackbar.make(it, "Sepete eklemek istiyor musunuz ?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    Snackbar.make(it, "Eklendi", Snackbar.LENGTH_SHORT).show()
                }.show()
        }

        return tasarim.root

    }

}


