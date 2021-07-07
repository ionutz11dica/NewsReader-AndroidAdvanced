package com.ionutconstantinnicolae.data.feature.news;

import androidx.annotation.NonNull;

import com.ionutconstantinnicolae.data.NewsRepository;
import com.ionutconstantinnicolae.data.feature.news.local.ArticleLocalDataStore;
import com.ionutconstantinnicolae.data.feature.news.model.Article;
import com.ionutconstantinnicolae.data.feature.news.remote.NewsRemoteSource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;
    private final ArticleLocalDataStore localSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource, ArticleLocalDataStore localDataStore) {
        this.remoteSource = remoteSource;
        this.localSource = localDataStore;
    }

    @NonNull
    @Override
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .doOnSuccess(localSource::insertArticles)
                .onErrorResumeNext(localSource.getArticleList());
    }



    @NonNull
    @Override
    public Completable saveArticleList(List<Article> articleList) {
        return localSource.insertArticles(articleList)
                .subscribeOn(Schedulers.io());
    }

    @NonNull
    @Override
    public Single<List<Article>> getArticleList() {
        return localSource.getArticleList()
                .subscribeOn(Schedulers.io());
    }
}
