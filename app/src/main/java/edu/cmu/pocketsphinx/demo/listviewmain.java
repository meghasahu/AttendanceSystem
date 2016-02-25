package edu.cmu.pocketsphinx.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Priyanka shahu on 2/24/2016.
 */
public class listviewmain extends Activity implements View.OnClickListener {

    Button b1;
    ArrayAdapter<defaultdetails> ad;
    String course_send,sem_send;

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.listviewmain);
        b1 = (Button) findViewById(R.id.send);
        b1.setOnClickListener(this);
    }


        public void listviewsetter(String teacher,String course,String sem)
        {

            course_send=course;
            sem_send=sem;
            Calendar cal = Calendar.getInstance();
            String month = String.valueOf(1 + (cal.get(Calendar.MONTH)));



            if (teacher.equalsIgnoreCase("Prasad"))
           {
            DatabaseHandlerPrasad pg = new DatabaseHandlerPrasad(this, null, null, 1);
            ArrayList<defaultdetails> al2 = pg.defaulterFor1month(pg.Tablenamereturns(course,sem,month),pg.getReadableDatabase());
            ListView list = (ListView) findViewById(R.id.defaulter_list);

            ad = new ArrayAdapter<defaultdetails>(this,R.layout.listviewmain, al2);

            list.setAdapter(ad);

           }        else if (teacher.equalsIgnoreCase("sudhir"))
              {

            DatabaseHandlerPrasad pg = new DatabaseHandlerPrasad(this, null, null, 1);
            ArrayList<defaultdetails> al2 = pg.defaulterFor1month(pg.Tablenamereturns(course, sem,month),pg.getReadableDatabase());
           ListView list = (ListView) findViewById(R.id.defaulter_list);

            ad = new ArrayAdapter<defaultdetails>(this,R.layout.listviewmain, al2);

            list.setAdapter(ad);


               }
        }

    @Override
    public void onClick(View v) {
       send s=new send();

      //  s.sending(v,);


    }
}