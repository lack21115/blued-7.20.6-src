package com.anythink.core.common;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ATMediationRequestInfo;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/j.class */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public String f6762a;
    public ATMediationRequestInfo b;

    /* renamed from: c  reason: collision with root package name */
    public String f6763c;
    public int d;
    public com.anythink.core.common.b.b e;
    public com.anythink.core.common.b.a f;
    public Map<String, Object> g;
    private Context h;
    private WeakReference<Activity> i;

    private int b() {
        return this.d;
    }

    public final Context a() {
        Activity activity;
        WeakReference<Activity> weakReference = this.i;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            Activity F = com.anythink.core.common.b.n.a().F();
            return F != null ? F : this.h;
        }
        return activity;
    }

    public final void a(Context context) {
        this.h = com.anythink.core.common.b.n.a().g();
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        this.i = new WeakReference<>((Activity) context);
    }
}
