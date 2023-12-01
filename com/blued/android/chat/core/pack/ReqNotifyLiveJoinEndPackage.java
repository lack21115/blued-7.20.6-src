package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqNotifyLiveJoinEndPackage.class */
public class ReqNotifyLiveJoinEndPackage extends ReqBasePackage {
    public final long endTime;
    public final long sessionId;
    public final short sessionType;
    public final long uid;

    public ReqNotifyLiveJoinEndPackage(short s, long j, long j2, long j3, long j4) {
        super((short) 32, j4);
        this.sessionType = s;
        this.sessionId = j;
        this.uid = j2;
        this.endTime = j3;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, Short.valueOf(this.sessionType));
        arrayMap.put("session_id", Long.valueOf(this.sessionId));
        arrayMap.put("uid", Long.valueOf(this.uid));
        arrayMap.put("end_time", Long.valueOf(this.endTime));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", uid:" + this.uid + ", endTime:" + this.endTime + "]";
    }
}
