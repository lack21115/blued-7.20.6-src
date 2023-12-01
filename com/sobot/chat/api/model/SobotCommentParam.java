package com.sobot.chat.api.model;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotCommentParam.class */
public class SobotCommentParam {
    int commentType;
    int isresolve = 0;
    String problem;
    String robotFlag;
    String score;
    int scoreFlag;
    String suggest;
    String type;

    public int getCommentType() {
        return this.commentType;
    }

    public int getIsresolve() {
        return this.isresolve;
    }

    public String getProblem() {
        return this.problem;
    }

    public String getRobotFlag() {
        return this.robotFlag;
    }

    public String getScore() {
        return this.score;
    }

    public int getScoreFlag() {
        return this.scoreFlag;
    }

    public String getSuggest() {
        return this.suggest;
    }

    public String getType() {
        return this.type;
    }

    public void setCommentType(int i) {
        this.commentType = i;
    }

    public void setIsresolve(int i) {
        this.isresolve = i;
    }

    public void setProblem(String str) {
        this.problem = str;
    }

    public void setRobotFlag(String str) {
        this.robotFlag = str;
    }

    public void setScore(String str) {
        this.score = str;
    }

    public void setScoreFlag(int i) {
        this.scoreFlag = i;
    }

    public void setSuggest(String str) {
        this.suggest = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
