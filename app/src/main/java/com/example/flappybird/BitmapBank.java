package com.example.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap[] bird;
    Bitmap tubeTop, tubeBottom;
    Bitmap redTubeTop, redTubeBottom;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background = scaleImage(background);
        bird = new Bitmap[4];
        bird[0] = BitmapFactory.decodeResource(res, R.drawable.bird_frame1);
        bird[1] = BitmapFactory.decodeResource(res, R.drawable.bird_frame2);
        bird[2] = BitmapFactory.decodeResource(res, R.drawable.bird_frame3);
        bird[3] = BitmapFactory.decodeResource(res, R.drawable.bird_frame4);
        tubeTop = BitmapFactory.decodeResource(res, R.drawable.tube_top);
        tubeBottom = BitmapFactory.decodeResource(res, R.drawable.tube_bottom);
        redTubeTop = BitmapFactory.decodeResource(res, R.drawable.red_tube_top);
        redTubeBottom = BitmapFactory.decodeResource(res, R.drawable.red_tube_bottom);
    }

    // Return Red Tup-Top Bitmap
    public Bitmap getRedTubeTop(){
        return redTubeTop;
    }

    public Bitmap getRedTubeBottom(){
        return redTubeBottom;
    }

    // Return Tube-Top bitmap
    public Bitmap getTubeTop(){
        return tubeTop;
    }

    public Bitmap getTubeBottom(){
        return tubeBottom;
    }

    public int getTubeWidth(){
        return tubeTop.getWidth();
    }

    public int getTubeHeight(){
        return tubeTop.getHeight();
    }

    // Return bird bitmap of frame
    public Bitmap getBird(int frame){
        return bird[frame];
    }

    public int getBirdWidth(){
        return bird[0].getWidth();
    }

    public int getBirdHeight(){
        return bird[0].getHeight();
    }

    // Return background bitmap
    public Bitmap getBackground(){
        return background;
    }

    // Return background width
    public int getBackgroundWidth(){
        return background.getWidth();
    }

    // Return background height
    public int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();

        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaledWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}
