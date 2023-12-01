package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqStartJoinLive.class */
public class ReqStartJoinLive extends ReqBasePackage {
    public final long invitedUid;
    public final long sessionId;
    public final short sessionType;

    public ReqStartJoinLive(short s, long j, long j2, long j3) {
        super((short) 10, j3);
        this.sessionType = s;
        this.sessionId = j;
        this.invitedUid = j2;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, Short.valueOf(this.sessionType));
        arrayMap.put("session_id", Long.valueOf(this.sessionId));
        long j = this.invitedUid;
        if (j > 0) {
            arrayMap.put("invited_uid", Long.valueOf(j));
        }
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", invitedUid:" + this.invitedUid + "]";
    }
}
