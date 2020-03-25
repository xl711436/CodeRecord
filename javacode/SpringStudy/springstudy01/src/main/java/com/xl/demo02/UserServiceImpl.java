package com.xl.demo02;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("add 用户");
    }

    @Override
    public void delete() {
        System.out.println("delete 用户");
    }

    @Override
    public void update() {
        System.out.println("update 用户");
    }

    @Override
    public void query() {
        System.out.println("query 用户");
    }
}
