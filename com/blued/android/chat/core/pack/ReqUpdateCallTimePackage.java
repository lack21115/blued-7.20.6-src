package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqUpdateCallTimePackage.class */
public class ReqUpdateCallTimePackage extends ReqBasePackage {
    public final int callTimeSec;
    public final String roomId;

    public ReqUpdateCallTimePackage(String str, int i, long j) {
        super((short) 15, j);
        this.roomId = str;
        this.callTimeSec = i;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("room_id", this.roomId);
        arrayMap.put("total_time", Integer.valueOf(this.callTimeSec));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[roomId:" + this.roomId + ", callTimeSec:" + this.callTimeSec + "]";
    }
}
