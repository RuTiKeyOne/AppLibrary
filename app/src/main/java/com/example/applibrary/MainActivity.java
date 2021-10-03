package com.example.applibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button seeAllBtn, currentlyReadingBooksBtn, alreadyReadBooksBtn, yourWishlistBtn, seeYourFavouriteBtn, aboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        seeAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllbooksActivity.class);
                startActivity(intent);
            }
        });

        alreadyReadBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadBookActiivity.class);
                startActivity(intent);
            }
        });

        seeYourFavouriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavouriteBooksActivity.class);
                startActivity(intent);
            }
        });

        currentlyReadingBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingBooksActivity.class);
                startActivity(intent);

            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Designed and Develop by Ershov Andrew at google)");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);
                        startActivity(intent);
                    }
                });
                builder.create().show();

            }
        });

        Utils.getInstance();
    }

    private void initView(){
        seeAllBtn = findViewById(R.id.seeAllBooksBtn);
        currentlyReadingBooksBtn = findViewById(R.id.currentlyReadingBooksBtn);
        alreadyReadBooksBtn = findViewById(R.id.alreadyReadBooksBtn);
        yourWishlistBtn = findViewById(R.id.youtWishlistBtn);
        seeYourFavouriteBtn = findViewById(R.id.seeYourFavouritesBtn);
        aboutBtn = findViewById(R.id.about);
    }
}