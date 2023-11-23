
public class Main {
    public static void main(String[] args) {

        /*ArrayHeap test = new ArrayHeap(6);

        test.bubble(2);
        test.bubble(5);
        test.bubble(1);
        test.bubble(9);
        test.bubble(17);
        test.bubble(0);
        System.out.println(test.sink());
        System.out.println(test.sink());*/

        Heap testHeap = new Heap();

        /*testHeap.enqueue(2);
        testHeap.enqueue(5);
        testHeap.enqueue(1);
        testHeap.enqueue(9);
        testHeap.enqueue(17);
        testHeap.enqueue(0);
        testHeap.dequeue();
        testHeap.push(7);*/

        System.out.println("");
        Benchmark.randomAdder(testHeap,5);
        testHeap.addRemove(testHeap,4);

    }

}
