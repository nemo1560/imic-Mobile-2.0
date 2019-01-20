package com.example.hhh.imicmo2.Entities;

public class StatusUser {
    private static boolean aCheck;

    public StatusUser() {
    }

    public static boolean isaCheck() {
        return aCheck;
    }

    public static void setaCheck(boolean aCheck) {
        StatusUser.aCheck = aCheck;
    }
}
