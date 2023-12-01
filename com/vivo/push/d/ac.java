package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/ac.class */
final class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f27381a;
    final /* synthetic */ List b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ List f27382c;
    final /* synthetic */ String d;
    final /* synthetic */ aa e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, int i, List list, List list2, String str) {
        this.e = aaVar;
        this.f27381a = i;
        this.b = list;
        this.f27382c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.b;
        context = this.e.f27414a;
        pushMessageCallback.onSetAlias(context, this.f27381a, this.b, this.f27382c, this.d);
    }
}
