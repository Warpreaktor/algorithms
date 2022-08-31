package ru.warpreaktor.leetcode;

import ru.warpreaktor.util.date_structure.cash.CashNode;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * LRU (least recently used) — это алгоритм, при котором вытесняются значения, которые дольше всего не запрашивались.
 * Соответственно, необходимо хранить время последнего запроса к значению.
 * И как только число закэшированных значений превосходит N необходимо вытеснить из кеша значение,
 * которое дольше всего не запрашивалось
 */
public class Lru {
    PriorityQueue<CashNode> cashTable;

//    public Integer calculateWithCache(int key) {
//        LocalDateTime curTime = LocalDateTime.now();
//        // Если значение уже было в кэше вернем его
//        if (cashTable.contains(key)) {
//            // Сначала обновим время последнего запроса к key
//            timeQueue.set(key, curTime);
//            return cashTable[key];
//        }
//
//        // Если в кэше уже N элементов, то вытесним самый старый
//        if (cashTable.length == N) {
//            minKey = timeQueue.extractMinValue();
//            cashTable.remove(minKey);
//        }
//
//        // Добавим в таблицу, и в очередь
//        cashTable.add(key, result);
//        timeQueue.add(key, curTime);
//
//        return result;
//    }
}
