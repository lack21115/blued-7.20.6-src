package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/ab.class */
final class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f41070a;
    final /* synthetic */ List b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ List f41071c;
    final /* synthetic */ String d;
    final /* synthetic */ aa e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, int i, List list, List list2, String str) {
        this.e = aaVar;
        this.f41070a = i;
        this.b = list;
        this.f41071c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.b;
        context = this.e.f41105a;
        pushMessageCallback.onSetTags(context, this.f41070a, this.b, this.f41071c, this.d);
    }
}
