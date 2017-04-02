package com.kento.takaproject;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CharacterDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra(NameListActivity.CHARACTER_NAME);
        TextView nameLabel = (TextView) findViewById(R.id.namename);
        nameLabel.setText(name);

    }
}
