package com.zawxtut.dev.covid_19test.fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zawxtut.dev.covid_19test.R;

public class AboutFragment extends Fragment implements View.OnClickListener {
    ImageView imagefacebook;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View about_v=inflater.inflate(R.layout.about_layout,container,false);
        imagefacebook=about_v.findViewById(R.id.facebook);
        imagefacebook.setOnClickListener(this);
        return about_v;

    }

    @Override
    public void onClick(View v) {
        Intent myfbz = Fbz(this,"100008058424499");
        if (myfbz!=null)
            startActivity(myfbz);
    }
    private Intent Fbz(AboutFragment aboutActivity, String s) {
        try {
            //fbid();
            aboutActivity.getContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
            String facebookScheme = "fb://profile/" + s;
            return new Intent(Intent.ACTION_VIEW, Uri.parse(facebookScheme));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
