/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.InputProtection;

/**
 *
 * @author admin
 */
public class HistoryManager {

    private final Scanner scanner;
    private final BookManager bookManager;
    private final ReaderManager readerManager;

    public HistoryManager(
            Scanner scanner, 
            ReaderManager readerManager, 
            BookManager bookManager) {
        this.scanner = scanner;
        this.bookManager = bookManager;
        this.readerManager = readerManager;
    }
    /**
     * Логика работы метода
     * 1. список книг
     * 2. пользователь вводит номер книги
     * 3. записываем в историю выбранную книгу из массива книг
     * 4. список читателей
     * 5. пользователь вводит номер читателя
     * 6. записываем в историю выбранного читателя из массива читателей
     * 7. записываем в историю дату выдачи книги
     * @param books
     * @param readers
     * @return History history
     */
    public History takeOutBook(Book[] books, Reader[] readers) {
        History history = new History();
        bookManager.printListBooks(books);
        System.out.print("Enter number book from list: ");
        int numberBook = InputProtection.intInput(1, books.length); //scanner.nextInt(); scanner.nextLine();
        history.setBook(books[numberBook - 1]);
        readerManager.printListReaders(readers);
        System.out.print("Enter number reader from list: ");
        int numberReader = InputProtection.intInput(1, readers.length);//scanner.nextInt(); scanner.nextLine();
        history.setReader(readers[numberReader-1]);
        history.setTakeOutBook(new GregorianCalendar().getTime());
        
        return history;
    }

    public void printListReadingBooks(History[] histories) {
        System.out.println("----- List reading books -----");
        for (int i = 0; i < histories.length; i++) {
            if(histories[i].getReturnBook() == null){
                System.out.printf("%d. %s. read %s %s%n",
                        i+1,
                        histories[i].getBook().getTitle(),
                        histories[i].getReader().getFirstname(),
                        histories[i].getReader().getLastname()
                );
            }
        }
    }

    public void returnBook(History[] histories) {
        System.out.println("Return book:");
        this.printListReadingBooks(histories);
        System.out.println("Enter number book: ");
        int numberReturnBook = InputProtection.intInput(1, histories.length);
        histories[numberReturnBook - 1].setReturnBook(new GregorianCalendar().getTime());
    }
    
}
