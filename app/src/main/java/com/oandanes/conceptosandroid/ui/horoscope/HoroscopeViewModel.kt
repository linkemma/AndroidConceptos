package com.oandanes.conceptosandroid.ui.horoscope

import androidx.lifecycle.ViewModel
import com.oandanes.conceptosandroid.data.provaider.HoroscopeProvaider
import com.oandanes.conceptosandroid.domain.model.HoroscopeInfo
import com.oandanes.conceptosandroid.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor( horoscopeProvaider: HoroscopeProvaider) : ViewModel() {
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = horoscopeProvaider.getHorocopes()
    }
}