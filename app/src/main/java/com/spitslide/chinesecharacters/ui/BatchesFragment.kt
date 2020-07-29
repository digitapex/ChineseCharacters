package com.spitslide.chinesecharacters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.spitslide.chinesecharacters.Constants
import com.spitslide.chinesecharacters.R
import com.spitslide.chinesecharacters.viewmodels.GlobalViewModel

class BatchesFragment : Fragment() {

    var numOfBatches = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_batches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val globalViewModel = ViewModelProvider(requireActivity()).get(GlobalViewModel::class.java)

        numOfBatches = when (globalViewModel.hsk) {
            Constants.HSKs.HSK1 -> 10
            Constants.HSKs.HSK2 -> 10
            Constants.HSKs.HSK3 -> 15
            Constants.HSKs.HSK4 -> 30
            Constants.HSKs.HSK5 -> 65
            Constants.HSKs.HSK6 -> 125
        }

        for (x in 1..numOfBatches) {
            val button = Button(activity)
            button.layoutParams = LinearLayout.LayoutParams(200, 200)
            button.text = x.toString()
            button.textSize = 30f
            button.setOnClickListener {
                globalViewModel.whichBatch = x - 1
                Navigation.findNavController(view)
                    .navigate(R.id.action_batchesFragment_to_exerciseFragment)
            }
            (view.findViewById(R.id.gridlayout) as GridLayout).addView(button)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}