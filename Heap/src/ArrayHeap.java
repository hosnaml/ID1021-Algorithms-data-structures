import java.lang.Math;
public class ArrayHeap {

    private int[] heap;

    private int maxSize;

    private int size;

    public ArrayHeap(int maxSize){

        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize + 1];

    }


    private int parent (int pos){
        int parent = (int)Math.floor( (pos - 1) / 2 );
        return parent;
    }

    private int leftChild(int pos){
        return(2*pos + 1);
    }

    private int rightChild(int pos){
        return (2 * pos) + 2;
    }

    //Return true if the node is a leaf.
    private boolean isLeaf(int pos){
        if(pos > (size / 2)){
            return true;
        }
        return false;
    }

    //To swap two nodes of the heap.
    private void swap (int fpos, int spos){

        int temp;
        temp = heap[fpos];

        heap[fpos] = heap[spos];
        heap[spos] = temp;

    }

    //If the new node has a higher value then all is fine
    // but if not we have to do something about it.
    private void heapify(int pos){

        if(!isLeaf(pos)){
            //swap with the minimum of the two children.'
            //To check if right child exists. Otherwise default value will be 0.
            if(rightChild(pos) <= size){
                while(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                    //if the left child is smaller then it is swapped with the parent.
                    if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                        swap(pos, leftChild(pos));
                    } else {
                        swap(pos, rightChild(pos));
                    }
                }
            }

        }

    }

    public void bubble(int element) {

        //Identify the parent node.
        //if the new node if lower we swap it.(repeated until tree is a heap).
        if (size > maxSize) {
            return;
        }

        else{

            heap[size] = element;
            size++;

            for (int i = 0; i <size ; i++) {

                int currentr = i;

                while (heap[currentr] < heap[parent(currentr)]) {

                    swap(currentr, parent(currentr));
                    currentr = parent(currentr);
                }

            }


        }
        //create a pointer to where in the array we are.

    }

    //The value that we should return is the root.
    public int sink(){

        //remove root and replace it with the last value in the array.
        int newArray[] = new int[size + 1];
        int pop = heap[0];

        if (size - 1 < 1)
            System.out.println();

        newArray[0] = heap[size - 1];
        for (int i = 0; i < size ; i++) {
            newArray[i] = heap[i];
        }
        heap = newArray;

        size--;

        heapify(0);
        return pop;

    }

}
