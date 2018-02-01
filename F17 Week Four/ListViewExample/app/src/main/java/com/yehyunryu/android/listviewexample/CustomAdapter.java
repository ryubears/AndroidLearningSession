package com.yehyunryu.android.listviewexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yehyun Ryu on 10/28/2017.
 */

public class CustomAdapter extends ArrayAdapter<Integer> {
    private ArrayList<Integer> mNumbers;

    public CustomAdapter(Context context, ArrayList<Integer> numbers) {
        super(context, R.layout.itemview, numbers);
        mNumbers = numbers;
    }

    @Override
    public int getCount() {
        return mNumbers.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            listItemView = layoutInflater.inflate(R.layout.itemview, parent, false);
        }
        TextView itemTextView = (TextView) listItemView.findViewById(R.id.itemview_text);
        itemTextView.setText(String.valueOf(mNumbers.get(position)));
        return listItemView;
    }
}
