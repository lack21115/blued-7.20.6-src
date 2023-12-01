package com.umeng.commonsdk.debug;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/debug/W.class */
public class W implements UInterface {
    @Override // com.umeng.commonsdk.debug.UInterface
    public void log(String str, String str2) {
        Log.w(str, str2);
    }
}
