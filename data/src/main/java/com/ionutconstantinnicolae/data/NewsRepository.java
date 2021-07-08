package com.ionutconstantinnicolae.data;

import com.ionutconstantinnicolae.data.feature.news.local.ArticleEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public interface NewsRepository {

    @NonNull
    Single<List<ArticleEntity>> getNewsArticles();

    @NonNull
    Single<List<ArticleEntity>> getArticleList();

    @NonNull
    Completable saveArticleList(List<ArticleEntity> articleList);
}
