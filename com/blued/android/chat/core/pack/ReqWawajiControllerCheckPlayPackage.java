package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqWawajiControllerCheckPlayPackage.class */
public class ReqWawajiControllerCheckPlayPackage extends ReqBasePackage {
    public final long sessionId;
    public final short sessionType;

    public ReqWawajiControllerCheckPlayPackage(long j, long j2) {
        super((short) 29, j2);
        this.sessionType = (short) 6;
        this.sessionId = j;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, (short) 6);
        arrayMap.put("session_id", Long.valueOf(this.sessionId));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionId:" + this.sessionId + "]";
    }
}
