package src.main.java.com.metehanmengen.example2.creational_design_patterns.singleton;

//Lazy Singleton Impementation

public class Singelton {
    private static Singelton instance;

    private Singelton() {
    }

    public static Singelton getInstance()
    {
        if (instance == null)
            instance = new Singelton();

        return instance;
    }
}
