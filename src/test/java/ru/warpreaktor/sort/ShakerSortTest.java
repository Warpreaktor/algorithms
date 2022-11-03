package ru.warpreaktor.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShakerSortTest {

    @Test
    void stupidShakerSort1() {
        int[] arr = new int[]{5,2,1,3,9,0,4,6,8,7};
        int[] result = new int[]{0,1,2,3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(result, ShakerSort.stupidShakerSort(arr));
    }

    @Test
    void smartShakerSort1() {
        int[] arr = new int[]{5,2,1,3,9,0,4,6,8,7};
        int[] result = new int[]{0,1,2,3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(result, ShakerSort.smartShakerSort(arr));
    }

    @Test
    void wikiShakerSort1() {
        int[] arr = new int[]{5,2,1,3,9,0,4,6,8,7};
        int[] result = new int[]{0,1,2,3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(result, ShakerSort.wikiShakerSort(arr));
    }

    //Наихудший случай
    @Test
    void stupidShakerSort2(){
        int[] arr = new int[]{9,8,7,6,5,4,3,2,1,0};
        int [] result = new int[]{0,1,2,3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(result, ShakerSort.stupidShakerSort(arr));
    }

    //Наихудший случай
    @Test
    void smartShakerSort2(){
        int[] arr = new int[]{9,8,7,6,5,4,3,2,1,0};
        int [] result = new int[]{0,1,2,3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(result, ShakerSort.smartShakerSort(arr));
    }

    //Наихудший случай
    @Test
    void wikiShakerSort2(){
        int[] arr = new int[]{9,8,7,6,5,4,3,2,1,0};
        int [] result = new int[]{0,1,2,3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(result, ShakerSort.wikiShakerSort(arr));
    }

    //Наилучший случай
    @Test
    void stupidShakerSort3() {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] result = new int[]{0,1,2,3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(result, ShakerSort.stupidShakerSort(arr));
    }

    @Test
    void smartShakerSort3() {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] result = new int[]{0,1,2,3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(result, ShakerSort.smartShakerSort(arr));
    }

    @Test
    void wikiShakerSort3() {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] result = new int[]{0,1,2,3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(result, ShakerSort.wikiShakerSort(arr));
    }

}