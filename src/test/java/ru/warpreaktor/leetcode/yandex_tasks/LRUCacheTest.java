package ru.warpreaktor.leetcode.yandex_tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void integration1() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache is {1=1}
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.peek().getValue());
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.getSize());

        lruCache.put(2, 2); // cache is {2=2, 1=1}
        Assertions.assertEquals(2, lruCache.leastRecentlyUsed.peek().getValue());
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.peek().getPrevious().getValue());
        Assertions.assertEquals(2, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(1, lruCache.get(1));    // return 1
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.peek().getValue());
        Assertions.assertEquals(2, lruCache.leastRecentlyUsed.peek().getPrevious().getValue());
        Assertions.assertEquals(2, lruCache.leastRecentlyUsed.getSize());

        lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {3=3, 1=1,}
        Assertions.assertEquals(3, lruCache.leastRecentlyUsed.peek().getValue());
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.peek().getPrevious().getValue());
        Assertions.assertEquals(2, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(-1, lruCache.get(2));    // returns -1 (not found)

        lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        Assertions.assertEquals(4, lruCache.leastRecentlyUsed.peek().getValue());
        Assertions.assertEquals(3, lruCache.leastRecentlyUsed.peek().getPrevious().getValue());
        Assertions.assertEquals(2, lruCache.leastRecentlyUsed.getSize());

        lruCache.get(1);    // return -1 (not found)
        Assertions.assertEquals(-1, lruCache.get(1));    // returns -1 (not found)

        lruCache.get(3);    // return 3
        Assertions.assertEquals(3, lruCache.get(3));

        lruCache.get(4);    // return 4
        Assertions.assertEquals(4, lruCache.get(4));
    }

    @Test
    void integration2() {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1); // cache is {1=1}
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.peek().getValue());
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.getSize());

        lruCache.get(2);
        lruCache.put(3,2);
        lruCache.get(2);
        lruCache.get(3);

    }

    @Test
    void integration3() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.peek().getValue());
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.getSize());

        lruCache.put(1, 1);
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.peek().getValue());
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.peek().getPrevious().getValue());
        Assertions.assertEquals(2, lruCache.leastRecentlyUsed.getSize());

        lruCache.put(2,3);
        Assertions.assertEquals(3, lruCache.leastRecentlyUsed.peek().getValue());
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.peek().getPrevious().getValue());
        Assertions.assertEquals(2, lruCache.leastRecentlyUsed.getSize());

        lruCache.put(4,1);
        Assertions.assertEquals(1, lruCache.leastRecentlyUsed.peek().getValue());
        Assertions.assertEquals(3, lruCache.leastRecentlyUsed.peek().getPrevious().getValue());
        Assertions.assertEquals(2, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(-1, lruCache.get(1));
        Assertions.assertEquals(3, lruCache.get(2));

    }

    @Test
    void integration4() {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(10, 13);
        lruCache.put(3, 17);
        lruCache.put(6,11);
        lruCache.put(10,5);
        lruCache.put(9,10);
        Assertions.assertEquals(4, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(-1, lruCache.get(13));
        lruCache.put(2,19);
        Assertions.assertEquals(5, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(19, lruCache.get(2));
        Assertions.assertEquals(17, lruCache.get(3));
        lruCache.put(5,25);
        Assertions.assertEquals(6, lruCache.leastRecentlyUsed.getSize());
        Assertions.assertEquals(-1, lruCache.get(8));
        lruCache.put(9,22);
        Assertions.assertEquals(6, lruCache.leastRecentlyUsed.getSize());

        lruCache.put(5,5);
        Assertions.assertEquals(6, lruCache.leastRecentlyUsed.getSize());
        lruCache.put(1,30);
        Assertions.assertEquals(7, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(-1, lruCache.get(11));
        lruCache.put(9,12);
        Assertions.assertEquals(7, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(-1, lruCache.get(7));
        Assertions.assertEquals(5, lruCache.get(5));
        Assertions.assertEquals(-1, lruCache.get(8));
        Assertions.assertEquals(12, lruCache.get(9));
        lruCache.put(4,30);
        Assertions.assertEquals(8, lruCache.leastRecentlyUsed.getSize());
        lruCache.put(9,3);
        Assertions.assertEquals(8, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(3, lruCache.get(9));
        Assertions.assertEquals(5, lruCache.get(10));
        Assertions.assertEquals(5, lruCache.get(10));
        lruCache.put(6,14);
        lruCache.put(3,1);
        Assertions.assertEquals(8, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(1, lruCache.get(3));
        lruCache.put(10,11);
        Assertions.assertEquals(-1, lruCache.get(8));
        lruCache.put(2,14);
        Assertions.assertEquals(8, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(30, lruCache.get(1));
        Assertions.assertEquals(5, lruCache.get(5));
        Assertions.assertEquals(30, lruCache.get(4));
        lruCache.put(11,4);
        lruCache.put(12,24);
        Assertions.assertEquals(10, lruCache.leastRecentlyUsed.getSize());

        lruCache.put(5,18);
        Assertions.assertEquals(10, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(-1, lruCache.get(13));
        lruCache.put(7,23);
        Assertions.assertEquals(-1, lruCache.get(8));
        Assertions.assertEquals(24, lruCache.get(12));
        lruCache.put(3,27);
        lruCache.put(2,12);
        Assertions.assertEquals(18, lruCache.get(5));
        lruCache.put(2,9);
        lruCache.put(13,4);
        lruCache.put(8,18);
        lruCache.put(1,7);
        Assertions.assertEquals(-1, lruCache.get(6));
        lruCache.put(9,29);
        Assertions.assertEquals(10, lruCache.leastRecentlyUsed.getSize());

        lruCache.put(8,21);
        Assertions.assertEquals(10, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(18, lruCache.get(5));
        lruCache.put(6,30);
        lruCache.put(1,12);
        Assertions.assertEquals(10, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(-1, lruCache.get(10));
        lruCache.put(4,15);
        lruCache.put(7,22);
        lruCache.put(11,26);
        lruCache.put(8,17);
        lruCache.put(9,29);
        Assertions.assertEquals(10, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(18, lruCache.get(5));
        lruCache.put(3,4);
        lruCache.put(11,30);
        Assertions.assertEquals(10, lruCache.leastRecentlyUsed.getSize());

        Assertions.assertEquals(-1, lruCache.get(12));

        // [4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]

    }

}