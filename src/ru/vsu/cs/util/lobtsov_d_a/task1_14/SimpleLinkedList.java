package ru.vsu.cs.util.lobtsov_d_a.task1_14;

public interface SimpleLinkedList<T> {
    public void add(T value);
    public void remove(int index);
    public void print();
    public int size();
    public T get(int index);

}