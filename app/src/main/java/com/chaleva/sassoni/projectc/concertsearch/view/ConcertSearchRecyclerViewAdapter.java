package com.chaleva.sassoni.projectc.concertsearch.view;

import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chaleva.sassoni.projectc.Artist;
import com.chaleva.sassoni.projectc.Concert;
import com.chaleva.sassoni.projectc.R;

import java.util.List;

/**
 * Created by sassa on 4/10/16.
 */
public class ConcertSearchRecyclerViewAdapter extends RecyclerView.Adapter<ConcertSearchRecyclerViewAdapter.ViewHolder> {

    private List<Concert> mConcertsList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.concert_search_list_row_txt);
        }
    }

    public ConcertSearchRecyclerViewAdapter(List<Concert> concertsList) {
        mConcertsList = concertsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.concert_search_list_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // TODO Check bounds
        String title = mConcertsList.get(position).getDisplayName();
        holder.mTextView.setText(title);
    }

    @Override
    public int getItemCount() {
        return (mConcertsList == null || mConcertsList.size() == 0) ? 0 : mConcertsList.size();
    }

    public void updateData(List<Concert> list) {
        if (mConcertsList != null) {
            mConcertsList.clear();
            mConcertsList.addAll(list);
        } else {
            mConcertsList = list;
        }
        notifyDataSetChanged();
    }
}
