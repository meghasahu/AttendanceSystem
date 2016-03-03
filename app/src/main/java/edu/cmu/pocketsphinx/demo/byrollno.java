package edu.cmu.pocketsphinx.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;

/**
 * Created by Priyanka shahu on 2/24/2016.
 */
public class byrollno extends Activity implements View.OnClickListener {

    monthadapter ad2=null;

    String[] data=null;
    ArrayList<dmonth> arraylistmonth;
    Button b1;

    public void onCreate(Bundle b) {
        super.onCreate(b);
        arraylistmonth=null;
        setContentView(R.layout.monthlistview);
        Intent intent = getIntent();
        data = intent.getStringArrayExtra("string");
        rollviewsetter();
        Button b1 = (Button) findViewById(R.id.sending);

        b1.setOnClickListener(this);


    }
    public void rollviewsetter()
    {
        ListView list = (ListView) findViewById(R.id.month_list);

        switch (data[0]) {
            case "prasad":
                arraylistmonth=null;
                DatabaseHandlerPrasad pg = new DatabaseHandlerPrasad(getApplicationContext(), null, null, 1);
                arraylistmonth = pg.getUsers(pg.Tablenamereturns(data[1],data[2],data[4]),data[3]);
                ad2 = new monthadapter(this, arraylistmonth);
                list.setAdapter(ad2);
                break;
            case "sudhir":
                arraylistmonth=null;
                DatabaseHandlerSudhir su = new DatabaseHandlerSudhir(getApplicationContext(), null, null, 1);
                arraylistmonth = su.getUsers(su.Tablenamereturns(data[1],data[2],data[4]),data[3]);
                ad2 = new monthadapter(this, arraylistmonth);
                list.setAdapter(ad2);
                break;
        }

    }

    @Override
    public void onClick(View v) {
        LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.popup, null);
        PopupWindow popupWindow = new PopupWindow(popupView,ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.showAsDropDown(b1, 50, -30);

    }
}
