package com.example.animationgame;

public class Ball {

    double x, y, xspeed, yspeed, max_x, max_y;

    public Ball(double x, double y, double xspeed, double yspeed, double max_x, double max_y) {
        this.x = x;
        this.y = y;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.max_x = max_x;
        this.max_y = max_y;
    }

    public void update(double yAcc) {
        yspeed += yAcc;
        y += yspeed;
        x += xspeed;

        //vertical bounce
        if (y >= max_y) {
            y = max_y;
            yspeed *= -0.8;
        } else if (y <= 0) {
            y = 0;
            yspeed *= -0.8;
        }

        //horizontal bounce
        if (x >= max_x) {
            x = max_x;
            xspeed *= -0.8;
        } else if (x <= 0) {
            x = 0;
            xspeed *= -0.8;
        }


    }
}
