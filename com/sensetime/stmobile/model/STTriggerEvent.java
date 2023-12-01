package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STTriggerEvent.class */
public class STTriggerEvent {
    private boolean isAppear;
    private int moduleId;
    private long trigger;
    private int triggerType;

    public int getModuleId() {
        return this.moduleId;
    }

    public long getTrigger() {
        return this.trigger;
    }

    public int getTriggerType() {
        return this.triggerType;
    }

    public boolean isAppear() {
        return this.isAppear;
    }

    public void setAppear(boolean z) {
        this.isAppear = z;
    }

    public void setModuleId(int i) {
        this.moduleId = i;
    }

    public void setTrigger(long j) {
        this.trigger = j;
    }

    public void setTriggerType(int i) {
        this.triggerType = i;
    }
}
