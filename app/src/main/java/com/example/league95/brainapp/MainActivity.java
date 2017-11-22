package com.example.league95.brainapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6;
    TextView textView1, textView2, textView3, textView4;
    //Random number generator
    Random rng;
    int rand,
        rand2,
        rand3,
        comp,
        comp2,
        comp3,
        comp4,
    currScore = 0,
    finaScore = 0;
    //Count down timer
    CountDownTimer ct;
    //while playing
    boolean isPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize all buttons
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        //make them invisible at the start of the app.
        //Same with text views
        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        //invisible
        setVis(View.INVISIBLE, View.VISIBLE);
        btn6.setVisibility(View.INVISIBLE);


    }

    public void go(View view)
    {
        isPlaying = true;
        textView4.setVisibility(View.INVISIBLE);
        currScore = 0;
        finaScore = 0;
        textView2.setText(currScore + "/" + finaScore);
        generate();
        setBtn(String.valueOf(rand), String.valueOf(comp2), String.valueOf(comp3), String.valueOf(comp4));
        setVis(View.VISIBLE, View.INVISIBLE);
        btn6.setVisibility(View.INVISIBLE);
        textView3.setText(comp + " + " + rand2);
        ct = new CountDownTimer(30000 + 100, 1000) {
            @Override
            public void onTick(long l) {
                textView1.setText(l/1000+"s");
            }

            @Override
            public void onFinish() {
                textView1.setText(0+"s");
                isPlaying = false;
                textView4.setText("Score: " + currScore +"/" + finaScore);
                textView4.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.VISIBLE);
            }
        }.start();

    }


    public void choose(View view)
    {

        if (isPlaying) {
            //increment final score
            finaScore++;
            switch (view.getId()) {
                case R.id.button1:
                    if (Integer.parseInt(btn1.getText().toString()) == rand) {
                        currScore++;
                        textView4.setText("Correct!");
                    } else
                    {
                        textView4.setText("Wrong!");
                    }
                    break;
                case R.id.button2:
                    if (Integer.parseInt(btn2.getText().toString()) == rand) {
                        currScore++;
                        textView4.setText("Correct!");
                    } else
                    {
                        textView4.setText("Wrong!");
                    }
                    break;
                case R.id.button3:
                    if (Integer.parseInt(btn3.getText().toString()) == rand) {
                        currScore++;
                        textView4.setText("Correct!");
                    } else
                    {
                        textView4.setText("Wrong!");
                    }
                    break;
                default:
                    if (Integer.parseInt(btn4.getText().toString()) == rand) {
                        currScore++;
                        textView4.setText("Correct!");
                    } else
                    {
                        textView4.setText("Wrong!");
                    }
                    break;
            }
            generate();
            setBtn(String.valueOf(rand), String.valueOf(comp2), String.valueOf(comp3), String.valueOf(comp4));
            textView4.setVisibility(View.VISIBLE);
            textView3.setText(comp + " + " + rand2);
            textView2.setText(currScore + "/" + finaScore);
        }
    }

    public void setVis(int vis, int go)
    {
        btn5.setVisibility(go);
        btn1.setVisibility(vis);
        btn2.setVisibility(vis);
        btn3.setVisibility(vis);
        btn4.setVisibility(vis);
        textView1.setVisibility(vis);
        textView2.setVisibility(vis);
        textView3.setVisibility(vis);
    }

    public void generate()
    {
        //rng = new Random();
        rand = 5 + (int)(Math.random()*((1000-670)+1));
        rand2= 5 + (int)(Math.random()*((660-290)+1));
        rand3= 5 + (int)(Math.random()*((280-200)+1));
        comp = rand - rand2;
        comp2= rand - rand3;
        rand3= 5 + (int)Math.random()*((280-200)+1);
        comp3= rand - rand3;
        rand3= 5 + (int)Math.random()*((280-200)+1);
        comp4= rand - comp3;
    }

    public void setBtn(String btn1, String btn2, String btn3, String btn4)
    {
        rng = new Random();
        int rd = 1 + rng.nextInt(4);
        if (rd == 1)
        {
            nameBtn(btn2,btn3,btn4,btn1);
        } else if (rd == 2)
        {
            nameBtn(btn3,btn4,btn1,btn2);
        } else if (rd == 3)
        {
            nameBtn(btn1,btn3,btn2,btn4);
        } else {
            nameBtn(btn1,btn4,btn2,btn3);
        }

    }

    public void nameBtn(String btn1, String btn2, String btn3, String btn4)
    {
        this.btn1.setText(btn1);
        this.btn2.setText(btn2);
        this.btn3.setText(btn3);
        this.btn4.setText(btn4);
    }




}
