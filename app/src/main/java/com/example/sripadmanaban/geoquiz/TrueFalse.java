package com.example.sripadmanaban.geoquiz;

/**
 * Class to hold the true or false answer
 * Created by Sripadmanaban on 3/16/2015.
 */
public class TrueFalse {

    private boolean mTrueQuestion;

    private int mQuestion;

    public TrueFalse(int mQuestion, boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
        this.mQuestion = mQuestion;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }
}
