package com.example.widgetapp;

public class Shortcut {
    private String name = "Shortcut Name";

    public Shortcut(int n) {
        this.name += String.valueOf(n);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
