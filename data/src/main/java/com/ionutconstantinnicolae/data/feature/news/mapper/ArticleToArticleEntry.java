package com.ionutconstantinnicolae.data.feature.news.mapper;

import com.ionutconstantinnicolae.data.feature.news.local.ArticleEntity;
import com.ionutconstantinnicolae.data.feature.news.model.Article;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.functions.Function;

public class ArticleToArticleEntry implements Function<List<Article>, List<ArticleEntity>> {
    @Override
    public List<ArticleEntity> apply(@NotNull List<Article> articleEntityList) throws Exception {
        List<ArticleEntity> articleItemViewModels = new ArrayList<>();
        for( Article articleItem: articleEntityList){
            ArticleEntity articleEntity = new ArticleEntity(articleItem.imageUrl, articleItem.title,articleItem.content,articleItem.description);

            articleItemViewModels.add(articleEntity);
        }

        return articleItemViewModels;
    }
}