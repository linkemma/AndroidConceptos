package com.oandanes.conceptosandroid.ui.horoscope

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.oandanes.conceptosandroid.databinding.FragmentHoroscopeBinding
import com.oandanes.conceptosandroid.domain.model.HoroscopeInfo
import com.oandanes.conceptosandroid.domain.model.HoroscopeInfo.*
import com.oandanes.conceptosandroid.domain.model.HoroscopeModel
import com.oandanes.conceptosandroid.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {
    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        iniList()
        initUIState()
    }

    private fun iniList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            val type: HoroscopeModel = when (it) {
                Aquarius -> HoroscopeModel.Aquarius
                Aries -> HoroscopeModel.Aries
                Cancer -> HoroscopeModel.Cancer
                Capricorn -> HoroscopeModel.Capricorn
                Gemini -> HoroscopeModel.Gemini
                Leo -> HoroscopeModel.Leo
                Libra -> HoroscopeModel.Libra
                Pisces -> HoroscopeModel.Pisces
                Sagittarius -> HoroscopeModel.Sagittarius
                Scorpio -> HoroscopeModel.Scorpio
                Taurus -> HoroscopeModel.Taurus
                Virgo -> HoroscopeModel.Virgo
            }
            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
            )
        })
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = horoscopeAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    //Cambios en horoscope
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}