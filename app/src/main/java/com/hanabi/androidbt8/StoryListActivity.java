package com.hanabi.androidbt8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.hanabi.androidbt8.adapter.ComicAdapter;
import com.hanabi.androidbt8.model.Comic;
import com.hanabi.androidbt8.model.ListComics;

import java.util.ArrayList;

public class StoryListActivity extends AppCompatActivity implements ComicAdapter.ComicItemListener {

    public static final String EXTRA_COMIC = "extra.COMIC";
    private RecyclerView rc_comics;
    private ComicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initViews();
        initData();
    }

    private void initViews() {
        rc_comics = findViewById(R.id.rc_comics);
        adapter = new ComicAdapter(getLayoutInflater());
        adapter.setComicItemListener(this);
        rc_comics.setAdapter(adapter);
    }


    private void initData() {
        ArrayList<Comic> comics = ListComics.getComics();
        adapter.setData(comics);
    }

    @Override
    public void onClickItem(Comic comic) {
        Intent intent = new Intent(this, StoryDetailActivity.class);
        intent.putExtra(EXTRA_COMIC, comic.getIdComic());
        startActivity(intent);
    }

    @Override
    public void onClickItem(Comic comic, int position) {

    }
}