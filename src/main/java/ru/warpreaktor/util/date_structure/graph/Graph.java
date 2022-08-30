package ru.warpreaktor.util.date_structure.graph;

import ru.warpreaktor.util.CollectionUtils;

import java.util.LinkedList;

/**
 * Граф бывает двух типов:
 * 1. Однонаправленный - это когда ребра вершин идут строго в одном направлении.
 * 2. Двунаправленный - это когда ребра связывают два элемента в обе стороны.
 * <p>
 * Ребро - соединение двух элементов графа.
 * Рёбра бывают трёх типов:
 * 1. Из предка в потомка
 * 2. Из потомка в предта
 * 3. Из одной ветки в другую
 * <p>
 * Путь:
 * 1. Простой путь - если от одной вершины до другой можно пройти по вершинам заходя в них лишь единожды.
 * 2. Сложный путь - если в пути вершины повторяются.
 * Две вершины находятся в одной компоненте связанности если от одной до другой можно дойти одним путём.
 */
public class Graph {
    private String name;
    private LinkedList<GraphNode> nodeList;

    public Graph(String name) {
        this.name = name;
        this.nodeList = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<GraphNode> getNodeList() {
        return nodeList;
    }

    public void setNodeList(LinkedList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void clear() {
        getNodeList().clear();
    }

    public Graph reset() {
        if (getNodeList() == null) return this;
        for (GraphNode node : getNodeList()) {
            node.reset();
        }
        return this;
    }

    /**
     * Строит граф от ноды обходя его в глубину. Т.е. граф не построится от полностью если в качестве корневой
     * ноды в параметр передать потомка.
     */
    public static Graph buildFromRoot(String name, GraphNode v) {
        Graph graph = new Graph(name);
        graph.setNodeList(differentSearch(v));
        return graph.reset();
    }

    public GraphNode getHead() {
        return getNodeList().getFirst();
    }

    /**
     * Удаляет ноду из графа, а так же все ведущие к и из нёё ребра.
     * @param v - нода, которую необходимо удалить из графа.
     * @return - true при удачно завершившейся операции.
     */
    public boolean removeNode(GraphNode v){
        for(GraphNode node : v.getIncomingNodeList()){
            node.getOutgoingNodeList().remove(v);
        }
        for(GraphNode node : v.getOutgoingNodeList()){
            node.getIncomingNodeList().remove(v);
        }
        return getNodeList().remove(v);
    }

    /**
     * Обход в глубину - Different Search.
     * Реализация алгоритма - https://www.youtube.com/watch?v=80icIrhJ6G0&t=696s&ab_channel=PavelMavrin
     */
    public static LinkedList<GraphNode> differentSearch(GraphNode v) {
        LinkedList<GraphNode> nodeList = new LinkedList<>();
        dfs(nodeList, v);
        return nodeList;
    }

    private static void dfs(LinkedList<GraphNode> nodeList, GraphNode v) {
        v.setEntryCount(v.getEntryCount() + 1);
        nodeList.addLast(v);

        for (GraphNode node : v.getOutgoingNodeList()) {
            if (node.getEntryCount() == 0) dfs(nodeList, node);
        }
    }

    /**
     * Цикл в однонаправленном графе может образовать только ребро ведущее обратно (снизу-вверх) к предку.
     * Чтобы понять есть ли в графе цикл, достаточно найти только одно такое ребро.
     * Будем помечать каждую ноду в которую входим инкрементом поля entryCount. Таким образом:
     * Если entryCount = 0 - ноду еще не проходили.
     * Если entryCount = 1 - нода является родителем.
     * Если entryCount = 2 - нода является потомком.
     */
    public static boolean findLoop(GraphNode v) {
        return isCyclical(v);
    }

    public static boolean findLoop(Graph graph) {
        return isCyclical(graph.getHead());
    }

    private static boolean isCyclical(GraphNode v) {
        v.setEntryCount(1);

        for (GraphNode node : v.getOutgoingNodeList()) {
            if (node.getEntryCount() == 0) {
                if(isCyclical(node)) return true;
            }
            if (node.getEntryCount() == 1) {
                v.setLooped(true);
                return true;
            }
        }
        v.setEntryCount(2);
        return false;
    }

    /**
     * Топологическая сортировка.
     * https://www.youtube.com/watch?v=80icIrhJ6G0&t=696s&ab_channel=PavelMavrin
     *
     * Выстраивает граф слева на право.
     * Циклический граф невозможно отсортировать.
     * Если в графе нет цикла, значит в нём существует хотя бы одна вершина к которой не ведет ни одного ребра.
     */
    public static LinkedList<GraphNode> topologicalSort(GraphNode v) {
        LinkedList<GraphNode> topSort = new LinkedList<>();
        dfs(topSort, v);
        CollectionUtils.reverse(topSort);
        return topSort;
    }

    /**
     * Метод находит первую ноду на которую нет рёбер с других нод, т.е. ни одна нода от нее не зависит.
     * @return - если в графе есть хоть одна нода на которую не ссылается ни одна другая нода в графе,
     * то возвращает ее, если нет то в ответе будет null
     */
    public static GraphNode findParentNode(Graph graph){
        for(GraphNode node : graph.getNodeList()){
            if (node.getOutgoingNodeList().size() == 0){
                return node;
            }
        }
        return null;
    }

    /**
     * Поиск зависимостей.
     * Алгоритм взят - https://www.youtube.com/watch?v=80icIrhJ6G0&t=696s&ab_channel=PavelMavrin
     *
     * Метод находит все ноды в графе не имеющие зависимостей и возвращает их списком.
     * @return - Возвращает список всех нод на которые нет ссылок с других нод в графе,
     * либо пустой список если таких нод нет.
     *
     * Список нод выстраивается в порядке: от родительской ноды независящией ни от кого
     * до ноды которая максимально зависит от всех других.
     *
     * Утверждается: если поочередно находить в графе конечные ноды (ноды которые не имеют исходящих рёбер)
     * и удалять их из графа помещая в отдельный список, мы получим список наследований в порядке от самого
     * зависимого. Чтобы получить последовательность в порядке увеличения их зависимостей, достаточно просто перевернуть
     * список.
     */
    public static LinkedList<GraphNode> findTreeDependency(Graph graph, boolean isParentFirst){
        LinkedList<GraphNode> listDependencies = new LinkedList<>();
        ftd(graph, listDependencies);
        if (isParentFirst) {
            CollectionUtils.reverse(listDependencies);
        }
        return listDependencies;
    }
    private static void ftd(Graph graph, LinkedList<GraphNode> listDependencies){
        for(GraphNode node : graph.getNodeList()){
            if (node.getOutgoingNodeList().size() == 0){
                listDependencies.add(node);
                graph.removeNode(node);
                ftd(graph, listDependencies);
            }
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "name='" + name + '\'' +
                ", nodeList=" + nodeList +
                '}';
    }

    /**
     * Выводит в консоль граф в виде списка.
     */
    public void print() {
        System.out.println(name);
        for (GraphNode node : nodeList) {
            node.print();
        }
    }
}
