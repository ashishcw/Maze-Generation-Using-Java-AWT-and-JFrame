package org.example;

import org.example.constant.Constants;
import org.example.display.Window;

import java.awt.*;

public class Main extends Canvas implements Runnable {

    private Window window;
    private Thread thread;

    private boolean isRunning = false;

    public Main(){
        //instantiate window code from here
        if(this.window == null){
            this.window = new Window(this);
        }


        init();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        new Main();
    }

    private void init(){
        if(this.thread == null){
            this.thread = new Thread(this, "Additional_Thread_1");
        }


        start();
    }

    @Override
    public void run(){
        mainLoop();
    }

    private synchronized void start(){
        if(this.isRunning){
            return;
        }

        if(this.thread != null){
            this.thread.start();
        }
        this.isRunning = true;
    }

    private synchronized void stop(){
        if(!this.isRunning){
            return;
        }

        if(this.thread != null){
            try{
                this.thread.join();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

        isRunning = false;
    }

    private void mainLoop(){
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

        long lastLoopTime = System.nanoTime();
        long lastFpsTime = 0;

        while (this.isRunning) {
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;

            double delta = updateLength / ((double) OPTIMAL_TIME);

            lastFpsTime += updateLength;
            if (lastFpsTime >= 1000000000) {
                lastFpsTime = 0;
            }

            // Update game logic based on delta
            tick();

            // Repaint or render the game
            render();



            try {
                // Sleep to maintain frame rate
                long gameTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
                Thread.sleep(gameTime);
            } catch (Exception e) {
                // Handle exceptions
                this.isRunning = false;
            }
        }
        stop();
    }
    private void render(){
        var bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        //additional render calls go here

        bs.show();
        g.dispose();
    }

    private void tick(){

    }


}