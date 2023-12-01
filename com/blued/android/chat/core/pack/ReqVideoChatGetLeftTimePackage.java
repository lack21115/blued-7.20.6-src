package com.blued.android.chat.core.pack;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqVideoChatGetLeftTimePackage.class */
public class ReqVideoChatGetLeftTimePackage extends ReqBasePackage {
    public int consume_beans;
    public long invited_uid;

    public ReqVideoChatGetLeftTimePackage(long j) {
        super((short) 17, j);
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        HashMap hashMap = new HashMap();
        hashMap.put("invited_uid", Long.valueOf(this.invited_uid));
        hashMap.put("consume_beans", Integer.valueOf(this.consume_beans));
        return hashMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[invited_uid:" + this.invited_uid + ", consume_beans:" + this.consume_beans + "]";
    }
}
