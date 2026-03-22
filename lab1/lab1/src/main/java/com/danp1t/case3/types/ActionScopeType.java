package com.danp1t.case3.types;

public enum ActionScopeType {
    INTERNAL("про себя"), //Например, "Думать"
    EXTERNAL("в слух"); // Например, "Говорить"

    private final String displayName;

    ActionScopeType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
