package com.zawxtut.dev.covid_19test;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.zawxtut.dev.covid_19test.adapters.NewFbRecycler;
import com.zawxtut.dev.covid_19test.modes.NewPageMode;

import java.util.List;


public class NewPage extends AppCompatActivity {
    RecyclerView recyclerNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_page);
        recyclerNew = findViewById(R.id.new_page_rcr);
        new FirebaseDbHelper().readNewPaper(new FirebaseDbHelper.DataStatus() {
            @Override
            public void DataLoading(List<NewPageMode> modes, List<String> keys) {
                new NewFbRecycler().setConfirm(recyclerNew, NewPage.this, modes, keys);
            }

            @Override
            public void dataInset() {

            }

            @Override
            public void dataUpdate() {

            }
        });
    }
}


