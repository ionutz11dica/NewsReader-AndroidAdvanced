package com.ionutconstantinnicolae.newsreader.feature.newslist.model.mapper;

import com.ionutconstantinnicolae.data.feature.news.local.ArticleEntity;
import com.ionutconstantinnicolae.newsreader.feature.newslist.model.ArticleItemViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleEntityToArticleItemViewModel implements Function<List<ArticleEntity>, List<ArticleItemViewModel>> {
    @Override
    public List<ArticleItemViewModel> apply(@NotNull List<ArticleEntity> articleEntityList) throws Exception {
        List<ArticleItemViewModel> articleItemViewModels = new ArrayList<>();
        for( ArticleEntity articleItem: articleEntityList){
            ArticleItemViewModel articleItemViewModel = new ArticleItemViewModel();
            articleItemViewModel.contentNews.set(articleItem.content);
            articleItemViewModel.urlPhoto.set(articleItem.imageUrl);
            articleItemViewModel.titleNews.set(articleItem.title);
            articleItemViewModels.add(articleItemViewModel);
        }

        return articleItemViewModels;
    }
}
