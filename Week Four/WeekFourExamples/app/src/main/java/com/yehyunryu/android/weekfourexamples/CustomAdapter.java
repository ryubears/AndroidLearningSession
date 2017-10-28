package com.yehyunryu.android.weekfourexamples;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yehyun Ryu on 10/27/2017.
 */

public class CustomAdapter extends ArrayAdapter<Integer> {
    private ArrayList<Integer> mNumbers;

    public CustomAdapter(Context context, ArrayList<Integer> numbers) {
        super(context, 0, numbers);
        mNumbers = numbers;
    }

    @Override
    public int getCount() {
        return mNumbers.size();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.itemview, viewGroup, false);
        }

        TextView mItemTextView = listItemView.findViewById(R.id.itemview_text);
        final int number = mNumbers.get(i);
        mItemTextView.setText(String.valueOf(number));

        int colorNum = number % 10;
        switch(colorNum) {
            case 9:
                mItemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.green1));
                break;
            case 8:
                mItemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.green2));
                break;
            case 7:
                mItemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.green3));
                break;
            case 6:
                mItemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.green4));
                break;
            case 5:
                mItemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.green5));
                break;
            case 4:
                mItemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.green5));
                break;
            case 3:
                mItemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.green4));
                break;
            case 2:
                mItemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.green3));
                break;
            case 1:
                mItemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.green2));
                break;
            default:
                mItemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.green1));
        }

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ColorActivity.class);
                intent.putExtra("Number", number);
                getContext().startActivity(intent);
            }
        });
        return listItemView;
    }
}
