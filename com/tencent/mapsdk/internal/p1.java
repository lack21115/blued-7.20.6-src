package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/p1.class */
public abstract class p1 implements TencentMapComponent.Component {

    /* renamed from: a  reason: collision with root package name */
    private final List<q1> f37680a = new ArrayList();
    private volatile int b;

    public void a(Context context) {
    }

    public void a(q1 q1Var) {
        synchronized (this) {
            if (q1Var != null) {
                this.f37680a.add(q1Var);
            }
        }
    }

    public void a(q1 q1Var, Bundle bundle) {
        synchronized (this) {
            if (this.f37680a.size() == 0) {
                return;
            }
            this.b = this.f37680a.indexOf(q1Var);
        }
    }

    public void b(q1 q1Var) {
        synchronized (this) {
            if (q1Var != null) {
                this.f37680a.remove(q1Var);
            }
            if (this.f37680a.size() == 0) {
                f();
            } else {
                this.b = this.f37680a.size() - 1;
            }
        }
    }

    public Context e() {
        q1 mapContext = getMapContext();
        if (mapContext != null) {
            return mapContext.getContext();
        }
        return null;
    }

    public void f() {
        synchronized (this) {
            this.f37680a.clear();
            this.b = 0;
        }
    }

    public q1 getMapContext() {
        synchronized (this) {
            if (this.b < 0 || this.b >= this.f37680a.size()) {
                return null;
            }
            return this.f37680a.get(this.b);
        }
    }
}
