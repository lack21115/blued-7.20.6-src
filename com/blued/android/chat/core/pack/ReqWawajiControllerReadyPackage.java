package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqWawajiControllerReadyPackage.class */
public class ReqWawajiControllerReadyPackage extends ReqBasePackage {
    public final long sessionId;
    public final int sessionType;

    public ReqWawajiControllerReadyPackage(long j, long j2) {
        super((short) 22, j2);
        this.sessionType = 6;
        this.sessionId = j;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, 6);
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID, Long.valueOf(this.sessionId));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionId:" + this.sessionId + "]";
    }
}
