package com.zawxtut.dev.covid_19test.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zawxtut.dev.covid_19test.R;
import com.zawxtut.dev.covid_19test.fragments.Knowledge;
import com.zawxtut.dev.covid_19test.fragments.KnowledgeSecond;

public class MainKnowledgeAdapter extends RecyclerView.Adapter<MainKnowledgeAdapter.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    String[] item={"သင့်ကိုယ်သင်နှင့်အခြားသူများကို\n" +
                   " ဖျားနာခြင်းမှကာကွယ်ပါ",
                   "ခရီးသွားနေစဥ်\n" +
                           "ကျန်းမာစွာနေထိုင်နိုင်ရန်",
                  "COVID-19 ဘယ်လိုပျံ့နှံ့သွား\n" +
                          "နိုင်သလဲ",
                  "လက်ကို လက်ဆေးရည်ဖြင့်\n" +
                          "ဘယ်လို ဆေးကြမလည်",
            "လက်ကို လက်ဆေးရည်ဖြင့်\n" +
                    "ဘယ်လို ဆေးကြမလည် (၂)",
                  "How to use mask\n" +
                          "(နှာခေါင်းစည်)OR(မျက်နှာဖုံး)" +
                          "ကိုဘယ်လိုသုံးရမလဲ"};
    public MainKnowledgeAdapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MainKnowledgeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.know_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainKnowledgeAdapter.ViewHolder myholder, int position) {
        myholder.mainKntxt.setText(item[position]);
    }

    @Override
    public int getItemCount() {
        return  item.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mainKntxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainKntxt=itemView.findViewById(R.id.title_know_tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent i=new Intent(context, KnowledgeSecond.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra("position",getPosition());
            context.startActivity(i);
        }
    }
}
