package com.example.bootcampproject.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.bootcampproject.viewmodel.AnasayfaFragmentViewModel
import com.example.bootcampproject.R
import com.example.bootcampproject.adapter.YemeklerAdapter
import com.example.bootcampproject.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var tasarim: FragmentAnasayfaBinding
    private lateinit var adapter: YemeklerAdapter
    private lateinit var viewModel: AnasayfaFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)
        tasarim.anasayfaFragment = this
        tasarim.anasayfaToolbarBaslik="TIKINTI"
        tasarim.rv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        tasarim.imageViewSepeteGit.setOnClickListener {
            val sepet = AnasayfaFragmentDirections.anasayfadanSepeteGecis()
            Navigation.findNavController(it).navigate(sepet)

        }

        viewModel.yemeklerListesi.observe(viewLifecycleOwner, { yemeklerListesi ->
            adapter = YemeklerAdapter(requireContext(), yemeklerListesi)
            tasarim.adapter = adapter
        })

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val temp: AnasayfaFragmentViewModel by viewModels()
        viewModel = temp
    }
}
