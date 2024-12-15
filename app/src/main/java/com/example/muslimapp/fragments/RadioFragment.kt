import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.muslimapp.Models.RadioService
import com.example.muslimapp.R
import com.example.muslimapp.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {

    private var isPlaying = false
    private lateinit var binding: FragmentRadioBinding
    private val radioStations = listOf(
        "https://Qurango.net/radio/alzain_mohammad_ahmad",
        "https://Qurango.net/radio/ahmad_khader_altarabulsi",
        "https://live.mp3quran.net:8000/radio2"
    )
    private var currentStationIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRadioBinding.inflate(inflater, container, false)
        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        binding.pauseIc.setOnClickListener {
            if (isPlaying) {
                stopRadioService()
            } else {
                startRadioService(radioStations[currentStationIndex])
            }
            isPlaying = !isPlaying
            updatePlayPauseIcon()
        }

        binding.lastIc.setOnClickListener {
            if (currentStationIndex > 0) {
                currentStationIndex--
                startRadioService(radioStations[currentStationIndex])
            }
        }

        binding.nextIc.setOnClickListener {
            if (currentStationIndex < radioStations.size - 1) {
                currentStationIndex++
                startRadioService(radioStations[currentStationIndex])
            }
        }
    }

    private fun updatePlayPauseIcon() {
        val icon = if (isPlaying) R.drawable.pause_btn else R.drawable.pause_ic
        binding.pauseIc.setImageResource(icon)
    }

    private fun startRadioService(url: String) {
        val intent = Intent(requireContext(), RadioService::class.java).apply {
            action = "START_RADIO"
            putExtra("RADIO_URL", url)
        }
        requireContext().startService(intent)
    }

    private fun stopRadioService() {
        val intent = Intent(requireContext(), RadioService::class.java).apply {
            action = "STOP_RADIO"
        }
        requireContext().startService(intent)
    }
}
