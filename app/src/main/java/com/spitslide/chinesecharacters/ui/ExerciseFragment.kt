package com.spitslide.chinesecharacters.ui

import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.spitslide.chinesecharacters.R
import com.spitslide.chinesecharacters.viewmodels.ExerciseViewModel
import com.spitslide.chinesecharacters.viewmodels.GlobalViewModel


class ExerciseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exercise, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val exerciseViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)
        val globalViewModel = ViewModelProvider(requireActivity()).get(GlobalViewModel::class.java)

        val currentWords = exerciseViewModel.getBatchOfWords(globalViewModel)
        val listQuestionsAndAnswers =
            exerciseViewModel.getQuestionAnswersPairs(globalViewModel, currentWords)
        var numOfWrongTries = 0
        var numOfCorrectAnswers = 0

        listQuestionsAndAnswers.shuffle()
        view.findViewById<TextView>(R.id.question).text = listQuestionsAndAnswers[0].first

        val randomizedAnswerList = listQuestionsAndAnswers.map { it.second } as ArrayList<String>
        randomizedAnswerList.shuffle()

        val allButtons = arrayListOf<Button>()
        for (item in randomizedAnswerList) {
            val button = Button(activity)
            button.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            button.isAllCaps = false
            button.setOnClickListener {
                // TODO - in han exercises two answers might have the same text
                if (button.text == listQuestionsAndAnswers[0].second) {
                    if (numOfWrongTries == 0) {
                        numOfCorrectAnswers++
                    }
                    numOfWrongTries = 0
                    button.visibility = View.GONE
                    // since the list is shuffled, we can simply always remove the first item and
                    // take the next item
                    listQuestionsAndAnswers.removeAt(0)
                    if (listQuestionsAndAnswers.isNotEmpty()) {
                        view.findViewById<TextView>(R.id.question).text =
                            listQuestionsAndAnswers[0].first
                    } else {
                        Toast.makeText(
                            activity,
                            "Correct: " + numOfCorrectAnswers,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    numOfWrongTries++
                    if (numOfWrongTries >= 3) {
                        for (but in allButtons) {
                            // TODO - this might be problematic if button is hidden, but has the
                            //  correct answer (multiple buttons with correct answer)
                            if (but.text == listQuestionsAndAnswers[0].second) {
                                but.requestRectangleOnScreen(
                                    Rect(0, 0, but.width, but.height),
                                    false
                                );
                                but.setBackgroundColor(Color.RED)
                            }
                        }
                    }
                }
            }
            button.text = item
            button.textSize = 30f
            allButtons.add(button)
            (view.findViewById(R.id.gridlayoutexercise) as LinearLayout).addView(button)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}