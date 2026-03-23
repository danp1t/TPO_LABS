package com.danp1t.case3.entity;

public class Person extends Entity {
    private final Integer age;
    private final Boolean isDrunk;

    public Person(String name, Integer age, Boolean isDrunk) {
        super(name);
        this.age = age;
        this.isDrunk = isDrunk;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getIsDrunk() {
        return isDrunk;
    }
}
