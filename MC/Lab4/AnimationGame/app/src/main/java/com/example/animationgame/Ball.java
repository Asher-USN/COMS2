package com.example.animationgame;

public class Ball {

    double x,y,xspeed,yspeed,max_x,max_y;

    public Ball(double x, double y, double xspeed, double yspeed, double max_x, double max_y) {
        this.x = x;
        this.y = y;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.max_x = max_x;
        this.max_y = max_y;
    }

    public void update(double yAcc){
        yspeed += yAcc;
        y += yspeed;
        x += xspeed;

        if(y>= max_y || y<=0){
            y*=-0.8;
        }

        if(x>= max_x || x<=0){
            x*=-0.8;
        }



    }
}
