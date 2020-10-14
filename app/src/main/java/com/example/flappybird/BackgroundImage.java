package com.example.flappybird;

public class BackgroundImage {

    private int backgroundImageX, backgroundImageY, backgroundImageVelocity;
    public BackgroundImage(){
        backgroundImageX = 0;
        backgroundImageY = 0;
        backgroundImageVelocity = 3;
    }

    // Getter methods for getting the X and Y coordinates
    public int getX(){
        return backgroundImageX;
    }

    public int getY(){
        return backgroundImageY;
    }

    // Setter methods for setting the X and Y coordinates
    public void setX(int backgroundImageX){
        this.backgroundImageX = backgroundImageX;
    }

    public void setY(int backgroundImageY){
        this.backgroundImageY = backgroundImageY;
    }

    // Getter method for getting the velocity
    public int getVelocity(){
        return backgroundImageVelocity;
    }
}
