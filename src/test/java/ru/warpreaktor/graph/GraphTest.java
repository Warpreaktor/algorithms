package ru.warpreaktor.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void differentSearch() {
        GraphNode gn1 = new GraphNode("gn1");
        GraphNode gn2 = new GraphNode("gn2");
        GraphNode gn3 = new GraphNode("gn3");
        LinkedList<GraphNode> assertion = new LinkedList<>();
        LinkedList<GraphNode> result;

        //Двунаправленный граф
        gn1.add(gn2);
        gn1.add(gn3);
        gn2.add(gn1);
        gn2.add(gn3);
        gn3.add(gn1);
        gn3.add(gn2);

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
        gn1.add(gn2);
        gn1.add(gn5);

        gn2.add(gn6);

        gn3.add(gn1);
        gn3.add(gn2);
        gn3.add(gn6);

        gn4.add(gn1);
        gn4.add(gn5);
        gn4.add(gn7);

        gn5.add(gn3);
        gn5.add(gn6);

        gn7.add(gn5);

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

        gn1.addFew(gn2, gn3);
        gn2.addFew(gn4);
        gn3.addFew(gn5);
        gn4.addFew(gn6, gn7);
        gn5.addFew(gn8);
        gn8.addFew(gn9, gn10);
        gn9.addFew(gn11);
        gn10.addFew(gn12);
        gn12.addFew(gn1);

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

        gn1.addFew(gn2, gn3);
        gn2.addFew(gn4);
        gn3.addFew(gn5);
        gn4.addFew(gn6, gn7);
        gn5.addFew(gn8);
        gn8.addFew(gn9, gn10);
        gn9.addFew(gn11);
        gn10.addFew(gn12);

        graph = Graph.buildFromRoot("G1", gn1);
        Assertions.assertEquals(false, Graph.findLoop(gn1));
        graph.print();
    }

}