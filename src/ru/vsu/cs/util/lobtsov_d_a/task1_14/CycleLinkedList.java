package ru.vsu.cs.util.lobtsov_d_a.task1_14;

import java.util.Arrays;
import java.util.List;

public class CycleLinkedList<T> extends DoubleLinkedList<T>{

    public static class Node<T> {
        public T val;
        public Node<T> next;

        public Node(T val) {
            this(val, null);
        }

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    public static Node<Integer> nextNode(Node<Integer> node) {
        if (node.next == null) {
            return node;
        }
        return node.next;
    }

    public static boolean hasCycle(Node<Integer> nodes) {
        Node<Integer> next = nextNode(nodes);
        Node<Integer> nextNext = nextNode(nextNode(nodes));
        while (next != nextNext && nextNext.next != null) {
            next = nextNode(next);
            nextNext = nextNode(nextNode(nextNext));
        }
        return nextNext.next != null;
    }
}
