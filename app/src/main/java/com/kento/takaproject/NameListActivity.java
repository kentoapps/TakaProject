package com.kento.takaproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class NameListActivity extends AppCompatActivity {

    public final static String CHARACTER_IMG = "CHARACTER_IMG";
    public final static String CHARACTER_NAME = "CHARACTER_NAME";
    public final static String CHARACTER_WORD = "CHARACTER_WORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);


        //ListViewの取得
        ListView list = (ListView) findViewById(R.id.characterList);

        //キャラリスト項目をarrayListとして準備
        final ArrayList<CharacterData> characterDataList = new ArrayList<>();

        final int[] img = {
                R.drawable.josuke,
                R.drawable.okuyasu,
                R.drawable.koichi,
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


        final String[] name = {
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

        final String[] words = {
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


        for (int i = 0; i < img.length; i++) {
            CharacterData characters = new CharacterData();
            characters.setImg(img[i]);
            characters.setName(name[i]);
            characters.setWords(words[i]);
            characterDataList.add(characters);
        }

        //Adapter -ArrayAdapter - CharacterAdapter
        final CharacterAdapter adapter = new CharacterAdapter(this, 0, characterDataList);


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
                CharacterData character = (CharacterData) parent.getItemAtPosition(pos);

                //通知ダイヤルを表示
                //Toast.makeText(NameListActivity.this, character.getCharacter_words(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), CharacterDetail.class);

                intent.putExtra(CHARACTER_IMG, character.getImg());
                intent.putExtra(CHARACTER_NAME, character.getName());
                intent.putExtra(CHARACTER_WORD, character.getWords());

                startActivity(intent);
            }

        });

    }


    public class CharacterAdapter extends ArrayAdapter<CharacterData> {
        private LayoutInflater layoutInflater;

        public CharacterAdapter(Context c, int id, ArrayList<CharacterData> character_data) {
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
            CharacterData characterData = getItem(pos);

            ((ImageView) convertView.findViewById(R.id.icon))
                    .setImageResource(characterData.getImg());
            ((TextView) convertView.findViewById(R.id.name))
                    .setText(characterData.getName());

            return convertView;
        }
    }


    public class CharacterData {
        private int img;
        private String name;
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getImg() {
            return img;
        }

        public void setImg(int img) {
            this.img = img;
        }
    }
}