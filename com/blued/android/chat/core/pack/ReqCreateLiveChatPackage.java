package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqCreateLiveChatPackage.class */
public class ReqCreateLiveChatPackage extends ReqBasePackage {
    public final String cover;
    public final String description;
    public final int liveType;
    public final int privateFlag;
    public final int screenPattern;
    public final short sessionType;
    public final int shareMirror;
    public final int showNearby;

    public ReqCreateLiveChatPackage(int i, int i2, String str, String str2, long j, int i3, int i4, int i5) {
        super((short) 3, j);
        if (ChatManager.clientType == ChatManager.ClientType.CHINA) {
            this.sessionType = (short) 4;
        } else if (ChatManager.clientType == ChatManager.ClientType.INTERNATIONAL) {
            this.sessionType = (short) 5;
        } else {
            this.sessionType = (short) -1;
        }
        this.liveType = i2;
        this.description = str;
        this.cover = str2;
        this.screenPattern = i3;
        this.showNearby = i4;
        this.privateFlag = i5;
        this.shareMirror = i;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        short s = this.sessionType;
        if (s > 0) {
            arrayMap.put(ReqAckPackage.REQ_RESPONSE_KEY.SESSION_TYPE, Short.valueOf(s));
        }
        arrayMap.put("share_mirror", Integer.valueOf(this.shareMirror));
        arrayMap.put("live_type", Integer.valueOf(this.liveType));
        arrayMap.put("description", this.description);
        arrayMap.put("pic_url", this.cover);
        arrayMap.put("screen_pattern", Integer.valueOf(this.screenPattern));
        arrayMap.put("show_in_nearby", Integer.valueOf(this.showNearby));
        arrayMap.put("is_private", Integer.valueOf(this.privateFlag));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", share_mirror:" + this.shareMirror + ", liveType:" + this.liveType + ", description:" + this.description + ", cover:" + this.cover + ", screenPattern:" + this.screenPattern + ", showNearby:" + this.showNearby + "]";
    }
}
