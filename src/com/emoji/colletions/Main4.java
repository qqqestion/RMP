package com.emoji.colletions;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class Main4 {
    public static void main(String[] args) {
        Map<User, Integer> score = new HashMap<>(Map.of(
                new User("Abby"), 1, new User("Bob"), 0,
                new User("Andy"), 3, new User("Abberton"), 2
        ));
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println(score.get(new User(name)));
    }
}
