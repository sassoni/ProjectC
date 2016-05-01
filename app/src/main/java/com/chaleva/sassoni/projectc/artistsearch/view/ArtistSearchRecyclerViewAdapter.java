package com.chaleva.sassoni.projectc.artistsearch.view;

import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
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

    private String mSearchedArtist;
    private List<Artist> mArtistsList;
    private StyleSpan mBold;
    private ArtistClickedListener mListener;

    public interface ArtistClickedListener {

        void onArtistClicked(Artist artist);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public View mView;

        public ViewHolder(View v) {
            super(v);
            mView = v;
            mTextView = (TextView) v.findViewById(R.id.artist_search_list_row_txt);
        }
    }

    public ArtistSearchRecyclerViewAdapter(List<Artist> artistList, ArtistClickedListener listener) {
        mArtistsList = artistList;
        mListener = listener;
        mBold = new StyleSpan(android.graphics.Typeface.BOLD);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_search_list_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // TODO Check bounds
        final Artist artist = mArtistsList.get(position);

        // Setup name
        String displayName = artist.getDisplayName();
        int index = displayName.toLowerCase().indexOf(mSearchedArtist.toLowerCase());
        SpannableStringBuilder sb = new SpannableStringBuilder(displayName);
        if (index != -1) {
            sb.setSpan(mBold, index, index + mSearchedArtist.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }
        holder.mTextView.setText(sb);

        // Setup click
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onArtistClicked(artist);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mArtistsList == null || mArtistsList.size() == 0) ? 0 : mArtistsList.size();
    }

    public void updateData(String searchedArtist, List<Artist> list) {
        mSearchedArtist = searchedArtist;
        if (mArtistsList != null) {
            mArtistsList.clear();
            mArtistsList.addAll(list);
        } else {
            mArtistsList = list;
        }
        notifyDataSetChanged();
    }
}
