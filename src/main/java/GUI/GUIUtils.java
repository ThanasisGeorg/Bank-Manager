package GUI;

import Utils.Utils;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.imgscalr.Scalr;

import main.*;

/**
 *
 * @author tgeorg
 */
public class GUIUtils {

    public static int checkLoginPassword(char[] password, ArrayList<Customer> customerList, int index) {
        int count = 0;

        if (password.length != customerList.get(index).getAcc().getPassword().length()) {
            return -1;
        }

        for (int i = 0; i < password.length; i++) {
            if (customerList.get(index).getAcc().getPassword().charAt(i) == password[i]) {
                count++;
            }
        }

        if (count == password.length) {
            return 1;
        }

        return -1;
    }

    public static int checkSignInPassword(char[] password, ArrayList<Customer> customerList, int index) {
        int count = 0;

        for (int i = 0; i < password.length; i++) {
            if (customerList.get(index).getAcc().getPassword().charAt(i) == password[i]) {
                count++;
            }
        }

        if (count == password.length) {
            return -1;
        }

        return 1;
    }

    public static String charArrayToString(char[] pw) {
        String password = "";

        for (int i = 0; i < pw.length; i++) {
            password = password + pw[i];
        }

        return password;
    }

    public static boolean checkSpecialChars(String stringToCheck) {
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(stringToCheck);
        boolean b = m.find();
        return b;
    }

    public static boolean checkChars(String stringToCheck) {
        Pattern p = Pattern.compile("[a-z]");
        Matcher m = p.matcher(stringToCheck);
        boolean b = m.find();
        return b;
    }

    public static boolean checkNums(String stringToCheck) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(stringToCheck);
        boolean b = m.find();
        return b;
    }
    
    public static boolean checkIfAllNums(String stringToCheck) {
        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = p.matcher(stringToCheck);
        boolean b = m.find();
        return b;
    }

    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        return Scalr.resize(originalImage, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, targetWidth, targetHeight,
                Scalr.OP_ANTIALIAS);
    }

    public static void changeFont(Component component, int fontSize, String font) {
        Font f = new Font(font, Font.PLAIN, 12);
        component.setFont(new Font(f.getName(), f.getStyle(), f.getSize() + fontSize));
        if (component instanceof Container container) {
            for (Component child : container.getComponents()) {
                changeFont(child, fontSize, font);
            }
        }
    }

    public static void changeGlobalFont(Component[] c, int size, String font) {
        for (Component c1 : c) {
            GUIUtils.changeFont(c1, size, font);
        }
    }

    public static Font[] getOsFonts() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        Font[] allFonts = ge.getAllFonts();

        return allFonts;
    }
}
