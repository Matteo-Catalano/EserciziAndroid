package com.android.example.eserciziandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.android.example.eserciziandroid.databinding.Fragment2Binding
import com.android.example.eserciziandroid.databinding.Fragment3Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Fragment2 : Fragment (R.layout.fragment2) {

    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!!
    var number: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = Fragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonInputCorru.setOnClickListener {
            increaseValue()
        }
    }

    private fun increaseValue() {
        viewLifecycleOwner.lifecycleScope.launch {
            delay(2000)
            number?.let {
                number = number?.plus(1)
                binding.textView.text = "value is: $it"
            } ?: kotlin.run {
                number = binding.editText.text.toString().toIntOrNull()?.plus(1)
                binding.textView.text = "value is: $number"
            }
        }
    }
}