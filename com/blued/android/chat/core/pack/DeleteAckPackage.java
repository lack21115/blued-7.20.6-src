package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/DeleteAckPackage.class */
public class DeleteAckPackage extends BasePackage {
    public int result;

    protected DeleteAckPackage() {
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected void parseMsgData(byte[] bArr, int i, int i2) {
        this.result = BytesUtils.byteTo1Number(bArr, i);
        this.localId = BytesUtils.bytesTo4Number(bArr, i + 1);
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[result:" + this.result + ", localId:" + this.localId + "]";
    }
}
