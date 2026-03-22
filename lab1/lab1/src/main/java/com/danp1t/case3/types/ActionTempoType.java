package com.danp1t.case3.types;

public enum ActionTempoType {
    FAST("быстро"),
    MEDIUM("в умеренном темпе"),
    SLOW("медленно");

    private final String displayName;

    ActionTempoType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}