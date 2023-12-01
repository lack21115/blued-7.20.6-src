package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cl.class */
public class cl extends h {
    final /* synthetic */ ck b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.b = ckVar;
    }

    @Override // com.baidu.mobads.sdk.internal.h
    protected Object i() {
        String a2;
        String a3;
        Context context;
        String a4;
        try {
            a2 = this.b.a("key_crash_trace");
            a3 = this.b.a("key_crash_ad");
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            ch a5 = ch.a();
            context = this.b.h;
            a5.a(context);
            a4 = this.b.a("key_crash_source");
            a5.a(a4, a2, a3);
            this.b.g();
            return null;
        } catch (Exception e) {
            bq.a().a(e);
            return null;
        }
    }
}
