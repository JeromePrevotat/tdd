package com.humanbooster.tdd.mazesolver;

import java.util.LinkedList;
import java.util.ListIterator;

public class DoubleLinkedList {
    LinkedList<Node> linkedList = new LinkedList<>();
    // ITERATOR has hasNext() and hasPrevious() methods to traverse the list in both directions.
    ListIterator<Node> iterator = linkedList.listIterator();
    
    public void addItem(Node item) {
        linkedList.add(item);
    }

    public void removeItem(Node item) {
        linkedList.remove(item);
    }

    public Node getItem(int index) {
        return linkedList.get(index);
    }

    public int size() {
        return linkedList.size();
    }


}
