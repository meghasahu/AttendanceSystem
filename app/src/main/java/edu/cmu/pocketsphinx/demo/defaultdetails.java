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

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDrollno() {
        return drollno;
    }

    public void setDrollno(String drollno) {
        this.drollno = drollno;
    }

    public String getDcourse() {
        return dcourse;
    }

    public void setDcourse(String dcourse) {
        this.dcourse = dcourse;
    }

    public double getDattendance() {
        return dattendance;
    }

    public void setDattendance(double dattendance) {
        this.dattendance = dattendance;
    }

    public ArrayList<defaultdetails> getTemp() {
        return temp;
    }
}
