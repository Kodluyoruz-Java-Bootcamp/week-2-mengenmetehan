package src.main.java.com.metehanmengen.example1.service;


import src.main.java.com.metehanmengen.example1.dao.UserRepository;
import src.main.java.com.metehanmengen.example1.models.Blog;
import src.main.java.com.metehanmengen.example1.models.Tag;
import src.main.java.com.metehanmengen.example1.models.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public void saveUser (User user)
    {
        userRepository.saveUser(user);
    }

    public List<User> getAllUser()
    {
        return userRepository.getAllUser();
    }

    public List<User> getAllFollower(User user)
    {
        return userRepository.getAllFollowerUser(user);
    }
    public void addFollowerUser(User follower, User following)
    {
        userRepository.addFollowerUser(follower, following);
    }

    public void deleteUser(User user)
    {
        userRepository.deleteUser(user);
    }

    public void printAllUser()
    {
        getAllUser().forEach(System.out::println);
    }

    public List<Blog> getAllBlogList ()
    {
        return userRepository.getAllUser().stream()
                .flatMap(list -> list.getBlogList().stream())
                .collect(Collectors.toList());
    }

    public List<Tag> findTagListByUser (User user)
    {
        var userList = userRepository.getAllUser()
                .stream().filter(u -> u.equals(user))
                .toList();

        return userList.stream().map(User::getTagList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }

    public void updatePassword(User user, String password)
    {
       userRepository.updatePassword(user, password);
    }

}
