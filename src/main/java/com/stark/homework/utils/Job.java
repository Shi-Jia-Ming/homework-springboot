package com.stark.homework.utils;

public enum Job {
    HEAD_TEACHER(1), TEACHER(2), HEAD_OF_STUDENT(3), HEAD_OF_TEACHER(4), CONSULTANT(5) {
        public boolean isRest() {
            return true;
        }
    };

    private int value;

    Job(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isRest() {
        return false;
    }
}
