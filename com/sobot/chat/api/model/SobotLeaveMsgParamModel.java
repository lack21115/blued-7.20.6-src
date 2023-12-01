package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotLeaveMsgParamModel.class */
public class SobotLeaveMsgParamModel implements Serializable {
    private ArrayList<SobotFieldModel> field;

    public ArrayList<SobotFieldModel> getField() {
        return this.field;
    }

    public void setField(ArrayList<SobotFieldModel> arrayList) {
        this.field = arrayList;
    }

    public String toString() {
        return "SobotLeaveMsgParamModel{field=" + this.field + '}';
    }
}
