package src.main.java;

import src.main.java.com.metehanmengen.example1.model.*;
import src.main.java.com.metehanmengen.example1.service.BlogService;
import src.main.java.com.metehanmengen.example1.service.UserService;

public class Main {
    public static void main(String [] args) {

        //User'lar oluşturuldu.
        User mete = new User(1, "Mete", "Mengen","asdqwe");
        User ahmet = new User(2,"Ahmet", "Akın", "qquıweqwe");
        User mehmet = new User(3,"Mehmet","Akın","zxcxzczxczx");
        User ayşe = new User(4,"Ayşe","Ateş", "lajsdlald");
        User zeynep = new User(5,"Zeynep","Yılmaz","ljkakljd");

        mete.setType(UserType.PREMIUM); //Default basic,
        ahmet.setType(UserType.PREMIUM);

        //Bloglar oluşturuldu.
        BlogService blogService = new BlogService();

        Blog blogRest = new Blog("Rest Service Yapısı", "Software Development");
        Blog blogDocker = new Blog("Docker nedir ?", "Software Development");
        Blog blogLahmacun = new Blog("Lahmacun'un pif noktaları: ", "Cuisine");
        Blog blogCar = new Blog("Neden BMW ? ", "Car");
        Blog blogPhone = new Blog("Iphone 14 özellikleri" , "Phone");
        Blog blogCrypto = new Blog("Blockchain nedir ?", "Crypto");
        Blog blogInvesment = new Blog("Piyasalarda yatırım yapmak", "Invesment");

        blogRest.setStatus(BlogStatus.PUBLISHED); //Default Draft'a kaydediyor.
        blogDocker.setStatus(BlogStatus.PUBLISHED);
        blogLahmacun.setStatus(BlogStatus.PUBLISHED);
        blogPhone.setStatus(BlogStatus.REMOVED);
        blogCar.setStatus(BlogStatus.PUBLISHED);
        blogCrypto.setStatus(BlogStatus.REMOVED);

        blogCar.setCreater(mete);
        mete.addBlogList(blogCar);
        blogDocker.setCreater(ayşe);
        ayşe.addBlogList(blogDocker);
        blogLahmacun.setCreater(mehmet);
        mehmet.addBlogList(blogLahmacun);
        blogRest.setCreater(ahmet);
        ahmet.addBlogList(blogRest);
        blogPhone.setCreater(zeynep);
        zeynep.addBlogList(blogPhone);
        blogInvesment.setCreater(zeynep);
        zeynep.addBlogList(blogInvesment);
        blogCrypto.setCreater(mehmet);
        mehmet.addBlogList(blogCrypto);


        UserService userService = new UserService();
        userService.saveUser(mete);
        userService.saveUser(mehmet);
        userService.saveUser(ahmet);
        userService.saveUser(ayşe);
        userService.saveUser(zeynep);

        userService.printAllUser();
        System.out.println("----------------------------------------");

        blogService.publishBlog(blogCar);
        blogService.publishBlog(blogDocker);
        blogService.publishBlog(blogLahmacun);
        blogService.publishBlog(blogRest);
        blogService.publishBlog(blogPhone);
        blogService.publishBlog(blogInvesment);
        blogService.publishBlog(blogCrypto);

        System.out.println("----------------------------------------");
        System.out.println("## Tüm aktif blog'lar");
        blogService.getAllActiveBlog().stream().forEach(System.out::println);

        System.out.println("----------------------------------------");
        System.out.println("## Tüm taslak blog'lar");
        blogService.getAllDraftBlog().stream().forEach(System.out::println);

        System.out.println("----------------------------------------");
        System.out.println("## Tüm kaldırılan blog'lar");
        blogService.getAllRemovedBlog().stream().forEach(System.out::println);

        System.out.println("----------------------------------------");

        //Tag'ler oluşturuldu.
        Tag tagRestService = new Tag("Rest Service", "Sofware Development");
        Tag tagDocker = new Tag("Docker", "Sofware Development");
        Tag tagFood = new Tag("South East Turkey Cuisine", "Cuisine");
        Tag tagCar = new Tag("BMW", "Car");
        Tag tagPhone = new Tag("Iphone", "Phone");

        //Tag'ler eklendi.
        mete.addTag(tagDocker);
        mete.addTag(tagCar);
        mete.addTag(tagFood);
        ahmet.addTag(tagDocker);
        ahmet.addTag(tagPhone);
        ahmet.addTag(tagCar);
        zeynep.addTag(tagPhone);
        zeynep.addTag(tagFood);
        zeynep.addTag(tagRestService);
        ayşe.addTag(tagDocker);
        mehmet.addTag(tagRestService);

        System.out.println("----------------------------------------");
        System.out.println("## Mete isimli kullancının Tag'leri");

        userService.findTagListByUser(mete).stream()
                .map(t -> t.getName())
                .forEach(System.out::println);

        System.out.println("----------------------------------------");
        System.out.println("## Zeynep isimli kullancının Tag'leri");


        userService.findTagListByUser(zeynep).stream()
                .map(t -> t.getName())
                .forEach(System.out::println);




    }
}
