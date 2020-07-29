package com.spitslide.chinesecharacters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.spitslide.chinesecharacters.R

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)
        view.findViewById<Button>(R.id.practice).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_mainFragment_to_hskFragment)
        }
        return view
    }
}