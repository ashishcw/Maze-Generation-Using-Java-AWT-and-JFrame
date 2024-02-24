package org.example.display;

import org.example.Main;
import org.example.constant.Constants;

import javax.swing.*;
import java.awt.*;

public class Window {

    private Main main;
    private JFrame frame;

    public Window(Main mainParameter) {
        this.main = mainParameter;
        init();
    }

    private void init(){
        if(this.frame == null){
            this.frame = new JFrame();
        }

        this.frame.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.frame.setMaximumSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.frame.setMinimumSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));

        this.frame.setTitle("Maze Generation - 1");

        this.frame.setResizable(false);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
        this.frame.add(this.main);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame.pack();
    }


}
