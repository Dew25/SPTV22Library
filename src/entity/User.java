/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author admin
 */
public class User implements Serializable{
    private String login;
    private String password;
    private Reader reader;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.login);
        hash = 23 * hash + Objects.hashCode(this.password);
        hash = 23 * hash + Objects.hashCode(this.reader);
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
        final User other = (User) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" 
                + "login=" + login 
                + ", password=" + password 
                + ", reader=" + reader.getFirstname()
                + " " + reader.getLastname()
                + '}';
    }
    
    
}
