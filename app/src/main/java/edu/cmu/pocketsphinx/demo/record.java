package edu.cmu.pocketsphinx.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class record extends Activity implements View.OnClickListener {

    Spinner s1, s2, s3,s4;
    Button b1;

    protected void onCreate(Bundle b) {

        super.onCreate(b);
        setContentView(R.layout.record);
        s1 = (Spinner) findViewById(R.id.coursedisplay);
        s2 = (Spinner) findViewById(R.id.sem_display);
        s3 = (Spinner) findViewById(R.id.choose_process);
        s4 = (Spinner) findViewById(R.id.teachername);

        b1 = (Button) findViewById(R.id.displaydata);

        //adding data in 1 spinner
        String[] arr = {"information", "computer", "electronics"};
        ArrayAdapter<String> ad1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arr);
        ad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(ad1);

        //adding data in spinner2
        String[] arr2 = {"1", "2", "3", "4", "5", "6"};
        ArrayAdapter<String> ad2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arr2);
        ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(ad2);

        //adding data in spinner 3
        String[] arr3 = {"DEFAULTER LIST", "ROLLNO", "MONTH"};
        ArrayAdapter<String> ad3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arr3);
        ad3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(ad3);

        //adding data in spinner4
        String[] arr4 = {"prasad","sudhir"};
        ArrayAdapter<String> ad4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arr4);
        ad4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(ad4);


        //setting listener
        s1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        s2.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        s3.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        b1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        String course = s1.getSelectedItem().toString();
        String sem = s2.getSelectedItem().toString();
        String teacher = s4.getSelectedItem().toString();
        if (s3.getSelectedItemId() == s3.getItemIdAtPosition(0)) {
            listviewmain l=new listviewmain();
            l.listviewsetter(teacher,course,sem);

        }else if (s3.getSelectedItemId() == s3.getItemIdAtPosition(1)) {


            Intent i = new Intent(record.this, byrollno.class);
        } else if (s3.getSelectedItemId() == s3.getItemIdAtPosition(2)) {
            Intent i = new Intent(record.this,bymonth.class);
        }
    }


}
