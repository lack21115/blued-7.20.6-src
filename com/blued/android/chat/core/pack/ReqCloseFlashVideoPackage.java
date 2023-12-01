package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqCloseFlashVideoPackage.class */
public class ReqCloseFlashVideoPackage extends ReqBasePackage {
    public final long matchedUid;
    public final int reason;
    public final String roomId;

    public ReqCloseFlashVideoPackage(long j, String str, int i, long j2) {
        super((short) 20, j2);
        this.matchedUid = j;
        this.roomId = str;
        this.reason = i;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("room_id", this.roomId);
        arrayMap.put("uid", Long.valueOf(this.matchedUid));
        arrayMap.put("reason", Integer.valueOf(this.reason));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[uid:" + this.matchedUid + ", roomId:" + this.roomId + ", reason:" + this.reason + "]";
    }
}
