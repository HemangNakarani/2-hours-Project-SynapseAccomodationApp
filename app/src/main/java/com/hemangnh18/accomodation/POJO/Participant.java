package com.hemangnh18.accomodation.POJO;

public class Participant {

    String name;
    String email;
    String institute;
    String id;
    String phone;
    String days;
    String city;

    public Participant() {
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

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Participant(String name, String email, String institute, String id, String phone, String days, String city) {
        this.name = name;
        this.email = email;
        this.institute = institute;
        this.id = id;
        this.phone = phone;
        this.days = days;
        this.city = city;
    }




}
