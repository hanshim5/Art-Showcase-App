package com.example.artspace.artworks

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Artwork(
    @StringRes val artistNameResourceId: Int,   // Artist name string resource
    @StringRes val artTitleResourceId: Int,     // Artwork title string resource
    @DrawableRes val imageResourceId: Int       // Image drawable resource
)