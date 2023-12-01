package com.tencent.turingface.sdk.mfa;

import android.app.Activity;
import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/flIYu.class */
public final class flIYu {
    public static Context d;

    /* renamed from: a  reason: collision with root package name */
    public static final WOMZP<IEttU> f26263a = new WOMZP<>(3);
    public static final WOMZP<IEttU> b = new WOMZP<>(3);

    /* renamed from: c  reason: collision with root package name */
    public static long f26264c = 0;
    public static final spXPg e = new spXPg();
    public static final ShGzN f = new ShGzN();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/flIYu$ShGzN.class */
    public final class ShGzN implements WT9z5 {
        @Override // com.tencent.turingface.sdk.mfa.WT9z5
        public final void onActivityPaused(Activity activity) {
            pZo7n a2 = pZo7n.a();
            activity.getApplicationContext();
            a2.a(activity.getClass().getName());
        }

        @Override // com.tencent.turingface.sdk.mfa.WT9z5
        public final void onActivityResumed(Activity activity) {
            pZo7n a2 = pZo7n.a();
            Context context = flIYu.d;
            a2.a(activity.getClass().getName(), 997, flIYu.e);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/flIYu$spXPg.class */
    public final class spXPg implements JD1Ej {
        @Override // com.tencent.turingface.sdk.mfa.JD1Ej
        public final void a(String str, int i, int i2, OCkqn oCkqn) {
            if (i2 == 2 || i2 == 3) {
                WOMZP<IEttU> womzp = flIYu.b;
                synchronized (womzp) {
                    womzp.a(new IEttU(str, i2, oCkqn));
                }
                return;
            }
            long abs = oCkqn != null ? Math.abs(oCkqn.b - flIYu.f26264c) : 1000L;
            flIYu.f26264c = System.currentTimeMillis();
            if (abs < 1000) {
                return;
            }
            WOMZP<IEttU> womzp2 = flIYu.f26263a;
            synchronized (womzp2) {
                womzp2.a(new IEttU(str, i2, oCkqn));
            }
        }
    }
}
