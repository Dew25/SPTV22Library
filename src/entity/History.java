/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author admin
 */
public class History implements Serializable{
    private Book book;
    private Reader reader;
    private Date takeOutBook;
    private Date returnBook;

    public History() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getTakeOutBook() {
        return takeOutBook;
    }

    public void setTakeOutBook(Date takeOutBook) {
        this.takeOutBook = takeOutBook;
    }

    public Date getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(Date returnBook) {
        this.returnBook = returnBook;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.book);
        hash = 83 * hash + Objects.hashCode(this.reader);
        hash = 83 * hash + Objects.hashCode(this.takeOutBook);
        hash = 83 * hash + Objects.hashCode(this.returnBook);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final History other = (History) obj;
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        if (!Objects.equals(this.takeOutBook, other.takeOutBook)) {
            return false;
        }
        if (!Objects.equals(this.returnBook, other.returnBook)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
        return "History{" 
                + "book=" + book.getTitle()
                + ", reader=" + reader.getFirstname()
                + " " + reader.getLastname()
                + ", takeOutBook=" + sdf.format(takeOutBook) 
                + ", returnBook=" + sdf.format(returnBook)
                + '}';
    }
    
}
