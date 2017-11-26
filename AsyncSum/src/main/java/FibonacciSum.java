import java.util.concurrent.RecursiveTask;

class FibonacciSum extends RecursiveTask<Integer> {
    final int n;
    FibonacciSum(int n) {
        this. n = n;
    }

    @Override
    protected Integer compute() {
        if(n <= 1 ) return n;
        FibonacciSum a1 = new FibonacciSum(n-1);
        a1.fork();
        FibonacciSum a2 = new FibonacciSum(n-2);
        return a2.compute() + a1.join();
    }

    public static void main(String []args) {
        int n = 1000;
        FibonacciSum a = new FibonacciSum(n);
        System.out.println("result: " + a.compute());
    }
}