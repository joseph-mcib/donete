package com.joseph.mcib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
     MaterialCardView card_list,card_save,card_reset,cart_delet;
     SharedPreferences pref_1,pref;
    TextInputEditText ed_ver_tot,ed_rest_tot;
    double   prix_tot_rest = 0;
    double prix_tot_ver=0;
    double prix_person = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        card_save=findViewById(R.id.card_2);
        card_list=findViewById(R.id.card_1);
        card_reset=findViewById(R.id.card_3);
        cart_delet=findViewById(R.id.card_4);
        ed_rest_tot=findViewById(R.id.prix_total_rest);
        ed_ver_tot=findViewById(R.id.prix_total_ver);

        pref_1 = getApplicationContext().getSharedPreferences("MyPref_1", MODE_PRIVATE);
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        for (int i=0;i<24;i++){
           prix_person= Double.parseDouble(pref.getString("prix_person", "0"));

            double prix_ver= Double.parseDouble(pref.getString(String.format("prix_ver_%d", i), "0"));

             prix_tot_ver=prix_tot_ver+prix_ver;

        }
        prix_tot_rest=(prix_person*24)-prix_tot_ver;

        ed_ver_tot.setText(Integer.toString((int) prix_tot_ver));
        ed_rest_tot.setText(Integer.toString((int) prix_tot_rest));

        card_save.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,verment.class);
            startActivity(intent);
        });
        card_list.setOnClickListener(v -> {
            Intent intent2=new Intent(MainActivity.this,lists.class);
            startActivity(intent2);
        });
        cart_delet.setOnClickListener(v -> {
            Intent intent2=new Intent(MainActivity.this,history_main.class);
            startActivity(intent2);
        });
        card_reset.setOnClickListener(v -> {

            MaterialAlertDialogBuilder dailog=new MaterialAlertDialogBuilder(MainActivity.this);
            dailog.setMessage("هل تريد حذف جميع البيانات ؟");
            dailog.setBackground(getResources().getDrawable(R.drawable.textlist));
            dailog.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    pref.edit().clear().apply();
                    pref_1.edit().clear().apply();
                    ed_ver_tot.setText("0");
                    ed_rest_tot.setText("0");
                }
            });
            dailog.setNegativeButton("لا", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dailog.show();

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        prix_tot_ver=0;
        for (int i=0;i<24;i++){
            prix_person= Double.parseDouble(pref.getString("prix_person", "0"));

            double prix_ver= Double.parseDouble(pref.getString(String.format("prix_ver_%d", i), "0"));

            prix_tot_ver=prix_tot_ver+prix_ver;

        }
        prix_tot_rest=(prix_person*24)-prix_tot_ver;

        ed_ver_tot.setText(Integer.toString((int) prix_tot_ver));
        ed_rest_tot.setText(Integer.toString((int) prix_tot_rest));

    }
}