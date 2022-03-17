package com.example.problem2;
//using drawLine to connect the corners of a panel

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DrawingProblem2 extends JPanel {
    @Override
    //draws an X from the corners of the panel
    public void paintComponent(Graphics g) {
        //call paintComponent to ensure the panel displays correctly
        super.paintComponent(g);
        int width = getWidth();//total width
        int height = getHeight();//total height

        //lower left corner
        int x1 = 0, y1 = 0, x2 = 0, y2 = height;
        g.setColor(Color.ORANGE.darker());
        while (y1 < height) {
            g.drawLine(x1, y1, x2, y2);
            y1 += 15;
            x2 += 15;
        }
        //upper right corner

        int z1 = 0, p1 = 0, z2 = height, p2 = 0;
        while (z1 < height) {
            g.drawLine(z1, p1, z2, p2);
            z1 += 15;
            p2 += 15;
        }

        //upper left corner

        int t1 = 0, q1 = 0, t2 = 0, q2 = height;
        int counter = 1;
        while (counter <= 15) {
            g.drawLine((int)t1, (int)q1,(int) t2,(int) q2);
            t2 += width / 15;
            q2 -= height / 15;
            counter++;
        }
    }//end method paintComponent

    public static void main(String[] args) {
        //create a panel that contains our drawing
        DrawingProblem2 panel = new DrawingProblem2();
        //create a new frame to hold the panel
        JFrame application = new JFrame();

        //set the frame to exit when it is closed
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel); // add the panel to the frame
        application.setSize(250, 250); // set the size of the frame
        application.setVisible(true); // make the frame visible
    }//end main
}//end class DrawingProblem2