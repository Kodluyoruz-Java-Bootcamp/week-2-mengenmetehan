package src.main.java.com.metehanmengen.example3.model;

import java.time.LocalDateTime;

public class BuilderTest {
    public static void main(String [] args)
    {
        new BuilderPatternUser.Builder()
                .setName("Mete")
                .setMail("qweqwe@gmail.com")
                .setPassword("123123")
                .setType(UserType.CORPARETE)
                .setCreateDate(LocalDateTime.of(2022, 9, 5,5, 3))
                .build()
                .show();

    }
}
