/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Reader;
import java.util.List;
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
    
    public Reader addReader() {
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

    public void printListReaders(List<Reader> readers) {
        System.out.println("----- List readers -----");
        for (int i = 0; i < readers.size(); i++) {
            System.out.printf("%d. %s %s. (%s)%n",
                    i+1,
                    readers.get(i).getFirstname(),
                    readers.get(i).getLastname(),
                    readers.get(i).getPhone()
            );
        }
    }

    

    
    
}
