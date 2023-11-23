import java.util.Random;
public class BenchmarkQueue {

    public static void main(String[] args){


        int[] sizes = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600};
        System.out.printf("#%7s%8s%8s\n", "n", "add", "remove");

        for (int n : sizes) {

            System.out.printf("%8d", n);
            double min = Double.POSITIVE_INFINITY;
            int k = 1000;
            int loop = 100;
            Random rnd = new Random();
            PriorityQueue test = new PriorityQueue();


            for (int j = 0; j < k; j++) {

                long t0 = System.nanoTime();
                for (int i = 0; i < n; i++){
                    Integer r = rnd.nextInt(n);
                    test.add(r);
                }
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;

            }

            System.out.printf("%8.0f", (min/loop));

            min = Double.POSITIVE_INFINITY;

            for (int j = 0; j < k; j++) {

                long t0 = System.nanoTime();
                for (int i = 0; i < n; i++){
                    test.remove();
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
