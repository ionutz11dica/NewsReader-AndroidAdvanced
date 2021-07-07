package com.ionutconstantinnicolae.newsreader.feature.newslist.model.mapper;

import com.ionutconstantinnicolae.data.feature.news.local.ArticleEntity;
import com.ionutconstantinnicolae.data.feature.news.model.Article;
import com.ionutconstantinnicolae.newsreader.feature.newslist.model.ArticleItemViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleItemToArticleEntityMapper implements Function<List<ArticleItemViewModel>, List<ArticleEntity>> {

    @Override
    public List<ArticleEntity> apply(@NotNull List<ArticleItemViewModel> articles) throws Exception {
        List<ArticleEntity> articleEntities = new ArrayList<>();
        for( ArticleItemViewModel articleItem: articles){
            ArticleEntity articleEntity = new ArticleEntity();
            articleEntity.content = articleItem.contentNews.get();
            articleEntity.imageUrl = articleItem.urlPhoto.get();
            articleEntity.title = articleItem.titleNews.get();
            articleEntities.add(articleEntity);
        }


        return articleEntities;
    }
}
