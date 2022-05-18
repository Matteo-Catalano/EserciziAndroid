package com.android.example.eserciziandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.example.eserciziandroid.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.fragment1bnt.setOnClickListener {
            replacefragment(Fragment1())

        }

        binding.fragment2bnt.setOnClickListener {

            replacefragment(Fragment2())

        }
    }

    private fun replacefragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTrasaction = fragmentManager.beginTransaction()
        fragmentTrasaction.replace(R.id.framelayout,fragment)
        fragmentTrasaction.commit()
    }
}