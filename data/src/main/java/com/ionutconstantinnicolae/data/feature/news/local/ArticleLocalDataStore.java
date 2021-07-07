package com.ionutconstantinnicolae.data.feature.news.local;

import com.ionutconstantinnicolae.data.feature.news.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleSource;

public class ArticleLocalDataStore {

    private ArticleDao articleDao;

    public ArticleLocalDataStore(ArticleDao articleDao){
        this.articleDao = articleDao;
    }

    public Single<List<Article>> getArticleList() {
        return articleDao.queryArticles();
    }

    public Completable insertArticles(List<Article> articles){
        if (articles.isEmpty()) { return null; }
        return articleDao.insertArticles(articles);

    }



}
