package com.microsoft.espressoexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    static List<String> tasks = new ArrayList<String>() {{ add("Aflevere børn"); add("Hente børn"); }};
    Button addTaskButton;
    ListView taskListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        taskListView = findViewById(R.id.TaskList);
        addTaskButton = findViewById(R.id.AddButton);

        // wire up add task button handler
        if (addTaskButton != null) {
            /*addTaskButton.Click += (sender, e) => {
                StartActivity(typeof(TodoItemScreen));
            };*/
        }

        // wire up task click handler
        if(taskListView != null) {
            /*taskListView.ItemClick += (object sender, AdapterView.ItemClickEventArgs e) => {
                var taskDetails = new Intent(this, typeof (TodoItemScreen));
                taskDetails.PutExtra ("TaskID", tasks[e.Position].ID);
                StartActivity (taskDetails);
            };*/
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_layout, tasks);
        taskListView.setAdapter(adapter);
    }

    public void addNewTask(View view) {
        Intent intent = new Intent(this, TodoItemActivity.class);
        startActivity(intent);
    }
}
