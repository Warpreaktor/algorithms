package ru.warpreaktor.util.fabric;

import ru.warpreaktor.util.comparator.MapValueIntegerComparator;

import java.util.Comparator;

public class MapComparatorFabric extends ComparatorFabric{

    @Override
    public Comparator createComparator() {
        return new MapValueIntegerComparator();
    }
}
