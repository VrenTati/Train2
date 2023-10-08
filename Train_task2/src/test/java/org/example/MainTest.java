package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    public static final double EPS = 1e-3;
    Main main;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
        main = new Main();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void funcTabulationTest0() {
        double expected = Math.cos(0.1) * Math.cos(0.1);
        double actual = main.funcTabulation(0.1);
        assertEquals(expected, actual, EPS);
    }
    @Test
    void funcTabulationTest280() {
        double expected = Math.cos(3.4) * Math.cos(3.4);
        double actual = main.funcTabulation(3.4);
        assertEquals(expected, actual, EPS);
    }
    @Test
    void funcTabulationTest600() {
        double expected = Math.sin(5) * Math.log(5);
        double actual = main.funcTabulation(5);
        assertEquals(expected, actual, EPS);
    }

    @Test
    void countOfSteps0() {
        int expected = 0;
        int actual = main.countOfSteps(3, 2, 0.005);
        assertEquals(expected, actual);
    }
    @Test
    void countOfSteps200() {
        int expected = 200;
        int actual = main.countOfSteps(2, 2.9999, 0.005);
        assertEquals(expected, actual);
    }
    @Test
    void countOfSteps600() {
        int expected = 600;
        int actual = main.countOfSteps(2, 4.9999, 0.005);
        assertEquals(expected, actual);
    }

    @Test
    void xyArr() {
        double expected = Math.cos(2) * Math.cos(2);
        double[]yArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        double[]xArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        main.xyArr(xArr, yArr, 2, 5, 0.005);
        double actualY = yArr[0];
        double actualX = xArr[0];
        assertEquals(expected, actualY, EPS);
        assertEquals(2, actualX);
    }

    @Test
    void minIndex() {
        int expected = 569;
        double[]yArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        double[]xArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        main.xyArr(xArr, yArr, 2, 5, 0.005);
        assertEquals(expected, main.minIndex(yArr));
    }

    @Test
    void maxIndex() {
        int expected = 228;
        double[]yArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        double[]xArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        main.xyArr(xArr, yArr, 2, 5, 0.005);
        assertEquals(expected, main.maxIndex(yArr));
    }

    @Test
    void sum() {
        double expected = -162.553;
        double[]yArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        double[]xArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        main.xyArr(xArr, yArr, 2, 5, 0.005);
        assertEquals(expected, main.sum(yArr), EPS);
    }

    @Test
    void middleArithmetic() {
        double expected = -0.270;
        double[]yArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        double[]xArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        main.xyArr(xArr, yArr, 2, 5, 0.005);
        assertEquals(expected, main.middleArithmetic(yArr), EPS);
    }

    @Test
    void minElem() {
        String expected = "Min elem: -1.5640929266972168 index: 569";
        double[]yArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        double[]xArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        main.xyArr(xArr, yArr, 2, 5, 0.005);
        main.minElem(yArr);
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void maxElem() {
        String expected = "Max elem: 0.9999974634566875 index: 228";
        double[]yArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        double[]xArr = new double[main.countOfSteps(2, 5, 0.005)+1];
        main.xyArr(xArr, yArr, 2, 5, 0.005);
        main.maxElem(yArr);
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }
}