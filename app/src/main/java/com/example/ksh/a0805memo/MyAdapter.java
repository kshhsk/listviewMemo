package com.example.ksh.a0805memo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ksh on 2016-08-05.
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Data> items;
    public MyAdapter(Context context, ArrayList<Data> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_list, null);

        TextView titleText = (TextView) view.findViewById(R.id.date);
        TextView dateText = (TextView) view.findViewById(R.id.content);

        Data data = items.get(position);

        titleText.setText(data.date);
        dateText.setText(data.content);

        return view;
    }
}
