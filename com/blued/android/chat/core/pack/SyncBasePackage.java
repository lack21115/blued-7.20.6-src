package com.blued.android.chat.core.pack;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/SyncBasePackage.class */
public class SyncBasePackage extends BasePackage {
    public static final short SYNC_ALL = 1;
    public static final short SYNC_LATER = 4;
    public static final short SYNC_NEW = 2;
    public static final short SYNC_RANGE = 3;
    protected final short syncType;

    /* JADX INFO: Access modifiers changed from: protected */
    public SyncBasePackage(short s, long j) {
        this.type = (short) 5;
        this.sync = true;
        this.needAck = true;
        this.syncType = s;
        this.localId = j;
    }

    public short getSyncType() {
        return this.syncType;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[syncType:" + ((int) this.syncType) + ", localId:" + this.localId + "]";
    }
}
