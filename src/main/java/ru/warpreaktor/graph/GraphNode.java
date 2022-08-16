package ru.warpreaktor.graph;

import java.util.LinkedList;

/**
 * Вершина графа
 */
public class GraphNode {
    private String name;
    private LinkedList<GraphNode> graphNodeList;

    public GraphNode() {
        graphNodeList = new LinkedList<>();
        this.name = this.toString();
    }

    public GraphNode(String name) {
        graphNodeList = new LinkedList<>();
        this.name = name;
    }

    public GraphNode(LinkedList<GraphNode> graphNodeList) {
        this.graphNodeList = graphNodeList;
    }

    public LinkedList<GraphNode> getGraphNodeList() {
        return graphNodeList;
    }

    public void setGraphNodeList(LinkedList<GraphNode> graphNodeList) {
        this.graphNodeList = graphNodeList;
    }

    public void add(GraphNode v){
        getGraphNodeList().add(v);
    }

    public void remove(GraphNode v){
        getGraphNodeList().remove();
    }

    public void remove(int index){
        getGraphNodeList().remove(index);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" + name + "}";
    }
}
