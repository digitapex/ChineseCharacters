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

class LanguageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_language, container, false)

        val globalViewModel = ViewModelProvider(requireActivity()).get(GlobalViewModel::class.java)

        view.findViewById<Button>(R.id.enghan).setOnClickListener {
            globalViewModel.questionLanguage = Constants.LANG.ENGLISH
            globalViewModel.answerLanguage = Constants.LANG.CHINESESIMPLIFIED
            Navigation.findNavController(view)
                .navigate(R.id.action_languageFragment_to_batchesFragment)
        }
        view.findViewById<Button>(R.id.engpin).setOnClickListener {
            globalViewModel.questionLanguage = Constants.LANG.ENGLISH
            globalViewModel.answerLanguage = Constants.LANG.PINYINACCENTED
            Navigation.findNavController(view)
                .navigate(R.id.action_languageFragment_to_batchesFragment)
        }
        view.findViewById<Button>(R.id.haneng).setOnClickListener {
            globalViewModel.questionLanguage = Constants.LANG.CHINESESIMPLIFIED
            globalViewModel.answerLanguage = Constants.LANG.ENGLISH
            Navigation.findNavController(view)
                .navigate(R.id.action_languageFragment_to_batchesFragment)
        }
        view.findViewById<Button>(R.id.hanpin).setOnClickListener {
            globalViewModel.questionLanguage = Constants.LANG.CHINESESIMPLIFIED
            globalViewModel.answerLanguage = Constants.LANG.PINYINACCENTED
            Navigation.findNavController(view)
                .navigate(R.id.action_languageFragment_to_batchesFragment)
        }
        view.findViewById<Button>(R.id.pineng).setOnClickListener {
            globalViewModel.questionLanguage = Constants.LANG.PINYINACCENTED
            globalViewModel.answerLanguage = Constants.LANG.ENGLISH
            Navigation.findNavController(view)
                .navigate(R.id.action_languageFragment_to_batchesFragment)
        }
        view.findViewById<Button>(R.id.pinhan).setOnClickListener {
            globalViewModel.questionLanguage = Constants.LANG.PINYINACCENTED
            globalViewModel.answerLanguage = Constants.LANG.CHINESESIMPLIFIED
            Navigation.findNavController(view)
                .navigate(R.id.action_languageFragment_to_batchesFragment)
        }
        return view
    }
}