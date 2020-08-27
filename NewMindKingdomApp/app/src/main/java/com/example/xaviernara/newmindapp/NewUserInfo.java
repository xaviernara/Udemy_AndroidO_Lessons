package com.example.xaviernara.newmindapp;

public class NewUserInfo {

    String fullName;
    String userId;
    String address;
    String phoneNumber;
    String email;
    String password;
    String selectedMinistry;
    String childrenName;


    public NewUserInfo() {
    }

    public NewUserInfo(String fullName, String address, String phoneNumber, String email, String password, String selectedMinistry, String childrenName) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.selectedMinistry = selectedMinistry;
        this.childrenName = childrenName;
    }

    public NewUserInfo(String userId,String fullName, String address, String email, String password,String phoneNumber) {
        this.userId = userId;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;

    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSelectedMinistry() {
        return selectedMinistry;
    }

    public String getChildrenName() {
        return childrenName;
    }
}
