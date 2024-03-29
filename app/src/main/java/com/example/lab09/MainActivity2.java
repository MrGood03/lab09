package com.example.lab09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText EXMax;
    EditText NOfP;
    EditText EXMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EXMax= findViewById(R.id.EditXmax);
        EXMin= findViewById(R.id.EditXmin);
        NOfP=findViewById(R.id.NOP);
    }
    public void  onSurface (View v )
    {

        float xMin, xMax;
        int points;

        try {
            xMin = Float.parseFloat(EXMin.getText().toString());
            xMax = Float.parseFloat(EXMax.getText().toString());
            points = Integer.parseInt(NOfP.getText().toString());
        }
        catch (Exception ex)
        {

            Toast.makeText(this, "Input was incorrect", Toast.LENGTH_SHORT).show();
            return;
        }


        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("points",points  );
        intent.putExtra("xMin", xMin);
        intent.putExtra("xMax", xMax);

        startActivityForResult(intent, 414);
    }


}