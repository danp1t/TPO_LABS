package com.danp1t.case3.entity;

public abstract class Entity {
    private String name;
    private Integer stressLevel;

    public Entity(String name) {
        this.name = name;
        this.stressLevel = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(Integer stressLevel) {
        this.stressLevel = stressLevel;
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
