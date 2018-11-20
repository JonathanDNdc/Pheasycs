package com.example.pheasycs.pheasycs;

public class Kinematics {

    public double selectFormula(int formula, int variable, double first, double second, double third, double fourth) {

        switch(formula){
            case 3:
                return kin1(variable, first, second, third, fourth);
            case 4:
                return kin2(variable, first, second, third, fourth);
            case 5:
                return kin3(variable, first, second, third, fourth);
            case 6:
                return kin4(variable, first, second, third, fourth);
        }

        return 10.0;
    }

    private double kin1(int variable, double first, double second, double third, double fourth){
        switch(variable){
            case 0:
                return second + third * fourth;
            case 1:
                return first - third * fourth;
            case 2:
                return (first - second) / fourth;
            case 3:
                return (first - second) / third;
            default:
                return 0;
        }
    }

    private double kin2(int variable, double first, double second, double third, double fourth){
        switch(variable){
            case 0:
                return (second + third) / 2 * fourth;
            case 1:
                return 2 * (first / fourth) - third;
            case 2:
                return 2 * (first / fourth) - second;
            case 3:
                return first * 2 / (second + third);
            default:
                return 0;
        }
    }

    private double kin3(int variable, double first, double second, double third, double fourth){
        switch(variable){
            case 0:
                return second * third  + (fourth * third) / 2;
            case 1:
                return -(fourth * third / 2) + first / third;
            case 2:
                return (-second - Math.sqrt(second * second + 2 * fourth * first)) / fourth;
            case 3:
                return -(2 * second / third) + 2 * first / (third * third);
            default:
                return 0;
        }
    }

    private double kin4(int variable, double first, double second, double third, double fourth){
        switch(variable){
            case 0:
                return Math.sqrt(second*second + 2*third*fourth);
            case 1:
                return Math.sqrt(first*first - 2*third*fourth);
            case 2:
                return -(second*second/(2*fourth)) + first*first / (2* fourth);
            case 3:
                return (first*first - second*second) / (2*third);
            default:
                return 0;
        }
    }

}
