package com.example.applibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    private TextView nameText, authorText, pagesText, descriptionText;
    private Button addToWantToReadBtn, addToAlreadyReadBtn, addToCurrentlyReadingBtn, addToFavouriteBtn;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initView();
        Book book = new Book(1, "The Fight Club", "Chuck Palahniuk", 208, "https://m.media-amazon.com/images/M/MV5BMmEzNTkxYjQtZTc0MC00YTVjLTg5ZTEtZWMwOWVlYzY0NWIwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg",
                "Fight Club is a 1996 novel by Chuck Palahniuk. It follows the experiences of an unnamed protagonist struggling with insomnia.", "In his debut novel, Chuck Palahniuk showed himself to be his generation's most visionary satirist. Fight Club's estranged narrator leaves his lackluster job when he comes under the thrall of Tyler Durden, an enigmatic young man who holds secret boxing matches in the basement of bars. There two men fight \"as long as they have to.\" A gloriously original work that exposes what is at the core of our modern world.");
        setData(book);
    }

    private void setData(Book book) {
        nameText.setText(book.getName());
        authorText.setText(book.getAuthor());
        pagesText.setText(String.valueOf(book.getPages()));
        descriptionText.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImageUlr())
                .into(this.bookImage);
    }

    public void initView(){
        nameText = findViewById(R.id.valueBookName);
        authorText = findViewById(R.id.valueAuthor);
        pagesText = findViewById(R.id.valuePages);
        descriptionText = findViewById(R.id.valueDescription);

        addToWantToReadBtn = findViewById(R.id.btnWantToRead);
        addToAlreadyReadBtn = findViewById(R.id.btnAlreayRead);
        addToCurrentlyReadingBtn = findViewById(R.id.btnAddToCurrentlyReading);
        addToFavouriteBtn = findViewById(R.id.btnAddToFavourite);

        bookImage = findViewById(R.id.imageView);
    }
}