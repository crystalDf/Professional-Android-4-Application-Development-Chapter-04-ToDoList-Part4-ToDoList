package com.star.todolist;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity
        implements NewItemFragment.OnNewItemAddedListener {

    private ArrayList<ToDoItem> toDoItems;
    private ToDoItemAdapter toDoItemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        FragmentManager fragmentManager = getSupportFragmentManager();
        ToDoListFragment toDoListFragment =
                (ToDoListFragment) fragmentManager.findFragmentById(R.id.ToDoListFragment);

        toDoItems = new ArrayList<>();

        toDoItemAdapter = new ToDoItemAdapter(this, R.layout.todolist_item, toDoItems);

        toDoListFragment.setListAdapter(toDoItemAdapter);

    }

    @Override
    public void onNewItemAdded(String newItem) {
        ToDoItem newToDoItem = new ToDoItem(newItem);
        toDoItems.add(newToDoItem);
        toDoItemAdapter.notifyDataSetChanged();
    }
}
