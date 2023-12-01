package com.blued.android.chat.core.pack;

import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqWawajiQueueUpPackage.class */
public class ReqWawajiQueueUpPackage extends ReqBasePackage {
    public final long sessionId;
    public final short sessionType;

    public ReqWawajiQueueUpPackage(long j, long j2) {
        super((short) 26, j2);
        this.sessionType = (short) 6;
        this.sessionId = j;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        HashMap hashMap = new HashMap();
        hashMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, (short) 6);
        hashMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID, Long.valueOf(this.sessionId));
        return hashMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionId:" + this.sessionId + "]";
    }
}
