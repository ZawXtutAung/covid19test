package com.zawxtut.dev.covid_19test.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

//import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.zawxtut.dev.covid_19test.R;
import com.zawxtut.dev.covid_19test.modes.RpUser;

public class MyReportFragment extends Fragment implements View.OnClickListener {
    EditText nameText,phoneText, idCardText, cityText, regionCityText, stText,vilText,resiontext;
    Button sent_button;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    RpUser user;
    long maxid=0;
    String[] userRp = { "မိမိကိုယ်တိုင်", "အကြောင်းကြား လိုသောသူ"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View report_v=inflater.inflate(R.layout.report_page,container,false);
        nameText=report_v.findViewById(R.id.name_reportText);
        idCardText=report_v.findViewById(R.id.idCard_reportText);
        phoneText=report_v.findViewById(R.id.phone_reportText);
        cityText=report_v.findViewById(R.id.city_reportText);
        regionCityText=report_v.findViewById(R.id.regCity_reportText);
        stText=report_v.findViewById(R.id.st_reportText);
        vilText=report_v.findViewById(R.id.vill_reportText);
        sent_button=report_v.findViewById(R.id.send_btn_report);
        resiontext=report_v.findViewById(R.id.resontx);
        ///////
        database.getInstance().setPersistenceEnabled(true);
        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference().child("User");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //////
        sent_button.setOnClickListener(this);
        user=new RpUser();
        return report_v;
    }
    private void getValues(){
        user.setUsername(nameText.getText().toString());
        user.setRpIdCard(idCardText.getText().toString());
        user.setRpphone(phoneText.getText().toString());
        user.setRpCity(cityText.getText().toString());
        user.setRpRegionCity(regionCityText.getText().toString());
        user.setRpStreet(stText.getText().toString());
        user.setRpVillage(vilText.getText().toString());
        user.setRpReson(resiontext.getText().toString());

    }

public void send_database(View view){
        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getValues();

                databaseReference.child("User01").setValue(user);
                Toast.makeText(getContext(), "Sent", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
}

    @Override
    public void onClick(View v) {
        getValues();
        databaseReference.child(String.valueOf(maxid+0)).setValue(user);
        ClearText();
        //Toast.makeText(getContext(), "Hello Developer", Toast.LENGTH_SHORT).show();
       // send_btn_report(v);

    }

    private void ClearText() {
        nameText.setText("");
        idCardText.setText("");
        phoneText.setText("");
        cityText.setText("");
        regionCityText.setText("");
        vilText.setText("");
        stText.setText("");
        resiontext.setText("");
    }

}
