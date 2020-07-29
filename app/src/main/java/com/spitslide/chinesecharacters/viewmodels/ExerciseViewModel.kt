package com.spitslide.chinesecharacters.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.spitslide.chinesecharacters.Constants
import com.spitslide.chinesecharacters.database.HSKBase
import com.spitslide.chinesecharacters.database.WordDatabase

class ExerciseViewModel(application: Application) : AndroidViewModel(application) {

    private var listOfCurrentWords = listOf<HSKBase>()
    private val listQuestionsAndAnswers = arrayListOf<Pair<String, String>>()

    fun getBatchOfWords(globalViewModel: GlobalViewModel): List<HSKBase> {
        when (globalViewModel.hsk) {
            Constants.HSKs.HSK1 -> listOfCurrentWords = WordDatabase
                .getDatabase(getApplication()).wordDao()
                .loadBatchOfWordsHsk1(globalViewModel.whichBatch * 15, 15)
            Constants.HSKs.HSK2 -> listOfCurrentWords = WordDatabase
                .getDatabase(getApplication()).wordDao()
                .loadBatchOfWordsHsk2(globalViewModel.whichBatch * 15, 15)
            Constants.HSKs.HSK3 -> listOfCurrentWords = WordDatabase
                .getDatabase(getApplication()).wordDao()
                .loadBatchOfWordsHsk3(globalViewModel.whichBatch * 20, 20)
            Constants.HSKs.HSK4 -> listOfCurrentWords = WordDatabase
                .getDatabase(getApplication()).wordDao()
                .loadBatchOfWordsHsk4(globalViewModel.whichBatch * 20, 20)
            Constants.HSKs.HSK5 -> listOfCurrentWords = WordDatabase
                .getDatabase(getApplication()).wordDao()
                .loadBatchOfWordsHsk5(globalViewModel.whichBatch * 20, 20)
            Constants.HSKs.HSK6 -> listOfCurrentWords = WordDatabase
                .getDatabase(getApplication()).wordDao()
                .loadBatchOfWordsHsk6(globalViewModel.whichBatch * 20, 20)
        }
        return listOfCurrentWords

    }

    fun getQuestionAnswersPairs(
        globalViewModel: GlobalViewModel, listOfCurrentWords:
        List<HSKBase>
    ): MutableList<Pair<String, String>> {
        for (a in listOfCurrentWords) {
            var questionWord = ""
            var answerWord = ""
            when (globalViewModel.questionLanguage) {
                Constants.LANG.ENGLISH -> questionWord = a.english
                Constants.LANG.CHINESESIMPLIFIED -> questionWord = a.chinesesimplified
                Constants.LANG.PINYINACCENTED -> questionWord = a.pinyinaccented
            }
            when (globalViewModel.answerLanguage) {
                Constants.LANG.ENGLISH -> answerWord = a.english
                Constants.LANG.CHINESESIMPLIFIED -> answerWord = a.chinesesimplified
                Constants.LANG.PINYINACCENTED -> answerWord = a.pinyinaccented
            }
            val pair = Pair(questionWord, answerWord)
            listQuestionsAndAnswers.add(pair)
        }
        return listQuestionsAndAnswers
    }
}