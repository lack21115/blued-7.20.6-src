package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqLiveChatStopTalkPackage.class */
public class ReqLiveChatStopTalkPackage extends ReqBasePackage {
    public final int enable;
    public final long sessionId;
    public final short sessionType;
    public final long stopTalkUid;

    public ReqLiveChatStopTalkPackage(short s, long j, long j2, int i, long j3) {
        super((short) 5, j3);
        this.sessionType = s;
        this.sessionId = j;
        this.stopTalkUid = j2;
        this.enable = i;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, Short.valueOf(this.sessionType));
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID, Long.valueOf(this.sessionId));
        arrayMap.put("uid", Long.valueOf(this.stopTalkUid));
        arrayMap.put("enable", Integer.valueOf(this.enable));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", stopTalkUid:" + this.stopTalkUid + ", enable:" + this.enable + "]";
    }
}
