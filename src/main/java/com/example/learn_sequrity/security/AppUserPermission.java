package com.example.learn_sequrity.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AppUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("cource:read"),
    COURSE_WRITE("cource:write");

    private final String permission;

}
