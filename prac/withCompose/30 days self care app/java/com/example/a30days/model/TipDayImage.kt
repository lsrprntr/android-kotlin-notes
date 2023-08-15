package com.example.a30days.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class TipDayImage(
    @IntegerRes val day: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val tip: Int,
)
