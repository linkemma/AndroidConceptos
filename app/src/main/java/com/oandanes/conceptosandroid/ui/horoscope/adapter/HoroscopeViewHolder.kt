package com.oandanes.conceptosandroid.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.oandanes.conceptosandroid.databinding.ItemHoroscopeBinding
import com.oandanes.conceptosandroid.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.tvTitle.context
        binding.ivHorosocope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            starRotationAnimation(
                binding.ivHorosocope,
                newLmbda = { onItemSelected(horoscopeInfo) })
        }
    }

    private fun starRotationAnimation(view: View, newLmbda: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { newLmbda() }
            start()

        }
    }
}