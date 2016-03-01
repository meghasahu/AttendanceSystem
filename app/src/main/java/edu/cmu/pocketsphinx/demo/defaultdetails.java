package edu.cmu.pocketsphinx.demo;

import android.widget.Toast;

/**
 * Created by Priyanka shahu on 2/24/2016.
 */
    public class defaultdetails {


        String dname;
        String drollno;
    String dcourse;
    double dattendance;
    defaultdetails(String name,String rollno,String course,double attendance)
    {
        dname=name;
        drollno=rollno;
        dcourse=course;
        dattendance=attendance;
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


    }
