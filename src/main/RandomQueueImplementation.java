package main;

import main.RandomQueue;

import java.util.NoSuchElementException;
import java.util.Random;

public class RandomQueueImplementation implements RandomQueue {

    private int capacity;
    private int front;
    private int rear;
    private int size;
    private String[] queue;

    public RandomQueueImplementation(int c){

        capacity = c;
        front = 0;
        size = 0;
        rear = capacity - 1;
        queue = new String[capacity];
    }

    @Override
    public void addString(String str) throws IllegalStateException {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = str;
            size ++;
        }
    }

    @Override
    public String remove() throws NoSuchElementException {
        Random rand = new Random();
        int randInt = rand.nextInt(rear+1);

        if (front == size) {
            throw new NoSuchElementException("Queue is empty");
        } else {
            String[] copy = new String[queue.length-1];

            for(int i = 0, k = 0; i < queue.length; i++){
                if(i == randInt){
                    continue;
                }
                copy[k++] = queue[i];
            }
            size --;
            String removed = queue[randInt];
            queue = copy;

            return removed;
        }
    }


    public int size(){
        int sizeCount = 0;
        for (int i = 0; i< queue.length; i++) {
            if(queue[i] != null) {
                sizeCount++;
            }
        }

        return sizeCount;
    }

    public void clear(){
        for (int i = 0; i< queue.length; i++) {
            queue[i] = null;
        }
    }

}
