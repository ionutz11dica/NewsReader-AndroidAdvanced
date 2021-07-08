package com.ionutconstantinnicolae.newsreader.feature.newslist.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.ionutconstantinnicolae.newsreader.databinding.NewsReaderItemBinding;
import com.ionutconstantinnicolae.newsreader.feature.newslist.model.ArticleItemViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<ArticleItemViewModel> articleModelList;

    @NonNull
    @NotNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        NewsReaderItemBinding binder = NewsReaderItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new NewsViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NewsViewHolder holder, int position) {
        holder.binding.setViewModel(articleModelList.get(position));

    }

    @Override
    public int getItemCount() {
        return articleModelList.size();
    }

    public void setArticleItems(List<ArticleItemViewModel> items){
        this.articleModelList = items;
        notifyDataSetChanged();
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder {
        final NewsReaderItemBinding binding;

        public NewsViewHolder(NewsReaderItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
