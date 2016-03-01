package edu.cmu.pocketsphinx.demo;

/**
 * Created by Priyanka shahu on 3/2/2016.
 */
//monthadapter class banao

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class monthadapter extends BaseAdapter {

    Context c;
    LayoutInflater inflater;
    ArrayList<dmonth> user;

    public monthadapter(Context c,ArrayList<dmonth> m)
    {
        this.c=c;
        this.user=m;
    }


    @Override
    public int getCount() {
        return user.size();
    }

    @Override
    public Object getItem(int position) {
        return user.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.monthlistviewrow,parent,false);
        }

        // Lookup view for data population
        TextView roll = (TextView) convertView.findViewById(R.id.roll);
        TextView  _1= (TextView) convertView.findViewById(R.id._1);
        TextView  _2= (TextView) convertView.findViewById(R.id._2);
        TextView  _3= (TextView) convertView.findViewById(R.id._3);
        TextView  _4= (TextView) convertView.findViewById(R.id._4);
        TextView  _5= (TextView) convertView.findViewById(R.id._5);
        TextView  _6= (TextView) convertView.findViewById(R.id._6);
        TextView  _7= (TextView) convertView.findViewById(R.id._7);
        TextView  _8= (TextView) convertView.findViewById(R.id._8);
        TextView  _9= (TextView) convertView.findViewById(R.id._9);
        TextView  _10= (TextView) convertView.findViewById(R.id._10);
        TextView  _11= (TextView) convertView.findViewById(R.id._11);
        TextView  _12= (TextView) convertView.findViewById(R.id._12);
        TextView  _13= (TextView) convertView.findViewById(R.id._13);
        TextView  _14= (TextView) convertView.findViewById(R.id._14);
        TextView  _15= (TextView) convertView.findViewById(R.id._15);
        TextView  _16= (TextView) convertView.findViewById(R.id._16);
        TextView  _17= (TextView) convertView.findViewById(R.id._17);
        TextView  _18= (TextView) convertView.findViewById(R.id._18);
        TextView  _19= (TextView) convertView.findViewById(R.id._19);
        TextView  _20= (TextView) convertView.findViewById(R.id._20);
        TextView  _21= (TextView) convertView.findViewById(R.id._21);
        TextView  _22= (TextView) convertView.findViewById(R.id._22);
        TextView  _23= (TextView) convertView.findViewById(R.id._23);
        TextView  _24= (TextView) convertView.findViewById(R.id._24);
        TextView  _25= (TextView) convertView.findViewById(R.id._25);
        TextView  _26= (TextView) convertView.findViewById(R.id._26);
        TextView  _27= (TextView) convertView.findViewById(R.id._27);
        TextView  _28= (TextView) convertView.findViewById(R.id._28);
        TextView  _29= (TextView) convertView.findViewById(R.id._29);
        TextView  _30= (TextView) convertView.findViewById(R.id._30);
        TextView  _31= (TextView) convertView.findViewById(R.id._31);

        roll.setText(user.get(pos).roll);
        _1.setText(user.get(pos).c1);
        _2.setText(user.get(pos).c2);
        _3.setText(user.get(pos).c3);
        _4.setText(user.get(pos).c4);
        _5.setText(user.get(pos).c5);
        _6.setText(user.get(pos).c6);
        _7.setText(user.get(pos).c7);
        _8.setText(user.get(pos).c8);
        _9.setText(user.get(pos).c9);
        _10.setText(user.get(pos).c10);
        _11.setText(user.get(pos).c11);
        _12.setText(user.get(pos).c12);
        _13.setText(user.get(pos).c13);
        _14.setText(user.get(pos).c14);
        _15.setText(user.get(pos).c15);
        _16.setText(user.get(pos).c16);
        _17.setText(user.get(pos).c17);
        _18.setText(user.get(pos).c18);
        _19.setText(user.get(pos).c19);
        _20.setText(user.get(pos).c20);
        _21.setText(user.get(pos).c21);
        _22.setText(user.get(pos).c22);
        _23.setText(user.get(pos).c23);
        _24.setText(user.get(pos).c24);
        _25.setText(user.get(pos).c25);
        _26.setText(user.get(pos).c26);
        _27.setText(user.get(pos).c27);
        _28.setText(user.get(pos).c28);
        _29.setText(user.get(pos).c29);
        _30.setText(user.get(pos).c30);
        _31.setText(user.get(pos).c31);


        return convertView;
    }
}


