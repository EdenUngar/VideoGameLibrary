package com.company;

public class Game {

    private String title;
    private String type;
    private int idNumber;
    private String dueDate;

    //constructor
    public Game(String title, String type, int idNumber) {
        this.title = title;
        this.type = type;
        this.idNumber = idNumber;
        dueDate = "";
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }
    //genre will not change

    public int getIdNumber() {
        return idNumber;
    }
    //ID # will not change


    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
