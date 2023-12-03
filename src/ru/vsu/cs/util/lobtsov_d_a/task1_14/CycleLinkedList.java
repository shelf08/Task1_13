package ru.vsu.cs.util.lobtsov_d_a.task1_14;

import java.util.*;

public class CycleLinkedList<T> extends DoubleLinkedList<T> {

    @Override
    protected Node<T> getNode(int i) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Лист пустой");
        } else if (size == 1) {
            return root;
        } else {
            if (i >= 0) {
                Node<T> current = root;
                for (int j = 0; j < i; j++) {
                    if (current.next != null) {
                        current = current.next;
                    } else {
                        current = root;
                    }
                }
                return current;
            } else {
                Node<T> current = tail;
                for (int j = -1; j > i; j--) {
                    if (current.previous != null) {
                        current = current.previous;
                    } else {
                        current = tail;
                    }
                }
                return current;
            }
        }
    }
}