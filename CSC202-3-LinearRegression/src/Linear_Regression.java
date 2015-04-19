/**
 * Created by admin on 2/28/15.
 */

import java.util.Random;

public class Linear_Regression {

    private static int[][] arrFirst = new int[10][2];
    private static double avgX;
    private static double avgY;
    private static double xVar, xyCoVar;
    private static double sum;
    private static double slopeM;
	
    public static void main (String[] args) {
        init();
    }

    public static void init() {
        arrFirst = new int[][] {{81,131},{14,71},{60,112},{12,53},{99,115},{35,92},{4,71},{23,65},{45,104},{14,25}};
        double _avgX = avgX(arrFirst);
        double _avgY = avgY(arrFirst);
        double _xVar = xVar(arrFirst);
        double _xyCoVar = xyCoVar(arrFirst);
        double _slope = slope(xVar, xyCoVar);
        double yieldMin = _avgY - _slope * _avgX;
        double yieldMax = _slope * 100 + yieldMin;
        
        System.out.println("Fert\t" + "Yield");
        display(arrFirst);
        System.out.println("Slope: " + _slope);
        System.out.println("Yield at 0: " + yieldMin);
        System.out.println("Yield at Max: " + yieldMax);
    }
    
    public static void display(int[][] arr) {
    	for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t" + arr[i][1]);
        }
    }

    public static double avgX(int[][] arr) {
    	avgX = 0;
    	sum = 0;
    	for (int i = 0; i < arr.length; i++) {
    	    sum += arr[i][0];
    	}
    	return avgX = sum/arr.length;
    }
    
    public static double avgY(int[][] arr) {
    	avgY = 0;
    	sum = 0;
    	for (int i = 0; i < arr.length; i++) {
    	    sum += arr[i][1];
    	}
    	return avgY = sum/arr.length;
    }

    public static double xVar(int[][] arr) {
    	xVar = 0;
    	sum = 0;
    	for (int i =0; i < arr.length; i++) {
    	    sum += (Math.pow(arr[i][0] - avgX, 2));
    	}
    	xVar = sum / arr.length;
    	return xVar;
    }
    
    public static double xyCoVar(int[][] arr) {
    	xyCoVar = 0;
    	sum = 0;
    	for (int i = 0; i < arr.length; i++) {
    	    sum += ((arr[i][0] - avgX)*(arr[i][1] - avgY));
    	}
    	xyCoVar = sum / arr.length;
    	return xyCoVar;
    }

    public static double slope(double xVar, double xyCoVar) {
    	slopeM = xyCoVar/xVar;
    	return slopeM;
    }
}

