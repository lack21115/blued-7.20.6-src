package com.tencent.tmsbeacon.module;

import android.content.Context;
import com.tencent.tmsbeacon.base.net.b.e;
import com.tencent.tmsbeacon.base.util.c;
import com.tencent.tmsbeacon.d.b;
import com.tencent.tmsbeacon.d.g;
import com.tencent.tmsbeacon.d.h;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/module/StrategyModule.class */
public class StrategyModule implements BeaconModule {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f39599a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private h f39600c;
    private boolean e = false;
    private b d = b.a();
    private com.tencent.tmsbeacon.d.a b = com.tencent.tmsbeacon.d.a.a();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/module/StrategyModule$a.class */
    public class a implements e.a {
        public a() {
        }

        @Override // com.tencent.tmsbeacon.base.net.b.e.a
        public void a() {
            synchronized (StrategyModule.this) {
                if (!StrategyModule.this.c() && !StrategyModule.this.f39600c.a()) {
                    StrategyModule.this.d();
                }
            }
        }

        @Override // com.tencent.tmsbeacon.base.net.b.e.a
        public void b() {
        }
    }

    public StrategyModule() {
        g.b().a(this.b);
        this.f39600c = new h(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        synchronized (this) {
            if (!this.f39600c.a()) {
                com.tencent.tmsbeacon.a.b.a.a().a(this.f39600c);
            }
        }
    }

    public com.tencent.tmsbeacon.d.a a() {
        return this.b;
    }

    @Override // com.tencent.tmsbeacon.module.BeaconModule
    public void a(Context context) {
        c.a("[module] strategy module > TRUE", new Object[0]);
        this.f39600c.b();
        d();
        e.a(context, new a());
    }

    public void a(boolean z) {
        synchronized (f39599a) {
            this.e = z;
        }
    }

    public b b() {
        return this.d;
    }

    public boolean c() {
        boolean z;
        synchronized (f39599a) {
            z = this.e;
        }
        return z;
    }
}
