package edu.cmu.pocketsphinx.demo;

import android.content.Context;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;

/**
 * Created by Priyanka shahu on 3/2/2016.
 */
public class GenerateFile {
     ArrayList<defaultdetails> temp;
    int random=0;
     ArrayList<dmonth> dmon;

    GenerateFile(ArrayList<defaultdetails> temp)
    {
        this.temp=temp;
    }

    GenerateFile(ArrayList<dmonth> dmon,Context context)
    {
        this.dmon=dmon;
    }

    public File saveDataDefaulters(){
        FileWriter writer;
            String tempname = "NewDocument";
            int i = 0;
        File file;
        random=0;
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),tempname+".txt");
        while(file.exists()) {
            random++;
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), tempname + "(" + random + ").txt");
        }
        try {
            file.createNewFile();
            writer = new FileWriter(file);
            writer.append("NAME     \r ROLLNO \r  COURSE  \r ATTENDANCE \n");
            for (i = 0; i < temp.size(); i++) {
                writer.append(temp.get(i).dname + "     \t  " + temp.get(i).drollno + "   \t  " + temp.get(i).dcourse + "   \t"
                        + temp.get(i).dattendance + "\t");
            }
            writer.flush();
            writer.close();
        }catch (IOException e)
        {
        e.printStackTrace();
        }

       return file;
    }
    public File saveDataAttendance(){
        FileWriter writer;
        String tempname = "NewDocument";
        int i = 0,j=0;
        File file;
        random=0;
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),tempname+".txt");
        while(file.exists()) {
            random++;
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), tempname + "(" + random + ").txt");
        }
        try {
            file.createNewFile();
            writer = new FileWriter(file);
            writer.append("ROLLNO     \t DAY1 \t  DAY2  \t DAY3 \t DAY4  \t DAY5 \t DAY6 \t DAY7 \t DAY8  \t DAY9  \t  DAY10\t  DAY11 \t DAY12\t  DAY13\t DAY14\t  DAY15 \t DAY16  \t  DAY17 \t  DAY18 \t DAY19 \t DAY20 \t DAY21 \t DAY22 \t DAY23 \t DAY24 \t DAY25 \t DAY26 \t DAY27 \t DAY28 \t DAY29 \t DAY30 \t DAY31\n");
            while (j<dmon.size()) {
               writer.append(dmon.get(j).c[0]);
                for (i = 1; i <=31; i++) {
                    if (dmon.get(j).c[i].equals("present")) {
                        writer.append("P\t");
                    }
                    else if (dmon.get(j).c[i].equals(null)){
                        writer.append("H\t");}
                    else if(dmon.get(j).c[i].equals("absent")){
                        writer.append("A\t");}
                }
                writer.append("\n");
                j++;
            }
            writer.flush();
            writer.close();
        }catch(IOException e)
        {
         e.printStackTrace();
        }
        return file;
    }

}
