package com.example.bootcampproject.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.bootcampproject.MainActivity
import com.example.bootcampproject.R
import com.example.bootcampproject.adapter.RozetAdapter
import com.example.bootcampproject.databinding.FragmentProfilBinding
import com.example.bootcampproject.entity.Rozetler
import kotlinx.android.synthetic.main.custom_dialog.*
import java.util.ArrayList

class ProfilFragment : Fragment() {
    private lateinit var rozetListesi : ArrayList<Rozetler>
    private lateinit var adapter : RozetAdapter
    private lateinit var tasarim: FragmentProfilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_profil, container, false)
        tasarim.profilFragment = this
        tasarim.profilToolbarBaslik = "Profil"
        tasarim.buttonCikis.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
        rozetListesiOlustur()

        adapter = RozetAdapter(requireContext(),rozetListesi)
        tasarim.rozetAdapter = adapter
        return tasarim.root
    }
    private fun rozetListesiOlustur(){
        rozetListesi = ArrayList()

        val a1 = Rozetler(1,"Rozet 1","badge1")
        val a2 = Rozetler(2,"Rozet 2)","badge2")
        val a3 = Rozetler(3,"Rozet 3","badge3")
        val a4 = Rozetler(4,"Rozet 4","badge4")
        val a5 = Rozetler(5,"Rozet 5","badge5")

        rozetListesi.add(a1)
        rozetListesi.add(a2)
        rozetListesi.add(a3)
        rozetListesi.add(a4)
        rozetListesi.add(a5)

    }

}