package com.example.applibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBook;
    private static ArrayList<Book> favouriteBooks;

    private Utils() {
        if(null == allBooks){
            allBooks = new ArrayList<>();
            initView();
        }

        if(null == alreadyReadBooks){
            alreadyReadBooks = new ArrayList<>();
        }

        if(null == wantToReadBooks){
            wantToReadBooks = new ArrayList<>();
        }

        if(null == currentlyReadingBook){
            currentlyReadingBook = new ArrayList<>();
        }

        if(null == favouriteBooks){
            favouriteBooks = new ArrayList<>();
        }
    }

    private void initView() {
        allBooks.add(new Book(1, "The fight club", "Chuck Palahniuk", 208, "https://m.media-amazon.com/images/M/MV5BMmEzNTkxYjQtZTc0MC00YTVjLTg5ZTEtZWMwOWVlYzY0NWIwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg",
                "Fight Club is a 1996 novel by Chuck Palahniuk. It follows the experiences of an unnamed protagonist struggling with insomnia.", ""));
        allBooks.add(new Book(2, "1984", "George Orwell", 328, "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1327144697l/3744438.jpg",
                "Nineteen Eighty-Four, often referred to as 1984, is a dystopian social science fiction novel by the English novelist George Orwell.", ""));
    }

    public static synchronized Utils getInstance(){

        if(null == instance){
            instance = new Utils();
        }

        return instance;
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBook;
    }

    public static ArrayList<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    public Book getBookById(int id) throws Exception {
        for(Book book : allBooks){
            if(book.getId() == id){
                return book;
            }
        }

        throw new Exception();
    }

    public boolean addToAlreadyReadBooks(Book book){
        return alreadyReadBooks.add(book);
    }

    public boolean addToWantToReadBooks(Book book){return wantToReadBooks.add(book);}

    public boolean addToFavouriteBooks(Book incomingBook) {return  favouriteBooks.add(incomingBook);
    }

    public boolean addToCurrentlyReadingBooks(Book incomingBook) {
        return currentlyReadingBook.add(incomingBook);
    }

    public boolean removeFromAlreadyRead(Book book){
        return alreadyReadBooks.remove(book);
    }

    public boolean removeFromWantToRead(Book book){return wantToReadBooks.remove(book);}

    public boolean removeCurrentlyReading(Book book){return currentlyReadingBook.remove(book);}

    public boolean removeFromFavourite(Book book){return favouriteBooks.remove(book);}

}
