package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.example.flashcard.adapters.AdapterDecks;
import com.example.flashcard.adapters.AdapterMain;
import com.example.flashcard.dao.ItemMainDao;
import com.example.flashcard.models.entity.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import io.reactivex.rxjava3.core.Single;


public class MainActivity extends AppCompatActivity {
    private ArrayList<ItemMainDao> listItems;
    private RecyclerView recyclerView;
    List<Deck> listDecks;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItems = new ArrayList<>();
        ItemMainDao newItem = new ItemMainDao("Emmanuel");
        ItemMainDao newItem2 = new ItemMainDao("Eduardo");
        listItems.add(newItem);
        listItems.add(newItem2);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").fallbackToDestructiveMigration().build();

/*        Deck deck = new Deck();
        deck.setName("Otro deck");
        db.deckDao().insertDeck(deck);*/
        try{
            listDecks = getDefaultData();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


//        RecyclerView.Adapter adapterMain = new AdapterMain(listItems);
        RecyclerView.Adapter adapterDecks = new AdapterDecks(listDecks);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapterDecks);

        adapterDecks.notifyDataSetChanged();
    }

    public List<Deck> getDefaultData() throws ExecutionException, InterruptedException {

        Callable< List<Deck>> callable = new Callable<List<Deck>>() {
            @Override
            public  List<Deck> call() throws Exception {
                return db.deckDao().getAllDecks();
            }
        };
        Future<List<Deck>> future = Executors.newSingleThreadExecutor().submit(callable);

        return future.get();
    }


}