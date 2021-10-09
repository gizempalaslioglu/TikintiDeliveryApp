package com.example.bootcampproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.bootcampproject.R
import com.example.bootcampproject.adapter.SepetAdapter
import com.example.bootcampproject.databinding.FragmentSepetBinding
import com.example.bootcampproject.entity.Yemekler
import com.example.bootcampproject.viewmodel.SepetFragmentViewModel

class SepetFragment : Fragment() {

    private lateinit var tasarim: FragmentSepetBinding
    private lateinit var adapter: SepetAdapter
    private lateinit var viewModel: SepetFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_sepet, container, false)
        tasarim.sepetFragment = this
        tasarim.sepetToolbarBaslik = "Sepetteki Ürünler"

        tasarim.buttonSatinAl.setOnClickListener {
            val yenile = SepetFragmentDirections.sepetiYenile()
            Navigation.findNavController(it).navigate(yenile)
            showCustomAlert()

        }

        viewModel.sepetListe.observe(viewLifecycleOwner, { yemeklerListesi ->
            println(yemeklerListesi)
           adapter = SepetAdapter(requireContext(), yemeklerListesi, SepetFragmentViewModel())
          tasarim.adapter = adapter
        })

        tasarim

        viewModel.sepettekileriGetir()

        return tasarim.root
    }

    private fun showCustomAlert() {
        val dialogView = layoutInflater.inflate(R.layout.siparis_custom_dialog, null)

        val customDialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .show()

        val btDismiss = dialogView.findViewById<ImageButton>(R.id.btDismissCustomDialog)
        btDismiss.setOnClickListener {
            customDialog.dismiss()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val temp: SepetFragmentViewModel by viewModels()
        viewModel = temp


    }

}