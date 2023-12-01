package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/DeleteAllPackage.class */
public class DeleteAllPackage extends DeleteBasePackage {
    private final DeleteHeader deleteHeader;

    public DeleteAllPackage(long j, boolean z) {
        super(j);
        this.deleteHeader = new DeleteHeader((short) 1, z);
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected BytesData msgDataToByte() {
        BytesData bytesData = new BytesData(5);
        bytesData.data[0] = this.deleteHeader.toByte();
        BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
        return bytesData;
    }

    @Override // com.blued.android.chat.core.pack.DeleteBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[deleteHeader:" + this.deleteHeader + "]";
    }
}
