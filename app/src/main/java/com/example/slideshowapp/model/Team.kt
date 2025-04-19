package com.example.slideshowapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Team(
    @DrawableRes val imageResource: Int,
    @StringRes val teamName: Int
)
