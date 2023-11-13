/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Author;
import entity.Book;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class BookManager {

    private final Scanner scanner;

    public BookManager(Scanner scanner) {
        this.scanner = scanner;
    }
    public Book addBook(){
        System.out.println("----- Add book -----");
        Book book = new Book();
        System.out.print("Enter title: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Enter published year: ");
        book.setPublishedYear(scanner.nextInt());scanner.nextLine();
        System.out.println("Hoy many authors in book: ");
        int countAuthors = scanner.nextInt(); scanner.nextLine();
        for (int i = 0; i < countAuthors; i++) {
            System.out.printf("Enter author (%d) firstname: ", i+1);
            String authorFirstname = scanner.nextLine();
            System.out.printf("Enter author (%d) lastname: ",i+1);
            String authorLastname = scanner.nextLine();
            book.addAuthor(new Author(authorFirstname, authorLastname));
        }
        System.out.println("Added book: "+book.toString());
        return book;
    }

    public void printListBooks(Book[] books) {
        System.out.println("----- List books -----");
        for (int i = 0; i < books.length; i++) {
            System.out.printf("%d. %s%n",
                    i+1,
                    books[i].getTitle()
            );
        }
    }
}
