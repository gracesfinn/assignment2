package controllers;
import java.util.List;


import models.Assessment;
import models.Member;
import play.Logger;
import play.mvc.Controller;

public class GymUtil extends Controller
{
    public static double calculateBMI(Member member)
    {
        List<Assessment>assessmentList = member.assessmentList;
        double weight = 0;
        if(!assessmentList.isEmpty()){

           weight= assessmentList.get(assessmentList.size()-1).weight;
        }
        else{
            weight = member.startingWeight;
        }
        double BMI  = toTwoDecimalPlaces((weight)/((member.height)*(member.height)));
        return BMI;
    }

    private static double toTwoDecimalPlaces(double BMI)
    {
        return(int)(BMI*100)/100.0;
    }

    public static String determineBMICategory(double BMI) {


        if (BMI <= 15.99)
            return  "Severely Underweight";
        else if (BMI <= 18.5)
            return  "Underweight";
        else if (BMI <= 25)
            return "Normal";
        else if (BMI <= 30)
            return "Overweight";
        else if (BMI <= 34.99)
            return "Moderately Obese";
        else if (BMI > 35)
            return  "Severely Obese";

        else return "BMI Category cannot be calculated";


    }

}
