package com.learntodroid.radiobuttontutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityOnClick extends AppCompatActivity {
    private Button submit;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_onclick);

        radioGroup = findViewById(R.id.activity_main_answers);

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

    public void onQuizRadioButtonClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            Toast.makeText(getApplicationContext(), String.format("%s is checked", radioButton.getText()), Toast.LENGTH_SHORT).show();
        }
    }
}
