package org.example;

//import javax.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private static final String PERSISTENCE_UNIT_NAME = "myPersistenceUnit";
    private static EntityManagerFactory emf;

    private EntityManagerFactorySingleton() {
    }

    public static EntityManagerFactory getInstance() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf;
    }
}
