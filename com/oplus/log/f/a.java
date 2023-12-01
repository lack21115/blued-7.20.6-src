package com.oplus.log.f;

import android.util.Log;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/f/a.class */
public class a extends b {
    @Override // com.oplus.log.f.b
    public void a(String str, String str2, boolean z, byte b) {
        if ((b >= b() || b() != -1) && z) {
            if (com.oplus.log.b.a() || com.oplus.log.b.b()) {
                if (b == 1) {
                    Log.v(str, str2);
                } else if (b == 2) {
                    Log.d(str, str2);
                } else if (b == 3) {
                    Log.i(str, str2);
                } else if (b == 4) {
                    Log.w(str, str2);
                } else if (b != 5) {
                } else {
                    Log.e(str, str2);
                }
            }
        }
    }
}
