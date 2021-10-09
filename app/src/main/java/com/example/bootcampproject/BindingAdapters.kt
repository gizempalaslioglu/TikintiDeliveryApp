package com.example.bootcampproject

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:resim")
fun setImageResource(imageView: ImageView, resim_adi: String) {
    val id = imageView.context.resources.getIdentifier(
        resim_adi,
        "drawable",
        imageView.context.packageName
    )
    imageView.setImageResource(id)
}


