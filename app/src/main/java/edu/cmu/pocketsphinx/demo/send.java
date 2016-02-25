package edu.cmu.pocketsphinx.demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Regis on 29-12-2015.
 */
public class send extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
    }

    public void sending(View v, ArrayList<emailStructure> e) {
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
}