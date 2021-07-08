package com.ionutconstantinnicolae.data.feature.news;

import androidx.annotation.NonNull;

import com.ionutconstantinnicolae.data.NewsRepository;
import com.ionutconstantinnicolae.data.feature.news.local.ArticleEntity;
import com.ionutconstantinnicolae.data.feature.news.local.ArticleLocalDataStore;
import com.ionutconstantinnicolae.data.feature.news.mapper.ArticleToArticleEntry;
import com.ionutconstantinnicolae.data.feature.news.remote.NewsRemoteSource;
import java.util.List;
import io.reactivex.Completable;
import io.reactivex.Single;
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
    public Single<List<ArticleEntity>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .map(new ArticleToArticleEntry())
                .doOnSuccess(localSource::insertArticles)
                .onErrorResumeNext(localSource.getArticleList());
    }

    @NonNull
    @Override
    public Completable saveArticleList(List<ArticleEntity> articleList) {
        return localSource.insertArticles(articleList)
                .subscribeOn(Schedulers.io());
    }

    @NonNull
    @Override
    public Single<List<ArticleEntity>> getArticleList() {
        return localSource.getArticleList()
                .subscribeOn(Schedulers.io());
    }
}
