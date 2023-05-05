package org.example;

//import javax.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManager {

    private static EntityManagerFactory emf;

    private EntityManager() {
    }

    public static EntityManagerFactory getInstance() {//instanta persistence
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ExamplePU");
        }
        return emf;
    }
}
