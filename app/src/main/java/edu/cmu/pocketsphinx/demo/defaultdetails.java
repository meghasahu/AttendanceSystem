package edu.cmu.pocketsphinx.demo;

import java.util.ArrayList;

/**
 * Created by Priyanka shahu on 2/24/2016.
 */
    public class defaultdetails {


    String dname;
    String drollno;
    String dcourse;
    double dattendance;
     static ArrayList<defaultdetails> temp=new ArrayList<>();

    defaultdetails(String name,String rollno,String course,double attendance)
    {
        dname=name;
        drollno=rollno;
        dcourse=course;
        dattendance=attendance;

        temp.add(this);

    }

    public ArrayList<defaultdetails> getTemp() {
        return temp;
    }
}
