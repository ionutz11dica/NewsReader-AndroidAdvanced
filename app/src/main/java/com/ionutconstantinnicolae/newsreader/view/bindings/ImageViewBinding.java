package com.ionutconstantinnicolae.newsreader.view.bindings;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.ionutconstantinnicolae.newsreader.R;

public class ImageViewBinding {
    @BindingAdapter({"newsReaderItemImageUrl"})
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}
