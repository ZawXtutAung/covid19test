package com.zawxtut.dev.covid_19test.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zawxtut.dev.covid_19test.modes.CovidCountry;
import com.zawxtut.dev.covid_19test.R;

import java.util.ArrayList;

public class CovidAdapter extends RecyclerView.Adapter<CovidAdapter.MyViewHolder> {
    ArrayList<CovidCountry> covidCountry;

    public CovidAdapter(ArrayList<CovidCountry> covidCountry){
        this .covidCountry=covidCountry;
    }

    public CovidAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View hv= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_data_list,viewGroup,false);
        return new MyViewHolder(hv);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidAdapter.MyViewHolder myViewHolder, int poss) {
        CovidCountry covidCountryy=covidCountry.get(poss);
        myViewHolder.textcountry.setText(covidCountryy.getmCovidCountry());
        myViewHolder.textcase.setText(covidCountryy.getMcases());
        myViewHolder.textDie.setText(covidCountryy.getMdeaths());
        myViewHolder.texttodayDie.setText(covidCountryy.getMtodayDeaths());
        myViewHolder.textnewcases.setText(covidCountryy.getMtodayCases());

    }

    @Override
    public int getItemCount() {
        return covidCountry.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textcountry,textcase,textDie,texttodayDie,textnewcases;

        public MyViewHolder(@NonNull View iView) {

            super(iView);
            textcountry=iView.findViewById(R.id.ccountry);
            textcase=iView.findViewById(R.id.ccase);
            textDie=iView.findViewById(R.id.cdie);
            texttodayDie=iView.findViewById(R.id.ctodaydie);
            textnewcases=iView.findViewById(R.id.newcases);


        }
    }
}
