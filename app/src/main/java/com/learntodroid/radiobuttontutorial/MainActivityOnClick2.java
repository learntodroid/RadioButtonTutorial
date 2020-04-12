package com.learntodroid.radiobuttontutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityOnClick2 extends AppCompatActivity implements View.OnClickListener {
    private Button submit;
    private RadioGroup radioGroup;
    private RadioButton answer1, answer2, answer3, answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_onclicklistener);

        radioGroup = findViewById(R.id.activity_main_answers);

        answer1 = findViewById(R.id.activity_main_onclicklistener_answer1);
        answer2 = findViewById(R.id.activity_main_onclicklistener_answer2);
        answer3 = findViewById(R.id.activity_main_onclicklistener_answer3);
        answer4 = findViewById(R.id.activity_main_onclicklistener_answer4);

        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);
        answer4.setOnClickListener(this);

        submit = findViewById(R.id.activity_main_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answerRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (answerRadioButtonId != -1) {
                    RadioButton answer = findViewById(answerRadioButtonId);
                    if (answer.getText().equals(getResources().getString(R.string.answer3))) {
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.correct_answer), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.incorrect_answer), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.missing_answer), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            Toast.makeText(getApplicationContext(), String.format("%s is checked", radioButton.getText()), Toast.LENGTH_SHORT).show();
        }
    }
}
