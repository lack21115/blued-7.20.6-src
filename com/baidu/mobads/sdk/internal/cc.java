package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.am;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cc.class */
public class cc implements am.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ double f9372a;
    final /* synthetic */ bw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bw bwVar, double d) {
        this.b = bwVar;
        this.f9372a = d;
    }

    @Override // com.baidu.mobads.sdk.internal.am.b
    public void a(String str, int i) {
        boolean z;
        z = this.b.A;
        if (z) {
            this.b.A = false;
            this.b.a(false, "remote update Network access failed");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.mobads.sdk.internal.am.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.cc.a(java.lang.String, java.lang.String):void");
    }
}
