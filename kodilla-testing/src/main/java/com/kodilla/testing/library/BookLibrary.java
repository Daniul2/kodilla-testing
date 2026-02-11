package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        if (titleFragment.length() < 3) return new ArrayList<>();
        List<Book> bookList = libraryDatabase.listBooksWithCondition(titleFragment);
        if (bookList.size() > 20) return new ArrayList<>();
        return bookList;
    }

    // Твоя нова реалізація для завдання 6.6:
    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        return libraryDatabase.listBooksInHandsOf(libraryUser);
    }
}
