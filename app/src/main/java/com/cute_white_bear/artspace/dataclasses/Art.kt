package com.cute_white_bear.artspace.dataclasses

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Art(
    var id: Int,
    @DrawableRes var image: Int,
    @StringRes var title: Int,
    @StringRes var author: Int,
)