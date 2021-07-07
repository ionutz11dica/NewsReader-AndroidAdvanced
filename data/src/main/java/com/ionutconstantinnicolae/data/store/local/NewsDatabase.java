package com.ionutconstantinnicolae.data.store.local;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ionutconstantinnicolae.data.feature.news.local.ArticleDao;
import com.ionutconstantinnicolae.data.feature.news.local.ArticleEntity;
import com.ionutconstantinnicolae.data.feature.news.model.Article;

@Database(entities = {Article.class},version = 2)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract ArticleDao articleDao();

}
