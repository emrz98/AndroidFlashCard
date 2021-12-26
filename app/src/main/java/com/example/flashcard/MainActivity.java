package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.flashcard.adapters.AdapterMain;
import com.example.flashcard.dao.ItemMainDao;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<ItemMainDao> listItems;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItems = new ArrayList<>();
        ItemMainDao newItem = new ItemMainDao("Emmanuel");
        ItemMainDao newItem2 = new ItemMainDao("Eduardo");
        listItems.add(newItem);
        listItems.add(newItem2);
        RecyclerView.Adapter adapterMain = new AdapterMain(listItems);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapterMain);

        adapterMain.notifyDataSetChanged();
    }
}