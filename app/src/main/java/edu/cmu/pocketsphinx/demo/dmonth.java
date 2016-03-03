package edu.cmu.pocketsphinx.demo;

/**
 * Created by Priyanka shahu on 3/2/2016.
 */
//dmonth class aur usme add karlo

import java.util.ArrayList;

public class dmonth {

    static ArrayList<dmonth> temp = new ArrayList<>();

    String c[]=new String[32];

    public dmonth(String[] strings)
    {
     for(int i=0;i<32;i++)
     {
         c[i]= strings[i];
     }
        temp.add(this);
    }

    public ArrayList<dmonth> getTemp()
    {
        return temp;
    }
}


