package com.joseph.mcib;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class history_main extends AppCompatActivity {
 MaterialCardView card_history;
 ListView lv_history;
    SharedPreferences pref_1;
    ArrayList<String> pesronlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_main);
        pref_1 = getApplicationContext().getSharedPreferences("MyPref_1", MODE_PRIVATE);

        card_history=findViewById(R.id.card_history);
        lv_history=findViewById(R.id.lv_history);
        for (int i=0;i<24;i++){
            String person=pref_1.getString(String.format("person_%d",i),"0");
        if (!person.equals("0")){

            pesronlist.add(person);
        }

        }
        ArrayAdapter<String> Adapter1 = new ArrayAdapter(history_main.this, R.layout.text_list, pesronlist);
        lv_history.setAdapter(Adapter1);
        lv_history.setOnItemClickListener((parent, view, position, id) -> {

            String txt=lv_history.getItemAtPosition(position).toString();

            Intent intent = new Intent(history_main.this, verment.class);

            intent.putExtra("nom", txt);

            startActivity(intent);


        });
        card_history.setOnClickListener(v -> {
            pref_1.edit().clear().apply();
            lv_history.setAdapter(null);
        });
    }
}