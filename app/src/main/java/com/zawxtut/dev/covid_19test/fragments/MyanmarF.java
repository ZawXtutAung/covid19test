package com.zawxtut.dev.covid_19test.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.zawxtut.dev.covid_19test.R;
import com.zawxtut.dev.covid_19test.modes.MohViews;

import org.json.JSONException;
import org.json.JSONObject;

public class MyanmarF extends Fragment implements ValueEventListener {
    MohViews mohViews;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference databaseref=database.getReference().child("mohCases");
    DatabaseReference dbtxt1=databaseref.child("casesOne");
    DatabaseReference dbtxt2=databaseref.child("casesTwo");
    DatabaseReference dbtxt3=databaseref.child("casesThree");
    DatabaseReference dbtxt4=databaseref.child("casestotal");
    DatabaseReference dbtxtDate=databaseref.child("mohDate");

    TextView textView,textView2,textView3,textView4,textView5,textView6,textView7,mohText1,mohText2,mohText3,mohText4,mohTextdate;
    ProgressBar progressBar;
    private static final String TAG=MyanmarF.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mmview=inflater.inflate(R.layout.myanmar_activity,container,false);
        textView=mmview.findViewById(R.id.mmt1);
        textView2=mmview.findViewById(R.id.mmt2);
        textView3=mmview.findViewById(R.id.mmt3);
        textView4=mmview.findViewById(R.id.mmt4);
        textView5=mmview.findViewById(R.id.mmt5);
        textView6=mmview.findViewById(R.id.mmt6);
        textView7=mmview.findViewById(R.id.mmt7);

        mohTextdate=mmview.findViewById(R.id.mohtextdate);
        mohText1=mmview.findViewById(R.id.mohs);
        mohText2=mmview.findViewById(R.id.mohs1);
        mohText3=mmview.findViewById(R.id.mohs2);
        mohText4=mmview.findViewById(R.id.mohsTotal);
        progressBar=mmview.findViewById(R.id.mmyProgress);

        getMyanmarData();
        //MohViewMode();
        return mmview;

    }


    @Override
    public void onStart() {
        super.onStart();
        dbtxt1.addValueEventListener(this);
        dbtxt2.addValueEventListener(this);
        dbtxt3.addValueEventListener(this);
        dbtxt4.addValueEventListener(this);
        dbtxtDate.addValueEventListener(this);
    }

    private void getMyanmarData() {
        RequestQueue mmqueue= Volley.newRequestQueue(getActivity());
        String mmurl="https://corona.lmao.ninja/V2/countries/104";
        StringRequest mmstrRequest=new StringRequest(Request.Method.GET, mmurl, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    textView.setText(jsonObject.getString("cases"));
                    textView2.setText(jsonObject.getString("deaths"));
                    textView3.setText(jsonObject.getString("todayDeaths"));
                    textView4.setText(jsonObject.getString("todayCases"));
                    textView5.setText(jsonObject.getString("recovered"));
                    textView6.setText(jsonObject.getString("active"));
                    textView7.setText(jsonObject.getString("tests"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            },new Response.ErrorListener(){
                public void onErrorResponse(VolleyError merror) {
                    Log.d("error Resporn", merror.toString());
                }

            });
        mmqueue.add(mmstrRequest);
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if (dataSnapshot.getValue(String.class) != null) {
            String key = dataSnapshot.getKey();
            if (key.equals("mohDate")) {
                String txdate = dataSnapshot.getValue(String.class);
                mohTextdate.setText(txdate);
            }
            if (key.equals("casesOne")) {
                String first = dataSnapshot.getValue(String.class);
                mohText1.setText(first);
            }
            if (key.equals("casesTwo")) {
                String secc = dataSnapshot.getValue(String.class);
                mohText2.setText(secc);
            }
            if (key.equals("casesThree")) {
                String thr = dataSnapshot.getValue(String.class);
                mohText3.setText(thr);
            }
            if (key.equals("casestotal")) {
                String tot = dataSnapshot.getValue(String.class);
                mohText4.setText(tot);
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
