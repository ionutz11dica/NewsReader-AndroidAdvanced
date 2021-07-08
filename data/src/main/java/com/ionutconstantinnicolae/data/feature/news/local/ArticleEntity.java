package com.ionutconstantinnicolae.data.feature.news.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "articles")
public class ArticleEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public final String imageUrl;

    public final String title;

    public final String content;

    public final String description;

    public ArticleEntity(@NonNull String imageUrl, @NonNull String title, @NonNull String content, @NonNull String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.description = description;
    }

}
