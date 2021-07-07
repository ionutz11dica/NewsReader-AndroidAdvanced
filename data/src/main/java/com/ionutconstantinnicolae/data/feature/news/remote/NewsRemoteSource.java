package com.ionutconstantinnicolae.data.feature.news.remote;

import com.ionutconstantinnicolae.data.feature.news.model.Article;
import com.ionutconstantinnicolae.data.feature.news.remote.mapper.NewsDtoToNewsMapper;
import com.ionutconstantinnicolae.data.remote.NewsApi;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {

    private static final String API_KEY = "f497af3a33c04edcae8d204142cdb500";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<List<Article>> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .map(new NewsDtoToNewsMapper())
                .subscribeOn(Schedulers.io());
    }

}
