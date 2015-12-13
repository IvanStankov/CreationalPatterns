package com.epam.jmp.service.database;

import org.h2.tools.Server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Ваня on 13.12.2015.
 */
public class DbManager {

    private static final DbManager DB_MANAGER = new DbManager();

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Server server;

    private DbManager() {
    }

    public void init() {
        try {
            server = Server.createTcpServer("-tcpAllowOthers").start();
            Class.forName("org.h2.Driver");

            entityManagerFactory = Persistence.createEntityManagerFactory("patterns");
            entityManager = entityManagerFactory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void destroy() {
        entityManager.close();
        entityManagerFactory.close();
        server.stop();
    }

    public static DbManager getInstance() {
        return DB_MANAGER;
    }

}
