package me.lexichristiansen.lyrics.lyriclist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import me.lexichristiansen.lyrics.R;

/**
 * ViewHolder for {@link LyricListAdapter}.
 */
public class LyricListViewHolder extends RecyclerView.ViewHolder {

    private TextView lyricsTitle;
    private View entireLayout;

    public LyricListViewHolder(View itemView) {
        super(itemView);
        lyricsTitle = (TextView) itemView.findViewById(R.id.text);
        entireLayout = itemView;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.entireLayout.setOnClickListener(onClickListener);
    }

    public void setTitle(String title) {
        lyricsTitle.setText(title);
    }
}
