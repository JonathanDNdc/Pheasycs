package com.example.pheasycs.pheasycs;

public class SumOfVectors {

    public double getOne(boolean mag, double mag1, double ang1, double mag2, double ang2, double mag3, double ang3){

        // Sum of all the vector's x components.
        double xaxis = mag1 * Math.cos(Math.toRadians(ang1))
                + mag2 * Math.cos(Math.toRadians(ang2))
                + mag3 * Math.cos(Math.toRadians(ang3));

        // Sum of all the vector's y components.
        double yaxis = mag1 * Math.sin(Math.toRadians(ang1))
                + mag2 * Math.sin(Math.toRadians(ang2))
                + mag3 * Math.sin(Math.toRadians(ang3));

        if(mag){
            return Math.sqrt(Math.pow(xaxis, 2) + Math.pow(yaxis, 2)); // Return the magnitude.
        } return Math.toDegrees(Math.atan2(yaxis, xaxis)); // Return the angle.
    }
}
