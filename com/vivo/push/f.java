package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/f.class */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f27406a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, String str) {
        this.b = eVar;
        this.f27406a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.b.h;
        if (context == null || TextUtils.isEmpty(this.f27406a)) {
            return;
        }
        context2 = this.b.h;
        context3 = this.b.h;
        if (z.b(context2, context3.getPackageName(), this.f27406a)) {
            this.b.i();
        }
    }
}
