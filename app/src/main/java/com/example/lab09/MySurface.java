package com.example.lab09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import math.arr;
import math.interp;

public class MySurface extends SurfaceView {
    Paint p;
    float xmin;
    float xmax;
    float ymin;
    float ymax;
    float[]x;
    float[]y;
    int n;
    float XMIN;
    float XMAX ;
    public void update()
    {

        xmin= arr.min(x,n);
        xmax=arr.max(x,n);
        ymin=arr.min(y,n);
        ymax=arr.max(y,n);
        XMIN = xmin;
        XMAX = xmax;
    }
    public MySurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        p=new Paint();
        p.setColor(Color.RED);
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.WHITE);
        int w=canvas.getWidth();
        int h = canvas.getHeight();
        float x0=0.0f, y0=0.0f;
        for (int i=0;i<n;i++)
        {
            float x1 = interp.map(x[i], xmin,xmax,0,w-1);
            float y1=interp.map(y[i],ymin,ymax,h-1,0);
            if(i>0)canvas.drawLine(x0,y0,x1,y1,p);
            x0=x1;
            y0=y1;

        }

    }
    public void scaleUp(float numb) {
        if (xmin + numb < xmax - numb) {
            xmax -= numb;
            xmin += numb;
        }
    }

    public void scaleDown(float numb) {
        if (xmin - numb > XMIN && xmax + numb < XMAX) {
            xmax += numb;
            xmin -= numb;
        }
        else {
            xmax = XMAX;
            xmin = XMIN;
        }
    }

    public void translateLeft(float numb) {
        if (xmin > XMIN) {
            xmax -= numb;
            xmin -= numb;
        }
    }

    public void translateRight(float numb) {
        if (xmax < XMAX) {
            xmax += numb;
            xmin += numb;
        }
    }
}
