package com.chaleva.sassoni.projectc.concertlist.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chaleva.sassoni.projectc.Concert;
import com.chaleva.sassoni.projectc.R;

import java.util.List;

/**
 * Created by cchaleva on 3/30/16.
 */
public class ConcertListRecyclerViewAdapter extends RecyclerView.Adapter<ConcertListRecyclerViewAdapter.ViewHolder> {

    private List<Concert> mConcertList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.concert_list_row_txt);
        }
    }

    public ConcertListRecyclerViewAdapter(List<Concert> concertList) {
        mConcertList = concertList;
    }

    @Override
    public ConcertListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.concert_list_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // TODO Check bounds
        holder.mTextView.setText(mConcertList.get(position).getDisplayName());
    }

    @Override
    public int getItemCount() {
        return (mConcertList == null || mConcertList.size() == 0) ? 0 : mConcertList.size();
    }

    public void updateData(List<Concert> list) {
        if (mConcertList != null) {
            mConcertList.clear();
            mConcertList.addAll(list);
        } else {
            mConcertList = list;
        }
        notifyDataSetChanged();
    }
}
