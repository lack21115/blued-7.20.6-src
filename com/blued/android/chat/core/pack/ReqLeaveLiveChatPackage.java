package com.blued.android.chat.core.pack;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqLeaveLiveChatPackage.class */
public class ReqLeaveLiveChatPackage extends ReqBasePackage {
    public final String from;
    public final long sessionId;
    public final short sessionType;

    public ReqLeaveLiveChatPackage(short s, long j, long j2, String str) {
        super((short) 7, j2);
        this.sessionType = s;
        this.sessionId = j;
        this.from = str;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, Short.valueOf(this.sessionType));
        arrayMap.put("session_id", Long.valueOf(this.sessionId));
        if (!TextUtils.isEmpty(this.from)) {
            arrayMap.put("from", this.from);
        }
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", from:" + this.from + "]";
    }
}
