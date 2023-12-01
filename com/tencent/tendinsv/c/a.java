package com.tencent.tendinsv.c;

import android.os.SystemClock;
import com.tencent.tendinsv.listener.AuthCallbacks;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/c/a.class */
public class a implements AuthCallbacks {
    @Override // com.tencent.tendinsv.listener.AuthCallbacks
    public void authFailed(int i, int i2, String str, String str2, int i3, String str3, long j, long j2, long j3) {
        String a2 = com.tencent.tendinsv.utils.d.a(i2, str2, str);
        long uptimeMillis = SystemClock.uptimeMillis();
        long uptimeMillis2 = SystemClock.uptimeMillis();
        com.tencent.tendinsv.b.Y.set(com.tencent.tendinsv.b.S);
        e.a().d(i, i2, a2, str2, str3, i3, 11, com.tencent.tendinsv.b.S, j, uptimeMillis2 - j2, uptimeMillis - j3);
    }

    @Override // com.tencent.tendinsv.listener.AuthCallbacks
    public void authSuccessed(int i, int i2, String str, String str2, int i3, String str3, long j, long j2, long j3) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long uptimeMillis2 = SystemClock.uptimeMillis();
        com.tencent.tendinsv.b.Y.set(com.tencent.tendinsv.b.T);
        e.a().d(i, i2, str, str2, str3, i3, 11, com.tencent.tendinsv.b.T, j, uptimeMillis2 - j2, uptimeMillis - j3);
    }
}
