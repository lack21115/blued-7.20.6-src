package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqDestroyMsgPackage.class */
public class ReqDestroyMsgPackage extends ReqBasePackage {
    public final long msgId;
    public final long sessionId;
    public final short sessionType;

    public ReqDestroyMsgPackage(short s, long j, long j2, long j3) {
        super((short) 2, j3);
        this.sessionType = s;
        this.sessionId = j;
        this.msgId = j2;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, Short.valueOf(this.sessionType));
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID, Long.valueOf(this.sessionId));
        arrayMap.put("msg_id", Long.valueOf(this.msgId));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", msgId:" + this.msgId + "]";
    }
}
