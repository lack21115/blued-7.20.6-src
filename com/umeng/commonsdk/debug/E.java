package com.umeng.commonsdk.debug;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/debug/E.class */
public class E implements UInterface {
    @Override // com.umeng.commonsdk.debug.UInterface
    public void log(String str, String str2) {
        Log.e(str, str2);
    }
}
