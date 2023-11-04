package main;

/**
 *
 * @author thana
 */
public class Account {

    private String username;
    private String password;
    private String id;
    private String str = "0.0";
    private double balance = Double.parseDouble(str);
    private Object[] accInfo = new Object[4];

    public Account() {
    }

    public Account(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object[] getAccInfo() {
        accInfo[0] = id;
        accInfo[1] = username;
        accInfo[2] = password;
        accInfo[3] = balance;

        return accInfo;
    }

    public void setAccInfo(String[] info) {
        this.accInfo = info;
    }

    public void addAccInfo(String[] info) {
        setAccInfo(info);

        setId(info[0]);
        setUsername(info[1]);
        setPassword(info[2]);
        str = info[3];
        setBalance(balance = Double.parseDouble(str));    
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", id=" + id + ", balance=" + balance + '}';
    }
}
