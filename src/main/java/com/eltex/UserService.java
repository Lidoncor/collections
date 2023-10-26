package com.eltex;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users = new ArrayList<>();

    public void save(final User user) {
        if (user.id() == 0) {
            users.add(user);
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).id() == user.id()) {
                    users.set(i, user);
                    break;
                }
            }
        }
    }

    public void removeById(final long userId) {
        for (User user : users) {
            if (user.id() == userId) {
                users.remove(user);
                break;
            }
        }
    }

    public User getById(final long userId) {
        for (User user : users) {
            if (user.id() == userId) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAll() {
        return new ArrayList<>(users);
    }
}
