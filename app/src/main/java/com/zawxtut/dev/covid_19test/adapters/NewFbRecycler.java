package com.zawxtut.dev.covid_19test.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zawxtut.dev.covid_19test.R;
import com.zawxtut.dev.covid_19test.modes.NewPageMode;

import java.util.List;

public class NewFbRecycler {
private Context nContext;
    private NewPageAdapter mPageAdapter;
public void setConfirm(RecyclerView recyclerView, Context context,List<NewPageMode>modes,List<String>keys){
    mPageAdapter=new NewPageAdapter(modes,keys);
    recyclerView.setLayoutManager(new LinearLayoutManager(context));
    recyclerView.setAdapter(mPageAdapter);
}

 class NewItemView extends RecyclerView.ViewHolder {
    private TextView textViewTitle,textViewBody,textViewDate;
    private String skey;
    public NewItemView(@NonNull ViewGroup viewGroup) {
        super(LayoutInflater.from(nContext)
        .inflate(R.layout.new_page_item, viewGroup,false));
        textViewTitle=itemView.findViewById(R.id.new_main_title);
        textViewBody=itemView.findViewById(R.id.new_main_body);
        textViewDate=itemView.findViewById(R.id.new_main_date);

    }
    public void bind(NewPageMode pageMode,String skey){
        textViewTitle.setText(pageMode.getTitle());
        textViewBody.setText(pageMode.getBodytext());
        textViewDate.setText(pageMode.getDates());
        this.skey=skey;
    }
}
 class NewPageAdapter extends RecyclerView.Adapter<NewItemView>{
private List<NewPageMode>pageModes;
private List<String> strKey;

     public NewPageAdapter(List<NewPageMode> pageModes, List<String> strKey) {
         this.pageModes = pageModes;
         this.strKey = strKey;
     }

     @NonNull
     @Override
     public NewItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         return new NewItemView(viewGroup);
     }

     @Override
     public void onBindViewHolder(@NonNull NewItemView holder, int i) {
         holder.bind(pageModes.get(i),strKey.get(i));
     }

     @Override
     public int getItemCount() {
         return pageModes.size();
     }
 }
}
