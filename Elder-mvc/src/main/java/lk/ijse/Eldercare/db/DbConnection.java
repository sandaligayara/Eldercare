package lk.ijse.Eldercare.db;

import java.sql.*;

public class DbConnection{
    private static DbConnection dbConnection;
    private static Connection connection;

    public DbConnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sss",
                "root",
                "Kavindu@1125"
        );
    }

    public static DbConnection getInstance() throws SQLException {
        return (null == dbConnection) ? dbConnection = new DbConnection() : dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }

    public static boolean setDetails(String sql) throws SQLException {
        connection = getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;
    }

    public static String[][] getDetails(String name, int columnCount) throws SQLException {
        connection = getInstance().getConnection();
        int rowsCount = checkRowsCount(name);
        String[][] details = new String[rowsCount][columnCount];

        String sql = "select * from "+name;

        Statement statement =  connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        int i = 0;
        while (resultSet.next()){
            for (int j = 0; j < columnCount; j++) {
                details[i][j] = resultSet.getString(j+1);
            }
            i++;
        }
        return details;
    }

    public static int checkRowsCount(String name) throws SQLException {
        connection = getInstance().getConnection();

        int rows = 0;

        String sql = "SELECT COUNT(*) FROM "+name;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) rows = resultSet.getInt(1);
        return rows;
    }
}