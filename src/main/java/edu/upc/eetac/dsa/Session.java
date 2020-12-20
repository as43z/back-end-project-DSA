package edu.upc.eetac.dsa;

import java.util.HashMap;
import java.util.List;

public interface Session<E> {
    void save(Object entity); //<-
    void close();   //<-
    Object get(Class c, String ID); //<-
    void update(Object o);
    void delete(Object o);
    List<Object> findAll(Class c); //<-
}
