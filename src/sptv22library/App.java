/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptv22library;

import entity.Author;
import entity.Book;
import java.util.Arrays;
import java.util.Scanner;
import managers.BookManager;

/**
 *
 * @author admin
 */
public class App {
    private Scanner scanner = new Scanner(System.in);
    private Book[] books = new Book[0];
    public void run() {
        boolean repeat = true;
        System.out.println("------- Library -------");
        do{
            System.out.println("List taks:");
            System.out.println("0. Exit");
            System.out.println("1. Add new book");
            System.out.print("Enter task number: ");
            int task = scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    BookManager bookManager = new BookManager(scanner);
                    this.books = Arrays.copyOf(this.books, this.books.length+1);
                    this.books[this.books.length - 1] = bookManager.addBook();
                    break;
                default:
                    System.out.println("Select from list tasks!");
            }
            System.out.println("-----------------------");
        }while(repeat);
        System.out.println("By-by!");
    }
    
}
