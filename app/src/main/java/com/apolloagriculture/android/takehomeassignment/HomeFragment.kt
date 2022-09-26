package com.apolloagriculture.android.takehomeassignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.apolloagriculture.android.takehomeassignment.data.response.Forecast
import com.apolloagriculture.android.takehomeassignment.data.response.Weather
import com.apolloagriculture.android.takehomeassignment.databinding.FragmentSecondBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val weatherViewModel: WeatherViewModel by viewModel()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weatherViewModel.getWeatherForecast().observe(viewLifecycleOwner) {
            updateUI(it)
        }
    }

    private fun updateUI(forecast: Forecast) {
        binding.weatherContainer.removeAllViews()
        forecast["today"]?.let { createWeatherWidget(it) }
        forecast["tomorrow"]?.let { createWeatherWidget(it) }
        forecast["dayAfterTomorrow"]?.let { createWeatherWidget(it) }

    }

    private fun createWeatherWidget(weather: Weather) {
        val weatherView = WeatherView(requireContext()).apply {
            setData(weather)
        }
        binding.weatherContainer.addView(weatherView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}