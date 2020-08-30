package com.hanabi.androidbt8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.hanabi.androidbt8.model.Comic;
import com.hanabi.androidbt8.model.ListComics;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryDetailActivity extends AppCompatActivity {

    private CircleImageView civContent;
    private TextView tvName, tvAuthor, tvChapter, tvUpdateTime, tvContent;
    private Comic comic = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();
    }

    private void initViews() {
        setComic();
        civContent = findViewById(R.id.civ_content);
        tvName = findViewById(R.id.tv_name);
        tvAuthor = findViewById(R.id.tv_author);
        tvUpdateTime = findViewById(R.id.tv_update_time);
        tvChapter = findViewById(R.id.tv_chapter);
        tvContent = findViewById(R.id.tv_content);

        tvContent.setMovementMethod(new ScrollingMovementMethod());
        civContent.setImageResource(comic.getImage());
        tvName.setText(comic.getName());
        tvAuthor.setText("Tác giả: " + comic.getAuthor());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
        String dateStr = dateFormat.format(comic.getUpdateTime());
        tvUpdateTime.setText("Ngày cập nhật: " + dateStr);
        tvChapter.setText("Chương mới nhất: " + comic.getNewChapter());
        tvContent.setText(comic.getContent());

    }

    private void setComic() {
        Intent intent = getIntent();
        int idComic = intent.getIntExtra(StoryListActivity.EXTRA_COMIC, 0);
        for (Comic item : ListComics.getComics()) {
            if (item.getIdComic() == idComic) {
                comic = item;
                break;
            }
        }
    }

}