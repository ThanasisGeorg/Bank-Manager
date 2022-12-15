
package main;

import Utils.UserInput;
import Utils.Utils;
import java.io.IOException;
import java.sql.SQLException;

public class BankManager {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
        Customer c = new Customer();
        Utils.services(c);
    }
}
