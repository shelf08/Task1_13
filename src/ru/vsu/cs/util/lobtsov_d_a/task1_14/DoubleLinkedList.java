package ru.vsu.cs.util.lobtsov_d_a.task1_14;

import java.util.*;

public class DoubleLinkedList<T> {

    protected static class Node<T> {
        public T value;
        public Node<T> next = null;
        public Node<T> previous = null;

        public Node(T value) {
            this.value = value;
        }

        public Node(Node<T> previous, T value, Node<T> next) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    protected Node<T> root = null;
    protected Node<T> tail = null;
    protected int size = 0;

    public DoubleLinkedList() {

    }
    private T unlink(Node<T> node) {
        T element = node.value;
        Node<T> next = node.next;
        Node<T> prev = node.previous;
        if (prev == null) {
            this.root = next;
        } else {
            prev.next = next;
            node.previous = null;
        }

        if (next == null) {
            this.tail = prev;
        } else {
            next.previous = prev;
            node.next = null;
        }

        node.value = null;
        --size;
        return element;
    }

    private void linkBefore(T value, Node<T> node) {
        Node<T> prev = node.previous;
        Node<T> newNode = new Node(prev, value, node);
        node.previous = newNode;
        if (prev == null) {
            this.root = newNode;
        } else {
            prev.next = newNode;
        }

        ++size;
    }

    void linkLast(T value) {
        Node<T> l = tail;
        Node<T> newNode = new Node<T>(l, value, null);
        tail = newNode;
        if (l == null) {
            root = newNode;
        } else {
            l.next = newNode;
        }
        ++size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        if (root == null) return false;
        Node<T> current = root;
        while (current != null) {
            if (current.value.equals(o)) return true;
            current = current.next;
        }
        return false;
    }

    public Object[] toArray() {
        Object[] result = new Object[this.size];
        int i = 0;

        for (Node<T> x = this.root; x != null; x = x.next) {
            result[i++] = x.value;
        }

        return result;
    }

    public void add(T o) {
        size++;
        if (root == null) {
            root = new Node<T>(o);
            tail = root;
            return;
        }
        tail.next = new Node<T>(o);
        tail.next.previous = tail;
        tail = tail.next;
    }

    public boolean remove(T o) {
        if (root == null) return false;

        Node<T> curNode;
        if (o == null) {
            for (curNode = this.root; curNode != null; curNode = curNode.next) {
                if (curNode.value == null) {
                    unlink(curNode);
                    return true;
                }
            }
        } else {
            for (curNode = this.root; curNode != null; curNode = curNode.next) {
                if (curNode.value.equals(o)) {
                    unlink(curNode);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addAll(Collection<T> collection) {
        for (T o : collection) {
            add(o);
        }
        return true;
    }

    public void clear() {
        Node<T> next;
        for (Node<T> x = this.root; x != null; x = next) {
            next = x.next;
            x.value = null;
            x.next = null;
            x.previous = null;
        }
        root = null;
        tail = null;
        size = 0;
    }

    protected Node<T> getNode(int i) {
        if (i >= size || i < 0) throw new IndexOutOfBoundsException("Index Out Of Bounds");

        int i_ = i;
        Node<T> node;
        if (i_ < size / 2) {
            node = root;
            while (i_-- != 0) {
                node = node.next;
            }
        } else {
            node = tail;
            i_ = size - 1 - i_;
            while (i_-- != 0) {
                node = node.previous;
            }
        }
        return node;
    }

    public T get(int i) {
        return getNode(i).value;
    }


    public T set(int i, T o) {
        Node<T> node = getNode(i);
        T value = node.value;
        node.value = o;
        return value;
    }

    public void add(int i, T o) {
        Node<T> node = getNode(i);
        linkBefore(o, node);
    }

    public T remove(int i) {
        return unlink(getNode(i));
    }

    public int indexOf(T o) {
        int i;
        Node<T> node;
        for (i = 0, node = root; node != null; i++, node = node.next) {
            if (node.value == null && o == null) return i;
            if (node.value == null) continue;
            if (node.value.equals(o)) return i;
        }
        return -1;
    }

    public int lastIndexOf(T o) {
        int i;
        Node<T> node;
        for (i = size-1, node = tail; node != null; i--, node = node.previous) {
            if (node.value == null && o == null) return i;
            if (node.value == null) continue;
            if (node.value.equals(o)) return i;
        }
        return -1;
    }

}