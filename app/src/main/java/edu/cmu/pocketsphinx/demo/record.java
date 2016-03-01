package edu.cmu.pocketsphinx.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class record extends Activity implements View.OnClickListener {

    Spinner s1, s2, s3, s4;
    Button b1;
    String course;
    String sem;
    String teacher;
    String rollno;
    String month,mon;
    EditText et1;
    adapter ad;
    monthadapter ad2;
    Calendar cal;
    ArrayList<defaultdetails> al2;
    ArrayList<emailStructure> e;
    ArrayList<dmonth> d;


    protected void onCreate(Bundle b) {

        super.onCreate(b);

        setContentView(R.layout.record);
        s1 = (Spinner) findViewById(R.id.coursedisplay);
        s2 = (Spinner) findViewById(R.id.sem_display);
        s3 = (Spinner) findViewById(R.id.choose_process);
        s4 = (Spinner) findViewById(R.id.teachername);
        et1 = (EditText) findViewById(R.id.enterrollormonth);


        b1 = (Button) findViewById(R.id.displaydata);

        cal = Calendar.getInstance();
        month = String.valueOf(1 + (cal.get(Calendar.MONTH)));

        //adding data in 1 spinner
        String[] arr = {"information", "computer", "electronics"};
        ArrayAdapter<String> ad1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arr);
        ad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(ad1);

        //adding data in spinner2
        String[] arr2 = {"first", "second", "third", "fourth", "fifth", "sixth"};
        ArrayAdapter<String> ad2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arr2);
        ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(ad2);

        //adding data in spinner 3
        String[] arr3 = {"DEFAULTER LIST", "ROLLNO", "MONTH"};
        ArrayAdapter<String> ad3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arr3);
        ad3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(ad3);

        //adding data in spinner4
        String[] arr4 = {"prasad", "sudhir"};
        ArrayAdapter<String> ad4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arr4);
        ad4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(ad4);


        b1.setOnClickListener(this);


        //deciding process


        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        et1.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        et1.setVisibility(View.VISIBLE);
                        et1.setText("enter rollno");
                        break;
                    case 2:
                        et1.setText("enter month ");
                        et1.setVisibility(View.VISIBLE);
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    @Override
    public void onClick(View v) {

        course = s1.getSelectedItem().toString();
        sem = s2.getSelectedItem().toString();
        teacher = s4.getSelectedItem().toString();


        if (s3.getSelectedItemId() == s3.getItemIdAtPosition(0)) {
            listviewsetter();

        }
        else
        if (s3.getSelectedItemId() == s3.getItemIdAtPosition(1)) {
        rollviewsetter();

        } else
        if (s3.getSelectedItemId() == s3.getItemIdAtPosition(2)) {
         monthviewsetter();
        }
    }

    // listview setter for defaulter list
    public void listviewsetter() {

        setContentView(R.layout.listviewmain);

        Button b2 = (Button)findViewById(R.id.send);

        if (teacher.equalsIgnoreCase("Prasad")) {

                DatabaseHandlerPrasad pg = new DatabaseHandlerPrasad(this, null, null, 1);

               al2 = pg.defaulterFor1month(pg.Tablenamereturns(course,sem,month));

                    ListView list = (ListView) findViewById(R.id.defaulter_list);

                    ad = new adapter(this, al2);
                list.setAdapter(ad);


            }
            else if (teacher.equalsIgnoreCase("sudhir")) {

                DatabaseHandlerPrasad pg = new DatabaseHandlerPrasad(this, null, null, 1);

                al2 = pg.defaulterFor1month(pg.Tablenamereturns(course,sem,month));

                ListView list = (ListView) findViewById(R.id.defaulter_list);

                ad = new adapter(this, al2);

                list.setAdapter(ad);

            }
        b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String temp[]={null};
                 String temp2[]={null};

                 for(int i=0;i<al2.size();i++)
                 {
                     temp[i]=  al2.get(i).drollno;
                     temp2[i]=Double.toString(al2.get(i).dattendance);

                 }

                 Intent intent=new Intent(record.this,send.class);
                 if(teacher.equalsIgnoreCase("prasad")) {

                     DatabaseHandlerPrasad pg = new DatabaseHandlerPrasad(getApplicationContext(), null, null, 1);
                     e=pg.getEmail(temp);
                     intent.putParcelableArrayListExtra("tempdata",e);
                     intent.putExtra("tempdata2attend",temp2);


                 }      else
                         if (teacher.equalsIgnoreCase("sudhir"))
                         {
                         DatabaseHandlerSudhir pg = new DatabaseHandlerSudhir(getApplicationContext(), null, null, 1);
                         e=pg.getEmail(temp);
                         intent.putParcelableArrayListExtra("tempdata",e);
                             intent.putExtra("tempdata2attend",temp2);
                         }

                 startActivity(intent);
             }
         });

    }
public void monthviewsetter()
{
    mon = et1.getText().toString();

    setContentView(R.layout.monthlistview);

    switch (teacher) {
        case "prasad":
            DatabaseHandlerPrasad pg = new DatabaseHandlerPrasad(getApplicationContext(), null, null, 1);
            d = pg.getUsersbymonth(pg.Tablenamereturns(course, sem, mon));
            ListView list = (ListView) findViewById(R.id.month_list);

            ad2 = new monthadapter(this, d);
            list.setAdapter(ad2);
            break;
        case "sudhir":

            DatabaseHandlerSudhir su = new DatabaseHandlerSudhir(getApplicationContext(), null, null, 1);
            d = su.getUsersbymonth(su.Tablenamereturns(course, sem, month));
            ListView list1 = (ListView) findViewById(R.id.month_list);

            ad2 = new monthadapter(this, d);

            list1.setAdapter(ad2);
            break;
    }

    Intent i=new Intent(record.this,)
}
    public void rollviewsetter()
    {
        rollno = et1.getText().toString();
        setContentView(R.layout.monthlistview);

        switch (teacher) {
            case "prasad":
                DatabaseHandlerPrasad pg = new DatabaseHandlerPrasad(getApplicationContext(), null, null, 1);
                d = pg.getUsers(pg.Tablenamereturns(course, sem, month), rollno);
                ListView list = (ListView) findViewById(R.id.month_list);
                ad2 = new monthadapter(this, d);
                list.setAdapter(ad2);
                break;
            case "sudhir":

                DatabaseHandlerSudhir su = new DatabaseHandlerSudhir(getApplicationContext(), null, null, 1);
                d = su.getUsers(su.Tablenamereturns(course, sem, month), rollno);
                ListView list1 = (ListView) findViewById(R.id.month_list);
                ad2 = new monthadapter(this, d);
                list1.setAdapter(ad2);
                break;
        }

    }


}