package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqVideoChatSwitchToAudioPackage.class */
public class ReqVideoChatSwitchToAudioPackage extends ReqBasePackage {
    public final String roomId;

    public ReqVideoChatSwitchToAudioPackage(String str, long j) {
        super((short) 16, j);
        this.roomId = str;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("room_id", this.roomId);
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[roomId:" + this.roomId + "]";
    }
}
