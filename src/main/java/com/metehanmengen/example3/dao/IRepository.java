package src.main.java.com.metehanmengen.example3.dao;

public interface IRepository<T, Id> {
    void save (T entity);
    Iterable<T> findAll();

}
