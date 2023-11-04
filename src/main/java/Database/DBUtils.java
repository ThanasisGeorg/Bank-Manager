package Database;

import java.util.ArrayList;

import main.Customer;

public class DBUtils {

    public static String arrayToList(int[] arr) {
        String s = "";

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                s = s.concat("" + arr[i]);
            } else {
                s = s.concat(arr[i] + ", ");
            }
        }

        return s;
    }

    public static String arrayToList(String[] arr) {
        String s = "";

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                s = s.concat(arr[i]);
            } else {
                s = s.concat(arr[i] + ", ");
            }
        }

        return s;
    }

    public static String arrayToList(ArrayList<String> arr) {
        String s = "";

        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size() - 1) {
                s = s.concat("\"" + arr.get(i) + "\"");
            } else {
                s = s.concat("\"" + arr.get(i) + "\", ");
            }
        }

        return s;
    }

    public static String columnsToList(String[] arr) {
        String s = "";

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                s = s.concat(arr[i]);
            } else {
                s = s.concat(arr[i] + ", ");
            }
        }

        return s;
    }

    public static String customerToList(ArrayList<Customer> customerList, int index) {
        String[] customerInfo = customerList.get(index).getInfo();
        String s = "";

        for (int i = 0; i < customerInfo.length; i++) {
            if (customerInfo[i] == null) {
                if (i == customerInfo.length - 1) {
                    s = s.concat("\'" + customerInfo[i] + "\'");
                } else {
                    s = s.concat("\'" + customerInfo[i] + "\', ");
                }
            } else {
                if (i == customerInfo.length - 1) {
                    s = s.concat("\'" + customerInfo[i].replaceAll("\'", "\\\'") + "\'");
                } else {
                    s = s.concat("\'" + customerInfo[i].replaceAll("\'", "\\\'") + "\', ");
                }
            }
        }
        return s;
    }

    public static String accountToList(ArrayList<Customer> customerList, int index) {
        Object[] AccountInfo = customerList.get(index).getAcc().getAccInfo();
        String s = "";

        for (int i = 0; i < AccountInfo.length; i++) {
            if (AccountInfo[i] == null) {
                if (i == AccountInfo.length - 1) {
                    s = s.concat("\'" + AccountInfo[i] + "\'");
                } else {
                    s = s.concat("\'" + AccountInfo[i] + "\', ");
                }
            } else {
                if (i == AccountInfo.length - 1) {
                    s = s.concat("\'" + AccountInfo[i].toString().replaceAll("\'", "\\\'") + "\'");
                } else {
                    s = s.concat("\'" + AccountInfo[i].toString().replaceAll("\'", "\\\'") + "\', ");
                }
            }
        }
        return s;
    }

    public static boolean correctType(String type) {
        String[] types = {
            "bigint",
            "bit",
            "decimal",
            "int",
            "money",
            "numeric",
            "smallint",
            "smallmoney",
            "tinyint",
            "float",
            "real",
            "date",
            "datetime2",
            "datetimeoffset",
            "smalldatetime",
            "datetime",
            "time",
            "char",
            "varchar",
            "text",
            "nchar",
            "nvarchar",
            "ntext",
            "binary",
            "varbinary",
            "image",
            "cursor",
            "rowversion",
            "hierarchyid",
            "uniqueidentifier",
            "sql_variant",
            "xml",
            "Spatial Geometry Types",
            "Spatial Geography Types",
            "table"
        };

        for (int i = 0; i < types.length; i++) {
            if (type.equals(types[i])) {
                return true;
            }
        }
        return false;
    }

    public static String tableColsFormat(ArrayList<String> cols, ArrayList<String> types) {
        String s = "";
        for (int i = 0; i < cols.size(); i++) {
            if (i == cols.size() - 1) {
                s = s.concat(cols.get(i) + " " + types.get(i));
            } else {
                s = s.concat(cols.get(i) + " " + types.get(i) + ", ");
            }

        }
        return s;
    }
}
