package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqCloseLiveChatPackage.class */
public class ReqCloseLiveChatPackage extends ReqBasePackage {
    public final long sessionId;
    public final short sessionType;
    private int stopReason;

    public ReqCloseLiveChatPackage(short s, long j, long j2) {
        super((short) 4, j2);
        this.sessionType = s;
        this.sessionId = j;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, Short.valueOf(this.sessionType));
        arrayMap.put("session_id", Long.valueOf(this.sessionId));
        int i = this.stopReason;
        if (i != 0) {
            arrayMap.put("stop_reason", Integer.valueOf(i));
        }
        return arrayMap;
    }

    public void setReason(int i) {
        this.stopReason = i;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + "]";
    }
}
