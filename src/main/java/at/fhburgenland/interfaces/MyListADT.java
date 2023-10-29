package at.fhburgenland.interfaces;

public interface MyListADT<T> {
    /**
     * Inserts the element on the first position of the list.
     *
     * @param element The element to insert.
     */
    void insertFirst(T element);

    /**
     * Inserts the element after a specific element.
     *
     * @param element   The element to insert.
     * @param reference The element before the element to insert.
     */
    void insertAfter(T element, T reference);

    /**
     * Inserts the element before a specific element.
     *
     * @param element   The element to insert.
     * @param reference The element after the element to insert.
     */
    void insertBefore(T element, T reference);

    /**
     * Removes the element from the list.
     *
     * @param element The element to remove.
     */
    void remove(T element);

    /**
     * Sorts the list from smallest to largest.
     */
    void sort();

    void printList();
}
