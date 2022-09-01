package ru.warpreaktor.practicum;

import java.util.HashSet;

/**
 * Даны две строки строчных латинских символов: строка J и строка S.
 * Символы, входящие в строку J, — «драгоценности», входящие в строку S — «камни».
 * Нужно определить, какое количество символов из S одновременно являются «драгоценностями».
 * Проще говоря, нужно проверить, какое количество символов из S входит в J.
 */
public class LuxAndStones {

    /**
     * Символы в строках S и J никогда не повторяются. Строки всегда одной длинны.
     * O(n * m)
     */
    public static int luxAndStones(String j, String s){
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            for(int k = 0; k < j.length(); k++){
                if(s.charAt(i) == j.charAt(k)){
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Символы в строках S и J могут повторяться. Строки могут быть разной длинны.
     * Каждому символу из списка S может соответствовать лишь один символ из списка J
     * J = "afrr";
     * S = "aabc";
     * result = 1;
     * O(n * m)
     */
    public static int luxAndStones2(String j, String s){
        int result = 0;
        StringBuilder luxuries = new StringBuilder(j);
        for(int i = 0; i < s.length(); i++){
            for(int k = 0; k < luxuries.length(); k++){
                if(s.charAt(i) == luxuries.charAt(k)){
                    result++;
                    luxuries.deleteCharAt(k);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Символы в строкe J никогда не повторяются. Строки всегда одной длинны.
     * O(n + m)
     */
    public static int luxAndStones3(String j, String s){
        int result = 0;
        HashSet<Character> jSet = new HashSet();
        for(int i = 0; i < j.length(); i++){
            jSet.add(j.charAt(i));
        }
        for(int i = 0; i < s.length(); i++){
            if(jSet.contains(s.charAt(i))){
                result++;
            }
        }
        return result;
    }

    /**
     * Символы в строкe J никогда не повторяются. Строки могут быть разной длинны.
     * O(n + m)
     */
    public static int luxAndStones4(String j, String s){
        int result = 0;
        int[] charArr = new int[256];

        for(int i = 0; i < s.length(); i++){
            charArr[s.charAt(i)]++;
        }
        for(int i = 0; i < j.length(); i++){
           result+= charArr[j.charAt(i)];
        }
        return result;
    }
}
