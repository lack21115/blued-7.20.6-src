package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotRobot.class */
public class SobotRobot implements Serializable {
    private int guideFlag;
    private boolean isSelected;
    private String operationRemark;
    private String robotFlag;
    private String robotHelloWord;
    private String robotLogo;
    private String robotName;

    public int getGuideFlag() {
        return this.guideFlag;
    }

    public String getOperationRemark() {
        return this.operationRemark;
    }

    public String getRobotFlag() {
        return this.robotFlag;
    }

    public String getRobotHelloWord() {
        return this.robotHelloWord;
    }

    public String getRobotLogo() {
        return this.robotLogo;
    }

    public String getRobotName() {
        return this.robotName;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setGuideFlag(int i) {
        this.guideFlag = i;
    }

    public void setOperationRemark(String str) {
        this.operationRemark = str;
    }

    public void setRobotFlag(String str) {
        this.robotFlag = str;
    }

    public void setRobotHelloWord(String str) {
        this.robotHelloWord = str;
    }

    public void setRobotLogo(String str) {
        this.robotLogo = str;
    }

    public void setRobotName(String str) {
        this.robotName = str;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
