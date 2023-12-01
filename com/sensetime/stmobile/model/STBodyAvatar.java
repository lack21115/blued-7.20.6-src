package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STBodyAvatar.class */
public class STBodyAvatar {
    int bodyQuatCount;
    boolean isIdle;
    STQuaternion[] quaternions;

    public int getBodyQuatCount() {
        return this.bodyQuatCount;
    }

    public STQuaternion[] getQuaternions() {
        return this.quaternions;
    }

    public boolean isIdle() {
        return this.isIdle;
    }
}
