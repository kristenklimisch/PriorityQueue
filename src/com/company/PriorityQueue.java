package com.company;

public class PriorityQueue {
    private static final int MAX_SIZE = 11;
    private int[] heap;
    private int size;

    PriorityQueue() {
        heap = new int[MAX_SIZE];

        // Set heap[0] to MAX_VALUE to ensure
        // first key inserted into Priority Queue is at
        // index 1.
        heap[0] = Integer.MAX_VALUE;
        // heap size is 0; heap[0] is not part of the heap
        size = 0;
    }

    public void print(){
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public void insert(int i) {
        size++;
        boolean heapified = false;

        // insert key in the last position in the array.
        heap[size] = i;
        int position = size;
        while ( !heapified && (position > 1) ) {
            int parent = heap[position/2];

            // if parent key is less than the newly-inserted key, swap.
            if (parent < i) {
                heap[position]=parent;
                heap[position/2]= i;
                position = (position/2);
            } else {
                heapified = true;
            }
        }
        System.out.print("After inserting " + i + ", the array is: ");
        print();
    }

    public int remove() {
        int root = heap[1];
        heap[1] = heap[size];
        size--;
        int position = 1;
        boolean heapified = false;
        while ( ( (position * 2) < size)  && !heapified ){
            int i = position * 2;
            if ( (i + 1) <= size) {
                if (heap[i] < heap[i + 1] ) {
                    i++;
                }
            }
            if (heap[position] < heap[i]) {
                int temp = heap[position];
                heap[position] = heap[i];
                heap[i] = temp;
            } else {
                heapified = true;
            }
            position = position * 2;
        }
        System.out.print("After removing " + root +", the array is: ");
        print();
        return root;
    }

    public static void main(String[] args) {
        PriorityQueue p = new PriorityQueue();
        p.insert(1);
        p.insert(5);
        p.insert(3);
        p.insert(6);
        p.insert(8);
        p.insert(2);
        p.insert(4);
        System.out.println("Element retrieved: " + p.remove());
        System.out.println("Element retrieved: " + p.remove());
        System.out.println("Element retrieved: " + p.remove());
        System.out.println("Element retrieved: " + p.remove());
        System.out.println("Element retrieved: " + p.remove());
        System.out.println("Element retrieved: " + p.remove());
        System.out.println("Element retrieved: " + p.remove());

    }
}
