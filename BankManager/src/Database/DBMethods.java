
package Database;

import Utils.UserInput;
import java.sql.*;
import java.util.ArrayList;
import main.Customer;

public class DBMethods {
 
    public static Statement s;
    private static String[] DBFields = {
            "Name",
            "Surname",
            "Username",
            "Password",
            "ID",
    };

    public static String[] getDBFields() {
            return DBFields;
    }
    
    public static void INSERT(Statement s, String Table, String Column, String Value) throws SQLException { //Inserts value to specific table and field
                s.executeUpdate("INSERT INTO " + Table + " (" + Column + ") VALUES (\'" + Value + "\')");
        }

    public static void INSERT(Statement s, String Table, String Column, int Value) throws SQLException { //Inserts value to specific table and field
            s.executeUpdate("INSERT INTO " + Table + "(" + Column + ") VALUES(" + Value + ")");
    }

    public static void INSERT(Statement s, String Table, String[] Columns, String[] Values) throws SQLException { //Inserts value to specific table and field
            s.executeUpdate("INSERT INTO " + Table + "(" + DBUtils.arrayToList(Columns) + ") VALUES(" + DBUtils.arrayToList(Values) + ")");
    }

    public static void INSERT(Statement s, String Table, String[] Columns, int[] Values) throws SQLException { //Inserts value to specific table and field
            s.executeUpdate("INSERT INTO " + Table + "(" + DBUtils.arrayToList(Columns) + ") VALUES(" + DBUtils.arrayToList(Values) + ")");
    }

    public static void INSERT(Statement s, String Table, String[] Columns, ArrayList<String> Values) throws SQLException { //Inserts value to specific table and field
            s.executeUpdate("INSERT INTO " + Table + "(" + DBUtils.arrayToList(Columns) + ") VALUES(" + DBUtils.arrayToList(Values) + ")");
    }
    
    public static int INSERT(Statement s, Customer c) throws SQLException { //Inserts customer to Database 
                //Check if customer already exists
                if (DBMethods.valueExists(s, "Customer", "ID", c.getAcc().getId())) {
                        System.out.println("Customer already exists");
                        return -1;
                }
                String query = "INSERT INTO Customer(" + DBUtils.arrayToList(DBFields) + ") VALUES(" + DBUtils.objectToList(c) + ")";
                //String query = "INSERT INTO Movies(" + DBUtils.arrayToList(DBFields) + ") VALUES(" + "\'"+m.getTitle()+ "\', \'"+m.getYear()+ "\', \'"+m.getRated()+ "\', \'"+m.getReleased()+ "\', \'"+m.getRuntime()+ "\', \'"+m.getDirector()+ "\', \'"+m.getWriter()+ "\', \'"+m.getActors()+ "\', \'"+m.getPlot()+ "\', \'"+m.getLanguage()+ "\', \'"+m.getCountry()+ "\', \'"+m.getAwards()+ "\', \'"+m.getPoster()+ "\', \'"+m.getType()+ "\', \'"+m.getImdbRating()+ "\', \'"+m.getImdbID() + "\')";

                System.out.println(query);
                s.executeUpdate(query);
                System.out.println("Customer Added");
                return 0;
        }
    
    /*===========================================================*/

    public static int DELETE(Statement s, String Table, String Column, char[] Value) throws SQLException { //Deletes record
            if (!valueExists(s, Table, Column, Value)) {
                    System.out.println("Record doesn't exist");
                    return -1;
            }

            String query = "DELETE FROM " + Table + " WHERE " + Column + " = \"" + Value + "\"";

            s.executeUpdate(query);
            System.out.println("Record deleted");
            return 0;
    }

    public static int DELETE(Statement s, String Table) throws SQLException { //Clears Table
            String query = "DELETE FROM " + Table;
            s.executeUpdate(query);

            System.out.println("Table Cleared");
            return 0;
    }

    /*===========================================================*/

    public static ArrayList<String> SELECT(Statement s, String Table, String Column, String Value) throws SQLException {
            ArrayList<String> list = new ArrayList<>();

            String query = "SELECT " + Value + " FROM " + Table + " WHERE " + Column + "= \"" + Value + "\"";
            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {

                    list.add(rs.getString(1));

            }

            return list;
    }

    public static ArrayList<String> SELECT(Statement s, String Table, String Column) throws SQLException {
            ArrayList<String> list = new ArrayList<>();

            String query = "SELECT " + Column + " FROM " + Table;
            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {

                    list.add(rs.getString(1));

            }

            return list;
    }

    public static ArrayList<String[]> SELECT(Statement s, String Table, String[] Columns) throws SQLException {
            ArrayList<String[]> list = new ArrayList<>();

            String query = "SELECT " + DBUtils.arrayToList(Columns) + " FROM " + Table;
            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                    String[] str = new String[Columns.length];

                    for (int i = 0; i < Columns.length; i++) {
                            str[i] = rs.getString(i+1);
                    }

                    list.add(str);
            }

            return list;
    }

    /*===========================================================*/

    public static boolean valueExists(Statement s, String table, String column, char[] value) throws SQLException {
            String query = "SELECT " + column + " FROM " + table + " WHERE " + column + "=\'" + value + "\'";

            ResultSet rs = s.executeQuery(query);
            if (rs.next()) {
                    return true;
            }

            return (false);
    }
    /*===========================================================*/

    public static int numOfRecords(Statement s, String Table) throws SQLException {
            ResultSet rs = s.executeQuery("SELECT COUNT(*)  FROM " + Table);

            rs.next();
            return rs.getInt(1);
    }

    public static int numOfRecords(Statement s, String Table, String Column) throws SQLException {
            ResultSet rs = s.executeQuery("SELECT COUNT( " + Column + ")  FROM " + Table);

            rs.next();
            return rs.getInt(1);
    }

    /*===========================================================*/

    public static void CREATE(Statement s, String name) throws SQLException { //Create table
            ArrayList<String> colNames = new ArrayList<>();
            ArrayList<String> dataTypes = new ArrayList<>();

            String again;
            int i = 1;
            do {
                    System.out.print("Column" + i + " name: ");
                    colNames.add(UserInput.getString());
                    String type;
                    do {
                            System.out.print("DataType" + i + ": ");
                            type = UserInput.getString();
                    } while (!DBUtils.correctType(type));
                    dataTypes.add(type);
                    i++;

                    System.out.print("Add another (y/n): ");
                    again = UserInput.getString();
            } while (again.equals("y"));

            String query = "CREATE TABLE " + name + " (" + DBUtils.tableColsFormat(colNames, dataTypes) + ")";
            s.executeUpdate(query);
            System.out.println("Table " + name + " created");
    }

    public static void CREATE(Statement s, String Table, String Column, String type) throws SQLException { //Create column in table
            if(!DBUtils.correctType(type)){
                    System.out.println("Incorrect data type");
                    return;
            }

            String query = "ALTER TABLE " + Table + " ADD " + Column + " " + type;
            System.out.println(query);
            s.executeUpdate(query);
            System.out.println("Column Added");
    }

}
