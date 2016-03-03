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
    static int random=0;
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
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),tempname+"("+random+").txt");
        random++;
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
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),tempname+"("+random+").txt");
        random++;
        try {
            file.createNewFile();
            writer = new FileWriter(file);
            writer.append("ROLLNO     \t 1 \t  2  \t3 \t 4  \t 5 \t 6 \t 7 \t 8 \t  \t9  \t  10\t  11 \t 12\t  13\t 14\t  15 \t 16  \t + 17 \t  18 \t 19 \t 20 \t 21 \t 22 \t 23 \t24 \t 25 \t 26 \t 27 \t 28 \t29 \t 30 \t 31\n");
            while (j<dmon.size()) {
               writer.append(dmon.get(j).c[0]);
                for (i = 1; i <=31; i++) {
                    if (dmon.get(j).c[i].equals("present")) {
                        writer.append("present\t");
                    }
                    else if (dmon.get(j).c[i].equals(null)){
                        writer.append("holiday\t");}
                    else if(dmon.get(j).c[i].equals("absent")){
                        writer.append("absent\t");}
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
