package Shared.geass.dataPOJO;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String password;
    private String gender;
    private String phone;
    private String Email;
    private String address;

    public User() {
    }

    public User(String name, String password, String gender, String phone, String email, String address) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        Email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
