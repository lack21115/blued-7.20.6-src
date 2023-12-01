package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/ac.class */
final class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f41072a;
    final /* synthetic */ List b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ List f41073c;
    final /* synthetic */ String d;
    final /* synthetic */ aa e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, int i, List list, List list2, String str) {
        this.e = aaVar;
        this.f41072a = i;
        this.b = list;
        this.f41073c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.b;
        context = this.e.f41105a;
        pushMessageCallback.onSetAlias(context, this.f41072a, this.b, this.f41073c, this.d);
    }
}
