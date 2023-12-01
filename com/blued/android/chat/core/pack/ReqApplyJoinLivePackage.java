package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqApplyJoinLivePackage.class */
public class ReqApplyJoinLivePackage extends ReqBasePackage {
    public final long answerId;
    public final long sessionId;
    public final short sessionType;

    public ReqApplyJoinLivePackage(short s, long j, long j2, long j3) {
        super((short) 11, j2);
        this.sessionType = s;
        this.sessionId = j;
        this.answerId = j3;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, Short.valueOf(this.sessionType));
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID, Long.valueOf(this.sessionId));
        arrayMap.put("answer", Long.valueOf(this.answerId));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", answerId:" + this.answerId + "]";
    }
}
