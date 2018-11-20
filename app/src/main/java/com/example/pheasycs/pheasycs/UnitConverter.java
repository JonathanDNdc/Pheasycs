package com.example.pheasycs.pheasycs;

public class UnitConverter {

    public double unitConverter(double num, int topic, int first, int second) {

        switch (topic) {
            case 0:
                return Area(num, first, second);
            case 1:
                return DStorage(num, first, second);
            case 2:
                return Frequency(num, first, second);
            case 3:
                return Length(num, first, second);
            case 4:
                return Angle(num, first, second);
            case 5:
                return Temperature(num, first, second);
            case 6:
                return Time(num, first, second);
            default:
                return 0.0;
        }
    }

    private double Area(double num, int first, int second) {

        double area_relation[][] = {
                {0, 1},
                {1, 1000000},
                {2, 0.386102},
                {3, 1195990.046301},
                {4, 10763867.361143},
                {5, 1550003100.006200}
        };

        return num / area_relation[first][1] * area_relation[second][1];
    }

    private double DStorage(double num, int first, int second) {

        double dstorage_relation[][] = {
                {0, 8000000},
                {1, 8000},
                {2, 8},
                {3, 0.008},
                {4, 0.000008},
                {5, 0.000000008},
                {6, 1000000},
                {7, 1000},
                {8, 1},
                {9, 0.001},
                {10, 0.000001},
                {11, 0.000000001}
        };

        return num / dstorage_relation[first][1] * dstorage_relation[second][1];
    }

    private double Frequency(double num, int first, int second) {

        double frequency_relation[][] = {
                {0, 1000000000},
                {1, 1000000},
                {2, 1000},
                {3, 1}
        };

        return num / frequency_relation[first][1] * frequency_relation[second][1];
    }

    private double Length(double num, int first, int second) {

        double length_relation[][] = {
                {0, 0.001},
                {1, 1},
                {2, 100},
                {3, 1000},
                {4, 1000000},
                {5, 1000000000},
                {6, 0.000621371},
                {7, 1.09361},
                {8, 3.28084},
                {9, 39.3701}
        };

        return num / length_relation[first][1] * length_relation[second][1];
    }

    private double Angle(double num, int first, int second) {

        double angle_relation[][] = {
                {0, 1},
                {1, 10/9},
                {2, Math.PI/180}
        };

        return num / angle_relation[first][1] * angle_relation[second][1];
    }

    private double Temperature(double num, int first, int second) {

        switch (first) {
            case 0:
                switch (second) {
                    case 0:
                        return num;
                    case 1:
                        return num * 1.8 + 32;
                    case 2:
                        return num + 273.15;
                }
            case 1:
                switch (second) {
                    case 0:
                        return (num - 32) * 5/9;
                    case 1:
                        return num;
                    case 2:
                        return (num - 32) * 5/9 + 273.15;
                }
            case 2:
                switch (second) {
                    case 0:
                        return num - 273.15;
                    case 1:
                        return (num - 273.15) * 1.8 + 32;
                    case 2:
                        return num;
                }
        }

        return 0.0;
    }

    private double Time(double num, int first, int second) {

        double time_relation[][] = {
                {0, 60000000000L},
                {1, 60000000},
                {2, 60000},
                {3, 60},
                {4, 1},
                {5, 1d/60},
                {6, 1d/60/24},
                {7, 1d/60/24/7},
                {8, 1d/60/24/30.436875},
                {9, 1d/60/24/365.2425},
                {10, 1d/60/24/365.2425/10},
                {11, 1d/60/24/365.2425/100}
        };

        return num / time_relation[first][1] * time_relation[second][1];
    }


}