package main.java.Leetcode.Chal30days.Week2;

public class LastStoneWeight {

    public static void main(String[] args) {

        System.out.println(new LastStoneWeight().lastStoneWeight(new int[]{3,3,3}));
    }

    public int lastStoneWeight(int[] stones) {

        MaxHeap maxHeap = new MaxHeap(stones.length);
        for (int i = 0; i < stones.length; i++)
            maxHeap.insert(stones[i]);

        while (maxHeap.size > 1) {
            int temp = maxHeap.getMaxVal() - maxHeap.getMaxVal();
            if (temp != 0)
                maxHeap.insert(temp);
        }
        if (maxHeap.size == 0)
            return 0;
        else
           return maxHeap.getMaxVal();
    }

    class MaxHeap {

        private int heap[], current;
        public int size;

        MaxHeap(int maxSize) {
            heap = new int[maxSize+1];
            this.size = 0;
            heap[0] = Integer.MAX_VALUE;
        }

        private int parent (int pos) {
            return pos/2;
        }

        private int leftChild (int pos) {
            return 2 * pos;
        }

        private int rightChild (int pos) {
            return 2 * pos + 1;
        }

        private void swap (int iPos, int fPos) {
            int temp = heap[iPos];
            heap[iPos] = heap[fPos];
            heap[fPos] = temp;
        }

        public void insert (int val) {
            heap[++size] = val;

            current = size;
            while (heap[current]>heap[parent(current)]) {
                swap (current, parent(current));
                current = parent(current);
            }
        }

        private boolean isLeaf (int pos) {
            if (pos > size/2 && pos <= size)
                return true;

            return false;
        }

        private void maxHeapify(int pos) {

            if (isLeaf(pos) || size == 0)
                return;

            if (rightChild(pos) > size) {
                if (heap[pos] < heap[leftChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }
            }
            else
            if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
                if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else if (heap[pos] < heap[rightChild(pos)]) {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }

        }

        public int getMaxVal () {
            int maxValue = heap[1];
            heap[1] = heap[size--];
            maxHeapify(1);
            return maxValue;
        }

    }
}
