package com.spitslide.chinesecharacters.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface WordDao {
    @Query("select * from HSK1 LIMIT :count OFFSET :offset")
    fun loadBatchOfWordsHsk1(offset: Int, count: Int): List<HSK1>

    @Query("select * from HSK2 LIMIT :count OFFSET :offset")
    fun loadBatchOfWordsHsk2(offset: Int, count: Int): List<HSK2>

    @Query("select * from HSK3 LIMIT :count OFFSET :offset")
    fun loadBatchOfWordsHsk3(offset: Int, count: Int): List<HSK3>

    @Query("select * from HSK4 LIMIT :count OFFSET :offset")
    fun loadBatchOfWordsHsk4(offset: Int, count: Int): List<HSK4>

    @Query("select * from HSK5 LIMIT :count OFFSET :offset")
    fun loadBatchOfWordsHsk5(offset: Int, count: Int): List<HSK5>

    @Query("select * from HSK6 LIMIT :count OFFSET :offset")
    fun loadBatchOfWordsHsk6(offset: Int, count: Int): List<HSK6>
}