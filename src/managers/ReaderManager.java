/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ReaderManager {
    private final Scanner scanner;

    public ReaderManager(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public Reader addReader(Reader[] readers) {
        Reader reader = new Reader();
        System.out.println("----- Add reader -----");
        System.out.print("Firstname: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Lastname: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Phone: ");
        reader.setPhone(scanner.nextLine());
        System.out.println("New reader added!");
        return reader;
    }

    public void printListReaders(Reader[] readers) {
        System.out.println("----- List readers -----");
        for (int i = 0; i < readers.length; i++) {
            System.out.printf("%d. %s %s. (%s)%n",
                    i+1,
                    readers[i].getFirstname(),
                    readers[i].getLastname(),
                    readers[i].getPhone()
            );
        }
    }

    

    
    
}
