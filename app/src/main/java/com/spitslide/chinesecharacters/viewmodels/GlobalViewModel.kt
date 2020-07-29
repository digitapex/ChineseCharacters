package com.spitslide.chinesecharacters.viewmodels

import androidx.lifecycle.ViewModel
import com.spitslide.chinesecharacters.Constants

class GlobalViewModel : ViewModel() {
    lateinit var questionLanguage: Constants.LANG
    lateinit var answerLanguage: Constants.LANG
    lateinit var hsk: Constants.HSKs
    var whichBatch = 0

}