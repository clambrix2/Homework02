package com.example.homework02_program1;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar Es_j_redslider;
    SeekBar Es_j_greeslider;
    SeekBar Es_j_blueslider;

    ListView Elv_J_Colorlist;

    Button Eb_J_savecolor;

    TextView Et_J_Redint;
    TextView Et_J_Greenint;
    TextView Et_J_Blueint;
    TextView Et_j_redtext;
    TextView Et_j_greentext;
    TextView Et_j_bluetext;
    TextView Et_j_Title;
    TextView Et_j_hexcodetext;
    TextView Et_j_hexcodevaule;

    View Ev_j_view;

    ArrayList<ColorController> listofcolors;

    Color_Cell adapter;

    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private  int id;
    private String hexcolor;
    boolean iswhiteext =   false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Es_j_redslider = findViewById(R.id.Es_V_Redslider);
        Es_j_greeslider = findViewById(R.id.Es_V_Greenslider);
        Es_j_blueslider = findViewById(R.id.Es_V_Bluesilder);
        Elv_J_Colorlist = findViewById(R.id.Elv_V_Colorlist);
        Eb_J_savecolor = findViewById(R.id.Eb_V_Savecolor);
        Et_J_Redint = findViewById(R.id.Et_V_Redint);
        Et_J_Greenint = findViewById(R.id.Et_V_Greenint);
        Et_J_Blueint = findViewById(R.id.Et_V_Blueint);
        Ev_j_view = findViewById(R.id.main);
        Et_j_redtext = findViewById(R.id.Et_V_Red);
        Et_j_greentext = findViewById(R.id.Et_V_Green);
        Et_j_bluetext = findViewById(R.id.Et_V_Blue);
        Et_j_Title = findViewById(R.id.Et_V_Title);
        Et_j_hexcodetext = findViewById(R.id.Et_V_Hexcode);
        Et_j_hexcodevaule = findViewById(R.id.Et_V_HexcodeVaule);
        setmax();
        setslidercolor();
        onSliderChanged();
        buttonpress();
        listofcolors = new ArrayList<ColorController>();
        fillcolorlist();
    }
    private void setmax()
    {
        Es_j_redslider.setMax(255);
        Es_j_greeslider.setMax(255);
        Es_j_blueslider.setMax(255);

    }
    private void changedtextcolor()
    {

        if(blue >= 127 && green <= 127 && red <= 127)
        {
            Log.d("Here changing color: ", "Did it work");
            Et_J_Blueint.setTextColor(Color.WHITE);
            Et_J_Greenint.setTextColor(Color.WHITE);
            Et_J_Redint.setTextColor(Color.WHITE);
            Et_j_redtext.setTextColor(Color.WHITE);
            Et_j_greentext.setTextColor(Color.WHITE);
            Et_j_bluetext.setTextColor(Color.WHITE);
            Et_j_Title.setTextColor(Color.WHITE);
            Et_j_hexcodetext.setTextColor(Color.WHITE);
            Et_j_hexcodevaule.setTextColor(Color.WHITE);
            iswhiteext = true;
        }
        else if(blue >= 127 && green > 127)
        {
            Et_J_Redint.setTextColor(Color.BLACK);
            Et_J_Greenint.setTextColor(Color.BLACK);
            Et_J_Blueint.setTextColor(Color.BLACK);
            Et_j_redtext.setTextColor(Color.BLACK);
            Et_j_greentext.setTextColor(Color.BLACK);
            Et_j_bluetext.setTextColor(Color.BLACK);
            Et_j_Title.setTextColor(Color.BLACK);
            Et_j_hexcodetext.setTextColor(Color.BLACK);
            Et_j_hexcodevaule.setTextColor(Color.BLACK);
            iswhiteext = false;
        }
        else if(blue <= 127 && green <= 127 && red <= 127)
        {
            Et_J_Redint.setTextColor(Color.WHITE);
            Et_J_Greenint.setTextColor(Color.WHITE);
            Et_J_Blueint.setTextColor(Color.WHITE);
            Et_j_redtext.setTextColor(Color.WHITE);
            Et_j_greentext.setTextColor(Color.WHITE);
            Et_j_bluetext.setTextColor(Color.WHITE);
            Et_j_Title.setTextColor(Color.WHITE);
            Et_j_hexcodevaule.setTextColor(Color.WHITE);
            Et_j_hexcodetext.setTextColor(Color.WHITE);
            iswhiteext = true;
        }
        else if(red >= 127)
        {
            Et_J_Redint.setTextColor(Color.BLACK);
            Et_J_Greenint.setTextColor(Color.BLACK);
            Et_J_Blueint.setTextColor(Color.BLACK);
            Et_j_redtext.setTextColor(Color.BLACK);
            Et_j_greentext.setTextColor(Color.BLACK);
            Et_j_bluetext.setTextColor(Color.BLACK);
            Et_j_Title.setTextColor(Color.BLACK);
            Et_j_hexcodetext.setTextColor(Color.BLACK);
            Et_j_hexcodevaule.setTextColor(Color.BLACK);
            iswhiteext = false;
        }
    }

    private  void buttonpress()
    {
        Eb_J_savecolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setcolors();
            }
        });
    }
    private  void setcolors()
    {
        ColorController colortoadd = new ColorController();
        colortoadd.setIswhitetext(iswhiteext);
        colortoadd.setRed(red);
        colortoadd.setGreen(green);
        colortoadd.setBlue(blue);
        colortoadd.setHexcolor(hexcolor);
        listofcolors.add(colortoadd);
        adapter.notifyDataSetChanged();
        cleatsliders();


    }
    private  void setbackgroundcolor(String h)
    {
       // Log.d("Hexcode: ", h);
        //int hexcolor = Color.parseColor("#" + h);
        //Log.d("Here the Hexcolor: " , h);
      Ev_j_view.setBackgroundColor(Color.parseColor(h));
    }
    private void cleatsliders()
    {
        red = 0;
        green = 0;
        blue = 0;
        Es_j_redslider.setProgress(0);
        Es_j_greeslider.setProgress(0);
        Es_j_blueslider.setProgress(0);
    }

    private void setslidercolor()
    {
        Et_J_Redint.setText("" + red);
        Et_J_Greenint.setText( "" + green);
        Et_J_Blueint.setText("" + blue);
    }
    public void onSliderChanged()
    {
        Es_j_redslider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                red = seekBar.getProgress();
                setslidercolor();
                hexcodebackground();
                changedtextcolor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Es_j_greeslider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                green = seekBar.getProgress();
                setslidercolor();
                hexcodebackground();
                changedtextcolor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
        Es_j_blueslider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                blue = seekBar.getProgress();
                setslidercolor();
                hexcodebackground();
                changedtextcolor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void hexcodebackground()
    {
     hexcolor = String.format("#%02x%02x%02x", red, green, blue);
        setbackgroundcolor(hexcolor);
    }

    private void fillcolorlist()
    {
        adapter = new Color_Cell(this, listofcolors);
        Elv_J_Colorlist.setAdapter(adapter);
    }
    private  void editcolor()
    {
        Elv_J_Colorlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private  void getadpatorcolors()
    {
        
    }


}