package com.tencent.beacon.module;

import android.content.Context;
import com.tencent.beacon.base.net.b.e;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.e.a;
import com.tencent.beacon.e.b;
import com.tencent.beacon.e.h;
import com.tencent.beacon.e.i;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/module/StrategyModule.class */
public class StrategyModule implements BeaconModule {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f21402a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private i f21403c;
    private boolean e = false;
    private b d = b.a();
    private a b = a.a();

    public StrategyModule() {
        h.b().a(this.b);
        this.f21403c = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        synchronized (this) {
            if (!this.f21403c.a()) {
                com.tencent.beacon.a.b.a.a().a(this.f21403c);
            }
        }
    }

    public a a() {
        return this.b;
    }

    @Override // com.tencent.beacon.module.BeaconModule
    public void a(Context context) {
        c.a("[module] strategy module > TRUE", new Object[0]);
        this.f21403c.b();
        d();
        e.a(context, new e.a() { // from class: com.tencent.beacon.module.StrategyModule.1
            @Override // com.tencent.beacon.base.net.b.e.a
            public void a() {
                synchronized (StrategyModule.this) {
                    if (!StrategyModule.this.c() && !StrategyModule.this.f21403c.a()) {
                        StrategyModule.this.d();
                    }
                }
            }

            @Override // com.tencent.beacon.base.net.b.e.a
            public void b() {
            }
        });
    }

    public void a(boolean z) {
        synchronized (f21402a) {
            this.e = z;
        }
    }

    public b b() {
        return this.d;
    }

    public boolean c() {
        boolean z;
        synchronized (f21402a) {
            z = this.e;
        }
        return z;
    }
}
