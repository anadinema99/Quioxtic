package com.assasin.quizappmodule;

public class Question {
    private int answerRedID;
    private boolean answerTrue;

    public Question(int answerRedID, boolean answerTrue) {
        this.answerRedID = answerRedID;
        this.answerTrue = answerTrue;
    }

    public int getAnswerRedID() {
        return answerRedID;
    }

    public void setAnswerRedID(int answerRedID) {
        this.answerRedID = answerRedID;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
