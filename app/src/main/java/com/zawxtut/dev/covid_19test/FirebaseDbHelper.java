package com.zawxtut.dev.covid_19test;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.zawxtut.dev.covid_19test.modes.NewPageMode;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDbHelper {
    FirebaseDatabase newDatabase;
    DatabaseReference newDbReference;
    List<NewPageMode> newMode=new ArrayList<>();

    public FirebaseDbHelper() {
        newDatabase=FirebaseDatabase.getInstance();
        newDbReference=newDatabase.getReference("MyNew");
       // readNewPaper();
    }

    ////////////////////////
    public void readNewPaper(final DataStatus dataStatus) {
        newDbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                newMode.clear();
                List<String>keys=new ArrayList<>();
                for (DataSnapshot keyNobe:dataSnapshot.getChildren()){
                    keys.add(keyNobe.getKey());
                    NewPageMode modeN=keyNobe.getValue(NewPageMode.class);
                newMode.add(modeN);
                }
                dataStatus.DataLoading(newMode,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //////////////////////
    public interface DataStatus{
        void DataLoading(List<NewPageMode>modes,List<String>keys);
        void dataInset();
        void dataUpdate();

    }
}
