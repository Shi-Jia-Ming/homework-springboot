package com.stark.homework.enums;

import lombok.Getter;

@Getter
public enum Job {
    HEAD_TEACHER(1, "班主任"), TEACHER(2, "讲师"), HEAD_OF_STUDENT(3, "学生主管"), HEAD_OF_TEACHER(4, "教研主管"), CONSULTANT(5, "咨询师") {
        public boolean isRest() {
            return true;
        }
    };

    private final int value;
    private final String description;

    Job(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public boolean isRest() {
        return false;
    }

    public static Job fromValue(int value) {
        for (Job job : Job.values()) {
            if (job.getValue() == value) {
                return job;
            }
        }
        throw new IllegalArgumentException("未知职位枚举值" + value);
    }
}
