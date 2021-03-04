package main;

import java.util.NoSuchElementException;

/**
 * This interface describes a queue of Strings where the items removed are returned in a random order.
 * NB a real collection would use generics, but making it a collection of Strings is easier to think about.
 * @author Billy
 *
 */
public interface RandomQueue {

    /**
     * Add the String to the queue.
     * @param str The String to add.
     * @throws IllegalStateException Thrown if the element cannot be added at this time due to capacity restrictions.
     */
    void addString(String str)
            throws IllegalStateException;

    /**
     * Remove a String from the queue.
     * @return a String at random.
     * @throws NoSuchElementException Thrown if the queue is empty.
     */
    String remove()
            throws NoSuchElementException;

}
