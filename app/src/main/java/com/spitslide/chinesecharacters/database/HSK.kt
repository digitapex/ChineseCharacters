package com.spitslide.chinesecharacters.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class HSK1(
    id: Int, chinesesimplified: String, chinesetraditional: String, pinyinnumbered: String,
    pinyinaccented: String, english: String
) : HSKBase(
    id, chinesesimplified,
    chinesetraditional,
    pinyinnumbered, pinyinaccented, english
)

@Entity
class HSK2(
    id: Int, chinesesimplified: String, chinesetraditional: String, pinyinnumbered: String,
    pinyinaccented: String, english: String
) : HSKBase(
    id, chinesesimplified,
    chinesetraditional,
    pinyinnumbered, pinyinaccented, english
)

@Entity
class HSK3(
    id: Int, chinesesimplified: String, chinesetraditional: String, pinyinnumbered: String,
    pinyinaccented: String, english: String
) : HSKBase(
    id, chinesesimplified,
    chinesetraditional,
    pinyinnumbered, pinyinaccented, english
)

@Entity
class HSK4(
    id: Int, chinesesimplified: String, chinesetraditional: String, pinyinnumbered: String,
    pinyinaccented: String, english: String
) : HSKBase(
    id, chinesesimplified,
    chinesetraditional,
    pinyinnumbered, pinyinaccented, english
)

@Entity
class HSK5(
    id: Int, chinesesimplified: String, chinesetraditional: String, pinyinnumbered: String,
    pinyinaccented: String, english: String
) : HSKBase(
    id, chinesesimplified,
    chinesetraditional,
    pinyinnumbered, pinyinaccented, english
)

@Entity
class HSK6(
    id: Int, chinesesimplified: String, chinesetraditional: String, pinyinnumbered: String,
    pinyinaccented: String, english: String
) : HSKBase(
    id, chinesesimplified,
    chinesetraditional,
    pinyinnumbered, pinyinaccented, english
)

open class HSKBase(
    @PrimaryKey val id: Int,
    val chinesesimplified: String,
    val chinesetraditional: String,
    val pinyinnumbered: String,
    val pinyinaccented: String,
    val english: String
)

