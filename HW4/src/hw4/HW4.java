package hw4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class HW4 
{
   
    public static void main(String[] args) 
    {
        try 
        {
            String host = "jdbc:derby://localhost:1527/trickortreaters";
            String uName = "admin1";
            String uPass= "password";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String SQL = "SELECT * FROM people";
            ResultSet rs = stmt.executeQuery( SQL );
            
            HW4 app = new HW4();
        // insert three new rows
        app.insert("mary", "Weatherton", "cloud");
        app.insert("Bob", "Fisher", "skeleton");
        app.insert("Joe", "Shakk", "crab");
            
            rs.first();
            rs.previous();
            while (rs.next()) 
            {
                String firstname = rs.getString("Firstname");
                String lastname = rs.getString("Lastname");
                String costume = rs.getString("Costume");
                
                System.out.println( firstname + " " + lastname + " " + costume );
            }
        }
        catch ( SQLException err )
        {
            System.out.println( err.getMessage( ) );
        }
        
    }
    
    private Connection connect() 
    {
        // SQLite connection string
        String host = "jdbc:derby://localhost:1527/trickortreaters";
        String uName = "admin1";
        String uPass= "password";
        Connection conn = null;
        try 
        {
            conn = DriverManager.getConnection(host, uName, uPass);
        }
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void insert(String firstname, String lastname, String costume)
    {
        String sql = "INSERT INTO people(firstname,lastname,costume) VALUES(?,?,?)";
        try(Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            pstmt.setString(3, costume);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
