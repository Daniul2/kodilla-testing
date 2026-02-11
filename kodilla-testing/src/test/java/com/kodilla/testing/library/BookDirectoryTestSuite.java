package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    void testListBooksInHandsOfZeroBooks() {
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("John", "Doe", "123456");
        when(libraryDatabaseMock.listBooksInHandsOf(any(LibraryUser.class))).thenReturn(new ArrayList<>());

        List<Book> resultList = bookLibrary.listBooksInHandsOf(user);
        assertEquals(0, resultList.size());
    }

    @Test
    void testListBooksInHandsOfOneBook() {
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("John", "Doe", "123456");
        List<Book> resultList = new ArrayList<>();
        resultList.add(new Book("Title1", "Author1", 2000));
        when(libraryDatabaseMock.listBooksInHandsOf(any(LibraryUser.class))).thenReturn(resultList);

        List<Book> result = bookLibrary.listBooksInHandsOf(user);

        assertEquals(1, result.size());
    }

    @Test
    void testListBooksInHandsOfFiveBooks() {
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("John", "Doe", "123456");
        List<Book> resultList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            resultList.add(new Book("Title" + i, "Author" + i, 2000 + i));
        }
        when(libraryDatabaseMock.listBooksInHandsOf(any(LibraryUser.class))).thenReturn(resultList);

        List<Book> result = bookLibrary.listBooksInHandsOf(user);

        assertEquals(5, result.size());
    }
}
