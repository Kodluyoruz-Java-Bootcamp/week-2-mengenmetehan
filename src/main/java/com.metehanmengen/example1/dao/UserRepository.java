package src.main.java.com.metehanmengen.example1.dao;

import src.main.java.com.metehanmengen.example1.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final List<User> userList = new ArrayList<>();
    private static final List<User> followerList = new ArrayList<>();
    public void saveUser(User user)
    {
        if (user != null)
            userList.add(user);
    }

    public void followUser(User user)
    {
        if (user != null)
            followerList.add(user);
    }
    public List<User> getAllUser()
    {
        List<User> users = new ArrayList<>(userList); //Dizinin kopyası veriliyor.

        return users;
    }

    public List<User> getAllFollower()
    {
        List<User> users = new ArrayList<>(followerList); //Dizinin kopyası veriliyor.

        return users;
    }

    public void delete (User user)
    {
        if (userList.remove(user))
            System.out.printf("%s isimli blog silindi", user);
        else
            System.out.println("Blog bulunamadı");
    }

    public boolean updatePassword(User user, String password)
    {
        for(User u : userList)
            if (u.getName().equals(user.getName())) {
                u.setPassword(password);
                return true;
            }
        return false;
    }
}
