package com.danp1t.case3.entity;

public abstract class Entity {
    private final String name;
    private Integer stressLevel;

    public Entity(String name) {
        this.name = name;
        this.stressLevel = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getStressLevel() {
        return stressLevel;
    }

    public void incrementStressLevel(int amount) {
        if (amount > 0) {
            this.stressLevel += amount;
        }
    }

    public void decrementStressLevel(int amount) {
        if (amount > 0) {
            this.stressLevel -= amount;
        }
    }
}
