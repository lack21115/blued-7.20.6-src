package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqWawajiControllerUploadResultPackage.class */
public class ReqWawajiControllerUploadResultPackage extends ReqBasePackage {
    public final String orderId;
    public final int result;
    public final long sessionId;
    public final long userId;

    public ReqWawajiControllerUploadResultPackage(long j, long j2, String str, int i, long j3) {
        super((short) 28, j3);
        this.sessionId = j;
        this.userId = j2;
        this.orderId = str;
        this.result = i;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, (short) 6);
        arrayMap.put("session_id", Long.valueOf(this.sessionId));
        arrayMap.put("uid", Long.valueOf(this.userId));
        arrayMap.put("order_id", this.orderId);
        arrayMap.put("result", Integer.valueOf(this.result));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionId:" + this.sessionId + ", userId:" + this.userId + ", orderId:" + this.orderId + ", result:" + this.result + "]";
    }
}
