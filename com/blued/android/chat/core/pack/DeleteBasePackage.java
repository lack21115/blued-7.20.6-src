package com.blued.android.chat.core.pack;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/DeleteBasePackage.class */
public class DeleteBasePackage extends BasePackage {
    /* JADX INFO: Access modifiers changed from: protected */
    public DeleteBasePackage(long j) {
        this.type = (short) 6;
        this.needAck = true;
        this.localId = j;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[localId:" + this.localId + "]";
    }
}
