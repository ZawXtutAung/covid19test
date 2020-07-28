package com.zawxtut.dev.covid_19test;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.zawxtut.dev.covid_19test.fragments.AboutFragment;
import com.zawxtut.dev.covid_19test.fragments.HomeFragment;
import com.zawxtut.dev.covid_19test.fragments.Knowledge;
import com.zawxtut.dev.covid_19test.fragments.MapFragment;
import com.zawxtut.dev.covid_19test.fragments.MyReportFragment;
import com.zawxtut.dev.covid_19test.fragments.MyanmarF;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
Toolbar mToolbar;
    BottomNavigationView myNav;
    FragmentManager fngManager;
    FragmentTransaction fragmentTransaction;
    ConnectivityManager connectivityManager;
    BroadcastReceiver broadcastReceiver=null;
    boolean isWifiConn = false;
    boolean isMobileConn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar=findViewById(R.id.myappbar);
        setSupportActionBar(mToolbar);
        myNav=findViewById(R.id.navbtn);

        myNav.setOnNavigationItemSelectedListener(this);
        fngManager =getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().replace(R.id.mymidfg,new MyanmarF()).commit();
        MyNetCheck();
    }

    private void MyNetCheck() {
        connectivityManager= (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
if (activeNetwork==null|| !activeNetwork.isConnected() || !activeNetwork.isAvailable())
                NetDai();

    }

    private void NetDai() {
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.check_net_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations=android.R.style.Animation_Dialog;
        Button buttondai=dialog.findViewById(R.id.close_dia);
        buttondai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

   
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case   R.id.mabout:
                fragment=new AboutFragment();
                break;
            case R.id.menu_Mreport:
                fragment=new MyReportFragment();
                //MyNetCheck();
                break;
//            case R.id.menu_new:
//                Intent intent=new Intent(MainActivity.this,Testts.class);
//               startActivity(intent);
//                 fragment=new Testts();
               // MyNetCheck();
//                break;
            case R.id.mmy:
                fragment=new MapFragment();
                // MyNetCheck();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.mymidfg,fragment).commit();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.menu_nav_home:
                fragment=new MyanmarF();
               // fragment=new HomeFragment();
                break;
            case R.id.menu_nav_know:
                fragment=new HomeFragment();
                //fragment=new MyanmarF();
               // fragment=new Knowledge();
                break;
            case R.id.menu_nav_map:
                fragment=new Knowledge();
                //fragment=new MyReportFragment();
               // fragment=new MapFragment();
                MyNetCheck();
                break;

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.mymidfg,fragment).commit();
        return true;
    }
}
