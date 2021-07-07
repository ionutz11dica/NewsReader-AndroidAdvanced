package com.ionutconstantinnicolae.newsreader.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ionutconstantinnicolae.newsreader.databinding.NewsreaderListFragmentBinding;
import com.ionutconstantinnicolae.newsreader.feature.newslist.model.NewsListViewModel;
import com.ionutconstantinnicolae.newsreader.feature.newslist.model.factory.ViewModelFactory;
import com.ionutconstantinnicolae.newsreader.feature.newslist.navigator.AlertNavigator;

public class NewsListFragment extends Fragment {

    private NewsListViewModel mViewModel;
    private AlertNavigator alertNavigator;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alertNavigator = new AlertNavigator(getChildFragmentManager(), requireContext());

        mViewModel = new ViewModelProvider(this, new ViewModelFactory(requireActivity().getApplication())).get(NewsListViewModel.class);
        mViewModel.error.observe(this, throwable -> alertNavigator.showErrorFor(throwable));
        mViewModel.openLink.observe(this,link-> openLink(link));
        getLifecycle().addObserver(mViewModel);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        NewsreaderListFragmentBinding binding = NewsreaderListFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }

    private void openLink(@NonNull String link) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);
    }




}