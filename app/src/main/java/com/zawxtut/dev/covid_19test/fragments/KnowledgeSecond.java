package com.zawxtut.dev.covid_19test.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zawxtut.dev.covid_19test.R;
import com.zawxtut.dev.covid_19test.adapters.SecondKnowAdapter;

public class KnowledgeSecond extends AppCompatActivity {
    Bundle bundle;
    SecondKnowAdapter secondAdapter;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;

    int[] img1={R.drawable.whos1,R.drawable.whos2,R.drawable.whos3,
            R.drawable.whos5,R.drawable.whos6,R.drawable.whos7,
            R.drawable.whos8,R.drawable.whos9,R.drawable.whos10,R.drawable.whos11,R.drawable.whos12};

    int[] img2={R.drawable.mmrt1,R.drawable.mmrt2,R.drawable.mmrt3,R.drawable.mmrt4,R.drawable.mmrt51};

    int[] img3={R.drawable.trae1,R.drawable.trae2,R.drawable.trae3};

    int[] img4a={R.drawable.hang1,R.drawable.hang2,R.drawable.hang3,R.drawable.hang4,R.drawable.hang5
            ,R.drawable.hang6,R.drawable.hang7,R.drawable.hang8,R.drawable.hang9,R.drawable.hang5};
    int[] img4b={R.drawable.hangb1,R.drawable.hangb2,R.drawable.hangb3,R.drawable.hangb4,R.drawable.hangb5
            ,R.drawable.hangb6,R.drawable.hangb7,R.drawable.hangb8,R.drawable.hangb9,R.drawable.hangb10
            ,R.drawable.hangb11,R.drawable.hangb12};

    int[] img5={R.drawable.mak1,R.drawable.mak2,R.drawable.mak3,R.drawable.mak4,R.drawable.mak5,R.drawable.mak6,
            R.drawable.mak7,R.drawable.mak8,R.drawable.mak9,R.drawable.mak10,R.drawable.mak11};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kno_view_photo);
        bundle=getIntent().getExtras();
        if (bundle.getInt("position")==0){
            secondAdapter=new SecondKnowAdapter(getApplicationContext(),img1);
        }else {
            if (bundle.getInt("position") == 1) {
                secondAdapter = new SecondKnowAdapter(getApplicationContext(), img2);
            } else {
                if (bundle.getInt("position") == 2) {
                    secondAdapter = new SecondKnowAdapter(getApplicationContext(), img3);
                } else {
                    if (bundle.getInt("position") == 3) {
                        secondAdapter = new SecondKnowAdapter(getApplicationContext(), img4a);
                    } else {
                        if (bundle.getInt("position") == 4) {
                            secondAdapter = new SecondKnowAdapter(getApplicationContext(), img4b);
                        } else {
                            if (bundle.getInt("position") == 5) {
                                secondAdapter = new SecondKnowAdapter(getApplicationContext(), img5);
                            }
                        }
                    }
                }
            }
        }
         recyclerView=findViewById(R.id.rcr_view_poto);
         layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(secondAdapter);
        recyclerView.setHasFixedSize(true);
    }
}
