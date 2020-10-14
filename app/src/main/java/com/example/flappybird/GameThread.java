package com.example.flappybird;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread{

    SurfaceHolder surfaceHolder;
    boolean isRunning; // flag to detect whether the thread is running
    long startTime, loopTime;
    long DELAY = 33;

    public GameThread(SurfaceHolder surfaceHolder){
        this.surfaceHolder = surfaceHolder;
        isRunning = true;

    }

    @Override
    public void run(){
        // Looping until boolean is false
        while(isRunning){
            startTime = SystemClock.uptimeMillis();
            // locking the canvas
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if(canvas != null){
                synchronized (surfaceHolder){
                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);
                    AppConstants.getGameEngine().updateAndDrawBird(canvas);
                    AppConstants.getGameEngine().updateAndDrawTubes(canvas);
                    // unlocking the canvas
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            // loop time
            loopTime = SystemClock.uptimeMillis() - startTime;
            // Pausing here to make sure we update the right amount per second
            if(loopTime < DELAY){
                try {
                    Thread.sleep(DELAY - loopTime);
                } catch (InterruptedException e) {
                    Log.e("Interrupted", "Interrupted while sleeping");
                }
            }
        }
    }

    // Return whether the thread is running
    public boolean isRunning(){
        return isRunning;
    }

    // Set the thread state, false = stopped, true = running
    public void setIsRunning(boolean state){
        isRunning = state;
    }
}
