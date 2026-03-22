package com.danp1t.case3.types;

public enum LightLevel {
    DARK("в темноте"),
    DIM("в сумерках"),
    BRIGHT("в светлый день");

    private final String displayName;

    LightLevel(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}