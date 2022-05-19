package com.android.example.eserciziandroid

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.android.example.eserciziandroid.databinding.Fragment3Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Fragment3 : Fragment(R.layout.fragment3) {


    private var _binding: Fragment3Binding? = null

    private val binding get() = _binding!!
    var number: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
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