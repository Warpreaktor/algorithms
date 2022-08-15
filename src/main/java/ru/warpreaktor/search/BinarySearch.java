package ru.warpreaktor.search;

public class BinarySearch {

    private static Integer searchInteger(int[] arr, int find){
        if (arr.length / 2 == find){
            return arr.length / 2;
        }
        return null;
    }
}
