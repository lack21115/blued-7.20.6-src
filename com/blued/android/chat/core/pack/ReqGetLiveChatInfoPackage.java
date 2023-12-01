package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqGetLiveChatInfoPackage.class */
public class ReqGetLiveChatInfoPackage extends ReqBasePackage {
    public static final int GET_ALL = 0;
    public static final int GRT_VIEWERS = 1;
    public final int getType;
    public final long sessionId;
    public final short sessionType;

    public ReqGetLiveChatInfoPackage(short s, long j, int i, long j2) {
        super((short) 8, j2);
        this.sessionType = s;
        this.sessionId = j;
        this.getType = i;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, Short.valueOf(this.sessionType));
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID, Long.valueOf(this.sessionId));
        arrayMap.put("type", Integer.valueOf(this.getType));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", getType:" + this.getType + "]";
    }
}
