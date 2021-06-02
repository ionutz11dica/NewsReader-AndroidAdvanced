package com.ionutconstantinnicolae.newsreader.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ionutconstantinnicolae.newsreader.databinding.NewsreaderListFragmentBinding;
import com.ionutconstantinnicolae.newsreader.feature.newslist.model.NewsListViewModel;

public class NewsListFragment extends Fragment {

    private NewsListViewModel mViewModel;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        NewsreaderListFragmentBinding binding = NewsreaderListFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NewsListViewModel.class);
        // TODO: Use the ViewModel
        getLifecycle().addObserver(mViewModel);

    }



}