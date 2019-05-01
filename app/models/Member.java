package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Member extends Model
{
    public String name;
    public String gender;
    public String address;
    public String email;
    public String password;
    public double targetWeight;
    public double startingWeight;
    public double height;
    public String comment;




    @OneToMany(cascade = CascadeType.ALL)
    public List<Assessment> assessmentList = new ArrayList<Assessment>();

    public Member(String name,  String gender, String address, String email, String password, double targetWeight, double startingWeight, double height)
    {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.targetWeight = targetWeight;
        this.startingWeight = startingWeight;
        this.height = height;

    }

    public static Member findByEmail(String email)
    {
        return find("email", email).first();
    }

    public boolean checkPassword(String password)
    {
        return this.password.equals(password);
    }




}


