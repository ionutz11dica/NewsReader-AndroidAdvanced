package com.ionutconstantinnicolae.data.feature.news.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


public class ArticleEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public String imageUrl;

    public String title;

    public String content;

    public String description;

}
