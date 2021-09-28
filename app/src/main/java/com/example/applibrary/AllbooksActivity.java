package com.example.applibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllbooksActivity extends AppCompatActivity {

    private RecyclerView booksRecView;
    private BookRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allbooks);

        adapter = new BookRecViewAdapter(this);
        booksRecView = findViewById(R.id.booksRecView);
        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new GridLayoutManager(this,2));
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "The fight club", "Chuck Palahniuk", 208, "https://cdn1.ozone.ru/s3/multimedia-8/wc1200/6008219528.jpg",
                "Fight Club is a 1996 novel by Chuck Palahniuk.", "Long description"));
        adapter.setBooksList(books);
    }
}