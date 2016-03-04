package edu.cmu.pocketsphinx.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.telephony.SmsManager;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Regis on 29-12-2015.
 */
public class send extends Activity {

    Button b1, b2;
    EditText et1;
    CheckBox ch1, ch2;
    ArrayList<emailStructure> e;
    Intent intent;
    String[] temp = {" "};
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.send);

        int i=0;

        intent = getIntent();
        e = intent.getParcelableArrayListExtra("tempdata");

        while(temp[i]!=null) {
            temp[i] = intent.getStringExtra(("tempdata2attend"));
        }

        b1= (Button) dialog.findViewById(R.id.sendmail);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    sendDefault();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        b2=(Button) dialog.findViewById(R.id.sms);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                smsDefault();
            }
        });
        ch1=(CheckBox)dialog.findViewById(R.id.checkbox1);
        ch2=(CheckBox)dialog.findViewById(R.id.checkother);
        et1=(EditText)dialog.findViewById(R.id.email);

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ch2.isChecked())
                {
                    et1.setVisibility(View.VISIBLE);
                    et1.setHint("enter emailId");
                }
                else
                    et1.setVisibility(View.INVISIBLE);
            }

        });
        dialog.show();
    }

    //send email
    public void sendDefault() throws IOException {
        int i = 0;
        Intent intent2 = null, chooser = null;
        intent2 = new Intent(Intent.ACTION_SEND);
        intent2.setData(Uri.parse("mailto:"));

        Intent intent3 = new Intent(Intent.ACTION_SEND);
        intent3.setData(Uri.parse("mailto:"));


        String sendTo[] = new String[e.size()];
        while (i < e.size()) {
            sendTo[i] = e.get(i).emailid;
            i++;
        }

        if (ch1.isChecked()) {
            intent3.putExtra(Intent.EXTRA_EMAIL, sendTo);
            intent3.putExtra(Intent.EXTRA_SUBJECT, "Regarding your child attendance");
            intent3.putExtra(Intent.EXTRA_TEXT, "Dear parents, \n We are informing you that your child's is not attending all the lectures.Hence ");

            intent3.setType("text/plain");
            try {
                chooser = Intent.createChooser(intent3, "send email");
                startActivity(chooser);
                Toast.makeText(getApplicationContext(), "sent", Toast.LENGTH_SHORT);
            } catch (android.content.ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "No email client installed", Toast.LENGTH_SHORT).show();
            }
        }
            if (ch2.isChecked()) {
                record r = new record();
                Uri uri = Uri.fromFile(r.getFile());
                String[] id = {et1.getText().toString()};
                intent2.putExtra(Intent.EXTRA_TEXT, "Dear parents this is to inform you that your child has been irregularly attending college since last month.Kindly take action on the same.");
                intent2.putExtra(Intent.EXTRA_STREAM, uri);
                intent2.putExtra(Intent.EXTRA_EMAIL, id);
                intent2.putExtra(Intent.EXTRA_SUBJECT, "Defaulter list");
                intent2.setType("text/plain");
                try {
                    chooser = Intent.createChooser(intent2, "send email");
                    startActivity(chooser);
                    Toast.makeText(getApplicationContext(), "sent to others", Toast.LENGTH_SHORT);
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "No email client installed", Toast.LENGTH_SHORT).show();
                }

            }
        }

    public void smsDefault() {
        String sent="SMS_SENT";
        PendingIntent sentPI=PendingIntent.getBroadcast(this,0,new Intent(sent),0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
             if(getResultCode()== Activity.RESULT_OK)
                 Toast.makeText(getApplicationContext(),"SMS sent",Toast.LENGTH_SHORT).show();
                else
                 Toast.makeText(getApplicationContext(),"SMS not sent",Toast.LENGTH_SHORT).show();
            }
        },new IntentFilter(sent));

        if (ch1.isChecked()) {
            int i = 0;
            while (i<e.size()) {
                SmsManager sms_manager = SmsManager.getDefault();
                sms_manager.sendTextMessage(e.get(i).col_phone, null, "  ", sentPI, null);
                i++;
            }
        } else
            Toast.makeText(getApplicationContext(), "please select option defaulters", Toast.LENGTH_SHORT).show();

    }

    public void onBackPressed() {

        super.onBackPressed();
        dialog.dismiss();
        return;
    }
}
