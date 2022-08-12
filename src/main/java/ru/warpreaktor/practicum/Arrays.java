package ru.warpreaktor.practicum;

public class Arrays {

    public static int min(int[] ar) {
        if (ar.length < 1) return 0;

        int result = ar[0];
        for (int i : ar) {
            if (i < result) result = i;
        }
        return result;
    }
}
