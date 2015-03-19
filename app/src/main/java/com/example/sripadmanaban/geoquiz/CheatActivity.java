package com.example.sripadmanaban.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This activity shows the answer for the question that is shown currently
 * Created by Sripadmanaban on 3/18/2015.
 */
public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.example.sripadmanaban.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_IS_SHOWN =
            "com.example.sripadmanaban.geoquiz.answer_shown";

    private boolean mAnswerIsTrue;
    private boolean mAnswerShown;

    private Button mShowAnswerButton;

    private TextView mAnswerTextView;
    private TextView mApiLevelTextView;

    private static final String ANSWER_SHOWN = "Answer_shown";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        if(savedInstanceState != null) {
            mAnswerShown = savedInstanceState.getBoolean(ANSWER_SHOWN, false);
        }

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
        mApiLevelTextView = (TextView) findViewById(R.id.apiLevel);

        mApiLevelTextView.setText("The API Level is " + Build.VERSION.SDK_INT);

        showAnswer(mAnswerShown);

        mShowAnswerButton = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnswerShown = true;
                showAnswer(mAnswerShown);
                startAnswerShownResult(mAnswerShown);

            }
        });

        startAnswerShownResult(mAnswerShown);
    }

    private void startAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_IS_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ANSWER_SHOWN, mAnswerShown);
    }

    private void showAnswer(boolean answerShown) {
        if(answerShown) {
            if(mAnswerIsTrue) {
                mAnswerTextView.setText(R.string.true_button);
            } else {
                mAnswerTextView.setText(R.string.false_button);
            }
        }
    }
}
