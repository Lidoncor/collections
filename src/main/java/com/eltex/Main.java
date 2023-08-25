package com.eltex;

public class Main {
    public static void main(final String[] args) {
        try {
            crash();
        } catch (final ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("В любом случае выполнится");
        }

        System.out.println("А до этой дойдёт");
    }

    private static void crash() throws ArithmeticException {
        final var result = 1 / 1;

        System.out.println("До этой строчки теперь дойдёт");
    }
}
