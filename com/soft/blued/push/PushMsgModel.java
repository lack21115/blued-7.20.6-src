package com.soft.blued.push;

import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/push/PushMsgModel.class */
public class PushMsgModel implements Serializable {
    public LiveMsgShareEntity extra;
    public long session_id;
    public short session_type;

    public String toString() {
        return "PushMsgModel{session_type=" + ((int) this.session_type) + ", session_id=" + this.session_id + ", extra=" + this.extra + '}';
    }
}
