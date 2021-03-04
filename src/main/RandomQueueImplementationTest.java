package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class RandomQueueImplementationTest {

    @Test
    void addString() {
        RandomQueueImplementation rQueue = new RandomQueueImplementation(5);
        rQueue.addString("red");
        rQueue.addString("yellow");
        rQueue.addString("pink");
        rQueue.addString("blue");
        rQueue.addString("purple");

        assertEquals(5, rQueue.size());
    }

    @Test
    void addStringWhenFull() {
        RandomQueueImplementation rQueue = new RandomQueueImplementation(5);
        rQueue.addString("red");
        rQueue.addString("yellow");
        rQueue.addString("pink");
        rQueue.addString("blue");
        rQueue.addString("purple");

        Exception e = assertThrows(IllegalStateException.class, () -> {
            rQueue.addString("green");
        });
    }

    @Test
    void removeString() {
        RandomQueueImplementation rQueue = new RandomQueueImplementation(5);
        rQueue.addString("red");
        rQueue.addString("yellow");
        rQueue.addString("pink");
        rQueue.addString("blue");
        rQueue.addString("purple");
        rQueue.remove();

        assertEquals(4, rQueue.size());
    }


    @Test
    void removeStringWhenEmpty() {
        RandomQueueImplementation rQueue = new RandomQueueImplementation(5);
        Exception e = assertThrows(NoSuchElementException.class, () -> {
            rQueue.remove();
        });
    }

    @Test
    void clear() {
        RandomQueueImplementation rQueue = new RandomQueueImplementation(5);
        rQueue.addString("red");
        rQueue.addString("yellow");
        rQueue.addString("pink");
        rQueue.addString("blue");
        rQueue.addString("purple");
        rQueue.clear();

        assertEquals(0, rQueue.size());
    }

    @Test
    void randomnessInRemove() {
        RandomQueueImplementation rQueue = new RandomQueueImplementation(5);
        rQueue.addString("red");
        rQueue.addString("yellow");
        rQueue.addString("pink");
        rQueue.addString("blue");
        rQueue.addString("grey");

        RandomQueueImplementation rQueue1 = new RandomQueueImplementation(5);
        rQueue1.addString("red");
        rQueue1.addString("yellow");
        rQueue1.addString("pink");
        rQueue1.addString("blue");
        rQueue1.addString("grey");

        try {
        rQueue.remove();
        rQueue.addString("purple");
        rQueue.remove();
        rQueue.addString("silver");
        rQueue.remove();
        rQueue.addString("black");
        rQueue.remove();
        rQueue.addString("orange");

        rQueue1.remove();
        rQueue1.addString("purple");
        rQueue1.remove();
        rQueue1.addString("silver");
        rQueue1.remove();
        rQueue1.addString("black");
        rQueue1.remove();
        rQueue1.addString("orange");


        assertNotEquals((rQueue.toString()), rQueue1.toString());

        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

}


