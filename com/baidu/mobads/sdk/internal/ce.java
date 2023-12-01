package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.mobads.sdk.internal.bw;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ce.class */
public class ce extends h {
    final /* synthetic */ bw.c b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Handler f9374c;
    final /* synthetic */ bw d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(bw bwVar, bw.c cVar, Handler handler) {
        this.d = bwVar;
        this.b = cVar;
        this.f9374c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.h
    protected Object i() {
        bq bqVar;
        SharedPreferences m;
        try {
            synchronized (bw.class) {
                this.d.b(this.b, this.f9374c);
            }
            m = this.d.m();
            SharedPreferences.Editor edit = m.edit();
            edit.putString(bw.d, this.d.a());
            edit.apply();
            return null;
        } catch (Throwable th) {
            bqVar = this.d.z;
            bqVar.a(bw.f9362a, th);
            return null;
        }
    }
}
