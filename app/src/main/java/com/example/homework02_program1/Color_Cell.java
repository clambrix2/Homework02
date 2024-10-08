package com.example.homework02_program1;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Color_Cell extends BaseAdapter {

    Context context;
    ArrayList<ColorInfo> listsofcolors;

    public Color_Cell(Context c, ArrayList<ColorInfo> cl)
    {
        context = c;
        listsofcolors = cl;
    }
    @Override
    public int getCount() {
        return listsofcolors.size();
    }

    @Override
    public Object getItem(int i) {
        return listsofcolors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater Inflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = Inflater.inflate(R.layout.activity_color_cell, null);

        }
        TextView redint = view.findViewById(R.id.Et_V_cell_Redint);
        TextView red = view.findViewById(R.id.Et_V_cell_Red);
        TextView green = view.findViewById(R.id.Et_V_cell_green);
        TextView greenint = view.findViewById(R.id.Et_V_cell_Greenint);
        TextView blue = view.findViewById(R.id.Et_V_cell_Blue);
        TextView blueint = view.findViewById(R.id.Et_V_cell_Blueint);
        TextView hexcode = view.findViewById(R.id.Et_V_cell_Hexcode);
        TextView hexcodevaule = view.findViewById(R.id.Et_V_cell_hexcodevaule);
        ColorInfo emp = listsofcolors.get(i);
        redint.setText("" + emp.getRed());
        Log.d("Here Before Error", "Esrror");
        greenint.setText("" + emp.getGreen());
        blueint.setText("" + emp.getBlue());
        hexcodevaule.setText(emp.getHexcolor());
        if(emp.getIswhitetext())
        {
            red.setTextColor(Color.WHITE);
            redint.setTextColor(Color.WHITE);
            green.setTextColor(Color.WHITE);
            greenint.setTextColor(Color.WHITE);
            blue.setTextColor(Color.WHITE);
            blueint.setTextColor(Color.WHITE);
            hexcode.setTextColor(Color.WHITE);
            hexcodevaule.setTextColor(Color.WHITE);
        }
        else
        {red.setTextColor(Color.BLACK);
            redint.setTextColor(Color.BLACK);
            green.setTextColor(Color.BLACK);
            greenint.setTextColor(Color.BLACK);
            blue.setTextColor(Color.BLACK);
            blueint.setTextColor(Color.BLACK);
            hexcode.setTextColor(Color.BLACK);
            hexcodevaule.setTextColor(Color.BLACK);

        }
        view.setBackgroundColor(Color.parseColor(emp.getHexcolor()));
        return view;
    }
}
