package com.kento.takaproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NameListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);

        //キャラリスト項目をarrayListとして準備
        final ArrayList<String> character_data = new ArrayList<>();
        character_data.add("東方仗助");
        character_data.add("虹村億泰");
        character_data.add("広瀬康一");
        character_data.add("岸辺露伴");
        character_data.add("空条承太郎");
        character_data.add("吉良吉影");
        character_data.add("山岸由花子");
        character_data.add("音石明");
        character_data.add("矢安宮重清");
        character_data.add("噴上裕也");
        character_data.add("宮本輝之輔");
        character_data.add("虹村形兆");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, character_data);
        ListView list = (ListView) findViewById(R.id.characterList);
        list.setAdapter(adapter);

        //リスト項目をクリックした時の処理
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View view, int pos, long id) {
                String msg = "が押されたよ";
                // 選択アイテムを取得
                ListView listView = (ListView) parent;
                String character = (String) listView.getItemAtPosition(pos);

                //通知ダイヤルを表示
                Toast.makeText(NameListActivity.this, character + msg, Toast.LENGTH_LONG).show();
            }
        });

    }
}
