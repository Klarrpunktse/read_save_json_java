package org.example;

public class User {
    private long id;
    private String username;

    // tom konstruktor och sätter sedan username och id med setter metod
    public User() {
    }

    // men går jättebra att göra så här också, se Main klassen där två users skapas
    public User(long id, String username) {
        this.id = id;
        this.username = username;
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
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
