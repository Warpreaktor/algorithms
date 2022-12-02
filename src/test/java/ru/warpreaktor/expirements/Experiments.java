package ru.warpreaktor.expirements;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
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
}
