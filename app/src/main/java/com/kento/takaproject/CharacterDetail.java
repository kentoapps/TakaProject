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
        int img = intent.getIntExtra(NameListActivity.CHARACTER_IMG,0);
        String name = intent.getStringExtra(NameListActivity.CHARACTER_NAME);
        String word = intent.getStringExtra(NameListActivity.CHARACTER_WORD);

        ImageView imgLabel = (ImageView) findViewById(R.id.icon);
        TextView nameLabel = (TextView) findViewById(R.id.name);
        TextView wordLabel = (TextView) findViewById(R.id.word);

        imgLabel.setImageResource(img);
        nameLabel.setText(name);
        wordLabel.setText(word);

    }
}
