//import database.ConnectionFactory;
import java.sql.*;

public class User {
    Connection connection = ConnectionFactory.getConnection();
    private String username = "";
    private int flag = 0;
    public boolean isValid(String username, String pswd) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select privelege from users where username = ? and password = ?");
        stmt.setString(1, username);
        stmt.setString(2, pswd);
        ResultSet rs = stmt.executeQuery();
        this.username = username;
        if (rs.next()) {
            int pvlg = rs.getInt(1);
            flag = 1;
            return true;
        } else {
            flag = 0;
            return false;
        }

    }

    public String getUsername() {
        if(flag == 1) {
            String username = this.username;
            return username;
        } else {
            return "";
        }
    }

    //= isValid(String username, String pswd);


}
