package com.ionutconstantinnicolae.newsreader.feature.newslist.model;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;

import com.ionutconstantinnicolae.data.feature.news.model.Article;

public class ArticleItemViewModel {

    @Nullable
    public Integer id;
    public final ObservableField<String> urlPhoto;
    public final ObservableField<String> titleNews;
    public final ObservableField<String> contentNews;
    public final ObservableField<String> descriptionNews;

    public ArticleItemViewModel(){
        urlPhoto = new ObservableField<>();
        titleNews = new ObservableField<>();
        contentNews = new ObservableField<>();
        descriptionNews = new ObservableField<>();
    }

    public ArticleItemViewModel(Article article){
        urlPhoto = new ObservableField<>(article.imageUrl);
        titleNews = new ObservableField<>(article.title);
        contentNews = new ObservableField<>(article.content);
        descriptionNews = new ObservableField<>(article.description);
    }
}
