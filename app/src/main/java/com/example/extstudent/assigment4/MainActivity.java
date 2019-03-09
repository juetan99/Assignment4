package com.example.extstudent.assigment4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button firstButton = null;
    LinearLayout linearLayout = null;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout)findViewById(R.id.scrollViewLayout);

        firstButton = (Button)findViewById(R.id.btnSubmit);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewButton();
            }
        });


    }
        private void generateNewButton() {
           final Button newButton = new Button(MainActivity.this);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            newButton.setLayoutParams(layoutParams);

            newButton.setText("PRESS ME: " + Integer.toString(++count));
            newButton.setTextColor(getRandomColor());

            newButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    generateNewButton();
                    newButton.setEnabled(false);
                }
            });

            linearLayout.addView(newButton);

        }

        private int getRandomColor() {
            Random rnd = new Random();
            return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        }

}
