package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/i.class */
final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f27386a;
    final /* synthetic */ List b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ List f27387c;
    final /* synthetic */ String d;
    final /* synthetic */ h e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, int i, List list, List list2, String str) {
        this.e = hVar;
        this.f27386a = i;
        this.b = list;
        this.f27387c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.b;
        context = this.e.f27414a;
        pushMessageCallback.onDelTags(context, this.f27386a, this.b, this.f27387c, this.d);
    }
}
