package com.umeng.commonsdk.debug;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/debug/D.class */
public class D implements UInterface {
    @Override // com.umeng.commonsdk.debug.UInterface
    public void log(String str, String str2) {
        Log.d(str, str2);
    }
}
