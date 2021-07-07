package com.ionutconstantinnicolae.newsreader.feature.newslist.model.mapper;

import com.ionutconstantinnicolae.data.feature.news.model.Article;
import com.ionutconstantinnicolae.newsreader.feature.newslist.model.ArticleItemViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleToArticleItemViewModel implements Function<List<Article>, List<ArticleItemViewModel>> {


    @Override
    public List<ArticleItemViewModel> apply(@NotNull List<Article> articles) throws Exception {
        List<ArticleItemViewModel> articleItemViewModels = new ArrayList<>();
        for( Article article: articles){
            ArticleItemViewModel articleItemViewModel = new ArticleItemViewModel();
            articleItemViewModel.urlPhoto.set(article.imageUrl);
            articleItemViewModel.titleNews.set(article.title);
            articleItemViewModel.contentNews.set(article.content);
            articleItemViewModel.descriptionNews.set(article.description);
            articleItemViewModels.add(articleItemViewModel);
        }
        return articleItemViewModels;
    }
}

