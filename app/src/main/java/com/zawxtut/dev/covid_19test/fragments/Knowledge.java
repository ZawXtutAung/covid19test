package com.zawxtut.dev.covid_19test.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zawxtut.dev.covid_19test.R;
import com.zawxtut.dev.covid_19test.adapters.MainKnowledgeAdapter;
import com.zawxtut.dev.covid_19test.modes.KnowModeMain;

import java.util.ArrayList;

public class Knowledge extends Fragment {
    View know_v;
    RecyclerView knowRecyclerView;
    //KnowledgeRecyclerViewAdapter myKnadapter;
    ArrayList<KnowModeMain> listItems = new ArrayList<>();
    MainKnowledgeAdapter mainKnAdapter;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         know_v= inflater.inflate(R.layout.knowledge,container,false);
     //   initData();
        return know_v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        knowRecyclerView=know_v.findViewById(R.id.knowRcr);
        knowRecyclerView.setHasFixedSize(true);
        knowRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainKnAdapter=new MainKnowledgeAdapter(getContext());
//        myKnadapter=new KnowledgeRecyclerViewAdapter(getActivity());
        knowRecyclerView.setAdapter(mainKnAdapter);

    }

}
