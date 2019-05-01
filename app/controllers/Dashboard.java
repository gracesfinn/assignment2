package controllers;

import models.Assessment;
import models.Member;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

import static controllers.GymUtil.determineBMICategory;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Assessment>assessmentList = member.assessmentList;
    double BMI = GymUtil.calculateBMI(member);//most recent assessment
      String BMICategory = determineBMICategory(BMI);
    render ("dashboard.html",member,assessmentList,BMI,BMICategory);
  }
  public static void addAssessment(String date, double weight,  double chest, double thigh, double upperArm, double waist, double hips)
  {
    Member member = Accounts.getLoggedInMember();
    Assessment assessment = new Assessment(date, weight, chest, thigh, upperArm, waist, hips);
    member.assessmentList.add(assessment);
    member.save();
    Logger.info("Adding Assessment" + date + weight + chest + thigh + upperArm + waist + hips);
    redirect("/dashboard");
  }
}
