/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.core;

import com.core.util.FileResourcesUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/**
 *
 * @author MARLON FIGUEROA
 */
public class ConnectDB {
   private static final String PROPERTIES_FILE = "application.properties";

    private static final String URL;
    private static final String USER;
    private static final String PASS;
    private static final String DRIVER;

    private static final int MAX_POOL;
    private static final List<Connection> CONNECTIONS_POOLS;

    static {
        Properties properties = loadProperties();
        URL = properties.getProperty("database.url");
        USER = properties.getProperty("database.user");
        PASS = properties.getProperty("database.password");
        DRIVER = properties.getProperty("database.driver");
        MAX_POOL = Integer.parseInt(properties.getProperty("database.maxpool"));
        CONNECTIONS_POOLS = new ArrayList<>(MAX_POOL);
    }

    @SuppressWarnings("unused")
	private static Properties loadProperties() {
        Properties properties = new Properties();
        FileResourcesUtils resourcesUtils = new FileResourcesUtils();
        try (FileInputStream inputStream = new FileInputStream(resourcesUtils.getFileFromResource(PROPERTIES_FILE))) {
            if (inputStream != null) {
                resourcesUtils.printFile(resourcesUtils.getFileFromResource(PROPERTIES_FILE));
                properties.load(inputStream);
            } else {
                throw new IOException("application.properties not found");
            }
        } catch (Exception e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException("Error loading properties file", e);
        }
        return properties;
    }

    private static void registerDriver(String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private static Connection createConnection() throws SQLException {
        registerDriver(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    }

    private static void initializeConnectionPool() {
        for (int i = 0; i < MAX_POOL; i++) {
            try {
                CONNECTIONS_POOLS.add(createConnection());
            } catch (SQLException e) {
                throw new RuntimeException("Error creating connection", e);
            }
        }
    }

    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (connection) {
                CONNECTIONS_POOLS.add(connection);
            }
        }
    }

    public static Connection getConnection() {
        synchronized (CONNECTIONS_POOLS) {
            if (CONNECTIONS_POOLS.isEmpty()) {
                initializeConnectionPool();
            }
        }
        return CONNECTIONS_POOLS.remove(CONNECTIONS_POOLS.size() - 1);
    }

}
