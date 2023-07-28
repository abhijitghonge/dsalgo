package com.ag.recursion;

public class PrintStrings {

    public static void main(String[] args) {
       /* PrintStrings printer = new PrintStrings();
        printer.solve(9);*/

        PrintStrings printer = new PrintStrings();
        //System.out.println(printer.f(2,10));
        printer.f(1023);

    }

    public int f(int n){
        if(n%2 == 0){
            System.out.println("n:"+n);
            return 0;
        }
        System.out.println("n:"+n);
        return f(n-1) + f(n/2);
    }

    public int f(int x, int n){
        if(n==0) return 1;
        else if (n%2==0) return f(x*x, n/2);
        else return x*f(x*x, (n-1)/2);
    }

    public void solve(int A) {
        // printTo(A);

        //print(A);
    }

    private void printTo(int A){
        if(A == 1){
            System.out.printf("%d ", 1);
            return;
        }
        //System.out.printf("Here for A: %d", A);
        printTo(A-1);
        System.out.printf("%d ", A);
    }

    private void print(int A){
        if(A==1){
            System.out.printf("%d ", 1);
        }else{
            System.out.printf("%d ", A);
            print(A-1);
        }
        return;

    }

}
