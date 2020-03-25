package com.xl.demo02;

public class UserServiceProxy implements UserService {



    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        System.out.println("add ");
        userService.add();
    }

    @Override
    public void delete() {
        System.out.println("delete ");
        userService.delete();
    }

    @Override
    public void update() {
        System.out.println("update ");
        userService.update();
    }

    @Override
    public void query() {
        System.out.println("query ");
        userService.query();
    }
}
