package nus.iss.workshop13.model;

import java.io.Serializable;
import java.util.UUID;

public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String phoneNum;
    private String id;

    public Contact() {
        //this.id = this.generateId(8);
    }

    public Contact(String name, String email, String phoneNum) {
        this.id = this.generateId(8);
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
    }
    
    public Contact(String id, String name, String email, String phoneNum) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    private synchronized String generateId(int numchars) {
        String id = UUID.randomUUID().toString().substring(0,numchars);
        //System.out.println(id);
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
    
}
