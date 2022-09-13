package ru.warpreaktor.leetcode.yandex_tasks;

import ru.warpreaktor.util.date_structure.cash.CacheQueue;

import java.util.HashMap;
import java.util.Map;

/**
 *  LRU Cache - https://leetcode.com/problems/lru-cache/
 - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 - int get(int key) Return the value of the key if the key exists, otherwise return -1.
 - void put(int key, int value) Update the value of the key if the key exists.
    Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {
    CacheQueue leastRecentlyUsed;
    Map<Integer, CacheQueue.Node<Integer>> map; // id против ноды из очереди.

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.leastRecentlyUsed = new CacheQueue(capacity);
    }

    /**
     * Размер кеша у нас строго ограничен, поэтому всегда предварительно проверяем текущий размер кеша,
     * если оно равно максимальному значению capacity, то вызываем метод pushOut() у CacheQueue, который вытолкнет самый
     * наименее используемый объект из очереди. При этом мапа и очередь рассогласуются, но на этом этапе это не
     * важно, мы снова сможем их синхронизировать во время get запроса.
     */
    public void put(int id, int value) {
        CacheQueue.Node<Integer> updateNode = map.get(id);
        if (updateNode != null && !updateNode.isDeleted()) {
            updateNode.setValue(value);
            leastRecentlyUsed.refreshCache(updateNode);
        } else {
            CacheQueue.Node newNode = leastRecentlyUsed.add(value);
            map.put(id, newNode);
        }
    }

    /**
     * Найдем в мапе нужный объект по индексу. Получив конкретную ноду, мы сможем за константу отдать значение хранящееся
     * в ней, несмотря на то, что сама нода хранится в очереди.
     * Если получилось так, что в мапе объект присутствует, а в очереди его нет, значит объект был вытолкнут из очереди
     * ранее и необходимо синхронизировать структуры удалив запрашиваемый объект из мапы.
     */
    public int get(int userId) {
        CacheQueue.Node node = map.get(userId);
        if (node != null && !node.isDeleted()) {
            leastRecentlyUsed.refreshCache(node);
            return (Integer)node.getValue();
        } else {
            map.remove(userId);
            return -1;
        }
    }


}
