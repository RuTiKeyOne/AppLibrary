package com.example.applibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

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
                Book incomingBook = null;
                try {
                    incomingBook = Utils.getInstance().getBookById(bookId);
                    setData(incomingBook);
                    handleFavouriteBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleAlreadyReadBooks(incomingBook);
                    handleWantToReadBooks(incomingBook);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void handleFavouriteBooks(final Book incomingBook) {
        ArrayList<Book> favouriteBooks = Utils.getInstance().getFavouriteBooks();
        boolean existInFavouriteBooks = false;
        for(Book book : favouriteBooks){
            if(book.getId() == incomingBook.getId()){
                existInFavouriteBooks = true;
            }
        }

        if(existInFavouriteBooks){
           addToFavouriteBtn.setEnabled(false);
        }else{
           addToFavouriteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToFavouriteBooks(incomingBook)){
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(BookActivity.this,FavouriteBooksActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happened try again", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

    private void handleCurrentlyReadingBooks(final Book incomingBook) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getCurrentlyReadingBooks();
        boolean exitsCurrentlyReadingBooks = false;

        for(Book book : currentlyReadingBooks){
            if(book.getId() == incomingBook.getId()){
                exitsCurrentlyReadingBooks = true;
            }
        }

        if(exitsCurrentlyReadingBooks){
            addToCurrentlyReadingBtn.setEnabled(false);
        }else{
            addToCurrentlyReadingBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToCurrentlyReadingBooks(incomingBook)){
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingBooksActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happened try again", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

    private void handleAlreadyReadBooks(final Book incomingBook) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();
        boolean exitsAlreadyReadBooks = false;

        for(Book book : alreadyReadBooks){
            if(book.getId() == incomingBook.getId()){
                exitsAlreadyReadBooks = true;
            }
        }

        if(exitsAlreadyReadBooks){
            addToAlreadyReadBtn.setEnabled(false);
        }else{
            addToAlreadyReadBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToAlreadyReadBooks(incomingBook)){
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActiivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happened try again", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBooks(final Book incomingBook) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();
        boolean exitsWantToReadBooks = false;

        for(Book book : wantToReadBooks){
            if(book.getId() == incomingBook.getId()){
                exitsWantToReadBooks = true;
            }
        }

        if(exitsWantToReadBooks){
            addToWantToReadBtn.setEnabled(false);
        }else{
            addToWantToReadBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToWantToReadBooks(incomingBook)){
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happened try again", Toast.LENGTH_LONG).show();
                    }
                }
            });
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