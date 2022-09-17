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
        nom_list.add("حداد احمد");
        nom_list.add("طالبي عبد القادر");
        nom_list.add("عريب عبد القادر");
        nom_list.add("داهل عبد القادر");
        nom_list.add("دفوس أحمد");
        nom_list.add("سعيداني محمد");
        nom_list.add("سعيداني عمار ");
        nom_list.add("بالي قدور");
        nom_list.add("عدي رابح");
        nom_list.add("عدي محمد");
        nom_list.add("قرنوق عبد القادر");
        nom_list.add("لحياني محمد");
        nom_list.add("محفوف محمد");
        nom_list.add("أيمن الحاج");
        nom_list.add("أيمن قدور");
        nom_list.add("أيمن محمد");
        nom_list.add("أيمن بن علي");
        nom_list.add("شنان الطيب");
        nom_list.add("سعاد عبد القادر");
        nom_list.add("حشيد أحمد");
        nom_list.add("مشعشع عبد القادر");
        nom_list.add("مشعشع محمد");
        nom_list.add("مخروط امحمد");
        nom_list.add("مخروط عبد القادر");
        nom_list.add("شقران عبد القادر بن السايح");
        nom_list.add("شقران عبد القادر بوطريق");
        nom_list.add("شقران علي");
        nom_list.add("شقران أحمد");
        nom_list.add("عماني عبد القادر");
        nom_list.add("عمارة بن شهرة");
        nom_list.add("ربحي الميلود");
        nom_list.add("دامو محمد");
        nom_list.add("دامو بوزيان");
        nom_list.add("مساد عبد القادر بن محمد");
        nom_list.add("مساد محمد بن قدور");
        nom_list.add("مساد عبد القادر بن قدور");
        nom_list.add("مساد قدور");
        nom_list.add("مساد عبد القادر(اللوز)");
        nom_list.add("العلالي بن شهرة");
        nom_list.add("مقراني محمد");
        nom_list.add("مقراني عبد القادر(قوشي)");
        vide.add("اختر القائمة المناسبة ؟");
        for (int i=0;i<41;i++){

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
