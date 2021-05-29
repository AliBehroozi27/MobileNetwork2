package com.example.myapplication.ui.util

import android.widget.ImageView
import com.example.myapplication.R
import com.squareup.picasso.Picasso

fun ImageView.loadFrom(imageUrl: String) {
    Picasso
        .get()
        .load(imageUrl)
        .placeholder(R.color.photo_background)
        .into(this)
}
