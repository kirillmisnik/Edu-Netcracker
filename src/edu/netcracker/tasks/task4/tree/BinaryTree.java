package edu.netcracker.tasks.task4.tree;

/**
 * Реализация простого бинарного древа.
 */
public class BinaryTree {
    private Node root;

    /**
     * Добавляет элемент в бинарное древо.
     * @param node узел
     * @param value значение узла
     * @return узел
     */
    private Node add(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = add(node.left, value);
        } else if (value > node.value) {
            node.right = add(node.right, value);
        } else {
            return node;
        }
        return node;
    }

    /**
     * Добавляет элемент в бинарное древо.
     * @param value узел
     */
    public void add(int value) {
        root = add(root, value);
    }

    /**
     * Центрированный обход бинарного древа.
     * @param node узел
     */
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(" " + node.value);
            inOrder(node.right);
        }
    }

    /**
     * Центрированный обход бинарного древа.
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * Прямой обход бинарного древа.
     * @param node узел
     */
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * Прямой обход бинарного древа.
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * Обратный обход бинарного древа.
     * @param node узел
     */
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    /**
     * Обратный обход бинарного древа.
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * Размер бинарного древа.
     * @param node узел
     * @return размер древа
     */
    private int size(Node node) {
        if (node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));
    }

    /**
     * Размер бинарного древа.
     * @return размер древа
     */
    public int size() {
        return size(root);
    }
}
