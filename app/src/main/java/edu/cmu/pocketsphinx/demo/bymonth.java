package edu.cmu.pocketsphinx.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class bymonth extends Activity {
    ArrayList<dmonth> arraylistmonth=null;
    monthadapter ad2=null;
    String[] data=null;

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Intent intent=getIntent();
        data=intent.getStringArrayExtra("string");
        monthviewsetter();
    }

    public void monthviewsetter()
    {
        setContentView(R.layout.monthlistview);
        ListView list = (ListView) findViewById(R.id.month_list);

        switch (data[0]) {
            case "prasad":
                arraylistmonth=null;

                DatabaseHandlerPrasad pg = new DatabaseHandlerPrasad(getApplicationContext(), null, null, 1);
                arraylistmonth = pg.getUsersbymonth(pg.Tablenamereturns(data[1],data[2],data[3]));
                ad2 = new monthadapter(this,arraylistmonth);
                list.setAdapter(ad2);
                break;
            case "sudhir":
               arraylistmonth=null;
                DatabaseHandlerSudhir su = new DatabaseHandlerSudhir(getApplicationContext(), null, null, 1);
                arraylistmonth = su.getUsersbymonth(su.Tablenamereturns(data[1],data[2],data[3]));
                ad2 = new monthadapter(this, arraylistmonth);
                list.setAdapter(ad2);
                break;
        }
    }


}




