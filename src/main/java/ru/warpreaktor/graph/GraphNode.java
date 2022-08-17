package ru.warpreaktor.graph;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Нода - Вершина графа.
 *
 * @timeEntered - время входа в ноду во время обхода графа.
 * @timeExit - время выхода из ноды во время обхода графа.
 * За счет времени входа и выхода можно быстро определить является данная нода потомком или предком.
 * @entryCount - количество вхождений в ноду.
 * @isLooped - маркировка, является ли эта нода цикличной по отношению к графу зависимостей.
 */
public class GraphNode {
    private final String name;
    private LocalDateTime timeEntered;
    private LocalDateTime timeExited;
    private int entryCount = 0;
    private boolean isLooped = false;
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
        this.name = this.toString();

    }

    public GraphNode(String name, LinkedList<GraphNode> graphNodeList) {
        this.name = name;
        this.graphNodeList = graphNodeList;
    }

    public LinkedList<GraphNode> getGraphNodeList() {
        return graphNodeList;
    }

    public void setGraphNodeList(LinkedList<GraphNode> graphNodeList) {
        this.graphNodeList = graphNodeList;
    }

    public boolean add(GraphNode v) {
        return getGraphNodeList().add(v);
    }

    public boolean addAll(LinkedList<GraphNode> c) {
        return getGraphNodeList().addAll(c);
    }

    public boolean addFew(GraphNode... nodes) {
        for (GraphNode node : nodes) {
            getGraphNodeList().add(node);
        }
        return true;
    }

    public void remove(GraphNode v) {
        getGraphNodeList().remove();
    }

    public void remove(int index) {
        getGraphNodeList().remove(index);
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(LocalDateTime timeEntered) {
        this.timeEntered = timeEntered;
    }

    public LocalDateTime getTimeExited() {
        return timeExited;
    }

    public void setTimeExited(LocalDateTime timeExited) {
        this.timeExited = timeExited;
    }

    public int getEntryCount() {
        return entryCount;
    }

    public void setEntryCount(int entryCount) {
        this.entryCount = entryCount;
    }

    public synchronized void increment() {
        this.entryCount++;
    }

    public synchronized void decrement() {
        this.entryCount--;
    }

    public void reset() {
        setTimeEntered(null);
        setTimeExited(null);
        setEntryCount(0);
    }

    @Override
    public String toString() {
        return "{" + name + (isLooped == true ? " <LOOP> " : "") + "}";
    }

    public void print() {
        System.out.println(this + " - " + this.getGraphNodeList());
    }

    public boolean isLooped() {
        return isLooped;
    }

    public void setLooped(boolean looped) {
        isLooped = looped;
    }
}
