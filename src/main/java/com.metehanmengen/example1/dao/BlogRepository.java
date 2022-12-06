package src.main.java.com.metehanmengen.example1.dao;

import src.main.java.com.metehanmengen.example1.model.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogRepository {
    private static List<Blog> blogList = new ArrayList<>();

    public void saveBlog(Blog blog)
    {
        if (blog != null)
            blogList.add(blog);
    }

    public List<Blog> getAll()
    {
        List<Blog> blogs = new ArrayList<>(blogList); //Dizinin kopyası veriliyor.

        return blogs;
    }

    public void delete (Blog blog)
    {
        if (blogList.remove(blog))
            System.out.printf("%s isimli blog silindi", blog);
        else
            System.out.println("Blog bulunamadı");
    }

    public boolean update (Blog blog)
    {
        for(Blog b : blogList)
            if (b.getName().equals(blog.getName())) {
                blogList.remove(b);
                blogList.add(blog);
                return true;
            }
        return false;
    }
}
