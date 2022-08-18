package ru.warpreaktor.graph;

import java.time.LocalDateTime;
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
    private LinkedList<GraphNode> outgoingNodeList = new LinkedList<>();
    private LinkedList<GraphNode> incomingNodeList = new LinkedList<>();

    public GraphNode() {
        this.name = this.toString();
    }

    public GraphNode(String name) {
        this.name = name;
    }

    public GraphNode(LinkedList<GraphNode> outgoingNodeList) {
        this.name = this.toString();
        addAllOutgoing(outgoingNodeList);
    }

    public GraphNode(String name, LinkedList<GraphNode> outgoingNodeList) {
        this.name = name;
        addAllOutgoing(outgoingNodeList);
    }

    public LinkedList<GraphNode> getOutgoingNodeList() {
        return outgoingNodeList;
    }

    public LinkedList<GraphNode> getIncomingNodeList() {
        return incomingNodeList;
    }

    public boolean addOutgoing(GraphNode v) {
        this.getOutgoingNodeList().add(v);
        v.addIncoming(this);
        return true;
    }

    public boolean addAllOutgoing(LinkedList<GraphNode> c) {
        getOutgoingNodeList().addAll(c);
        for (GraphNode node : c) {
            node.addIncoming(this);
        }
        return true;
    }

    public boolean addFewOutgoing(GraphNode... nodes) {
        for (GraphNode node : nodes) {
            getOutgoingNodeList().add(node);
            node.addIncoming(this);
        }
        return true;
    }

    private boolean addIncoming(GraphNode v) {
        return getIncomingNodeList().add(v);
    }

    public void remove(GraphNode v) {
        getOutgoingNodeList().remove();
    }

    public void remove(int index) {
        getOutgoingNodeList().remove(index);
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
        System.out.println(this + " - " + this.getOutgoingNodeList());
    }

    public boolean isLooped() {
        return isLooped;
    }

    public void setLooped(boolean looped) {
        isLooped = looped;
    }
}
