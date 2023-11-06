package Database;

import java.sql.*;
import java.util.ArrayList;

import kdesp73.databridge.connections.DatabaseConnection;
import kdesp73.databridge.helpers.QueryBuilder;
import main.Customer;

public class DBMethods {

    public static Statement s;
    private static final String[] CustomersFields = {
        "Account_ID",
        "Name_",
        "Surname_",
        "Age_"
    };

    private static final String[] AccountsFields = {
        "Account_ID",
        "Username_",
        "Password_",
        "Balance_"
    };

    private static final String[] ImagesFields = {
        "Account_ID",
        "Image_Path"
    };

    private static final String[] SettingsFields = {
        "OS",
        "Font",};

    public static String[] getCustomersFields() {
        return CustomersFields;
    }

    public static String[] getAccountsFields() {
        return AccountsFields;
    }

    public static void insertCustomer(ArrayList<Customer> customerList, int index) throws SQLException {
        DatabaseConnection db = Database.connection();
        String query = "INSERT INTO Customers(" + DBUtils.columnsToList(CustomersFields) + ") VALUES(" + DBUtils.customerToList(customerList, index) + ")";

        db.executeUpdate(query);
        db.close();
    }

    public static void insertCustomerAcc(ArrayList<Customer> customerList, int index) throws SQLException {
        DatabaseConnection db = Database.connection();
        String query = "INSERT INTO Accounts(" + DBUtils.columnsToList(AccountsFields) + ") VALUES(" + DBUtils.accountToList(customerList, index) + ")";

        db.executeUpdate(query);
        db.close();
    }

    public static void updateImg(ArrayList<Customer> customerList, int index, String imgDir) throws SQLException {
        DatabaseConnection db = Database.connection();

        db.executeUpdate(new QueryBuilder().update("Images").set("Img_Path", imgDir).where("Account_ID = \"" + customerList.get(index).getAcc().getId() + "\"").build());

        db.close();
    }

    public static String getImg(ArrayList<Customer> customerList, int index) throws SQLException {
        DatabaseConnection db = Database.connection();
        String dir;

        String query = new QueryBuilder().select("Img_Path").from("Images").where("Account_ID = \"" + customerList.get(index).getAcc().getId() + "\"").build();

        ResultSet rs = db.executeQuery(query);

        dir = rs.getString(1);

        db.close();

        return dir;
    }

    public static ArrayList<String[]> getCustomer() throws SQLException {
        DatabaseConnection db = Database.connection();
        ArrayList<String[]> list = new ArrayList<>();

        ResultSet rs = db.executeQuery(new QueryBuilder().select(CustomersFields).from("Customers").build());

        while (rs.next()) {
            String[] str = new String[CustomersFields.length];

            for (int i = 0; i < CustomersFields.length; i++) {
                str[i] = rs.getString(i + 1);
            }

            list.add(str);
        }

        db.close();
        return list;
    }

    public static ArrayList<String[]> getCustomerAcc() throws SQLException {
        DatabaseConnection db = Database.connection();
        ArrayList<String[]> list = new ArrayList<>();

        ResultSet rs = db.executeQuery(new QueryBuilder().select(AccountsFields).from("Accounts").build());

        while (rs.next()) {
            String[] str = new String[AccountsFields.length];

            for (int i = 0; i < AccountsFields.length; i++) {
                str[i] = rs.getString(i + 1);
            }

            list.add(str);
        }

        db.close();
        return list;
    }

    public static void updateCustomerAcc(ArrayList<Customer> customerList, int j) throws SQLException {
        DatabaseConnection db = Database.connection();

        db.executeUpdate(new QueryBuilder().update("Accounts").set("Username_", customerList.get(j).getAcc().getUsername()).where("Account_ID = \"" + customerList.get(j).getAcc().getId() + "\"").build());
        db.executeUpdate(new QueryBuilder().update("Accounts").set("Password_", customerList.get(j).getAcc().getPassword()).where("Account_ID = \"" + customerList.get(j).getAcc().getId() + "\"").build());
        db.executeUpdate(new QueryBuilder().update("Accounts").set("Balance_", customerList.get(j).getAcc().getBalance()).where("Account_ID = \"" + customerList.get(j).getAcc().getId() + "\"").build());

        db.close();
    }

    public static void insertFont(String os, String font) throws SQLException {
        DatabaseConnection db = Database.connection();
        String[] valuesToInsert = {os, font};

        db.executeUpdate(new QueryBuilder().insertInto("Settings").columns(SettingsFields).values((Object[]) valuesToInsert).build());

        db.close();
    }

    public static void updateLanguage(String language) throws SQLException {
        DatabaseConnection db = Database.connection();

        db.executeUpdate(new QueryBuilder().update("Settings").set("Language", language).where("No = \"" + 1 + "\"").build());

        db.close();
    }
    
    public static void updateTheme(String themeName) throws SQLException {
        DatabaseConnection db = Database.connection();

        db.executeUpdate(new QueryBuilder().update("Settings").set("Theme", themeName).where("No = \"" + 1 + "\"").build());

        db.close();
    }

    public static void deleteAccount(ArrayList<Customer> customerList, int j) throws SQLException {
        DatabaseConnection db = Database.connection();

        db.executeUpdate(new QueryBuilder().deleteFrom("Accounts").where("Account_ID = \"" + customerList.get(j).getAcc().getId() + "\"").build());

        db.close();
    }

    public static void deleteCustomer(ArrayList<Customer> customerList, int j) throws SQLException {
        DatabaseConnection db = Database.connection();

        db.executeUpdate(new QueryBuilder().deleteFrom("Customers").where("Name_ = \"" + customerList.get(j).getName() + "\"").build());

        db.close();
    }

    public static void formatDatabase() throws SQLException {
        DatabaseConnection db = Database.connection();
        db.executeUpdate("DELETE FROM Customers");
        db.executeUpdate("DELETE FROM Accounts");

        db.close();
    }
}
