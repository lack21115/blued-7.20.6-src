package com.hihonor.push.sdk;

import android.os.Looper;
import android.util.Log;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.j;
import com.hihonor.push.sdk.l;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/n.class */
public class n implements l {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f8705a = new AtomicInteger(1);
    public volatile IPushInvoke b;

    /* renamed from: c  reason: collision with root package name */
    public final l.a f8706c;
    public p d;

    public n(l.a aVar) {
        this.f8706c = aVar;
    }

    public final void a(int i) {
        Log.i("PushConnectionClient", "notifyFailed result: ".concat(String.valueOf(i)));
        l.a aVar = this.f8706c;
        if (aVar != null) {
            j.a aVar2 = (j.a) aVar;
            aVar2.getClass();
            if (Looper.myLooper() == j.this.f8695a.getLooper()) {
                aVar2.a(HonorPushErrorEnum.fromCode(i));
            } else {
                j.this.f8695a.post(new i(aVar2, i));
            }
        }
    }

    public boolean a() {
        return this.f8705a.get() == 3 || this.f8705a.get() == 4;
    }
}
