package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/PushReadedPackage.class */
public class PushReadedPackage {
    public long msgId;
    public PushBasePackage pushBasePackage;
    public long sessionId;
    public short sessionType;

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseSubPackageData(byte[] bArr, int i, int i2) {
        this.sessionType = BytesUtils.byteTo1Number(bArr, i);
        int i3 = i + 1;
        this.sessionId = BytesUtils.bytesTo4Number(bArr, i3);
        this.msgId = BytesUtils.byteTo8Number(bArr, i3 + 4);
    }

    public String toString() {
        return "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", msgId:" + this.msgId + "]";
    }
}
