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
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        //if convert view is null, inflate a new view (when there is no view in scrap views
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            listItemView = layoutInflater.inflate(R.layout.itemview, parent, false);
        }

        //set text to corresponding number
        TextView itemTextView = (TextView) listItemView.findViewById(R.id.itemview_text);
        itemTextView.setText(String.valueOf(mNumbers.get(position)));

        //TODO 2. Add appropriate background color depending on number
        //TODO 4. Add OnClickListener to listItemView
        //TODO 5. Display Toast to check if OnClick works
        //TODO 6. Create new Activity called ColorActivity
        //TODO 7. Add TextView to ColorActivity layout file
        //TODO 8. Start ColorActivity when item is clicked
        //TODO 9. Pass in number to intent
        //TODO 10. Bind TextView in ColorActivity
        //TODO 11. Get number in ColorActivity and display appropriate number and background

        return listItemView;
    }
}
