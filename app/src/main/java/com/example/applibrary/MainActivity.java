package com.example.applibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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