package edu.cmu.pocketsphinx.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Priyanka shahu on 2/24/2016.
 */
public class byrollno extends Activity implements View.OnClickListener {

    monthadapter ad2;

    String[] data = null;
    static ArrayList<dmonth> arraylistmonth;
    Button b1;

    public void onCreate(Bundle b) {
        super.onCreate(b);
        arraylistmonth = null;
        //we need to call the onCreate() of the AppCompatDelegate

        setContentView(R.layout.monthlistview);
        Intent intent = getIntent();
        data = intent.getStringArrayExtra("string");
        rollviewsetter();
        Button b1 = (Button) findViewById(R.id.sending);

        b1.setOnClickListener(this);

    }

    public void rollviewsetter() {
        ListView list = (ListView) findViewById(R.id.month_list);

        switch (data[0]) {
            case "prasad":
                DatabaseHandlerPrasad pg = new DatabaseHandlerPrasad(getApplicationContext(), null, null, 1);
                arraylistmonth = pg.getUsers(pg.Tablenamereturns(data[1], data[2], data[4]), data[3]);
                ad2 = new monthadapter(this, arraylistmonth);
                list.setAdapter(ad2);
                break;
            case "sudhir":
                DatabaseHandlerSudhir su = new DatabaseHandlerSudhir(getApplicationContext(), null, null, 1);
                arraylistmonth = su.getUsers(su.Tablenamereturns(data[1], data[2], data[4]), data[3]);
                ad2 = new monthadapter(this, arraylistmonth);
                list.setAdapter(ad2);
                break;
        }

    }

    @Override
    public void onClick(View v) {









        setContentView(R.layout.popup);
        sendroll(this);

    }

    public void onBackPressed() {

        super.onBackPressed();
        ListView list = (ListView) findViewById(R.id.month_list);
        list.setAdapter(null);

        return;
    }

    public void sendroll(Context context) {

        Button b1 = (Button) findViewById(R.id.rollsend);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        });
    }
    public File getFile(){
        File temp;
        GenerateFile g=new GenerateFile(arraylistmonth,this);
        temp= g.saveDataAttendance();
        return temp;
    }

}