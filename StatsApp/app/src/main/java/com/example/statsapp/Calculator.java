package com.example.statsapp;

import java.util.ArrayList;

public class Calculator {

    public static Double getMean(ArrayList<Double> input){
        double mean = 0.0;
        double sum =0.0;
        int n = input.size();
        for(Double e: input){
            sum+=e;
        }
        mean = sum/n;
        return mean;
    }

    public static Double getVariance(ArrayList<Double> input){
        double var = 0.0;
        double sum = 0.0;
        int n = input.size();
        double mean = getMean(input);
        for(Double e : input){
            sum+=Math.pow((e-mean),2);
        }

        var = sum/n;
        return var;
    }

    public static Double getStdDev(ArrayList<Double> input){
        double std = 0.0;
        double var = getVariance(input);
        std = Math.sqrt(var);
        return std;
    }
}
