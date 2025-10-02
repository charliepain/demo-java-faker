package org.example;

import java.util.HashMap;

public class UserController {
    private HashMap<String, User> emailUserMap;

    public UserController() {
        emailUserMap = new HashMap<>();
    }

    public void add(String name, String email, String password) {
        emailUserMap.put(email, new User(name, email, password));
    }

    public boolean connect(String email, String password) {
        User user = emailUserMap.get(email);
        return (user != null && password.equals(user.getPassword()));
    }
}
