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
}
