package com.joseph.mcib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class lists extends AppCompatActivity {
     ListView lv;
    ArrayList<String> nom_list=new ArrayList<>();
    ArrayList<String> ver_complete=new ArrayList<>();
    ArrayList<String> no_ver=new ArrayList<>();
    ArrayList<String> ver_par=new ArrayList<>();
    ArrayList<String> nom_kridi=new ArrayList<>();
    ArrayList<String> vide=new ArrayList<>();

    SharedPreferences pref;
    Chip chip_1,chip_2,chip_3,chip_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lists_main);
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        lv=findViewById(R.id.lv);
        chip_1=findViewById(R.id.chip_1);
        chip_2=findViewById(R.id.chip_2);
        chip_3=findViewById(R.id.chip_3);
        chip_4=findViewById(R.id.chip_4);

        nom_list.add(" الميلود");
        nom_list.add(" مراد");
        nom_list.add("  القادر");
        nom_list.add(" محمد");
        nom_list.add(" قدور");
        nom_list.add(" عمار");
        nom_list.add(" بن عمر");
        nom_list.add("Taxi  أحمد");
        nom_list.add(" عبد القادر");
        nom_list.add("Taxi  أحمد");
        nom_list.add(" اسماعيل");
        nom_list.add(" محمد");
        nom_list.add(" عبد القادر");
        nom_list.add(" محمد");
        nom_list.add(" عبد القادر");
        nom_list.add(" علي");
        nom_list.add(" محمد");
        nom_list.add(" أحمد");
        nom_list.add(" محمد");
        nom_list.add(" أمحمد");
        nom_list.add("  بن علي");
        nom_list.add(" الجيلالي");
        nom_list.add(" محمد");
        nom_list.add(" عبد القادر");
        vide.add("اختر القائمة المناسبة ؟");
        for (int i=0;i<24;i++){

            String rest=pref.getString(String.format("prix_rest_%d",i),"0");
            String ver=pref.getString(String.format("prix_ver_%d",i),"0");
           String kridi= pref.getString(String.format("prix_kridi_%d",i),"0");
            if (rest.equals("0")&&!(ver.equals("0"))) {
                String nom_rst = nom_list.get(i);
                ver_complete.add(nom_rst);
            }
            if (!(ver.equals("0"))&&!(rest.equals("0"))) {
                String nom_rst = nom_list.get(i);
                ver_par.add(nom_rst);
            }

            if (ver.equals("0")&&!(pref.getString("prix_person", "0").equals("0"))
            ){
                String nom_vr= nom_list.get(i);
                no_ver.add(nom_vr);
            }
            if (!kridi.equals("0")){
                String nomkridi= nom_list.get(i);
                nom_kridi.add(nomkridi);

            }

        }




        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter(lists.this, R.layout.text_list, ver_complete);
        lv.setAdapter(arrayAdapter1);




        chip_1.setOnClickListener(v -> {
            if (chip_1.isChecked()){
            ArrayAdapter<String> Adapter1 = new ArrayAdapter(lists.this, R.layout.text_list, ver_complete);
            lv.setAdapter(Adapter1);
            }else {
                ArrayAdapter<String> array_vid = new ArrayAdapter(lists.this, R.layout.text_list, vide);
                lv.setAdapter(array_vid);
            }
        });
        chip_2.setOnClickListener(v -> {
            if (chip_2.isChecked()){
                ArrayAdapter<String> Adapter1 = new ArrayAdapter(lists.this, R.layout.text_list, ver_par);
                lv.setAdapter(Adapter1);
            }else {
                ArrayAdapter<String> array_vid = new ArrayAdapter(lists.this, R.layout.text_list, vide);
                lv.setAdapter(array_vid);
            }
        });
        chip_3.setOnClickListener(v -> {
            if (chip_3.isChecked()){
                ArrayAdapter<String> Adapter1 = new ArrayAdapter(lists.this, R.layout.text_list,no_ver);
                lv.setAdapter(Adapter1);
            }else {
                ArrayAdapter<String> array_vid = new ArrayAdapter(lists.this, R.layout.text_list, vide);
                lv.setAdapter(array_vid);
            }
        });
        chip_4.setOnClickListener(v -> {
            if (chip_4.isChecked()){
                ArrayAdapter<String> Adapter1 = new ArrayAdapter(lists.this, R.layout.text_list, nom_kridi);
                lv.setAdapter(Adapter1);
            }else {
                ArrayAdapter<String> array_vid = new ArrayAdapter(lists.this, R.layout.text_list, vide);
                lv.setAdapter(array_vid);
            }
        });

        lv.setOnItemClickListener((parent, view, position, id) -> {

           String txt=lv.getItemAtPosition(position).toString();

            Intent intent = new Intent(lists.this, verment.class);

            intent.putExtra("nom", txt);

            startActivity(intent);


        });
    }






    }
