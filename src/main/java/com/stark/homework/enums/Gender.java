package com.stark.homework.enums;


import lombok.Getter;

@Getter
public enum Gender {
    MALE(1, "男性"), FEMALE(2, "女性") {
        public boolean isRest() {
            return true;
        }
    };

    private final int value;
    private final String description;

    Gender(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public boolean isRest() {
        return false;
    }

    public static Gender fromValue(int value) {
        for (Gender gender : Gender.values()) {
            if (gender.getValue() == value) {
                return gender;
            }
        }
        throw new IllegalArgumentException("未知性别枚举值" + value);
    }
}
