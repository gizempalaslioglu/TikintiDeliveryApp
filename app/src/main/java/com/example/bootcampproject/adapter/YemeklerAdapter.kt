package com.example.bootcampproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcampproject.entity.Yemekler
import com.example.bootcampproject.databinding.YemeklerCardTasarimBinding
import com.example.bootcampproject.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso


class YemeklerAdapter(
    var mContext: Context,
    var yemeklerListesi: List<Yemekler>
) : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(yemeklerCardTasarimBinding: YemeklerCardTasarimBinding) :
        RecyclerView.ViewHolder(yemeklerCardTasarimBinding.root) {
        var cardTasarim: YemeklerCardTasarimBinding

        init {
            this.cardTasarim = yemeklerCardTasarimBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = YemeklerCardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemekler = yemeklerListesi.get(position)
        holder.cardTasarim.ymkNesnesi = yemekler

        holder.cardTasarim.imageViewDetay.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayaGecis(yemekler)
            Navigation.findNavController(it).navigate(gecis)


        }

        val url = "http://kasimadalan.pe.hu/yemekler/resimler//${yemekler.yemek_resim_adi}"
        Picasso.get().load(url).into(holder.cardTasarim.yemekResim)
    }


    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }

}
