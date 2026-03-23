package com.danp1t.case3.entity;

public class Computer extends Entity {
    private final Boolean isKillerRobot;

    public Computer(String name, Boolean isKillerRobot) {
        super(name);
        this.isKillerRobot = isKillerRobot;

    }

    public Boolean getIsKillerRobot() {
        return this.isKillerRobot;
    }
}