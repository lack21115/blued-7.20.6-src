package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.anythink.core.common.b.e;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqNotifyLiveJoinStartPackage.class */
public class ReqNotifyLiveJoinStartPackage extends ReqBasePackage {
    public final String name;
    public final long sessionId;
    public final short sessionType;
    public final long startTime;
    public final long uid;

    public ReqNotifyLiveJoinStartPackage(short s, long j, long j2, String str, long j3, long j4) {
        super((short) 31, j4);
        this.sessionType = s;
        this.sessionId = j;
        this.uid = j2;
        this.name = str;
        this.startTime = j3;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, Short.valueOf(this.sessionType));
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID, Long.valueOf(this.sessionId));
        arrayMap.put("uid", Long.valueOf(this.uid));
        arrayMap.put("name", this.name);
        arrayMap.put(e.a, Long.valueOf(this.startTime));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", uid:" + this.uid + ", name:" + this.name + ", startTime:" + this.startTime + "]";
    }
}
