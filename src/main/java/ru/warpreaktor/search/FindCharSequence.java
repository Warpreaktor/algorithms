package ru.warpreaktor.search;

public class FindCharSequence {


    public static boolean findCharSequence(String s, String ref) {
        return false;
    }

        /**
         * Решение построено на том факте, что от перестановки слогаемых сумма не меняется и если представить буквы в виде
         * суммы их кодов, то казалось бы, что в сумме это должно быть то же слово, но к сожалению это не так, потому что
         * разные коды могут давать одну и ту же сумму, даже при том, что слов одинаковая длинна.
         * Например, последовательность символов "ac" и "bb" в сумме обе дадут 196, но на деле это разные слова.
         */
    public static boolean badFindCharSequence(String s, String ref) {
        if (s.length() < ref.length()) return false;
        int orSum = 0;
        int refSum = 0;
        int j = 0;
        int k = 0;

        for (int i = 0; i < ref.length(); i++) {
            refSum += ref.charAt(i);
        }
        while (j < s.length()){
            while (k < s.length() && k - j < ref.length()) {
                orSum += s.charAt(k);
                orSum -= s.charAt(k);
                if (orSum == refSum && k - j == ref.length() - 1) return true;
                k++;
            }
            orSum -= s.charAt(j);
            j++;
        }
        return false;
    }
}
