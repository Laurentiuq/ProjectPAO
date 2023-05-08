package Persistence.Repos;
import Model.CropField;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
public interface GenericRepository<T> {
    T save(T entity) throws SQLException;

    List<T> findAll();

    Optional<T> findById(String id);

    void update(T entity);

    void delete(T entity);

}
