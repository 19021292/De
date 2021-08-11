package com.example.football;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class KitInfoDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kit_info);
        Intent intent = getIntent();
        ContactBook details = (ContactBook) intent.getSerializableExtra("kit_info");
    }
}
