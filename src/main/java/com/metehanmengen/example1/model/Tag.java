package src.main.java.com.metehanmengen.example1.model;

public class Tag {
    private final String name;
    private final String category;

    public Tag(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
