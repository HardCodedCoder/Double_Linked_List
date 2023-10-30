package at.fhburgenland;

import at.fhburgenland.interfaces.MyListADT;
import at.fhburgenland.interfaces.Node;

public class MyList<T extends Comparable<T>> implements MyListADT<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size;

    public MyList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Inserts the element on the first position of the list.
     *
     * @param element The element to insert.
     */
    @Override
    public void insertFirst(T element) {
        Node<T> newNode = new Node<T>(element);
        if (this.head == null)
        {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
            this.head = newNode;
        }

        size++;
    }

    /**
     * Inserts the element after a specific element.
     *
     * @param element   The element to insert.
     * @param reference The element before the element to insert.
     */
    @Override
    public void insertAfter(T element, T reference) {
        Node<T> newNode = new Node<>(element);
        Node<T> current = head;

        while (current != null) {

            if (current.getValue().equals(reference)) {
                if (current == tail) {
                    newNode.setPrevious(current);
                    current.setNext(newNode);
                    tail = newNode;
                } else {
                    newNode.setPrevious(current);
                    newNode.setNext(current.getNext());
                    current.getNext().setPrevious(newNode);
                    current.setNext(newNode);
                }

                size++;
                return;
            }

            current = current.getNext();
        }
    }

    /**
     * Inserts the element before a specific element.
     *
     * @param element   The element to insert.
     * @param reference The element after the element to insert.
     */
    @Override
    public void insertBefore(T element, T reference) {
        Node<T> newNode = new Node<>(element);
        Node<T> current = head;

        while (current != null) {

            if (current.getValue().equals(reference)) {
                newNode.setNext(current);
                newNode.setPrevious(current.getPrevious());
                current.setPrevious(newNode);


                if (newNode.getPrevious() != null) {
                    newNode.getPrevious().setNext(newNode);
                } else {
                    head = newNode;
                }

                size++;
                return;
            }

            current = current.getNext();
        }
    }

    /**
     * Removes the element from the list.
     *
     * @param element The element to remove.
     */
    @Override
    public void remove(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(element)) {

                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(current.getNext());
                } else {
                    head = current.getNext();
                }

                if (current.getNext() != null) {
                    current.getNext().setPrevious(current.getPrevious());
                } else {
                    tail = current.getPrevious();
                }

                size--;
                return;

            } else {
                current = current.getNext();
            }
        }
    }

    /**
     * Sorts the list from smallest to largest.
     */
    @Override
    public void sort() {
        if (size <= 1) {
            return;
        }

        boolean swapped;

        do {
            swapped = false;
            Node<T> current = head;
            while (current.getNext() != null) {
                if (((Comparable<T>) current.getValue()).compareTo(current.getNext().getValue()) > 0) {
                    T temp = current.getValue();
                    current.setValue(current.getNext().getValue());
                    current.getNext().setValue(temp);
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }

    @Override
    public void printList() {
        Node<T> current = head;

        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}

