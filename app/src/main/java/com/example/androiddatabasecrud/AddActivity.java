package com.example.androiddatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText etGedung, etRuang, etKapasitas;
    Button addButtonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etGedung = findViewById(R.id.et_gedung2);
        etRuang = findViewById(R.id.et_ruang2);
        etKapasitas = findViewById(R.id.et_kapasitas2);
        addButtonSubmit = findViewById(R.id.btn_update_submit);

        addButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addRoom(etGedung.getText().toString().trim(),
                        etRuang.getText().toString().trim(),
                        Integer.valueOf(etKapasitas.getText().toString().trim()));
            }
        });
    }
}