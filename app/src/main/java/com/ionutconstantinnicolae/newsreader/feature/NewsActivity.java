package com.ionutconstantinnicolae.newsreader.feature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ionutconstantinnicolae.newsreader.R;
import com.ionutconstantinnicolae.newsreader.ui.main.NewsListFragment;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsListFragment.newInstance())
                    .commitNow();
        }
    }
}