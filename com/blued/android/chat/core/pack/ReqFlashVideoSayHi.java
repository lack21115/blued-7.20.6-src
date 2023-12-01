package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqFlashVideoSayHi.class */
public class ReqFlashVideoSayHi extends ReqBasePackage {
    public final long matchedUid;
    public final String roomId;

    public ReqFlashVideoSayHi(long j, String str, long j2) {
        super((short) 39, j2);
        this.matchedUid = j;
        this.roomId = str;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(TTLiveConstants.ROOMID_KEY, this.roomId);
        arrayMap.put("uid", Long.valueOf(this.matchedUid));
        return arrayMap;
    }
}
