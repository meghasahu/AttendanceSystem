package edu.cmu.pocketsphinx.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;


public class bymonth extends Activity implements View.OnClickListener{
    static ArrayList<dmonth> arraylistmonth=new ArrayList<>();
    monthadapter ad2;
    String[] data;
    Button b1;

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Intent intent=getIntent();
        data=intent.getStringArrayExtra("string");
        try {
            monthviewsetter();
        }
        catch (DatabaseException e)
        {
        }
    }

    public void monthviewsetter()throws DatabaseException
    {
        switch (data[0]) {
            case "prasad":
                DatabaseHandlerPrasad pg = new DatabaseHandlerPrasad(getApplicationContext(), null, null, 1);
                String s1=pg.Tablenamereturns(data[1],data[2],data[3]);
                if(s1.equals("no record found")) {
                    Toast.makeText(this, "please enter valid details", Toast.LENGTH_SHORT).show();
                    throw new DatabaseException(" ");
                }
                else {
                    setContentView(R.layout.monthlistview);
                    b1=(Button)findViewById(R.id.sending);
                    b1.setOnClickListener(this);
                    ListView list = (ListView) findViewById(R.id.month_list);
                    arraylistmonth = pg.getUsersbymonth(s1);
                    ad2 = new monthadapter(this, arraylistmonth);
                    list.setAdapter(ad2);
                }
                break;
            case "sudhir":
                DatabaseHandlerSudhir su = new DatabaseHandlerSudhir(getApplicationContext(), null, null, 1);
                String s=su.Tablenamereturns(data[1],data[2],data[3]);
                if(s.equals("no record found")) {
                    Toast.makeText(this, "please enter valid details", Toast.LENGTH_SHORT).show();
                    throw new DatabaseException(" ");
                }
                else {
                    setContentView(R.layout.monthlistview);
                    b1=(Button)findViewById(R.id.sending);
                    b1.setOnClickListener(this);
                    ListView list = (ListView) findViewById(R.id.month_list);
                    arraylistmonth = su.getUsersbymonth(s);
                    ad2 = new monthadapter(this, arraylistmonth);
                    list.setAdapter(ad2);
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {

        setContentView(R.layout.popup);
        Button b1 = (Button)findViewById(R.id.rollsend);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendroll(getApplicationContext());
            }
        });
    }


    public void sendroll(Context context) {

                EditText et1 = (EditText) findViewById(R.id.receiverid);
                Intent intent2 = null, chooser = null;
                Uri uri = Uri.fromFile(getFile());
                String[] id = {et1.getText().toString()};

                intent2 = new Intent(Intent.ACTION_SEND);
                intent2.setData(Uri.parse("mailto:"));

                intent2.putExtra(Intent.EXTRA_STREAM, uri);
                intent2.putExtra(Intent.EXTRA_EMAIL, id);
                intent2.putExtra(Intent.EXTRA_SUBJECT, "Defaulter list");
                intent2.setType("text/plain");
                try {
                    chooser = Intent.createChooser(intent2, "send email");
                    startActivity(chooser);
                    Toast.makeText(getApplicationContext(), "sent and saved ", Toast.LENGTH_SHORT);
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "No email client installed", Toast.LENGTH_SHORT).show();
                }

            }
    public File getFile(){
        File temp;
        GenerateFile g=new GenerateFile(arraylistmonth,this);
        temp= g.saveDataAttendance();
        return temp;
    }
    public void onBackPressed() {
        super.onBackPressed();
        arraylistmonth.clear();
    }


}