package org.example;

import org.example.utility.SqlFileReaderUtility;

import java.nio.file.Path;

import java.sql.Connection;
import java.sql.Statement;

public class DatabasePopulateService {
    public void populateUsersTable() throws Exception {
        Path path= Path.of("sql/populate_db.sql");
        SqlFileReaderUtility sqlFileReaderUtility = new SqlFileReaderUtility();
        String sqlSript = sqlFileReaderUtility.convertSqlScriptToString(path);
        Connection connection=Database.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlSript);
        }
    }

    public static void main(String[] args) throws Exception {
        DatabasePopulateService databasePopulateService = new DatabasePopulateService();
        databasePopulateService.populateUsersTable();
    }
}
