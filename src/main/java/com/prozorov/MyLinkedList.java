package com.prozorov;


public class MyLinkedList <T extends Comparable>{
    private Integer size = 0;
    private Node <T> first = null;

    private Node <T> last = null;

    public boolean isLinkedListSorted = false;


    public MyLinkedList() {}


    public void add(T value) {
        Node<T> link;
        if (first == null) {
            link = new Node<>(null, value, null);
            first = link;
        } else {
            link = new Node<>(last, value, null);
            last.next = link;
        }
        last = link;
        size++;
        if (isLinkedListSorted) {
            isLinkedListSorted = false;
        }
    }


    public void addAll(MyLinkedList<T> listForAdd) {
        Node node = listForAdd.first;
        for (int i = 0; i < listForAdd.size; i++) {
            this.add((T)node.item);
            node = node.next;
        }
        if (isLinkedListSorted) {
            isLinkedListSorted = false;
        }
    }


    public void remove (Integer index) {
        Node node = first;
        for (int i=0; i < size; i++) {
            if (size == 0 || index >= size) {
                throw new NullPointerException();
            } else if (size == 1 && index == 0) {
                first = null;
                last = null;
                size = 0;
            } else if (i < index) {
                node = node.next;
            } else if (index == 0) {
                node.next.previous = null;
                first = node.next;
                size--;
                break;
            } else if (i == index && i == size-1) {
                node.previous.next = null;
                last = node.previous;
                size--;
            } else if (i == index && i!=(size-1)){
                node.next.previous = node.previous;
                node.previous.next = node.next;
                size--;
                break;
            }
        }
    }


    public T get (Integer index) {
        Node node = first;
        T value = null;
        for (int i=0; i < size; i++) {
            if (size == 0 || index >= size) {
                throw new NullPointerException();
            } else if (i < index) {
                node = node.next;
            } else if (i == index) {
                value = (T) node.item;
            }
        }
        return value;
    }


    public void set (Integer index) {
        Node node = first;
        T value = null;
        for (int i=0; i < size; i++) {
            if (size == 0 || index >= size) {
                throw new NullPointerException();
            } else if (i < index) {
                node = node.next;
            } else if (i == index) {
                value = (T) node.item;
            }
        }

    }


    public void sort() {
        if (!isLinkedListSorted) {
            Node currentNode = first;
            T tempForValue;
            isLinkedListSorted = false;
            while(!isLinkedListSorted) {
                isLinkedListSorted = true;
                for (int i = 0; i < (size-1); i++) {
                    if((((T)currentNode.item).compareTo((T)currentNode.next.item)) > 0){
                        isLinkedListSorted = false;
                        tempForValue = (T)currentNode.item;
                        currentNode.item = currentNode.next.item;
                        currentNode.next.item = tempForValue;
                    }
                    currentNode = currentNode.next;
                }
                currentNode = first;
            }
        }
    }


    public Integer size() {
        return size;
    }


    private class Node<T> {
        T item;
        Node<T> previous = null;
        Node<T> next = null;
        Node(Node<T> previous, T item, Node<T> next){
            this.previous = previous;
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + item +
                    '}';
        }
    }

    @Override
    public String toString() {
        StringBuilder linkedListItems = new StringBuilder();
        Node buffer = first;
        linkedListItems.append(first.item + "  ");
        for (int i = 0; i < size-1; i++) {
            buffer = buffer.next;
            linkedListItems.append(buffer.item + "  ");
        }
        return linkedListItems.toString();
    }
}