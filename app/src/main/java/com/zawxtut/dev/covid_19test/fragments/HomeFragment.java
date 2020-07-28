package com.zawxtut.dev.covid_19test.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.zawxtut.dev.covid_19test.adapters.CovidAdapter;
import com.zawxtut.dev.covid_19test.modes.CovidCountry;
import com.zawxtut.dev.covid_19test.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    TextView wtextCase,wtextRe,wtextDie,mmCasetext,mmDietext,mmTodaytext,mtextdate,textrcv,mmTodayCases,mmRecov,mmActiv,mmtests;
    ProgressBar progressBar;
    RecyclerView mRecyclerView;
    ArrayList<CovidCountry> covidCountry;
private static final String TAG=HomeFragment.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View home_v= inflater.inflate(R.layout.home_page,container,false);
        wtextCase=home_v.findViewById(R.id.wcase);
        wtextRe=home_v.findViewById(R.id.wRec);
        wtextDie=home_v.findViewById(R.id.wDie);
        textrcv=home_v.findViewById(R.id.recov);
        ///myanmar
//        mmCasetext=home_v.findViewById(R.id.mmcase);
//        mmDietext=home_v.findViewById(R.id.mmdie);
//        mmTodaytext=home_v.findViewById(R.id.mmtoday);
//        mmTodayCases=home_v.findViewById(R.id.mmtodaycase);
//        mmtests=home_v.findViewById(R.id.mmTest);
//        mmRecov=home_v.findViewById(R.id.mmRecov);
//         mmActiv=home_v.findViewById(R.id.mmAtive);
        //Recycler
        mRecyclerView=home_v.findViewById(R.id.myRecycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar=home_v.findViewById(R.id.mProgress);
        //Volly Meth
        //Globle
        getData();
        //Myanmar Owly
       // getMyanmarData();
        //allCountry
        getCountryData();
        return home_v;
    }

    private void ShowRecycler(){
        CovidAdapter covidAdapter=new CovidAdapter(covidCountry);
        mRecyclerView.setAdapter(covidAdapter);
    }

    private void getCountryData() {
        String cunurl="https://corona.lmao.ninja/V2/countries";
        covidCountry=new ArrayList<>();
        StringRequest countryStrRequest=new StringRequest(Request.Method.GET, cunurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                if (response != null) {
                    Log.d(TAG, "On Resporn" + response);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonData = jsonArray.getJSONObject(i);
                            covidCountry.add(new CovidCountry(
                                    jsonData.getString("country"),
                                    jsonData.getString("cases")
                                    ,jsonData.getString("deaths"),
                                    jsonData.getString("todayDeaths"),
                                    jsonData.getString("todayCases")


                            ));
                        }
                        ShowRecycler();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError cerror) {
                        progressBar.setVisibility(View.GONE);
                        Log.d("error Resporn", cerror.toString());
                    }
                });
        Volley.newRequestQueue(getActivity()).add(countryStrRequest);

    }

//    private void getMyanmarData() {
//        RequestQueue mmqueue= Volley.newRequestQueue(getActivity());
//        String mmurl="https://corona.lmao.ninja/V2/countries/104";
//        StringRequest mmstrRequest=new StringRequest(Request.Method.GET, mmurl, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                progressBar.setVisibility(View.GONE);
//                try {
//                    JSONObject jsonObject = new JSONObject(response.toString());
//                    mmCasetext.setText(jsonObject.getString("cases"));
//                    mmDietext.setText(jsonObject.getString("deaths"));
//                    mmTodaytext.setText(jsonObject.getString("todayDeaths"));
//                    mmTodayCases.setText(jsonObject.getString("todayCases"));
//                    mmRecov.setText(jsonObject.getString("recovered"));
//                    mmActiv.setText(jsonObject.getString("active"));
//                    mmtests.setText(jsonObject.getString("tests"));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError merror) {
//                Log.d("error Resporn", merror.toString());
//            }
//        });
//        mmqueue.add(mmstrRequest);
//    }


    private void getData() {
        RequestQueue queue= Volley.newRequestQueue(getActivity());
        String url="https://corona.lmao.ninja/V2/all";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    wtextCase.setText(jsonObject.getString("cases"));
                    wtextRe.setText(jsonObject.getString("deaths"));
                    wtextDie.setText(jsonObject.getString("active"));
                    textrcv.setText(jsonObject.getString("recovered"));
                    ///Date
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error Resporn", error.toString());
            }
        });
        queue.add(stringRequest);

    }

    }


