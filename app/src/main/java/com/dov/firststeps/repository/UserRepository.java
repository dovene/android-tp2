package com.dov.firststeps.repository;

import com.dov.firststeps.model.User;

import java.util.ArrayList;

public class UserRepository {

    private ArrayList<User> users = new ArrayList<>();


    private UserRepository(){ }
    private static UserRepository INSTANCE = null;

    public static synchronized UserRepository getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new UserRepository();
        }
        return INSTANCE;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
