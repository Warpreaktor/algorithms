package ru.warpreaktor.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.warpreaktor.util.date_structure.graph.GraphNode;

import java.util.LinkedList;

class GraphLinkedNodeTest {

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
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");
        GraphNode gn3 = new GraphNode("gn3");
        LinkedList list = new LinkedList<>();
        list.add(gn2);
        list.add(gn3);
        gn1.addAllOutgoing(list);

        Assertions.assertEquals(gn1, gn2.getIncomingNodeList().getFirst());
        Assertions.assertEquals(gn1, gn3.getIncomingNodeList().getFirst());
    }

    @Test
    void addFewOutgoing() {
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");
        GraphNode gn3 = new GraphNode("gn3");
        gn1.addFewOutgoing(gn2, gn3);

        Assertions.assertEquals(gn1, gn2.getIncomingNodeList().getFirst());
        Assertions.assertEquals(gn1, gn3.getIncomingNodeList().getFirst());
    }
}