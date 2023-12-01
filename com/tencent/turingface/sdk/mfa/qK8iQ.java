package com.tencent.turingface.sdk.mfa;

import android.app.Activity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/qK8iQ.class */
public final class qK8iQ {
    public static WT9z5 b;

    /* renamed from: a  reason: collision with root package name */
    public static List<JD1Ej> f39983a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static Set<String> f39984c = new HashSet();
    public static final spXPg d = new spXPg();
    public static ShGzN e = new ShGzN();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/qK8iQ$ShGzN.class */
    public final class ShGzN implements WT9z5 {
        @Override // com.tencent.turingface.sdk.mfa.WT9z5
        public final void onActivityPaused(Activity activity) {
            pZo7n a2 = pZo7n.a();
            activity.getApplicationContext();
            a2.a(activity.getClass().getName());
        }

        @Override // com.tencent.turingface.sdk.mfa.WT9z5
        public final void onActivityResumed(Activity activity) {
            WT9z5 wT9z5 = qK8iQ.b;
            if (wT9z5 != null) {
                wT9z5.onActivityResumed(activity);
            }
            int i = qK8iQ.f39984c.contains(activity.getClass().getName()) ? 100 : 999;
            pZo7n a2 = pZo7n.a();
            activity.getApplicationContext();
            a2.a(activity.getClass().getName(), i, qK8iQ.d);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/qK8iQ$spXPg.class */
    public final class spXPg implements JD1Ej {
        @Override // com.tencent.turingface.sdk.mfa.JD1Ej
        public final void a(String str, int i, int i2, OCkqn oCkqn) {
            Iterator<JD1Ej> it = qK8iQ.f39983a.iterator();
            while (it.hasNext()) {
                JD1Ej next = it.next();
                if (next != null) {
                    next.a(str, i, i2, oCkqn);
                }
            }
        }
    }
}
