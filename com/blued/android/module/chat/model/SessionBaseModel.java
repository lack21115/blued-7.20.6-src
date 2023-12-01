package com.blued.android.module.chat.model;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/model/SessionBaseModel.class */
public class SessionBaseModel {
    private long loadName;
    private long sessionId;
    private short sessionType;

    public long getLoadName() {
        return this.loadName;
    }

    public long getSessionId() {
        return this.sessionId;
    }

    public short getSessionType() {
        return this.sessionType;
    }

    public void setLoadName(long j) {
        this.loadName = j;
    }

    public void setSessionId(long j) {
        this.sessionId = j;
    }

    public void setSessionType(short s) {
        this.sessionType = s;
    }

    public String toString() {
        return "SessionBaseModel{sessionId=" + this.sessionId + ", sessionType=" + ((int) this.sessionType) + ", loadName=" + this.loadName + '}';
    }
}
