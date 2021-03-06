package edu.cmu.pocketsphinx.demo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Priyanka shahu on 2/24/2016.
 */
public class emailStructure implements Parcelable {

    String ename;
    String erollno;
    String ecourse;
    String emailid;
    String col_phone;
    public static ArrayList<emailStructure> e = new ArrayList<>();

    emailStructure(String name, String roll, String course, String email, String phone) {
        ename = name;
        erollno = roll;
        ecourse = course;
        emailid = email;
        col_phone = phone;
        e.add(this);
    }

    public emailStructure() {

    }


    public ArrayList<emailStructure> getE() {
        return e;
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(ename);
        dest.writeString(erollno);
        dest.writeString(ecourse);
        dest.writeString(emailid);
        dest.writeString(col_phone);

    }

    public static final Parcelable.Creator<emailStructure> CREATOR = new Creator<emailStructure>() {
        public emailStructure createFromParcel(Parcel source) {
            emailStructure temp = new emailStructure();
            temp.ename = source.readString();
            temp.erollno= source.readString();
            temp.ecourse = source.readString();
            temp.emailid=source.readString();
            temp.col_phone=source.readString();


            return temp;
        }

        public emailStructure[] newArray(int size) {
            return new emailStructure[size];
        }
    };
}


