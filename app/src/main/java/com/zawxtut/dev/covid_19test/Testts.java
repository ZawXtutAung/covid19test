package com.zawxtut.dev.covid_19test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Testts extends Fragment {
    final static String DB_URL = "https://covid-19-test-19983.firebaseio.com/";
    RecyclerView rv;
    View v;
    LinearLayoutManager llayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
         v= inflater.inflate(R.layout.new_page, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rv = (RecyclerView)v. findViewById(R.id.new_page_rcr);
         llayoutManager = new LinearLayoutManager(this.getContext());
        rv.setLayoutManager(llayoutManager);
    }
}
