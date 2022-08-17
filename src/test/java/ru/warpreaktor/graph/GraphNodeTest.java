package ru.warpreaktor.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphNodeTest {

    @Test
    void addOutgoing() {
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");

        gn1.addOutgoing(gn2);

        Assertions.assertEquals(gn1, gn2.getIncomingNodeList().getFirst());
        gn1.print();

    }

    @Test
    void addAllOutgoing() {
    }

    @Test
    void addFewOutgoing() {
    }
}