package dudv.vn.java_big_assignment.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class DBUtils {
    @FunctionalInterface
    public interface ExcuteQuery{
        Object excute(Connection connection);
    }
    private static String DB_URL = "jdbc:mysql://localhost:3306/java_big_assignment";
    private static String USER_NAME = "root";
    private static String PASSWORD = "Duongdu1";
    public static Object excuteSql(ExcuteQuery excuteQuery){
        Connection connection = null;
        Object result = null;
        try{
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connect Successfully");

        }
        catch(SQLException e){
            System.out.println("Connect Failure");
            e.printStackTrace();
        }
        finally {
            if(connection == null){
                return "null";
            }
            try{
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
