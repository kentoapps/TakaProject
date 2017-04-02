package com.kento.takaproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class NameListActivity extends AppCompatActivity {

    public final static String CHARACTER_NAME = "com.kento.takaproject.CHARACTER_NAME.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);


        //ListViewの取得
        ListView list = (ListView) findViewById(R.id.characterList);

        //キャラリスト項目をarrayListとして準備
        final ArrayList<Character_date> character_data = new ArrayList<>();

        final int[] character_img = {
                R.drawable.josuke,
                R.drawable.okuyasu,
                R.drawable.keicho,
                R.drawable.rohan,
                R.drawable.jotaro,
                R.drawable.kira,
                R.drawable.yukako,
                R.drawable.otoishi,
                R.drawable.shigekiyo,
                R.drawable.fungami,
                R.drawable.miyamoto,
                R.drawable.keicho,
        };


        final String[] character_name = {
                "東方仗助",
                "虹村億泰",
                "広瀬康一",
                "岸辺露伴",
                "空条承太郎",
                "吉良吉影",
                "山岸由花子",
                "音石明",
                "矢安宮重清",
                "噴上裕也",
                "宮本輝之輔",
                "虹村形兆",
        };

        final String[] character_words = {
                "グレートだぜ！",
                "このダボが！",
                "僕のエコーズ！",
                "だが断る",
                "やれやれだぜ",
                "いいや限界だ！押すね！",
                "あたし康一君のこと好きなんです",
                "笑うものか！アクビしたものか！",
                "パパとママを守るど！",
                "おれってよ～やっぱりカッコよくて美しいよなあー！",
                "『エニグマ』はじっくりと「観察」する",
                "いつだっておれの足手まといだったぜ",
        };


        for (int i = 0; i < character_img.length; i++) {
            Character_date characters = new Character_date();
            characters.setCharacter_img(character_img[i]);
            characters.setCharacter_name(character_name[i]);
            characters.setCharacter_words(character_words[i]);
            character_data.add(characters);
        }

        //Adapter -ArrayAdapter - CharacterAdapter
        final CharacterAdapter adapter = new CharacterAdapter(this, 0, character_data);


        //ListViewに表示
        list.setAdapter(adapter);

        //リスト項目をクリックした時の処理
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(
                    AdapterView<?> parent,
                    View view,
                    int pos,
                    long id) {
                // 選択アイテムを取得
                Character_date character = (Character_date) parent.getItemAtPosition(pos);


                //通知ダイヤルを表示
                //Toast.makeText(NameListActivity.this, character.getCharacter_words(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), CharacterDetail.class);

               // i.putExtra("CHARACTER_INFO", character.getCharacter_img());
                  i.putExtra("CHARACTER_NAME", character.getCharacter_name());
               // i.putExtra("CHARACTER_WORDS", character.getCharacter_words());

                startActivity(i);

            }

        });

    }


    public class CharacterAdapter extends ArrayAdapter<Character_date> {
        private LayoutInflater layoutInflater;

        public CharacterAdapter(Context c, int id, ArrayList<Character_date> character_data) {
            super(c, id, character_data);

            this.layoutInflater = (LayoutInflater) c.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE
            );
        }


        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = layoutInflater.inflate(
                        R.layout.list_item,
                        parent,
                        false
                );
            }
            // 特定の行(pos)のデータを得る
            Character_date character_date = (Character_date) getItem(pos);

            ((ImageView) convertView.findViewById(R.id.icon))
                    .setImageResource(character_date.getCharacter_img());
            ((TextView) convertView.findViewById(R.id.name))
                    .setText(character_date.getCharacter_name());

            return convertView;
        }
    }


    public class Character_date {
        private int character_img;
        private String character_name;
        private String character_words;

        public String getCharacter_words() {
            return character_words;
        }

        public void setCharacter_words(String character_words) {
            this.character_words = character_words;
        }

        public String getCharacter_name() {
            return character_name;
        }

        public void setCharacter_name(String character_name) {
            this.character_name = character_name;
        }

        public int getCharacter_img() {
            return character_img;
        }

        public void setCharacter_img(int character_img) {
            this.character_img = character_img;
        }
    }
}