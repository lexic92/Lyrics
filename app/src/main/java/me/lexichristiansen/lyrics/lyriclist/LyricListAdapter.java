package me.lexichristiansen.lyrics.lyriclist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.lexichristiansen.lyrics.LyricDetailActivity;
import me.lexichristiansen.lyrics.LyricDetailFragment;
import me.lexichristiansen.lyrics.R;
import me.lexichristiansen.lyrics.database.DatabaseHelper;
import me.lexichristiansen.lyrics.database.Lyric;

/**
 * RecyclerView adapter for {@link LyricListActivity}.
 */
public class LyricListAdapter extends RecyclerView.Adapter<LyricListViewHolder> {

    private Lyric[] allLyrics;
    private boolean isTwoPane;
    private FragmentManager fragmentManager;

    public LyricListAdapter(Context context, boolean isTwoPane, FragmentManager fragmentManager) {
        DatabaseHelper db = new DatabaseHelper(context);
        allLyrics = db.getAllLyrics();
        this.fragmentManager = fragmentManager;
        this.isTwoPane = isTwoPane;
    }

    @Override
    public LyricListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View lyricListItemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.lyric_list_item, parent, false);
        LyricListViewHolder LyricListViewHolder = new LyricListViewHolder(lyricListItemLayout);
        return LyricListViewHolder;
    }

    @Override
    public void onBindViewHolder(final LyricListViewHolder holder, int position) {
        final Lyric lyric = allLyrics[position];
        holder.setTitle(lyric.getTitle());
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putInt(LyricDetailFragment.ARG_ITEM_ID, lyric.getID());
                    LyricDetailFragment fragment = new LyricDetailFragment();
                    fragment.setArguments(arguments);
                    fragmentManager.beginTransaction()
                            .replace(R.id.lyric_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, LyricDetailActivity.class);
                    intent.putExtra(LyricDetailFragment.ARG_ITEM_ID, lyric.getID());
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return allLyrics.length;
    }
}
