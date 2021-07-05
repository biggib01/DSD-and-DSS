import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class statement {
    statement(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root", "root", "Nope0970948728**");
            Statement st = con.createStatement();
            rs = st.executeQuery("select*from se212.statement");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getResultSet() {
          return rs;
    }

private ResultSet rs = null;
    
}
