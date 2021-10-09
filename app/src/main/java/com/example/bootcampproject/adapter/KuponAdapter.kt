package com.example.bootcampproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcampproject.databinding.KuponCardTasarimBinding
import com.example.bootcampproject.entity.Kuponlar
import com.google.android.material.snackbar.Snackbar

class KuponAdapter(var mContext: Context, var kuponListesi: List<Kuponlar>) :
    RecyclerView.Adapter<KuponAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(kuponCardTasarimBinding: KuponCardTasarimBinding) :
        RecyclerView.ViewHolder(kuponCardTasarimBinding.root) {
        var cardTasarim: KuponCardTasarimBinding

        init {
            this.cardTasarim = kuponCardTasarimBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = KuponCardTasarimBinding.inflate(layoutInflater, parent, false)

        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kupon = kuponListesi.get(position)

        holder.cardTasarim.kupon = kupon
        holder.cardTasarim.satirCard.setOnClickListener {
            Snackbar.make(it, "${kupon.isim} - ${kupon.aciklama}", Snackbar.LENGTH_SHORT)
                .show()
        }
        holder.cardTasarim.kuponAdi.text=kupon.aciklama

    }


    override fun getItemCount(): Int {
        return kuponListesi.size
    }
}