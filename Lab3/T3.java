import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * T3
 */
public class T3 {

    private static Vector<JDBC> dataList = new Vector<>();

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        File file = new File("C:/Users/User/Desktop/Python test/T3/adult.data");
        Scanner in = new Scanner(file);

        statement dr = new statement();
        ResultSet rs = dr.getResultSet();
        int count = 0;
        while (rs.next()) {
            System.out.println(rs.getString(2)+", "+rs.getString(4)+", "+rs.getString(6)+", "+
            rs.getString(12)+", "+rs.getString(13)+", "+rs.getString(14));
            count++; //gets the first column's rows.
        }

        System.out.println("All row: "+count);

        /* while (in.hasNext()) {
            dataList.add(convertData(in.nextLine()));
        } */

        //insertsql(dataList);
        
    in.close();
    }

    public static void insertsql(Vector<JDBC> Input) throws SQLException {
        
        String url = "jdbc:mysql://localhost:3306/?user=root";
        String user = "root";
        String password = "UrPassWord";
        Connection myConn = null;
        Statement myStmt = null;
    
        try {
            myConn = DriverManager.getConnection(url, user, password);
            myStmt = myConn.createStatement();
            myStmt.executeUpdate("use se212;");
            for (int i = 0; i < Input.size(); i++) {
    
                String sql = "insert into statement " + " (age, workclass, fnlwgt, education, education_num, marital_status, occupation, relationship, race, sex, capital_gain, capital_loss, hours_per_week, native_country, income)" + " values ("+
                        ((JDBC)Input.get(i)).getAge()+","+"'"+((JDBC)Input.get(i)).getWorkClass()+"'"+","+((JDBC)Input.get(i)).getFnlwgt()+","+
                        "'"+((JDBC)Input.get(i)).getEducation()+"'"+","+((JDBC)Input.get(i)).getEducation_num()+","+"'"+((JDBC)Input.get(i)).getMarital_status()+"'"+","+
                        "'"+((JDBC)Input.get(i)).getOccupation()+"'"+","+"'"+((JDBC)Input.get(i)).getRelationShip()+"'"+","+"'"+((JDBC)Input.get(i)).getRace()+"'"+","+
                        "'"+((JDBC)Input.get(i)).getSex()+"'"+","+((JDBC)Input.get(i)).getCapital_gain()+","+((JDBC)Input.get(i)).getCapital_loss()+","+
                        ((JDBC)Input.get(i)).getHours_per_week()+","+"'"+((JDBC)Input.get(i)).getNative_country()+"'"+","+"'"+((JDBC)Input.get(i)).getIncome()+"'"+")";
                myStmt.executeUpdate(sql);
            }
            System.out.println("Insert complete.");
    
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myStmt != null) {
                myStmt.close();
            }
    
            if (myConn != null) {
                myConn.close();
            }
        }
    }

    private static JDBC convertData(String rawData) {
        String[] data = rawData.trim().split(", ");
        return new JDBC(Integer.parseInt(data[0]),(data[1]),Integer.parseInt(data[2]),
        (data[3]),Integer.parseInt(data[4]),(data[5]),(data[6]),(data[7]),(data[8]),
        (data[9]),Integer.parseInt(data[10]),Integer.parseInt(data[11]),
        Integer.parseInt(data[12]),(data[13]),(data[14]));
      }
}
