package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqFlashVideoEmoji.class */
public class ReqFlashVideoEmoji extends ReqBasePackage {
    public final String emojiTag;
    public final long matchedUid;
    public final String roomId;

    public ReqFlashVideoEmoji(long j, String str, long j2, String str2) {
        super((short) 40, j2);
        this.matchedUid = j;
        this.roomId = str;
        this.emojiTag = str2;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(TTLiveConstants.ROOMID_KEY, this.roomId);
        arrayMap.put("uid", Long.valueOf(this.matchedUid));
        arrayMap.put("emoji_tag", this.emojiTag);
        return arrayMap;
    }
}
