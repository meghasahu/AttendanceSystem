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
    ArrayList<dmonth> dmon;
    File tempFile;

    GenerateFile(ArrayList<defaultdetails> temp)
    {
        this.temp=temp;
    }
    public File saveDataDefaulters(Context context){

            FileWriter writer;
            String tempname = "NewDocument";
            int i = 0;
        File file;
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),tempname+".txt");
        try {
            file.createNewFile();
            writer = new FileWriter(file);
            writer.append("NAME     \r ROLLNO \r  COURSE  \r ATTENDANCE \n");
            for (i = 0; i < temp.size(); i++) {
                writer.append(temp.get(i).dname + "     \t  " + temp.get(i).drollno + "   \t  " + temp.get(i).dcourse + "   \t"
                        + temp.get(i).dattendance + "\t");
            }
            saveFile(file);
            writer.flush();
            writer.close();
        }catch (IOException e)
        {
        e.printStackTrace();
        }

       return file;
    }
    public File saveDataAttendance(Context context){
        FileWriter writer;
        String tempname = "NewDocument";
        int i = 0,j=0;
        File file;
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),tempname+".txt");
        try {
            file.createNewFile();
            writer = new FileWriter(file);
            writer.append("ROLLNO     \t 1 \t  2  \t3 \t 4  \t 5 \t 6 \t 7 \t 8 \t  \t9  \t  10\t  11 \t 12\t  13\t 14\t  15 \t 16  \t" +
                    "17 \t  18 \t 19 \t 20 \t 21 \t 22 \t 23 \t24 \t 25 \t 26 \t 27 \t 28 \t29 \t 30 \t 31\n");
            while (!temp.isEmpty()) {
                j = 0;

                for (i = 0; i < 31; i++) {
                    if (dmon.get(i).c1.equals("present"))
                        writer.append("present\t");
                    else if (dmon.get(i).equals(null))
                        writer.append("holiday\t");
                    else if (dmon.get(i).equals("absent"))
                        writer.append("absent\t");
                }

                writer.append(dmon.get(i).roll + "     \r  " + dmon.get(i).c1 + "   \r  " + dmon.get(i).c2 + "   \r "
                        + dmon.get(i).c3 + dmon.get(i).c4 + dmon.get(i).c5 + dmon.get(i).c6 + dmon.get(i).c7 + dmon.get(i).c8
                        + dmon.get(i).c9 + dmon.get(i).c10 + dmon.get(i).c11 + dmon.get(i).c12 + dmon.get(i).c13 + dmon.get(i).c14
                        + dmon.get(i).c15 + dmon.get(i).c16 + dmon.get(i).c17 + dmon.get(i).c18 + dmon.get(i).c19 + dmon.get(i).c20 +
                        dmon.get(i).c21 + dmon.get(i).c22 + dmon.get(i).c23 + dmon.get(i).c24 + dmon.get(i).c25 + dmon.get(i).c26 +
                        dmon.get(i).c27 + dmon.get(i).c28 + dmon.get(i).c29 + dmon.get(i).c30 + dmon.get(i).c30 + "\n");
            }
            writer.flush();
            writer.close();
        }catch(IOException e)
        {
         e.printStackTrace();
        }
        return file;
    }
    public void saveFile(File file)
    {
     tempFile=file;
    }
    public File getSavedFile()
    {
        return tempFile;
    }
}
