package com.zholdiyarov.convertyourtenge.helpers;

/**
 * Created by szholdiyarov on 4/21/15.
 */

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zholdiyarov.convertyourtenge.R;


public class CustomListAdapter extends ArrayAdapter<String> {

    private Activity context;
    private String[] itemname;
    private String[] imgId;
    private String[] rate;
    private LayoutInflater inflater;
    private View rowView;
    private TextView txtTitle;
    private ImageView imageView;
    private TextView extratxt;
    ImageLoader imageLoader;

/*
    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid, String[] rate) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
        this.rate = rate;


        if(rate == null){
            Log.i("Custom Activit Adapter"," rate is null");
        }
    }*/

    public CustomListAdapter(Activity context, String[] itemname, String[] imgId, String[] rate) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.imgId = imgId;
        this.rate = rate;
        imageLoader = new ImageLoader(context.getApplicationContext());


        if (rate == null) {
            Log.i("Custom Activit Adapter", " rate is null");
        }
    }


    public View getView(int position, View view, ViewGroup parent) {
        Log.i("Custom List Adapter", " getView()");

        inflater = context.getLayoutInflater();
        rowView = inflater.inflate(R.layout.mylist, null, true);

        txtTitle = (TextView) rowView.findViewById(R.id.item);
        imageView = (ImageView) rowView.findViewById(R.id.icon);

        extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        //imageView.setImageResource(imgId[position]);
        imageLoader.DisplayImage(imgId[position], imageView);
        extratxt.setText("Курс: " + rate[position]);
        return rowView;

    }
}