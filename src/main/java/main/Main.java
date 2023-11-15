package main;

import Utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thana
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
        ArrayList<Customer> customerList = new ArrayList<>();
        // DBMethods.formatDatabase();
        
        Utils.prompt(customerList);
    }
}
