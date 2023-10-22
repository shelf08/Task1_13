package ru.vsu.cs.util.lobtsov_d_a.task1_14;

public class CycleLinkedList<T> extends DoubleLinkedList<T>{
    @Override
    protected Node<T> getNode(int i) {
        int j = (Math.abs(i) % size + size) % size;
        return super.getNode(j);
    }
}