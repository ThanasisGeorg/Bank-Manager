package main;

import Utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.DBMethods;
import Database.Database;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.Locale;
import javax.swing.UIManager;
import kdesp73.databridge.connections.DatabaseConnection;
import kdesp73.databridge.helpers.QueryBuilder;

/**
 *
 * @author thana
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
        ArrayList<Customer> customerList = new ArrayList<>();
//        DatabaseConnection db = Database.connection();
//        GraphicsEnvironment ge = GraphicsEnvironment
//                .getLocalGraphicsEnvironment();
//
//        Font[] allFonts = ge.getAllFonts();
//        String[] fonts = new String[allFonts.length];
//        for (int i = 0; i < allFonts.length; i++) {
//            fonts[i] = allFonts[i].getName();
//            System.out.println(fonts[i]);
//        }
//
//        for (int i = 1; i < fonts.length; i++) {
//            db.executeUpdate(new QueryBuilder().insertInto("Fonts_Unix").columns("No").values(i).build());
//        }
//        for (int i = 0; i < fonts.length; i++) {
//            db.executeUpdate(new QueryBuilder().update("Fonts_Unix").set("OS", "UNIX").build());
//        }
//        for (int i = 0; i < fonts.length; i++) {
//            db.executeUpdate(new QueryBuilder().update("Fonts_Unix").set("Font", fonts[i]).where("No = \"" + i + "\"").build());
//        }

        //DBMethods.formatDatabase();
        //Utils.prompt(customerList);
//        db.close();

        System.out.println(UIManager.getSystemLookAndFeelClassName());
        
    }
}
