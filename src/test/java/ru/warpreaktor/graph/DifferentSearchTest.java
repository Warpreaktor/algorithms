package ru.warpreaktor.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DifferentSearchTest {

    @Test
    void differentSearch() {
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");
        GraphNode gn3 = new GraphNode("gn3");
        LinkedList<GraphNode> assertion = new LinkedList<>();
        LinkedList<GraphNode> result;

        gn1.add(gn2);
        gn1.add(gn3);
        gn2.add(gn1);
        gn2.add(gn3);
        gn3.add(gn1);
        gn3.add(gn2);

        assertion.addLast(gn1);
        assertion.addLast(gn2);
        assertion.addLast(gn3);

        result = DifferentSearch.differentSearch(gn1);
        Assertions.assertEquals(3, result.size());
        System.out.println(result);



    }
    @Test
    void differentSearch2(){
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");
        GraphNode gn3 = new GraphNode("gn3");
        GraphNode gn4 = new GraphNode("gn4");
        GraphNode gn5 = new GraphNode("gn5");
        LinkedList<GraphNode> assertion = new LinkedList<>();
        LinkedList<GraphNode> result;

        gn1.add(gn2);
        gn2.add(gn3);
        gn2.add(gn4);
        gn3.add(gn2);
        gn3.add(gn4);
        gn3.add(gn5);
        gn4.add(gn2);
        gn4.add(gn3);
        gn4.add(gn5);
        gn5.add(gn3);
        gn5.add(gn4);

        result = DifferentSearch.differentSearch(gn1);
//        Assertions.assertEquals(4, result.size());
        System.out.println(result);
    }
}