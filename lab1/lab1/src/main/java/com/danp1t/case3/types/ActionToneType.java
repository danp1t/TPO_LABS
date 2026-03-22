package com.danp1t.case3.types;

public enum ActionToneType {
    AGGRESSIVE("агрессивно"),
    BENEVOLENT("доброжелательно"),
    NEUTRAL("нейтрально");

    private final String displayName;

    ActionToneType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
