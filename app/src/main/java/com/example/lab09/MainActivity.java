package com.example.lab09;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import math.interp;

public class MainActivity extends AppCompatActivity {
    MySurface s = null;
    String action="Match.tan";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        s = findViewById(R.id.mySurface);


        float xMin = intent.getFloatExtra("xMin", 0.0f);
        float xMax = intent.getFloatExtra("xMax", 0.0f);
        int points = intent.getIntExtra("points", 0);

        s.n=points;
        s.x=new float[s.n];
        s.y=new float[s.n];



    }
    public void btnBack (View v)
    {
        finish();
    }
    public void  ChangeGraf(View v)
    {
        final String[] action={"Sin","Cos","Tan","sqrt","Ex"};
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("ВЫбирете");
        builder.setSingleChoiceItems(action, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectAction =action[which];
                Intent intent = getIntent();
                s = findViewById(R.id.mySurface);
                float xMin = intent.getFloatExtra("xMin", 0.0f);
                float xMax = intent.getFloatExtra("xMax", 0.0f);
                int points = intent.getIntExtra("points", 0);
                s.n=points;
                s.x=new float[s.n];
                s.y=new float[s.n];
                if (selectAction=="Cos")
                {
                    for (int i=0;i<s.n;i++)
                    {
                        s.x[i]=interp.map(i,0,s.n-1,xMin,xMax);
                        s.y[i]=(float)  Math.cos(s.x[i]);
                    }
                }
                if (selectAction=="Sin")
                {
                    for (int i=0;i<s.n;i++)
                    {
                        s.x[i]=interp.map(i,0,s.n-1,xMin,xMax);
                        s.y[i]=(float)  Math.sin(s.x[i]);
                    }
                }
                if (selectAction=="Tan")
                {
                    for (int i=0;i<s.n;i++)
                    {
                        s.x[i]=interp.map(i,0,s.n-1,xMin,xMax);
                        s.y[i]=(float)  Math.tan(s.x[i]);
                    }
                }
                if (selectAction=="sqrt")
                {
                    for (int i=0;i<s.n;i++)
                    {
                        s.x[i]=interp.map(i,0,s.n-1,xMin,xMax);
                        s.y[i]=(float)  Math.sqrt(s.x[i]);
                    }
                }
                if (selectAction=="Ex")
                {
                    for (int i=0;i<s.n;i++)
                    {
                        s.x[i]=interp.map(i,0,s.n-1,xMin,xMax);
                        s.y[i]=(float)  Math.exp(s.x[i]);
                    }
                }


                s.update();
                s.invalidate();

            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();



    }
    public void btnScalePlus(View v)
    {
        s.scaleUp(2.f);
        s.invalidate();
    }

    public void btnScaleMinus(View v)
    {
        s.scaleDown(2.f);
        s.invalidate();
    }

    public void btnTransLeft(View v)
    {
        s.translateLeft(2.f);
        s.invalidate();
    }

    public void btnTransRight(View v)
    {
        s.translateRight(2.f);
        s.invalidate();
    }



}