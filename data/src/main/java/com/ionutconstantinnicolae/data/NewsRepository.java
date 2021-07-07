package com.ionutconstantinnicolae.data;

import com.ionutconstantinnicolae.data.feature.news.local.ArticleEntity;
import com.ionutconstantinnicolae.data.feature.news.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public interface NewsRepository {

    @NonNull
    Single<List<Article>> getNewsArticles();

    @androidx.annotation.NonNull
    Single<List<Article>> getArticleList();

    @androidx.annotation.NonNull
    Completable saveArticleList(List<Article> articleList);
}
