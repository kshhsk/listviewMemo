package com.example.ksh.a0805memo;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
    ListView listView;
    MyAdapter adapter;
    EditText edit;
    ArrayList<Data> items;

    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = PreferenceManager.getDefaultSharedPreferences(this);

        listView = (ListView)findViewById(R.id.list);
        items = new ArrayList<>();
        adapter = new MyAdapter(this, items);
        listView.setAdapter(adapter);

        loadNowData();
        adapter.notifyDataSetChanged();

        edit = (EditText)findViewById(R.id.edit_add);


        button=(Button)findViewById(R.id.btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = edit.getText().toString();
                items.add(new Data("3월 5일", input));
                saveNowData();
                adapter.notifyDataSetChanged();
            }
        });
    }

    void saveNowData(){ //items 안의 내용이 저장됨
       String json = new Gson().toJson(items);
        pref.edit().putString("save", json).apply();
    }

    void loadNowData(){ //items 안의 내용이 저장된 내용에서 가져와짐
        String json = pref.getString("save", "");
        Type listType = new TypeToken<ArrayList<Data>>(){}.getType();
        ArrayList<Data> list = new Gson().fromJson(json, listType);

        if(list != null) items.addAll(list);
    }
}

