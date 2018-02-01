package com.yehyunryu.android.listviewexample;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Yehyun Ryu on 10/28/2017.
 */

public class CustomAdapter extends ArrayAdapter<Integer> {
    private ArrayList<Integer> mNumbers;

    //constructor, context: current state of application, environment data, number: data
    public CustomAdapter(Context context, ArrayList<Integer> numbers) {
        super(context, R.layout.itemview, numbers);
        mNumbers = numbers;
    }

    //get number of data, in this case size of numbers arraylist
    @Override
    public int getCount() {
        return mNumbers.size();
    }

    //getView to use for the next listview item
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        //if convert view is null, inflate a new view (when there is no view in scrap views
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            listItemView = layoutInflater.inflate(R.layout.itemview, parent, false);
        }

        final int number = mNumbers.get(position);

        //set text to corresponding number
        TextView itemTextView = (TextView) listItemView.findViewById(R.id.itemview_text);
        itemTextView.setText(String.valueOf(mNumbers.get(position)));

        //set appropriate background color
        switch(number%9) {
            case 0:
                itemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.greenZero));
                break;
            case 1:
                itemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.greenOne));
                break;
            case 2:
                itemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.greenTwo));
                break;
            case 3:
                itemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.greenThree));
                break;
            case 4:
                itemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.greenFour));
                break;
            case 5:
                itemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.greenThree));
                break;
            case 6:
                itemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.greenTwo));
                break;
            case 7:
                itemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.greenOne));
                break;
            default:
                itemTextView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.greenZero));
        };

        //set onClickListener to listItemView
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Item Click: " + String.valueOf(number), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), ColorActivity.class);
                intent.putExtra("NUMBER", number);
                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}
