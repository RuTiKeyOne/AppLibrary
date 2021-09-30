package com.example.applibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private TextView nameText, authorText, pagesText, descriptionText;
    private Button addToWantToReadBtn, addToAlreadyReadBtn, addToCurrentlyReadingBtn, addToFavouriteBtn;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initView();

        Intent intent = getIntent();

        if(null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);

            if(bookId != -1){
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if(null != incomingBook){
                    setData(incomingBook);
                }
            }
        }

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