package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqLiveChatStatusChangePackage.class */
public class ReqLiveChatStatusChangePackage extends ReqBasePackage {
    public final int liveStatus;
    public final long sessionId;
    public final short sessionType;

    public ReqLiveChatStatusChangePackage(short s, long j, int i, long j2) {
        super((short) 35, j2);
        this.sessionType = s;
        this.sessionId = j;
        this.liveStatus = i;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, Short.valueOf(this.sessionType));
        arrayMap.put("session_id", Long.valueOf(this.sessionId));
        arrayMap.put("live_status", Integer.valueOf(this.liveStatus));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", liveStatus:" + this.liveStatus + "]";
    }
}
