package com.umeng.commonsdk.debug;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/debug/I.class */
public class I implements UInterface {
    @Override // com.umeng.commonsdk.debug.UInterface
    public void log(String str, String str2) {
        Log.i(str, str2);
    }
}
