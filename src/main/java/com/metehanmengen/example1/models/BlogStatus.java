package src.main.java.com.metehanmengen.example1.models;

public enum BlogStatus {
    DRAFT("Taslak"), PUBLISHED("Yayında"), REMOVED("Kaldırıldı");

    public final String name;

    BlogStatus(String name) {
        this.name = name;
    }
}
