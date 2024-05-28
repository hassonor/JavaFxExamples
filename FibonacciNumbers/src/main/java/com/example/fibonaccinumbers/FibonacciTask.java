package com.example.fibonaccinumbers;

import javafx.concurrent.Task;

public class FibonacciTask extends Task<Long> {
    private final int n; // Fibonacci number to calculate

    public FibonacciTask(int n) {
        this.n = n;
    }

    // long-running code to be run in a worker thread

    @Override
    protected Long call() {
        updateMessage("Calculating...");
        long result = fibonacci(n);
        updateMessage("Done calculating.");
        return result;
    }

    // recursive method fibonacci; calculates nth Fibonacci number
    public long fibonacci(long number) {
        if (number == 0 || number == 1) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}
