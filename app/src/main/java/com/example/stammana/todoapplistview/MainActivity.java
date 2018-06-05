package com.example.stammana.todoapplistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> toDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toDos = new ArrayList<>();
        setToDosInListView();
    }


    public void addToDo(View view) {

        Intent intent = new Intent(this, AddToDoActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                toDos.add(data.getStringExtra("TO_DO_ITEM"));
                setToDosInListView();
            }
        }
    }

    private void setToDosInListView() {
        ListView listView = findViewById(R.id.toDos);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, toDos);
        listView.setAdapter(arrayAdapter);
    }
}
