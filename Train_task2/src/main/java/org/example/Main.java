package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        int length = countOfSteps(2, 5, 0.005) + 1;
        double[] xArr = new double[length];
        double[] yArr = new double[length];

        xyArr(xArr, yArr, 2, 5, 0.005);

        for(int i = 0; i < length; ++i){
            System.out.println(i + ". " + xArr[i] + ": " + yArr[i]);
        }

        int minIndex = minIndex(yArr);
        int maxIndex = maxIndex(yArr);

        System.out.println("Min index: " + minIndex);
        System.out.println("Max index: " + maxIndex);

        double sum = sum(yArr);
        System.out.println("Sum: " + sum);

        double middle = middleArithmetic(yArr);
        System.out.println("Middle arithmetic: " + middle);

        minElem(yArr);
        maxElem(yArr);
    }
    public double funcTabulation(double x){
        if(x > 3.4){
            return Math.sin(x) * Math.log(x);
        }
        return Math.cos(x) * Math.cos(x);
    }
    public int countOfSteps(double start, double end, double step){
        if(start >= end){
            return 0;
        }

        return (int) Math.ceil((end - start) / step);
    }
    public void xyArr(double[]xArr, double[]yArr, double start, double end, double step){
        int i = 0;
        for(double x = start; x <= end; x += step){
            xArr[i] = x;
            yArr[i] = funcTabulation(x);
            ++i;
        }
    }
    public int minIndex(double[] arr){
        int minIndex = 0;
        double minNum = arr[0];
        for(int i = 1; i < arr.length; ++i){
            if(arr[i] < minNum){
                minNum = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public int maxIndex(double[] arr){
        int maxIndex = 0;
        double maxNum = arr[0];
        for(int i = 1; i < arr.length; ++i){
            if(arr[i] > maxNum){
                maxNum = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public double sum(double[] arr){
        return Arrays.stream(arr).sum();
    }
    public double middleArithmetic(double[] arr){
        return Arrays.stream(arr).sum()/arr.length;
    }
    public void minElem(double[] arr){
        int index = minIndex(arr);
        System.out.println("Min elem: " + arr[index] + " index: " + index);
    }
    public void maxElem(double[] arr){
        int index = maxIndex(arr);
        System.out.println("Max elem: " + arr[index] + " index: " + index);
    }
}