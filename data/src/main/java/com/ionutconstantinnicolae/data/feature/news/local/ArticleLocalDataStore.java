package com.ionutconstantinnicolae.data.feature.news.local;

import java.util.List;
import io.reactivex.Completable;
import io.reactivex.Single;

public class ArticleLocalDataStore {

    private final ArticleDao articleDao;

    public ArticleLocalDataStore(ArticleDao articleDao){
        this.articleDao = articleDao;
    }

    public Single<List<ArticleEntity>> getArticleList() {
        return articleDao.queryArticles();
    }

    public Completable insertArticles(List<ArticleEntity> articles) {
        if (articles.isEmpty()) {
            return null;
        }
        return articleDao.insertArticles(articles);

    }

}
