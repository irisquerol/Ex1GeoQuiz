package com.androidpprog2.com.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidpprog2.com.R;

public class QuizActivity extends AppCompatActivity {
    private int count = 0;

    private TextView question;

    private Button trueBtn;
    private Button falseBtn;
    private Button restartBtn;

    private String[] questions;
    private int[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questions = getResources().getStringArray(R.array.questions);
        answers = getResources().getIntArray(R.array.answers);

        question = findViewById(R.id.question);
        question.setText(questions[count]);

        trueBtn = findViewById(R.id.true_button);
        falseBtn = findViewById(R.id.false_button);
        restartBtn = findViewById(R.id.reset_button);

        restartBtn.setOnClickListener(view -> restartQuiz());

        trueBtn.setOnClickListener(view -> verifyCorrectOrIncorrect(answers[count], 1));

        falseBtn.setOnClickListener(view -> verifyCorrectOrIncorrect(answers[count], 0));

    }

    private void verifyCorrectOrIncorrect(int answer, int isTrue) {
        if (answer == isTrue) {
            //correct
            count++;
            if (count > 4) {
                showEndAndRestartButton();
            } else {
                question.setText(questions[count]);
            }
            showToast(1);
        } else {
            //incorrect
            showToast(0);
        }
    }

    private void showToast(int type) {
        Toast t;

        if (type == 1) {
            t = Toast.makeText(QuizActivity.this,
                    R.string.correct_toast, Toast.LENGTH_SHORT);
        } else {
            t = Toast.makeText(QuizActivity.this,
                    R.string.incorrect_toast, Toast.LENGTH_SHORT);
        }

        t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        t.show();
    }

    private void showEndAndRestartButton() {
        question.setText(R.string.finished);
        question.setGravity(Gravity.CENTER);

        falseBtn.setVisibility(View.GONE);
        trueBtn.setVisibility(View.GONE);

        restartBtn.setVisibility(View.VISIBLE);
    }

    private void restartQuiz() {
        count = 0;
        question.setText(questions[count]);

        restartBtn.setVisibility(View.GONE);

        falseBtn.setVisibility(View.VISIBLE);
        trueBtn.setVisibility(View.VISIBLE);
    }
}