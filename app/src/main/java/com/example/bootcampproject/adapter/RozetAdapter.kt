package com.example.bootcampproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcampproject.databinding.KuponCardTasarimBinding
import com.example.bootcampproject.databinding.RozetCardTasarimBinding
import com.example.bootcampproject.entity.Kuponlar
import com.example.bootcampproject.entity.Rozetler
import com.google.android.material.snackbar.Snackbar

class RozetAdapter(var mContext: Context, var rozetListesi: List<Rozetler>) :
    RecyclerView.Adapter<RozetAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(rozetCardTasarimBinding: RozetCardTasarimBinding) :
        RecyclerView.ViewHolder(rozetCardTasarimBinding.root) {
        var cardTasarim: RozetCardTasarimBinding

        init {
            this.cardTasarim = rozetCardTasarimBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = RozetCardTasarimBinding.inflate(layoutInflater, parent, false)

        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val rozet = rozetListesi.get(position)

        holder.cardTasarim.rozet = rozet

    }


    override fun getItemCount(): Int {
        return rozetListesi.size
    }
}