package com.example.bootcampproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcampproject.databinding.SepetCardTasarimBinding
import com.example.bootcampproject.entity.Yemekler
import com.example.bootcampproject.fragment.SepetFragmentDirections
import com.example.bootcampproject.viewmodel.SepetFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class SepetAdapter(
    var mContext: Context,
    var sepetListesi: List<Yemekler>,
    var viewModel: SepetFragmentViewModel,
) :
    RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(sepetCardTasarimBinding: SepetCardTasarimBinding) :
        RecyclerView.ViewHolder(sepetCardTasarimBinding.root) {
        var cardTasarim: SepetCardTasarimBinding

        init {
            this.cardTasarim = sepetCardTasarimBinding
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = SepetCardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemekler = sepetListesi.get(position)
        holder.cardTasarim.sepetNesnesi = yemekler

        holder.cardTasarim.ekleButton2.setOnClickListener {
            viewModel.sil(yemekler.yemek_id)
            var adet = yemekler.yemek_siparis_adet + 1
            viewModel.sepet(
                yemekler.yemek_id,
                yemekler.yemek_adi,
                yemekler.yemek_resim_adi,
                yemekler.yemek_fiyat,
                adet
            )
        }

        holder.cardTasarim.cikarButton2.setOnClickListener {
            viewModel.sil(yemekler.yemek_id)
            var adet = yemekler.yemek_siparis_adet - 1
            viewModel.sepet(
                yemekler.yemek_id,
                yemekler.yemek_adi,
                yemekler.yemek_resim_adi,
                yemekler.yemek_fiyat,
                adet
            )
        }

        holder.cardTasarim.imageViewSil.setOnClickListener {
            val sepet = SepetFragmentDirections.sepetiYenile()
            Navigation.findNavController(it).navigate(sepet)
            Snackbar.make(it, "Silmek istiyor musunuz ?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    viewModel.sil(yemekler.yemek_id)
                    notifyItemRemoved(position)
                    Snackbar.make(it, "Silindi", Snackbar.LENGTH_SHORT).show()
                }.show()

        }


        val url = "http://kasimadalan.pe.hu/yemekler/resimler//${yemekler.yemek_resim_adi}"
        Picasso.get().load(url).into(holder.cardTasarim.sepetUrunResim)
    }


    override fun getItemCount(): Int {
        return sepetListesi.size
    }

}