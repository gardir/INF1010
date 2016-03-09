public class Fibonacci{
    public static int fibo(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return fibo(n-1) + fibo(n-2);
    }

    public static int fiboIter(int n){
        int[] fib = new int[n+1];

        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i <= n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    public static void main(String[] args){

        System.out.println("FibIter 5: " + fiboIter(5));
        System.out.println("FibRek  5: " + fibo(5));
    }

}