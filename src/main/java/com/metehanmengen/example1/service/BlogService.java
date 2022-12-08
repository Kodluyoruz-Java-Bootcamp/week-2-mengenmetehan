package src.main.java.com.metehanmengen.example1.service;

import src.main.java.com.metehanmengen.example1.dao.BlogRepository;
import src.main.java.com.metehanmengen.example1.models.Blog;
import src.main.java.com.metehanmengen.example1.models.BlogStatus;
import src.main.java.com.metehanmengen.example1.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class BlogService {
    private BlogRepository blogRepository = new BlogRepository();

    public void publishBlog (Blog blog)
    {
        blogRepository.saveBlog(blog);
        System.out.printf("%s isimli blog kaydedildi.", blog.getName());
        System.out.println();
    }

    public void deleteBlog(Blog blog)
    {
        blogRepository.deleteBlog(blog);
    }

    public void updateBlog(Blog blog)
    {
        blogRepository.updateBlog(blog);
    }

    public List<Blog> getAll()
    {
        return blogRepository.getAll();
    }

    public List<Blog> getAllDraftBlog()
    {
        return getAll().stream().filter(blog -> blog.getStatus().name.equals(BlogStatus.DRAFT.name))
                .collect(Collectors.toList());
    }

    public List<Blog> getAllActiveBlog()
    {
        return getAll().stream().filter(blog -> blog.getStatus().name.equals(BlogStatus.PUBLISHED.name))
                .collect(Collectors.toList());
    }

    public List<Blog> getAllRemovedBlog()
    {
        return getAll().stream().filter(blog -> blog.getStatus().name.equals(BlogStatus.REMOVED.name))
                .collect(Collectors.toList());
    }



    public List<Blog> getBasicAccountByUsername(User user)
    {
        return getAll().stream().filter(blog -> blog.getCreater().getName().equals(user.getName()))
                .filter(blog -> blog.getStatusName().equals("ACTIVE"))
                .collect(Collectors.toList());
    }








}
