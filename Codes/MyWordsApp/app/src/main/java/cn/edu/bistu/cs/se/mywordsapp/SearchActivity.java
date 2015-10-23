package cn.edu.bistu.cs.se.mywordsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Map;

import cn.edu.bistu.cs.se.mywordsapp.wordcontract.Words;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        ArrayList<Map<String, String>> items= (ArrayList<Map<String, String>>) bundle.getSerializable("result");

        SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.item,
                new String[]{Words.Word._ID,Words.Word.COLUMN_NAME_WORD},
                new int[]{R.id.textId,R.id.textViewWord});

        ListView list = (ListView) findViewById(R.id.lstSearchResultWords);

        list.setAdapter(adapter);
    }
}
