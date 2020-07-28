package com.zawxtut.dev.covid_19test.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zawxtut.dev.covid_19test.MainActivity;
import com.zawxtut.dev.covid_19test.R;

public class SecondKnowAdapter  extends RecyclerView.Adapter<SecondKnowAdapter.ViewHolder>  {
    Context context;
    LayoutInflater inflater;
    int[]  arrayi;

    public SecondKnowAdapter (Context context,int[] arrayi) {
        this.context = context;
        this.arrayi=arrayi;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SecondKnowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.kno_view_item,viewGroup,false);
        SecondKnowAdapter.ViewHolder viewHolder=new SecondKnowAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SecondKnowAdapter.ViewHolder sviewHolder, int position) {
        sviewHolder.imageView.setImageResource(arrayi[position]);
    }

    @Override
    public int getItemCount() {
        return arrayi.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            Intent i=new Intent(context, MainActivity.class);
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(i);
        }
    }
}
