package ru.warpreaktor.expirements;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class Experiments {

    @Test
    public void primitives() {
        int i = 0;
        System.out.println(i++);
        i = 0;
        System.out.println(++i);
    }

    @Test
    public void priorityQueue(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;

        priorityQueue.add(three);
        priorityQueue.add(two);
        priorityQueue.add(one);

        System.out.println(priorityQueue);
    }

    @Test
    public void linkedListRemove() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.remove(0);
    }

    @Test
    public void hash() {
        String str = "Пост-алгоритмика";
        String str2 = "Хабрахабр -- торт! ЧЫМДШРС Пост-алгоритмика";
        String str3 = "A";
        HashMap<String, String> hs = new HashMap();
        hs.put(str, str);
        hs.put(str2, str2);
        System.out.println(hs.get("dgsdf"));
    }
}
