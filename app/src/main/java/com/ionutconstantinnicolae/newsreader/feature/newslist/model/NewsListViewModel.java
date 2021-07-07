package com.ionutconstantinnicolae.newsreader.feature.newslist.model;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.ionutconstantinnicolae.data.NewsRepository;
import com.ionutconstantinnicolae.data.feature.news.local.ArticleEntity;
import com.ionutconstantinnicolae.newsreader.feature.newslist.model.mapper.ArticleEntityToArticleItemViewModel;
import com.ionutconstantinnicolae.newsreader.feature.newslist.model.reactive.SingleLiveEvent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class NewsListViewModel extends AndroidViewModel implements LifecycleObserver {

    private static final String TAG = NewsListViewModel.class.getName();

    private final static String LINK = "https://newsapi.org/";
    private final NewsRepository repo;
    public final ObservableField<String> resultText;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;

    @NonNull
    public final ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList<>();

    public NewsListViewModel(Application application, NewsRepository repo) {
        super(application);
        this.repo = repo;
        this.openLink = new SingleLiveEvent<>();;
        this.resultText = new ObservableField<>();
        this.error = new SingleLiveEvent<>();
    }

    private void onNewsArticlesReceived(@NonNull List<ArticleEntity> articles) throws Exception {
        newsList.addAll(new ArticleEntityToArticleItemViewModel().apply(articles));
    }

    @SuppressLint("CheckResult")
    private void onNewsArticlesError(Throwable throwable) {
        error.setValue(throwable);
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh(){
        repo.getNewsArticles()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }
}
