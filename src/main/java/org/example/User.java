package org.example;

import java.util.HashMap;
import java.util.Map;

public class User {
    private Subject subject;
    private long id;
    private String username;

    private Map<String, Income> incomeList;

    // tom konstruktor och sätter sedan username och id med setter metod
    public User() {
    }

    // men går jättebra att göra så här också, se Main klassen där två users skapas

    public User(long id, String username) {
        this.id = id;
        this.username = username;
    }


    public User(long id, String username, String inputSubject) {
        this.id = id;
        this.username = username;
        incomeList = new HashMap<>();

        switch (inputSubject) {
            case "Java":
                this.subject = Subject.JAVA;
                break;
            case "JavaScript":
                this.subject = Subject.JAVASCRIPT;
                break;
            case "Python":
                this.subject = Subject.PYTHON;
                break;
            default:
                this.subject = Subject.SUBJECT;
                break;
        }
    }



   public void setSubject(String subject) {
        switch(subject) {
            case "Java":
                this.subject = Subject.JAVA;
                break;
            case "JavaScript":
                this.subject = Subject.JAVASCRIPT;
                break;
            case "Python":
                this.subject = Subject.PYTHON;
                break;
            default:
                this.subject = Subject.SUBJECT;
                break;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "subject=" + subject +
                ", id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    public void addIncome(Income income) {
        incomeList.put(income.getId(), income);
    }


  /*  @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }*/
}
