package com.ionutconstantinnicolae.data.feature.news.model;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import io.reactivex.annotations.NonNull;


@Entity(tableName = "articles")
public class Article {
    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public String imageUrl;

    public String title;

    public String content;

    public String description;
    public Article(@NonNull String imageUrl, @NonNull String title, @NonNull String content, @NonNull String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.description = description;
    }


}
