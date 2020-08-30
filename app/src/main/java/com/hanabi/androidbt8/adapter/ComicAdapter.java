package com.hanabi.androidbt8.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.hanabi.androidbt8.R;
import com.hanabi.androidbt8.model.Comic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<Comic> data;
    private ComicItemListener comicItemListener;

    public ComicAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public void setData(ArrayList<Comic> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setComicItemListener(ComicItemListener comicItemListener) {
        this.comicItemListener = comicItemListener;
    }

    @NonNull
    @Override
    public ComicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.comic_view, parent, false);
        return new ComicHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicHolder holder, final int position) {
        final Comic comic = data.get(position);
        holder.bindData(comic);
        if (comicItemListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comicItemListener.onClickItem(comic);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ComicHolder extends RecyclerView.ViewHolder {
        private CircleImageView civContent;
        private TextView tvChapterAuthor, tvUpdateTime, tvName;

        public ComicHolder(@NonNull View itemView) {
            super(itemView);
            civContent = itemView.findViewById(R.id.civ_content);
            tvChapterAuthor = itemView.findViewById(R.id.tv_chapter_author);
            tvUpdateTime = itemView.findViewById(R.id.tv_update_time);
            tvName = itemView.findViewById(R.id.tv_name);

        }

        public void bindData(@NonNull Comic comic) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            String dateStr = dateFormat.format(comic.getUpdateTime());
            civContent.setImageResource(comic.getImage());
            tvName.setText(comic.getName());
            tvChapterAuthor.setText(String.format("Chương %s - t/g: %s", comic.getNewChapter(), comic.getAuthor()));
            tvUpdateTime.setText("Ngày cập nhật: " + dateStr);

        }

    }

    public interface ComicItemListener {
        void onClickItem(Comic comic);
    }

}
