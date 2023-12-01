package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/j.class */
final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f41079a;
    final /* synthetic */ List b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ List f41080c;
    final /* synthetic */ String d;
    final /* synthetic */ h e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, int i, List list, List list2, String str) {
        this.e = hVar;
        this.f41079a = i;
        this.b = list;
        this.f41080c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.b;
        context = this.e.f41105a;
        pushMessageCallback.onDelAlias(context, this.f41079a, this.b, this.f41080c, this.d);
    }
}
