package ru.warpreaktor.graph;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author Алексей Катачигов
 *
 * Обход в глубину - Different Search.
 * Путь:
 * 1. Простой путь - если от одной вершины до другой можно пройти по вершинам заходя в них лишь единожды.
 * 2. Сложный путь - если в пути вершины повторяются.
 * Две вершины находятся в одной компоненте связанности если от одной до другой можно дойти одним путём.
 *
 * Реализация алгоритма - https://www.youtube.com/watch?v=80icIrhJ6G0&t=696s&ab_channel=PavelMavrin
 */
public class DifferentSearch {

    /**
     * Дан граф {@link /main/resources/paint1.png}
     */
    public static LinkedList<GraphNode> differentSearch(GraphNode v){
        HashMap<GraphNode, Boolean> graph = new LinkedHashMap<>();
        LinkedList<GraphNode> way = new LinkedList<>();

        dfs(graph, way, v);

        return way;
    }

    private static void dfs(HashMap<GraphNode, Boolean> graph, LinkedList<GraphNode> way, GraphNode v){
        graph.put(v, true);
        way.addLast(v);

        for(GraphNode node : v.getGraphNodeList()){
            if(graph.get(node) == null || graph.get(node) == false) dfs(graph, way, node);
        }
    }
}
