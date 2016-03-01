package edu.cmu.pocketsphinx.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Priyanka shahu on 2/28/2016.
 */
public class adapter extends BaseAdapter {

    Context c;
    LayoutInflater inflater;
    ArrayList<defaultdetails> e;
    TextView tname,trollno,tcourse,tattend;

    public adapter(Context c,ArrayList<defaultdetails> e)
    {
        this.c=c;
        this.e=e;
    }


    @Override
    public int getCount() {
        return e.size();
    }

    @Override
    public Object getItem(int position) {
        return e.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
   @Override
    public View getView(int pos,View convertView,ViewGroup vg1)
    {

        if(convertView==null)
        {
         inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.listviewrow,vg1,false);
        }
        tname=(TextView)convertView.findViewById(R.id.listname);
        trollno=(TextView)convertView.findViewById(R.id.listrollno);
        tcourse=(TextView)convertView.findViewById(R.id.listcourse);
        tattend=(TextView)convertView.findViewById(R.id.listAttendance);

        tname.setText(e.get(pos).dname);
        trollno.setText(e.get(pos).drollno);
        tcourse.setText(e.get(pos).dcourse);
        tattend.setText(Double.toString(e.get(pos).dattendance));


        return convertView;
    }

}
