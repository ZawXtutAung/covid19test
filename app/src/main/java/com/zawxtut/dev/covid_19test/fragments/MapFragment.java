package com.zawxtut.dev.covid_19test.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.zawxtut.dev.covid_19test.R;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    MapView mapView;
    private GoogleMap mMap;
    SupportMapFragment supMapFragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View map_v=inflater.inflate(R.layout.map_page,container,false);
        WebView webView=map_v.findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.trackcorona.live/map");
//         mapView=map_v.findViewById(R.id.myMap);
//         mapView.onCreate(savedInstanceState);
//         mapView.onResume();
//         try {
//             MapsInitializer.initialize(getActivity().getApplicationContext());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         mapView.getMapAsync(this);
        return map_v;
    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
//        mMap=setti
    }
}
