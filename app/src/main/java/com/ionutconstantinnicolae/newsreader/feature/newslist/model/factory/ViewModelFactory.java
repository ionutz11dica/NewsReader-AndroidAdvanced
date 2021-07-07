package com.ionutconstantinnicolae.newsreader.feature.newslist.model.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ionutconstantinnicolae.data.NewsRepository;
import com.ionutconstantinnicolae.newsreader.NewsReaderApplication;
import com.ionutconstantinnicolae.newsreader.feature.newslist.model.NewsListViewModel;

import org.jetbrains.annotations.NotNull;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;

    public ViewModelFactory(Application application) {
        this.application = application;
    }

    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NewsListViewModel.class)) {
            NewsRepository repository = NewsReaderApplication.getRepoProvider().provideNewsRepository();

        return (T) new NewsListViewModel(application,repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
