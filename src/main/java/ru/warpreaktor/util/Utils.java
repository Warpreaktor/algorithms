package ru.warpreaktor.util;

public class Utils {

    public static int compareAndGetMin(int x, int y){
        return (x < y) ? x : ((x == y) ? x : y);
    }

    public static int compareAndGetMax(int x, int y){
        return (x < y) ? y : ((x == y) ? y : x);
    }

}
