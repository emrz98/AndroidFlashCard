package com.example.flashcard;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.flashcard.dao.DeckDao;
import com.example.flashcard.models.entity.Deck;

@Database(entities = {Deck.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DeckDao deckDao();
}
