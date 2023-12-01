package com.zx.a.I8b7;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/i0.class */
public class i0 implements d0 {
    @Override // com.zx.a.I8b7.d0
    public void a(int i, String str, String str2) {
        if (i == 1) {
            Log.v(str, str2);
        } else if (i == 2) {
            Log.d(str, str2);
        } else if (i == 3) {
            Log.i(str, str2);
        } else if (i == 4) {
            Log.w(str, str2);
        } else if (i != 5) {
        } else {
            Log.e(str, str2);
        }
    }
}
