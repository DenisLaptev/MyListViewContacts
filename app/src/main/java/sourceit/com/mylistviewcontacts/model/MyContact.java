package sourceit.com.mylistviewcontacts.model;

import android.support.annotation.ColorInt;

import java.io.Serializable;

/**
 * Created by Lenovo on 08.05.2017.
 */

public class MyContact implements Serializable {

    private String name;
    private String email;
    private String address;
    private String phone;
    @ColorInt
    private int color;


    public MyContact(String name, String email, String address, String phone, int color) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}
