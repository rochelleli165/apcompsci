import java.sql.*;
public class App {
    public static void main(String[] args){
        try{
            Class.forName('com.mysql.cj.jdbc.Driver');
            Connection con-DriverManager.getConnection("jdbc:mysql://localhost:3306/world" )
            Statement stmt-con.createStatement();
            ResultSet rs-stmt.executeQuery("select * from names");
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
