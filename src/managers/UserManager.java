/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Reader;
import entity.User;
import java.util.List;
import java.util.Scanner;
import sptv22library.App;
import tools.InputProtection;
import tools.PassEncrypt;

/**
 *
 * @author admin
 */
public class UserManager {
    private final Scanner scanner;
    private final DatabaseManager databaseManager;
    
    public UserManager(Scanner scanner,DatabaseManager databaseManager) {
        this.scanner = scanner;
        this.databaseManager = databaseManager;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }
    
    public User addUser() {
        
        Reader reader = new Reader();
        System.out.println("----- Add reader -----");
        System.out.print("Firstname: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Lastname: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Phone: ");
        reader.setPhone(scanner.nextLine());
        User user = new User();
        System.out.print("Login: ");
        user.setLogin(scanner.nextLine());
        System.out.print("Password: ");
        PassEncrypt pe = new PassEncrypt();
        user.setPassword(pe.getEncryptPassword(scanner.nextLine().trim(),pe.getSalt()));
        user.setReader(reader);
        user.getRoles().add(App.ROLES.USER.toString());
        System.out.println("New reader added!");
        return user;
    }

    public void printListUsers() {
        System.out.println("----- List readers -----");
        List<User> users = getDatabaseManager().getListUsers();
        for (int i = 0; i < users.size(); i++) {
            System.out.printf("%d. %s %s. Login: %s (phone: %s)%n",
                    users.get(i).getId(),
                    users.get(i).getReader().getFirstname(),
                    users.get(i).getReader().getLastname(),
                    users.get(i).getLogin(),
                    users.get(i).getReader().getPhone()
            );
        }
    }

    public void changeRole() {
        //Выводим список пользователей и выбираем пользователя
        //Выводим список ролей и выбираем роль
        //Выводим список действий и выбираем действие
        printListUsers();
        System.out.println("Выберите пользователя: ");
        int idUser = InputProtection.intInput(1, null);
        for (int i = 0; i < App.ROLES.values().length; i++) {
            System.out.printf("%d %s%n", i+1, App.ROLES.values()[i].toString());
        }
        System.out.println("Выберите роль: ");
        int numRole = InputProtection.intInput(1, 3);
        System.out.println("Выберите действие: ");
        System.out.println("1 - Добавить роль");
        System.out.println("2 - Удалить роль");
        int action = InputProtection.intInput(1, 2);
        if(action == 1){
            this.addRole(idUser, numRole);
        }else if(action == 2){
            this.removeRole(idUser, numRole);
        }
        
    }

    private void addRole(int idUser, int numRole) {
        User user = getDatabaseManager().getUser((long)idUser);
        String role = App.ROLES.values()[numRole-1].toString();
        if(!user.getRoles().contains(role)){
            user.getRoles().add(role);
            getDatabaseManager().saveUser(user);
            System.out.println("Роль добавлена");
            if(App.user.getId().equals(user.getId())){
                App.user = user;
            }
        }else{
            System.out.printf("Роль %s  уже есть у пользователя",role);
        }
        
    }

    private void removeRole(int idUser, int numRole) {
        User user = getDatabaseManager().getUser((long)idUser);
        if(user.getLogin().equals("admin")){
            System.out.println("Изменения невозможны");
            return;
        }
        String role = App.ROLES.values()[numRole-1].toString();
        if(user.getRoles().contains(role)){
            user.getRoles().remove(role);
            getDatabaseManager().saveUser(user);
            if(App.user.getId().equals(user.getId())){
                App.user = user;
            }
            System.out.println("Роль удалена");
        }else{
            System.out.printf("Роли %s  у пользователя нет",role);
        }
    }
}
