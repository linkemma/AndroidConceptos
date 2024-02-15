package com.oandanes.conceptosandroid.data.provaider

import com.oandanes.conceptosandroid.domain.model.HoroscopeInfo
import com.oandanes.conceptosandroid.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvaider @Inject constructor() {
    fun getHorocopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}