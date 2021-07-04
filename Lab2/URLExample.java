package T2;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
public class URLExample
{  
  private static Vector<Iris> dataList = new Vector<>();

  public static void main(String[] args)  throws Exception
  {  
    URL url = new URL("https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data");
    InputStream inrul = url.openStream();
    Scanner in = new Scanner(inrul);
    
    while (in.hasNext()) {
      dataList.add(convertData(in.nextLine()));
    }

    StringBuilder builder = new StringBuilder();
    for (Iris value : dataList) {
        builder.append(value);
    }
    String text = builder.toString();

    System.out.println(text); 
    System.out.println("-============-");
    System.out.println("Count Row: " + countRow(dataList)); 
    System.out.println("-============-") ;
    countType(dataList); 

    //insertsql(dataList);
    
    in.close();
  }  

  public static void insertsql(Vector<Iris> Input) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/?user=root";
    String user = "root";
    String password = "Nope0970948728**";
    Connection myConn = null;
    Statement myStmt = null;

    try {
        myConn = DriverManager.getConnection(url, user, password);
        myStmt = myConn.createStatement();
        myStmt.executeUpdate("use se212_iris;");
        myStmt.executeUpdate("delete from iris_tbl;");
        for (int i = 0; i < Input.size(); i++) {

            String sql = "insert into iris_tbl " + " (s_length, s_width, p_length,p_width,f_type)" + " values ("
                    + ((Iris) Input.get(i)).getSl() + "," + ((Iris) Input.get(i)).getSw() + ","
                    + ((Iris) Input.get(i)).getPl() + "," + ((Iris) Input.get(i)).getPw() + ","
                    + "'" + ((Iris) Input.get(i)).getName() + "'" + ")";
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

  private static void countType(List<Iris> dataLisnamet){
    //dataList.add(0, new Iris(2.9, 2.8, 2.6, 2.6, ""));
    String[] name = new String[5];
    int[] count = new int[5];
    name[0] = dataList.get(0).getName();
    int at = 0;
    for(int i = 0 ; i<dataList.size();i++){
      //count++ in that name and keep go if name is same
      if((dataList.get(i).getName().equals(name[at]))){
        count[at]++;
        System.out.println("["+dataList.get(i).getName()+"] -"+i);
      //difference name go to next arrayName and arrayCount, add new name in next arrayName
      }else if(!dataList.get(i).getName().equals(name[at])){
        System.out.println("Total number of "+name[at]+": "+count[at]);
        at++;
        name[at] = dataList.get(i).getName();
        count[at]++;
        System.out.println("["+dataList.get(i).getName()+"] -"+i);
      }
    }
    System.out.println("Total number of "+name[at]+": "+count[at]);
  }

  //convert rawData to CleanData
  private static Iris convertData(String rawData) {
    String[] data = rawData.trim().split(",");
    return new Iris(Double.parseDouble(data[0]),Double.parseDouble(data[1]),Double.parseDouble(data[2]),
    Double.parseDouble(data[3]),(data[4]));
  }
  //simple count
  private static Integer countRow(List<Iris> dataList){
  
    return dataList.size();
  }
  //simple count but more line
  private static Integer countRoww(List<Iris> dataList){

    int count = 0;
    for(int i = 0; i < dataList.size(); i++){
      count++;
    }
    return count;
  }

}  