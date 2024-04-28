package com.stark.homework.utils;

public enum Gender {
    MALE(1), FEMAILE(2) {
        public boolean isRest() {
            return true;
        }
    };

    private int value;

    private Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isRest() {
        return false;
    }
}
