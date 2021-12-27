package com.example.flashcard.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.flashcard.models.entity.Deck;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface DeckDao {
    @Query("SELECT * FROM Deck")
    public List<Deck> getAllDecks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDeck(Deck deck);

}
