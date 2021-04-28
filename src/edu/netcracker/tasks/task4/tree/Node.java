package edu.netcracker.tasks.task4.tree;

/**
 * Узел бинарного древа.
 */
public class Node {
    /**
     * Значение узла.
     */
    int value;
    /**
     * Узел-потомок слева.
     */
    Node left;
    /**
     * Узел-потомок справа.
     */
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
