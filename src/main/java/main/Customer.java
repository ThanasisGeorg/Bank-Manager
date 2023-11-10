package main;

/**
 *
 * @author thana
 */
public class Customer {

    private String name;
    private String surname;
    private String age;
    private Account acc = new Account();
    private String[] info = new String[4];

    public Customer() {
    }

    public Customer(String name, String surname, String age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public String[] getInfo() {
        info[0] = getAcc().getId();
        info[1] = name;
        info[2] = surname;
        info[3] = age;

        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    public void addInfo(String[] info) {
        setInfo(info);

        setName(info[0]);
        setSurname(info[1]);
        setAge(info[2]);
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", surname=" + surname + ", age=" + age + '}';
    }
}
