package com.yehyunryu.android.recyclerviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Yehyun Ryu on 11/4/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private Context mContext;
    private ArrayList<Integer> mNumbers;

    public RecyclerAdapter(Context context, ArrayList<Integer> numbers) {
        mContext = context;
        mNumbers = numbers;
    }

    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        int layoutId = R.layout.itemview;
        boolean attachToParent = false;

        View view = layoutInflater.inflate(layoutId, parent, attachToParent);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumbers.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mNumberTextView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mNumberTextView = (TextView) itemView.findViewById(R.id.item_textview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Testing", Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bind(int position) {
            int number = mNumbers.get(position);
            mNumberTextView.setText(String.valueOf(number));
        }
    }
}
