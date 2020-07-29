package com.spitslide.chinesecharacters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.spitslide.chinesecharacters.Constants
import com.spitslide.chinesecharacters.R
import com.spitslide.chinesecharacters.viewmodels.GlobalViewModel

class HskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_hsk, container, false)

        val globalViewModel = ViewModelProvider(requireActivity()).get(GlobalViewModel::class.java)

        view.findViewById<Button>(R.id.hsk1).setOnClickListener {
            globalViewModel.hsk = Constants.HSKs.HSK1
            Navigation.findNavController(view)
                .navigate(R.id.action_hskFragment_to_languageFragment)
        }
        view.findViewById<Button>(R.id.hsk2).setOnClickListener {
            globalViewModel.hsk = Constants.HSKs.HSK2
            Navigation.findNavController(view)
                .navigate(R.id.action_hskFragment_to_languageFragment)
        }
        view.findViewById<Button>(R.id.hsk3).setOnClickListener {
            globalViewModel.hsk = Constants.HSKs.HSK3
            Navigation.findNavController(view)
                .navigate(R.id.action_hskFragment_to_languageFragment)
        }
        view.findViewById<Button>(R.id.hsk4).setOnClickListener {
            globalViewModel.hsk = Constants.HSKs.HSK4
            Navigation.findNavController(view)
                .navigate(R.id.action_hskFragment_to_languageFragment)
        }
        view.findViewById<Button>(R.id.hsk5).setOnClickListener {
            globalViewModel.hsk = Constants.HSKs.HSK5
            Navigation.findNavController(view)
                .navigate(R.id.action_hskFragment_to_languageFragment)
        }
        view.findViewById<Button>(R.id.hsk6).setOnClickListener {
            globalViewModel.hsk = Constants.HSKs.HSK6
            Navigation.findNavController(view)
                .navigate(R.id.action_hskFragment_to_languageFragment)
        }
        return view
    }
}