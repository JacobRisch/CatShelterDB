
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author river
 */
public class catsDB {

    public static void main(String[] args) {
        final String QUERY = "select * from kitties";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/catshelter", "boca", "mucis");
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(
                        +rs.getInt("id") + ", "
                        + rs.getString("breed") + ", "
                        + rs.getString("name") + ", "
                        + rs.getInt("age"));
            }
        } catch (SQLException ex) {
            System.out.println("Retrieve SQLException: " + ex.getMessage());

        }
    }
}
