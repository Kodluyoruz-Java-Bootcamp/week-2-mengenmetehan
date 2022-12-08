package src.main.java;


import src.main.java.com.metehanmengen.example7.model.User;
import src.main.java.com.metehanmengen.example7.model.UserType;
import src.main.java.com.metehanmengen.example7.service.UserService;

import java.util.Collections;

public class Main {
    public static void main(String [] args) {

        User mete = new User("Mete", "mete@gmail.com", "123345", UserType.INDIVIDUAL, Collections.emptyList());
        User ayşe = new User("Ayşe", "ayşe@gmail.com", "123345", UserType.CORPARETE, Collections.emptyList());
        User ali = new User("Ali", "ali@gmail.com", "123345", UserType.CORPARETE, Collections.emptyList());
        User zeynep = new User("Zeynep", "zeynep@gmail.com", "123345", UserType.INDIVIDUAL, Collections.emptyList());

        UserService.


    }
}
