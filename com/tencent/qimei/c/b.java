package com.tencent.qimei.c;

import android.os.SystemClock;
import com.tencent.qmsp.oaid2.IVendorCallback;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/c/b.class */
public class b implements IVendorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f24626a;
    public final /* synthetic */ c b;

    public b(c cVar, d dVar) {
        this.b = cVar;
        this.f24626a = dVar;
    }

    @Override // com.tencent.qmsp.oaid2.IVendorCallback
    public void onResult(boolean z, String str, String str2) {
        long j;
        this.b.h = str2;
        int i = (str2 == null || str2.isEmpty()) ? 0 : 1;
        if (i != 0) {
            c cVar = this.b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            j = this.b.f24628c;
            cVar.d = elapsedRealtime - j;
            long j2 = this.b.d;
        }
        d dVar = this.f24626a;
        if (dVar != null) {
            dVar.a(1 ^ i);
        }
    }
}
