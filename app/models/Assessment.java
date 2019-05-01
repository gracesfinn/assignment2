package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Assessment extends Model
{
    public String date;
    public double weight, thigh, chest, upperArm, waist, hips;

    public Assessment(String date, double weight, double chest, double thigh, double upperArm, double waist, double hips)
    {
        this.date= date;
        this.weight = weight;
        this.thigh = thigh;
        this.chest = chest;
        this.upperArm = upperArm;
        this.waist = waist;
        this.hips = hips;



    }
}