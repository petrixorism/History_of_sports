package uz.gita.historyofsports.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Sport(
    val title: String,

    @DrawableRes
    val image: Int,

    @StringRes
    val info: Int = 1
)