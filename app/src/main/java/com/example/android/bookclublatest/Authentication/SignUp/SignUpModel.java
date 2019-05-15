package com.example.android.bookclublatest.Authentication.SignUp;

public class SignUpModel {
    String name,email,admissionnumber,phonenumber,Status;

    public SignUpModel(String name, String email, String admissionnumber, String phonenumber, String status) {
        this.name = name;
        this.email = email;
        this.admissionnumber = admissionnumber;
        this.phonenumber = phonenumber;
        Status = status;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
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

    public String getAdmissionnumber() {
        return admissionnumber;
    }

    public void setAdmissionnumber(String admissionnumber) {
        this.admissionnumber = admissionnumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}