package com.androidpprog2.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] questions = getResources().getStringArray(R.array.questions);
        int[] answers = getResources().getIntArray(R.array.answers);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView question = findViewById(R.id.question);
        question.setText(questions[cont]);

        Button trueBtn = findViewById(R.id.true_button);
        Button falseBtn = findViewById(R.id.false_button);
        trueBtn.setOnClickListener(view -> {
            //click true
            if (answers[cont] == 1) {
                //correct
                cont++;
                if (cont > 4) {
                    question.setText(R.string.finished);
                    falseBtn.setVisibility(View.INVISIBLE);
                    trueBtn.setVisibility(View.INVISIBLE);
                } else {
                    question.setText(questions[cont]);
                }
                Toast t = Toast.makeText(MainActivity.this,
                        R.string.correct_toast, Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                t.show();


            } else {
                //incorrect
                Toast t = Toast.makeText(MainActivity.this,
                        R.string.incorrect_toast, Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                t.show();
            }


        });

        falseBtn.setOnClickListener(view -> {
            //click false
            if (answers[cont] == 0) {
                //correct
                cont++;

                if (cont > 4) {
                    question.setText(R.string.finished);
                    falseBtn.setVisibility(View.INVISIBLE);
                    trueBtn.setVisibility(View.INVISIBLE);
                } else {
                    question.setText(questions[cont]);
                }
                Toast t = Toast.makeText(MainActivity.this,
                        R.string.correct_toast, Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                t.show();

            } else {
                //incorrect
                Toast t = Toast.makeText(MainActivity.this,
                        R.string.incorrect_toast, Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                t.show();
            }

        });

    }
}