package com.example.homework02_program1;

import android.util.Log;

public class ColorController {
    private int red;
    private int green;
    private int blue;
    private String hexcolor;
    private Boolean iswhitetext;

    public ColorController()
    {

    }
    public ColorController(int r, int g, int b)
    {
        red = r;
        green = g;
        blue = b;
    }
    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public String getHexcolor() {
        return hexcolor;
    }

    public void setHexcolor(String h)
    {
        hexcolor = h;
        //i cant belive that this worked. like why isn't tohexstring in the hex format
        //most people how want hex, want the hex format not an int
        //Log.d("Hexcolor: ", String.format("#%02x%02x%02x", r, g, b));
    }

    public Boolean getIswhitetext() {
        return iswhitetext;
    }

    public void setIswhitetext(Boolean iswhitetext) {
        this.iswhitetext = iswhitetext;
    }
}
