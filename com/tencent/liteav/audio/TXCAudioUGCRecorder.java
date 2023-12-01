package com.tencent.liteav.audio;

import android.content.Context;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/TXCAudioUGCRecorder.class */
public class TXCAudioUGCRecorder {
    private static final TXCAudioUGCRecorder INSTANCE = new TXCAudioUGCRecorder();

    private TXCAudioUGCRecorder() {
    }

    public static TXCAudioUGCRecorder getInstance() {
        return INSTANCE;
    }

    public boolean getIsMute() {
        synchronized (this) {
        }
        return false;
    }

    public void setAECType(int i, Context context) {
    }
}
