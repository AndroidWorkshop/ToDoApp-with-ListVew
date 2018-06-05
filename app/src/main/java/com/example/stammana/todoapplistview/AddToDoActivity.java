package com.example.stammana.todoapplistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
    }

    public void addToDoItem(View view) {
        Intent intent = new Intent();
        EditText toDoItemView = (EditText) findViewById(R.id.toDoItem);
        intent.putExtra("TO_DO_ITEM", toDoItemView.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
