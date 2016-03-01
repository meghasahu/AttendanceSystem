package edu.cmu.pocketsphinx.demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Regis on 29-12-2015.
 */
public class send extends Activity {

    Button b1,b2;
    EditText et1;
    CheckBox ch1,ch2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);

        b1=(Button)findViewById(R.id.sendmail);
        b2=(Button)findViewById(R.id.sms);

        et1=(EditText)findViewById(R.id.email);

        ch1=(CheckBox)findViewById(R.id.checkbox1);
        ch2=(CheckBox)findViewById(R.id.checkother);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }
    send(View v, ArrayList<emailStructure> e) {
        Intent intent = null, chooser = null;
        if (v.getId() == R.id.send) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            Iterator itr = e.iterator();
            while (itr.hasNext())
            {
                String email=itr.next().toString();
               intent.putExtra(Intent.EXTRA_EMAIL,email);
                intent.putExtra(Intent.EXTRA_SUBJECT, "");
                intent.putExtra(Intent.EXTRA_TEXT, "");
            }


        }
    }
    public send()
    {

    }
}