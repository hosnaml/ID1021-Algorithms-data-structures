
import java.util.Random;

public class Benchmark {
    public static void randomAdder(ArrayHeap h, int n){

        Random rd = new Random();

        for (int i = 0; i < n ; i++) {
            int t = rd.nextInt(100);
            h.bubble(t);
            //System.out.println(t);
        }
    }
    public static void randomAdder(Heap h, int n){

        Random rd = new Random();

        for (int i = 0; i < n ; i++) {
            int t = rd.nextInt(100);
            h.enqueue(t);
            //System.out.println(t);
        }
    }

    public  static void pushRnd (Heap h, int n){

        Random rd = new Random();

        for (int i = 0; i < n ; i++) {
            int t = rd.nextInt(100);
            h.enqueue(t);
            //System.out.println(t);
        }
    }


    public static void main(String[] args){



        int[] sizes = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600};
        System.out.printf("#%7s%8s%8s\n", "n",  "Lremove",  "sink");

        for (int n : sizes) {

            System.out.printf("%8d", n);
            double min = Double.POSITIVE_INFINITY;
            int k = 1000;
            int loop = 100;
            //Heap h = new Heap();
            Random rnd = new Random();

            for (int j = 0; j < k; j++) {

                Heap test = new Heap();
                randomAdder(test,2000);

                long t0 = System.nanoTime();

                for (int i = 0; i < n; i++){
                    Integer r = rnd.nextInt(n);
                    test.enqueue(r);
                }


                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;

            }

            System.out.printf("%8.0f", (min/loop));

            /*min = Double.POSITIVE_INFINITY;

            for (int j = 0; j < k; j++) {

                Heap test = new Heap();
                randomAdder(test,2000);

                long t0 = System.nanoTime();

                for (int i = 0; i < n; i++){

                    test.dequeue();
                }

                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min/loop));*/


            /*for (int j = 0; j < k; j++) {

                long t0 = System.nanoTime();

                for (int i = 0; i < n; i++){

                    Integer r = rnd.nextInt(n);
                    h.bubble(r);
                }

                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;

            }

            System.out.printf("%8.0f", (min/loop));*/

            min = Double.POSITIVE_INFINITY;

            //h = new ArrayHeap(10000);
            //randomAdder(h,3000);

            for (int j = 0; j < k; j++) {

                ArrayHeap h = new ArrayHeap(10000);
                randomAdder(h,2000);
                long t0 = System.nanoTime();
                //h.addRemove(h,n);
                for (int i = 0; i < n; i++){
                    h.sink();
                }

                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f\n", (min/loop));

        }



    }

}
