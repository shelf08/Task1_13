package ru.vsu.cs.util.lobtsov_d_a.task1_14;

public class LinkedList<T> implements SimpleLinkedList<T> {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    protected class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    @Override
    public void add(T value) {
        Node newNode = new Node(value);
        Node currentNode = head;

        if (head == null) {
            head = newNode;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        System.out.println("Был добавлен: " + newNode.data);

    }

    @Override
    public void remove(int index) {
        int curInd = 0;
        Node currentNode = head;
        Node prevNode = null;

        while (currentNode != null) {
            if (curInd == index) {
                if(currentNode == head) {
                    head = currentNode.next;
                } else{
                    prevNode.next = currentNode.next;
                }
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
            curInd++;

        }
        System.out.println("Был удалён элемент под индексом: " + index);


    }

    @Override
    public void print() {
        int curInd = 0;
        Node currentNode = head;

        if (head != null && this.size() > 1) {
            System.out.print("[" + head.data + ", ");
            curInd++;
            while (curInd != this.size() - 1) {
                curInd++;
                currentNode = currentNode.next;
                System.out.print(currentNode.data + ", ");
            }

        }
        if(size() == 1) {
            System.out.println("[" + head.data + "]");
            return;
        }

        if (curInd == this.size() - 1) {
            System.out.println(currentNode.next.data + "]");
        }
    }


    @Override
    public int size() {
        int size = 0;
        Node currentNode = head;
        if (head != null) {
            size++;
            while (currentNode.next != null) {
                size++;
                currentNode = currentNode.next;
            }
        }
        return size;
    }

    @Override
    public T get(int index) {
        if(index > this.size() - 1) {
            throw new IndexOutOfBoundsException("Индекс выше размера списка");
        }

        int curInd = 0;
        Node curNode = head;
        while (curNode != null){
            if(curInd == index) {
                System.out.println("Элемент списка, № индеса " + "'" + index + "'"+ " далее: " + curNode.data);
                return curNode.data;
            }
            curNode = curNode.next;
            curInd++;
        }
        return null;
    }
}