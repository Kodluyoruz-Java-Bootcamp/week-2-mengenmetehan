package src.main.java.com.metehanmengen.example7.dao;

public interface IRepository<T, Id> {
    void save (T entity);
    Iterable<T> findAll();

}
