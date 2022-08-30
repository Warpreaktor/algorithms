package ru.warpreaktor.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.warpreaktor.util.date_structure.graph.Graph;
import ru.warpreaktor.util.date_structure.graph.GraphNode;

import java.util.LinkedList;

class GraphTest {

    @Test
    void differentSearch() {
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");
        GraphNode gn3 = new GraphNode("gn3");
        LinkedList<GraphNode> assertion = new LinkedList<>();
        LinkedList<GraphNode> result;

        //Двунаправленный граф
        gn1.addOutgoing(gn2);
        gn1.addOutgoing(gn3);
        gn2.addOutgoing(gn1);
        gn2.addOutgoing(gn3);
        gn3.addOutgoing(gn1);
        gn3.addOutgoing(gn2);

        assertion.addLast(gn1);
        assertion.addLast(gn2);
        assertion.addLast(gn3);

        result = Graph.differentSearch(gn1);
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
        LinkedList<GraphNode> result;

        //Двунаправленный граф
        gn1.addOutgoing(gn2);
        gn2.addOutgoing(gn3);
        gn2.addOutgoing(gn4);
        gn3.addOutgoing(gn2);
        gn3.addOutgoing(gn4);
        gn3.addOutgoing(gn5);
        gn4.addOutgoing(gn2);
        gn4.addOutgoing(gn3);
        gn4.addOutgoing(gn5);
        gn5.addOutgoing(gn3);
        gn5.addOutgoing(gn4);

        result = Graph.differentSearch(gn1);
        Assertions.assertEquals(5, result.size());
        System.out.println(result);
    }

    @Test
    void buildFromRoot() {
        Graph graph;
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");
        GraphNode gn3 = new GraphNode("gn3");
        GraphNode gn4 = new GraphNode("gn4");
        GraphNode gn5 = new GraphNode("gn5");
        GraphNode gn6 = new GraphNode("gn6");
        GraphNode gn7 = new GraphNode("gn7");

        //Однонаправленный граф {@link src/main/resources/paint2.png}
        gn1.addOutgoing(gn2);
        gn1.addOutgoing(gn5);

        gn2.addOutgoing(gn6);

        gn3.addOutgoing(gn1);
        gn3.addOutgoing(gn2);
        gn3.addOutgoing(gn6);

        gn4.addOutgoing(gn1);
        gn4.addOutgoing(gn5);
        gn4.addOutgoing(gn7);

        gn5.addOutgoing(gn3);
        gn5.addOutgoing(gn6);

        gn7.addOutgoing(gn5);

        graph = Graph.buildFromRoot("G1", gn1);
        Assertions.assertEquals(5, graph.getNodeList().size());
        graph.print();
    }

    /**
     * Example - {src/main/resources/graph_loop_01.png}
     */
    @Test
    void findLoop() {
        Graph graph;
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");
        GraphNode gn3 = new GraphNode("gn3");
        GraphNode gn4 = new GraphNode("gn4");
        GraphNode gn5 = new GraphNode("gn5");
        GraphNode gn6 = new GraphNode("gn6");
        GraphNode gn7 = new GraphNode("gn7");
        GraphNode gn8 = new GraphNode("gn8");
        GraphNode gn9 = new GraphNode("gn9");
        GraphNode gn10 = new GraphNode("gn10");
        GraphNode gn11 = new GraphNode("gn11");
        GraphNode gn12 = new GraphNode("gn12");

        //Циклический однонаправленный граф
        gn1.addFewOutgoing(gn2, gn3);
        gn2.addFewOutgoing(gn4);
        gn3.addFewOutgoing(gn5);
        gn4.addFewOutgoing(gn6, gn7);
        gn5.addFewOutgoing(gn8);
        gn8.addFewOutgoing(gn9, gn10);
        gn9.addFewOutgoing(gn11);
        gn10.addFewOutgoing(gn12);
        gn12.addFewOutgoing(gn1);

        graph = Graph.buildFromRoot("G1", gn1);
        Assertions.assertEquals(true, Graph.findLoop(gn1));
        graph.print();
    }

    @Test
    void findLoop2() {
        Graph graph;
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");
        GraphNode gn3 = new GraphNode("gn3");
        GraphNode gn4 = new GraphNode("gn4");
        GraphNode gn5 = new GraphNode("gn5");
        GraphNode gn6 = new GraphNode("gn6");
        GraphNode gn7 = new GraphNode("gn7");
        GraphNode gn8 = new GraphNode("gn8");
        GraphNode gn9 = new GraphNode("gn9");
        GraphNode gn10 = new GraphNode("gn10");
        GraphNode gn11 = new GraphNode("gn11");
        GraphNode gn12 = new GraphNode("gn12");

        //Не циклический однонаправленный граф
        gn1.addFewOutgoing(gn2, gn3);
        gn2.addFewOutgoing(gn4);
        gn3.addFewOutgoing(gn5);
        gn4.addFewOutgoing(gn6, gn7);
        gn5.addFewOutgoing(gn8);
        gn8.addFewOutgoing(gn9, gn10);
        gn9.addFewOutgoing(gn11);
        gn10.addFewOutgoing(gn12);

        graph = Graph.buildFromRoot("G1", gn1);
        Assertions.assertEquals(false, Graph.findLoop(gn1));
        graph.print();
    }

    @Test
    void findParentNode() {
        Graph graph;
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");
        GraphNode gn3 = new GraphNode("gn3");
        GraphNode gn4 = new GraphNode("gn4");
        GraphNode gn5 = new GraphNode("gn5");
        GraphNode gn6 = new GraphNode("gn6");
        GraphNode gn7 = new GraphNode("gn7");
        GraphNode gn8 = new GraphNode("gn8");
        GraphNode gn9 = new GraphNode("gn9");
        GraphNode gn10 = new GraphNode("gn10");
        GraphNode gn11 = new GraphNode("gn11");
        GraphNode gn12 = new GraphNode("gn12");

        //Не циклический однонаправленный граф
        gn1.addFewOutgoing(gn2, gn3);
        gn2.addFewOutgoing(gn4);
        gn3.addFewOutgoing(gn5);
        gn4.addFewOutgoing(gn6, gn7);
        gn5.addFewOutgoing(gn8);
        gn8.addFewOutgoing(gn9, gn10);
        gn9.addFewOutgoing(gn11);
        gn10.addFewOutgoing(gn12);

        graph = Graph.buildFromRoot("G1", gn1);
        Assertions.assertEquals(gn6, Graph.findParentNode(graph));
        graph.print();
    }

    @Test
    void findAllParentNode() {
        Graph graph;
        LinkedList<GraphNode> assertion = new LinkedList<>();
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");
        GraphNode gn3 = new GraphNode("gn3");
        GraphNode gn4 = new GraphNode("gn4");
        GraphNode gn5 = new GraphNode("gn5");
        GraphNode gn6 = new GraphNode("gn6");
        GraphNode gn7 = new GraphNode("gn7");
        GraphNode gn8 = new GraphNode("gn8");
        GraphNode gn9 = new GraphNode("gn9");
        GraphNode gn10 = new GraphNode("gn10");
        GraphNode gn11 = new GraphNode("gn11");
        GraphNode gn12 = new GraphNode("gn12");

        //Не циклический однонаправленный граф
        gn1.addFewOutgoing(gn2, gn3);
        gn2.addFewOutgoing(gn4);
        gn3.addFewOutgoing(gn5);
        gn4.addFewOutgoing(gn6, gn7);
        gn5.addFewOutgoing(gn8);
        gn8.addFewOutgoing(gn9, gn10);
        gn9.addFewOutgoing(gn11);
        gn10.addFewOutgoing(gn12);

        assertion.add(gn1);
        graph = Graph.buildFromRoot("G1", gn1);

        Assertions.assertEquals(gn6, Graph.findParentNode(graph));
        graph.print();
    }

    @Test
    void removeNode() {
        Graph graph;
        LinkedList<GraphNode> assertion = new LinkedList<>();
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");
        GraphNode gn3 = new GraphNode("gn3");
        GraphNode gn4 = new GraphNode("gn4");
        GraphNode gn5 = new GraphNode("gn5");
        GraphNode gn6 = new GraphNode("gn6");

        //Не циклический однонаправленный граф
        gn1.addFewOutgoing(gn3, gn5);
        gn2.addFewOutgoing(gn1, gn6);
        gn3.addFewOutgoing(gn5);
        gn4.addFewOutgoing(gn2, gn1, gn3);
        gn6.addFewOutgoing(gn5);

        assertion.add(gn1);
        graph = Graph.buildFromRoot("G1", gn4);

        LinkedList<GraphNode> listDependency = Graph.findTreeDependency(graph, true);
        Assertions.assertEquals(gn4, listDependency.get(0));
        Assertions.assertEquals(gn2, listDependency.get(1));
        Assertions.assertEquals(gn6, listDependency.get(2));
        Assertions.assertEquals(gn1, listDependency.get(3));
        Assertions.assertEquals(gn3, listDependency.get(4));
        Assertions.assertEquals(gn5, listDependency.get(5));
        System.out.println(listDependency);
    }
}