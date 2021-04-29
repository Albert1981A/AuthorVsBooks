package com.AlbertAbuav.AuthorVsBooks.utils;

public class TestUtils {

    private static int COUNT = 1;

    public static void testInfo(String content) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("                      TEST: #%d - %s%n", COUNT, content);
        System.out.println("-----------------------------------------------------------------------");
        COUNT++;
    }
}
