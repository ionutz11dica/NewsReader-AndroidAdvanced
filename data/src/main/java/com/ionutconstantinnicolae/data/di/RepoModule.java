package com.ionutconstantinnicolae.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.ionutconstantinnicolae.data.NewsRepository;
import com.ionutconstantinnicolae.data.feature.news.NewsRepositoryImpl;
import com.ionutconstantinnicolae.data.feature.news.local.ArticleLocalDataStore;
import com.ionutconstantinnicolae.data.feature.news.remote.NewsRemoteSource;
import com.ionutconstantinnicolae.data.remote.HttpClientFactory;
import com.ionutconstantinnicolae.data.store.local.NewsDatabase;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;
    private volatile NewsDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(),provideLocalDataStore());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }

    ArticleLocalDataStore provideLocalDataStore() {
        NewsDatabase database = getInstance();
        return new ArticleLocalDataStore(database.articleDao());
    }

    NewsDatabase getInstance() {
        if (database == null) {
            synchronized (NewsDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class, "news.db")
                            .build();
                }
            }
        }
        return database;
    }
}
