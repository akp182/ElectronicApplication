package com.example.electronicapplication.Model;

public class ElectronicBooking {

    private String name;
    private String contact;
    private String location;

    private String problem;
    private String date;
    private String time;

    public ElectronicBooking(String name, String contact, String location, String problem, String date, String time) {
        this.name = name;
        this.contact = contact;
        this.location = location;
        this.problem = problem;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
