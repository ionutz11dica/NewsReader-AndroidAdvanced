package com.ionutconstantinnicolae.newsreader.feature.newslist.model.mapper;

import com.ionutconstantinnicolae.data.feature.news.model.Article;
import com.ionutconstantinnicolae.newsreader.feature.newslist.model.ArticleItemViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleItemViewModelToArticle implements Function<List<ArticleItemViewModel>, List<Article>> {



    @Override
    public List<Article> apply(@NotNull List<ArticleItemViewModel> articleItemViewModels) throws Exception {
        List<Article> articles = new ArrayList<>();
        for( ArticleItemViewModel articleItemViewModel: articleItemViewModels){
            Article article = new Article(articleItemViewModel.urlPhoto.get(), articleItemViewModel.titleNews.get(),articleItemViewModel.contentNews.get(),articleItemViewModel.descriptionNews.get());

            articles.add(article);
        }
        return articles;
    }
}
