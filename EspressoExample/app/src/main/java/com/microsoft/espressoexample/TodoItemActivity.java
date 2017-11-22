package com.microsoft.espressoexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TodoItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_item);
    }

    public void save(View view) {
        TextView textView = findViewById(R.id.NameText);
        String name = textView.getText().toString();
        HomeActivity.tasks.add(name);
        finish();
    }

    public void cancel(View view) {
        finish();
    }
}
