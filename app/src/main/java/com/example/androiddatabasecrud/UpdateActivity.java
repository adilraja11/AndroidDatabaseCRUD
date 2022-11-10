package com.example.androiddatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText etGedung, etRuang, etKapasitas;
    Button updateButtonSubmit;
    String id, gedung, ruang, kapasitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etGedung = findViewById(R.id.et_gedung2);
        etRuang = findViewById(R.id.et_ruang2);
        etKapasitas = findViewById(R.id.et_kapasitas2);
        updateButtonSubmit = findViewById(R.id.btn_update_submit);

        getAndSetIntentData();

        updateButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                gedung = etGedung.getText().toString().trim();
                ruang = etRuang.getText().toString().trim();
                kapasitas = etKapasitas.getText().toString().trim();
                myDB.updateData(id, gedung, ruang, Integer.parseInt(kapasitas));
            }
        });
    }

    void getAndSetIntentData () {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("gedung") &&
                getIntent().hasExtra("ruang") && getIntent().hasExtra("kapasitas")) {
//            Getting Data From Intent
            id = getIntent().getStringExtra("id");
            gedung = getIntent().getStringExtra("gedung");
            ruang = getIntent().getStringExtra("ruang");
            kapasitas = getIntent().getStringExtra("kapasitas");

//            Setting Intent Data
            etGedung.setText(gedung);
            etRuang.setText(ruang);
            etKapasitas.setText(kapasitas);
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}