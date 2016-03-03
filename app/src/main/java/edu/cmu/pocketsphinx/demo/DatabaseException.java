package edu.cmu.pocketsphinx.demo;

import android.database.DatabaseErrorHandler;
import android.widget.Toast;

/**
 * Created by Priyanka shahu on 3/4/2016.
 */
public class DatabaseException extends Exception{

    DatabaseException(String s)
    {
        super(s);
      //  Toast.makeText(this,"",Toast.LENGTH_SHORT);
    }
}
