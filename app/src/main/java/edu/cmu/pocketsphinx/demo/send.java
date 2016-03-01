package edu.cmu.pocketsphinx.demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Regis on 29-12-2015.
 */
public class send extends Activity {

    Button b1, b2;
    EditText et1;
    CheckBox ch1, ch2;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);

        b1 = (Button) findViewById(R.id.sendmail);
        b2 = (Button) findViewById(R.id.sms);

        et1 = (EditText) findViewById(R.id.email);

        ch1 = (CheckBox) findViewById(R.id.checkbox1);
        ch2 = (CheckBox) findViewById(R.id.checkother);



        //send email

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                   String temp;
                   ArrayList<emailStructure> e;
                   int i = 0;
                   Intent intent2 = null, chooser = null;
                   Intent intent = getIntent();
                   e = intent.getParcelableArrayListExtra("tempdata");
                   temp=intent.getStringExtra("tempdata2attend");

                   intent2 = new Intent(Intent.ACTION_SEND);
                   intent2.setData(Uri.parse("mailto:"));

                if(ch1.isChecked()) {

                   while (!e.isEmpty()) {

                       intent2.putExtra(Intent.EXTRA_EMAIL, e.get(i).emailid);
                       intent2.putExtra(Intent.EXTRA_SUBJECT, "Regarding your child attendance");
                       intent2.putExtra(Intent.EXTRA_TEXT, "Dear parents, \n We are informing you that your child's is not attending all the lectures.Hence ");
                       i++;

                       intent2.setType("message/rfc822");

                       chooser = Intent.createChooser(intent, "send email");
                       startActivity(chooser);
                   }
               }
                else
                   if (ch2.isChecked())
                   {
                       et1.setVisibility(View.VISIBLE);
                       et1.setText("enter emailId");

                       while(!e.isEmpty()) {

                           intent2.putExtra(Intent.EXTRA_TEXT,"" );
                       }
                       intent2.putExtra(Intent.EXTRA_EMAIL, et1.getText());
                       intent2.putExtra(Intent.EXTRA_SUBJECT, "Defaulter list");

                       intent2.setType("message/rfc822");

                       chooser = Intent.createChooser(intent, "send email");
                       startActivity(chooser);

                   }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (ch1.isChecked()) {
                    ArrayList<emailStructure> e;
                    int i = 0;
                    Intent intent = getIntent();
                    e = intent.getParcelableArrayListExtra("tempdata");

                    while (!e.isEmpty()) {
                        SmsManager sms_manager = SmsManager.getDefault();
                        sms_manager.sendTextMessage(e.get(i).col_phone, null, "", null, null);
                    }
                }

                else
                    Toast.makeText(getApplicationContext(),"please select option defaulters",Toast.LENGTH_SHORT).show();
            }
        });


    }
}