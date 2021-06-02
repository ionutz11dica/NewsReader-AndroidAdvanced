package com.ionutconstantinnicolae.newsreader.feature.newslist.model;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;

public class ArticleItemViewModel {

    @Nullable
    public Integer id;
    public final ObservableField<String> urlPhoto;
    public final ObservableField<String> titleNews;
    public final ObservableField<String> contentNews;

    public ArticleItemViewModel(){
        urlPhoto = new ObservableField<>();
        titleNews = new ObservableField<>();
        contentNews = new ObservableField<>();
    }

    public ArticleItemViewModel(String url, String title, String content){
        urlPhoto = new ObservableField<>(url);
        titleNews = new ObservableField<>(title);
        contentNews = new ObservableField<>(content);
    }
}
