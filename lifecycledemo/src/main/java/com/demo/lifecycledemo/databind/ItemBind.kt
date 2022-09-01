package com.demo.lifecycledemo.databind

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object ItemBind {
    @androidx.databinding.BindingAdapter(value = ["android:imageUrl"])
    @JvmStatic
    fun setUserPhoto(
        iView: ImageView,
        imageUrl: String
    ) {
        Picasso.get().load(imageUrl)
            .into(iView)
    }
}