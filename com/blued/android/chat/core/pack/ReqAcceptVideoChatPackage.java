package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqAcceptVideoChatPackage.class */
public class ReqAcceptVideoChatPackage extends ReqBasePackage {
    public final String streamId;

    public ReqAcceptVideoChatPackage(long j, String str) {
        super((short) 50, j);
        this.streamId = str;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("stream_id", this.streamId);
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[ streamId=" + this.streamId + "]";
    }
}
