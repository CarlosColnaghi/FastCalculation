package com.example.fastcalculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fastcalculation.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var result: Float = 0f
    private lateinit var fragmentResultBinding: FragmentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            result = it.getFloat(Extras.EXTRA_RESULT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentResultBinding = FragmentResultBinding.inflate(inflater, container, false)
        fragmentResultBinding.apply {
            "%.1f".format(result).also {
                resultValueTextView.text = it
            }
            restartButton.setOnClickListener {
                (context as OnPlayGame).onPlayGame()
            }
        }
        return fragmentResultBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(settings: Settings, result: Float) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putFloat(Extras.EXTRA_RESULT, result)
                }
            }
    }
}