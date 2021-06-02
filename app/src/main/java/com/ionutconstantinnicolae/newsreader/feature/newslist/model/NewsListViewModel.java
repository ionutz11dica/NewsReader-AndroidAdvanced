package com.ionutconstantinnicolae.newsreader.feature.newslist.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class NewsListViewModel extends ViewModel implements LifecycleObserver {
    private static final String TAG = NewsListViewModel.class.getName();

    @NonNull
    public final ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList<>();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh(){
        Log.d(TAG,"refresh()");

        if(newsList.isEmpty()){
            for(int i = 0; i < 10 ; i++){
                newsList.add(new ArticleItemViewModel("Url "+i,"Title "+i, "Content "+i));
            }
        }
    }

}
