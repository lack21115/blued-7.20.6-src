package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqCloseVideoChatPackage.class */
public class ReqCloseVideoChatPackage extends ReqBasePackage {
    public final long chatTimeSec;
    public final int closeReason;
    public final String roomId;

    public ReqCloseVideoChatPackage(String str, int i, long j, long j2) {
        super((short) 14, j2);
        this.roomId = str;
        this.closeReason = i;
        this.chatTimeSec = j;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(TTLiveConstants.ROOMID_KEY, this.roomId);
        arrayMap.put("reason", Integer.valueOf(this.closeReason));
        arrayMap.put("total_time", Long.valueOf(this.chatTimeSec));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[roomId:" + this.roomId + ", closeReason:" + this.closeReason + ", chatTimeSec:" + this.chatTimeSec + "]";
    }
}
