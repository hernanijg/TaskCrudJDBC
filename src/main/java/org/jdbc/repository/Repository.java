package org.jdbc.repository;

import java.util.List;

// CRUD SPECIFIC
public interface Repository<T> {
    List<T> show();
    T forId(Long id);
    void save(T t);
    void delete(Long id);
}
