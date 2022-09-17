package com.joseph.mcib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class verment extends AppCompatActivity {
    MaterialButton btn_save;
    TextInputEditText ed_prix_person, ed_prix_ver, ed_prix_rest, ed_prix_kridi, ed_obsarvation;
    AutoCompleteTextView auto_nom;
    ArrayList<String> nom = new ArrayList<>();
    SharedPreferences pref, perf_1;

    SharedPreferences.Editor editor, editor_1;
    String prix_person, prix_ver, prix_rest, prix_kridi, obsarvation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verment_main);
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        perf_1 = getApplicationContext().getSharedPreferences("MyPref_1", MODE_PRIVATE);

        editor = pref.edit();
        editor_1 = perf_1.edit();
        Intent intent = getIntent();

        btn_save = findViewById(R.id.btn_save);
        ed_prix_ver = findViewById(R.id.prix_ver);
        ed_prix_rest = findViewById(R.id.prix_rest);
        ed_prix_kridi = findViewById(R.id.prix_kridi);
        ed_prix_person = findViewById(R.id.prix_parson);
        ed_obsarvation = findViewById(R.id.obsarvation);
        auto_nom = findViewById(R.id.nom);
        nom.add("حداد احمد");
        nom.add("طالبي عبد القادر");
        nom.add("عريب عبد القادر");
        nom.add("داهل عبد القادر");
        nom.add("دفوس أحمد");
        nom.add("سعيداني محمد");
        nom.add("سعيداني عمار ");
        nom.add("بالي قدور");
        nom.add("عدي رابح");
        nom.add("عدي محمد");
        nom.add("قرنوق عبد القادر");
        nom.add("لحياني محمد");
        nom.add("محفوف محمد");
        nom.add("أيمن الحاج");
        nom.add("أيمن قدور");
        nom.add("أيمن محمد");
        nom.add("أيمن بن علي");
        nom.add("شنان الطيب");
        nom.add("سعاد عبد القادر");
        nom.add("حشيد أحمد");
        nom.add("مشعشع عبد القادر");
        nom.add("مشعشع محمد");
        nom.add("مخروط امحمد");
        nom.add("مخروط عبد القادر");
        nom.add("شقران عبد القادر بن السايح");
        nom.add("شقران عبد القادر بوطريق");
        nom.add("شقران علي");
        nom.add("شقران أحمد");
        nom.add("عماني عبد القادر");
        nom.add("عمارة بن شهرة");
        nom.add("ربحي الميلود");
        nom.add("دامو محمد");
        nom.add("دامو بوزيان");
        nom.add("مساد عبد القادر بن محمد");
        nom.add("مساد محمد بن قدور");
        nom.add("مساد عبد القادر بن قدور");
        nom.add("مساد قدور");
        nom.add("مساد عبد القادر(اللوز)");
        nom.add("العلالي بن شهرة");
        nom.add("مقراني محمد");
        nom.add("مقراني عبد القادر(قوشي)");

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter(this,
                R.layout.textviewlist, nom);
        auto_nom.setAdapter(arrayAdapter1);
        if (!(intent == null)) {
            String nomfromfirst = intent.getStringExtra("nom");

            auto_nom.setText(nomfromfirst);
            ed_prix_ver.setText(pref.getString(String.format("prix_ver_%d", nom.indexOf(nomfromfirst)), null));
            ed_prix_rest.setText(pref.getString(String.format("prix_rest_%d", nom.indexOf(nomfromfirst)), null));
            ed_prix_kridi.setText(pref.getString(String.format("prix_kridi_%d", nom.indexOf(nomfromfirst)), null));
            ed_obsarvation.setText(pref.getString(String.format("obsarvation_%d", nom.indexOf(nomfromfirst)), null));
        }
        ed_prix_person.setText(pref.getString("prix_person", null));

        btn_save.setOnClickListener(v -> {

            prix_person = ed_prix_person.getText().toString();
            prix_ver = ed_prix_ver.getText().toString();
            prix_rest = ed_prix_rest.getText().toString();
            prix_kridi = ed_prix_kridi.getText().toString();
            obsarvation = ed_obsarvation.getText().toString();
            if (prix_person.isEmpty() || prix_ver.isEmpty()) {
                if (prix_person.isEmpty()) {
                    ed_prix_person.setError("ادخل المبلغ");
                    return;
                }
                if (prix_ver.isEmpty()) {
                    ed_prix_ver.setError("ادخل المبلغ");
                    return;
                }

            } else if (prix_rest.isEmpty()) {
                prix_rest = "0";
            }
            if (prix_kridi.isEmpty()) {
                prix_kridi = "0";
            }
            if (obsarvation.isEmpty()) {
                obsarvation = "لا شيئ";
            }
            String auto_selsct1 = auto_nom.getText().toString();

            editor_1.putString(String.format("person_%d", nom.indexOf(auto_selsct1)), auto_selsct1);
            editor_1.apply();
            editor.putString("prix_person", prix_person);
            editor.putString(String.format("prix_ver_%d", nom.indexOf(auto_selsct1)), prix_ver);
            editor.putString(String.format("prix_rest_%d", nom.indexOf(auto_selsct1)), prix_rest);
            editor.putString(String.format("prix_kridi_%d", nom.indexOf(auto_selsct1)), prix_kridi);
            editor.putString(String.format("obsarvation_%d", nom.indexOf(auto_selsct1)), obsarvation);

            editor.apply();

        });
        auto_nom.setOnItemClickListener((parent, view, position, id) -> {
            String auto_selsct2 = auto_nom.getAdapter().getItem(position).toString();

            ed_prix_ver.setText(pref.getString(String.format("prix_ver_%d", nom.indexOf(auto_selsct2)), null));
            ed_prix_rest.setText(pref.getString(String.format("prix_rest_%d", nom.indexOf(auto_selsct2)), null));
            ed_prix_kridi.setText(pref.getString(String.format("prix_kridi_%d", nom.indexOf(auto_selsct2)), null));
            ed_obsarvation.setText(pref.getString(String.format("obsarvation_%d", nom.indexOf(auto_selsct2)), null));

        });


        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String prix_per = ed_prix_person.getText().toString();

                btn_save.setEnabled(true);
                String prix_v = ed_prix_ver.getText().toString();
                if (prix_per.isEmpty()) {
                    ed_prix_person.setError("ادخل المبلغ");
                } else {
                    if (prix_v.isEmpty()) {
                        prix_v = "0";
                    }
                    double prix_per1 = Double.parseDouble(prix_per);
                    double prix_v1 = Integer.parseInt(prix_v);
                    int prix_r = (int) (prix_per1 - prix_v1);
                    ed_prix_rest.setText(Integer.toString(prix_r));
                }
            }
        };
        ed_prix_ver.addTextChangedListener(textWatcher);
    }
}