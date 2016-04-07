package com.chaleva.sassoni.projectc.artistsearch.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chaleva.sassoni.projectc.Artist;
import com.chaleva.sassoni.projectc.R;

import java.util.List;

/**
 * Created by sassa on 4/6/16.
 */
public class ArtistSearchRecyclerViewAdapter extends RecyclerView.Adapter<ArtistSearchRecyclerViewAdapter.ViewHolder> {

    private List<Artist> mArtistsList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.artist_search_list_row_txt);
        }
    }

    public ArtistSearchRecyclerViewAdapter(List<Artist> artistList) {
        mArtistsList = artistList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_search_list_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // TODO Check bounds
        holder.mTextView.setText(mArtistsList.get(position).getDisplayName());
    }

    @Override
    public int getItemCount() {
        return (mArtistsList == null || mArtistsList.size() == 0) ? 0 : mArtistsList.size();
    }

    public void updateData(List<Artist> list) {
        if (mArtistsList != null) {
            mArtistsList.clear();
            mArtistsList.addAll(list);
        } else {
            mArtistsList = list;
        }
        notifyDataSetChanged();
    }
}
