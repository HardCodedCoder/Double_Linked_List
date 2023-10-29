package at.fhburgenland.interfaces;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {
    /**
     * The value of this node.
     */
    private T value;

    /**
     * The next node in the list.
     */
    private Node<T> next;

    /**
     * The previous node in the list.
     */
    private Node<T> previous;

    /**
     * Initializes a new instance of the Node class.
     * @param value The value the node is holding
     */
    public Node(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    /**
     * Initializes a new instance of the Node class.
     * @param value The value the node is holding.
     * @param next The next node this node is pointing to.
     * @param previous The previous node this node is pointing to.
     */
    public Node(T value, Node<T> next, Node<T> previous) {
        this(value);
        this.next = next;
        this.previous = previous;
    }
}
