package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/BytesData.class */
public class BytesData {
    public final byte[] data;
    public final int length;

    public BytesData(int i) {
        this.data = BytesUtils.getReuseByte(i);
        this.length = i;
    }
}
