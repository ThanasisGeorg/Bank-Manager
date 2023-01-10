
package main;

import Utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class BankManager {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
        ArrayList<Customer> customerList = new ArrayList<>();
        
        Utils.main(customerList);
    }
}
