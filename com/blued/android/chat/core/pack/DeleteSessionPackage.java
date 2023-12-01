package com.blued.android.chat.core.pack;

import android.util.Pair;
import com.blued.android.chat.utils.BytesUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/DeleteSessionPackage.class */
public class DeleteSessionPackage extends DeleteBasePackage {
    private final DeleteHeader deleteHeader;
    private final List<Pair<Short, Long>> sessionPairList;

    public DeleteSessionPackage(List<Pair<Short, Long>> list, long j, boolean z) {
        super(j);
        this.deleteHeader = new DeleteHeader((short) 2, z);
        this.sessionPairList = list;
    }

    public DeleteSessionPackage(short s, long j, long j2, boolean z) {
        super(j2);
        this.deleteHeader = new DeleteHeader((short) 2, z);
        ArrayList arrayList = new ArrayList();
        this.sessionPairList = arrayList;
        arrayList.add(new Pair(Short.valueOf(s), Long.valueOf(j)));
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected BytesData msgDataToByte() {
        int i = 5;
        BytesData bytesData = new BytesData((short) ((this.sessionPairList.size() * 5) + 5));
        bytesData.data[0] = this.deleteHeader.toByte();
        BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
        for (Pair<Short, Long> pair : this.sessionPairList) {
            BytesUtils.numberTo1Byte(bytesData.data, i, pair.first.shortValue());
            int i2 = i + 1;
            BytesUtils.numberTo4Bytes(bytesData.data, i2, pair.second.longValue());
            i = i2 + 4;
        }
        return bytesData;
    }

    @Override // com.blued.android.chat.core.pack.DeleteBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        Iterator<Pair<Short, Long>> it = this.sessionPairList.iterator();
        String str = "";
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return super.toString() + "[DeleteSession, " + str2 + ", deleteHeader:" + this.deleteHeader + "]";
            }
            Pair<Short, Long> next = it.next();
            str = str2 + " <sessionType:" + next.first + ", sessionId:" + next.second + "> ";
        }
    }
}
