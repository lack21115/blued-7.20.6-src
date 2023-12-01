package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STCondition.class */
public class STCondition {
    private int preState;
    private int preStateModuleId;
    private int triggerCount;
    private STTriggerEvent[] triggers;

    public int getPreState() {
        return this.preState;
    }

    public int getPreStateModuleId() {
        return this.preStateModuleId;
    }

    public int getTriggerCount() {
        return this.triggerCount;
    }

    public STTriggerEvent[] getTriggers() {
        return this.triggers;
    }

    public void setPreState(int i) {
        this.preState = i;
    }

    public void setPreStateModuleId(int i) {
        this.preStateModuleId = i;
    }

    public void setTriggerCount(int i) {
        this.triggerCount = i;
    }

    public void setTriggers(STTriggerEvent[] sTTriggerEventArr) {
        this.triggers = sTTriggerEventArr;
    }
}
