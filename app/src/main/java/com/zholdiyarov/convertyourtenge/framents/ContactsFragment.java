package com.zholdiyarov.convertyourtenge.framents;

/**
 * Created by szholdiyarov on 4/21/15.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zholdiyarov.convertyourtenge.R;

public class ContactsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View windows = inflater.inflate(R.layout.fragment_contacts, container, false);
        ((TextView)windows.findViewById(R.id.textView)).setText("Windows");
        return windows;
    }}