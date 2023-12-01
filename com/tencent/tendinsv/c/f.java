package com.tencent.tendinsv.c;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.tendinsv.listener.SwitchNetworkCallbacks;
import com.tencent.tendinsv.tool.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/c/f.class */
public class f implements SwitchNetworkCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private Context f39030a;

    public f(Context context) {
        this.f39030a = context;
    }

    @Override // com.tencent.tendinsv.listener.SwitchNetworkCallbacks
    public void switchFailed(int i, int i2, String str, String str2, int i3, long j, long j2, long j3) {
        String a2 = com.tencent.tendinsv.tool.d.a().a(this.f39030a);
        long uptimeMillis = SystemClock.uptimeMillis();
        g.a().a(i, i2, str, str2, a2, i3, 0, com.tencent.tendinsv.b.S, j, SystemClock.uptimeMillis() - j2, uptimeMillis - j3, false, 1);
    }

    @Override // com.tencent.tendinsv.listener.SwitchNetworkCallbacks
    public void switchSuccessed(int i, int i2, String str, String str2, int i3, long j, long j2, long j3) {
        String a2 = com.tencent.tendinsv.tool.d.a().a(this.f39030a);
        long uptimeMillis = SystemClock.uptimeMillis();
        g.a().a(i, i2, str, str2, a2, i3, 0, com.tencent.tendinsv.b.S, j, SystemClock.uptimeMillis() - j2, uptimeMillis - j3, false, 1);
    }
}
