package com.kento.takaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSend_onClick(View v) {
        Intent i = new Intent(this, DetailActivity.class);
        startActivity(i);
    }

    public void btnCharacter_onClick(View v) {
        Intent i = new Intent(this, NameListActivity.class);
        startActivity(i);
    }
}