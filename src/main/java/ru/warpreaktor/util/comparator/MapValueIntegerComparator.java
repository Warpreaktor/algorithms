package ru.warpreaktor.util.comparator;

import java.util.Comparator;
import java.util.Map;

public class MapValueIntegerComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Map.Entry<Integer, Integer> val1 = (Map.Entry) o1;
        Map.Entry<Integer, Integer> val2 = (Map.Entry) o2;
        if (val1.getValue() > val2.getValue()) {
            return -1;
        } else if (val1.getValue() == val2.getValue()) {
            return 0;
        } else {
            return 1;
        }
    }
}
