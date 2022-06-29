package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {


    @Mock
    private LibraryDatabase libraryDatabaseMock;
    @Test
    void testLListBooksWithConditionsReturnList(){
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        //when
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        //then
        assertEquals(4, theListOfBooks.size());
    }
     private List<Book> generateListOfNBooks(int booksQuantity) {
         List<Book> resultList = new ArrayList<>();
         for (int n = 1; n <= booksQuantity; n++) {
             Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
             resultList.add(theBook);
         }
         return resultList;
     }

     @Test
     void testListBooksWithConditionMoreThan20() {
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition((anyString()))).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        //when
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Anytitle");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        //then
        assertEquals(0,theListOfBooks0.size());
        assertEquals(15,theListOfBooks15.size());
        assertEquals(0,theListOfBooks40.size());
    }


    @Test
    void testListBooksWithConditionFragmentShorterThan3(){
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        //when
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
        //then
        assertEquals(0,theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());

    }
    @Test
    void testListBooksInHandsOfNoneBooks(){

        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("John","Smith","123456789");

        List<Book> userBooks = new ArrayList<>();


        when((libraryDatabaseMock.listBooksInHandsOf(user))).thenReturn(userBooks);
        //when
        List<Book> userBooks2 = bookLibrary.listBooksInHandsOf(user);
        //then
        assertEquals(userBooks2,userBooks);
        assertEquals(userBooks.size(),0);


    }
    @Test
    void testListBooksInHandsOfOneBook(){
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("John","Smith","123456789");
        Book book1 = new Book("Title","Author", 1995);
        List<Book> userBooks = new ArrayList<>();
        userBooks.add(book1);

        when((libraryDatabaseMock.listBooksInHandsOf(user))).thenReturn(userBooks);
        //when
        List<Book> userBooks2 = bookLibrary.listBooksInHandsOf(user);
        //then
        assertEquals(userBooks2,userBooks);
        assertEquals(userBooks.size(),1);

}
    @Test
    void testListBooksInHandsOfFiveBooks(){
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("John","Smith","123456789");
        Book book1 = new Book("Title","Author", 1995);
        Book book2 = new Book("Title1","Author1", 1995);
        Book book3 = new Book("Title2","Author2", 1995);
        Book book4 = new Book("Title3","Author3", 1995);
        Book book5 = new Book("Title4","Author4", 1995);
        List<Book> userBooks = new ArrayList<>();
        userBooks.add(book1);
        userBooks.add(book2);
        userBooks.add(book3);
        userBooks.add(book4);
        userBooks.add(book5);

        when((libraryDatabaseMock.listBooksInHandsOf(user))).thenReturn(userBooks);
        //when
        List<Book> userBooks2 = bookLibrary.listBooksInHandsOf(user);
        //then
        assertEquals(userBooks.size(),5);
    }
 }