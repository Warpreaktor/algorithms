package ru.warpreaktor.expirements;

import org.junit.jupiter.api.Test;

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
        Integer one = Integer.valueOf(1);
        Integer two = Integer.valueOf(2);
        Integer three = Integer.valueOf(3);

        priorityQueue.add(three);
        priorityQueue.add(two);
        priorityQueue.add(one);

        System.out.println(priorityQueue);
    }
}
