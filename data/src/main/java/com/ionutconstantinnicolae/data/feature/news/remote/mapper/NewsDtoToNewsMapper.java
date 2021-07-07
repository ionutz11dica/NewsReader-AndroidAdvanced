package com.ionutconstantinnicolae.data.feature.news.remote.mapper;

import com.ionutconstantinnicolae.data.feature.news.model.Article;
import com.ionutconstantinnicolae.data.feature.news.remote.model.ArticleDto;
import com.ionutconstantinnicolae.data.feature.news.remote.model.ArticleListDto;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.functions.Function;

public class NewsDtoToNewsMapper implements Function<ArticleListDto, List<Article>> {
    @Override
    public List<Article> apply(ArticleListDto articleListDto) {
        List<Article> articles = new ArrayList<>();

        for (ArticleDto dto : articleListDto.articles) {
            Article article = new Article(
                    dto.urlToImage != null ? dto.urlToImage : "",
                    dto.title != null ? dto.title : "",
                    dto.content != null ? dto.content : "",
                    dto.description != null ? dto.description : ""
            );

            articles.add(article);
        }

        return articles;
    }
}
