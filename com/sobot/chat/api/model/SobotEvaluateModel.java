package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotEvaluateModel.class */
public class SobotEvaluateModel implements Serializable {
    private int isQuestionFlag;
    private String problem;
    private int evaluateStatus = 0;
    private int isResolved = 0;
    private int score = 0;
    private int scoreFlag = 0;

    public int getEvaluateStatus() {
        return this.evaluateStatus;
    }

    public int getIsQuestionFlag() {
        return this.isQuestionFlag;
    }

    public int getIsResolved() {
        return this.isResolved;
    }

    public String getProblem() {
        return this.problem;
    }

    public int getScore() {
        return this.score;
    }

    public int getScoreFlag() {
        return this.scoreFlag;
    }

    public void setEvaluateStatus(int i) {
        this.evaluateStatus = i;
    }

    public void setIsQuestionFlag(int i) {
        this.isQuestionFlag = i;
    }

    public void setIsResolved(int i) {
        this.isResolved = i;
    }

    public void setProblem(String str) {
        this.problem = str;
    }

    public void setScore(int i) {
        this.score = i;
    }

    public void setScoreFlag(int i) {
        this.scoreFlag = i;
    }
}
