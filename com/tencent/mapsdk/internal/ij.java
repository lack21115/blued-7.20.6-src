package com.tencent.mapsdk.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ij.class */
public class ij extends View implements x1 {
    private Context g;
    private yi h;
    private Object i;
    private int j;
    private int k;
    private xi l;
    private boolean m;

    public ij(e1 e1Var) {
        super(e1Var.getContext());
        this.m = true;
        Object i = e1Var.i();
        if (i == null) {
            return;
        }
        this.g = e1Var.getContext();
        this.h = (yi) e1Var.j();
        this.i = i;
        this.j = e1Var.l();
        int c2 = e1Var.c();
        this.k = c2;
        if (c2 <= 0 || this.j <= 0) {
            this.j = 0;
            this.k = 0;
        }
        xi xiVar = new xi(this.h);
        this.l = xiVar;
        xiVar.a(this.i);
        this.l.a(e1Var.k());
        this.l.start();
    }

    private void a() {
        yi yiVar = this.h;
        if (yiVar == null || !this.m) {
            return;
        }
        yiVar.a((GL10) null, (EGLConfig) null);
        this.h.a((GL10) null, this.j, this.k);
        this.h.d(this.j, this.k);
        this.m = false;
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void a(float f) {
        xi xiVar = this.l;
        if (xiVar != null) {
            xiVar.a(f);
        }
    }

    @Override // com.tencent.mapsdk.internal.x1
    public View getView() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void j() {
        xi xiVar = this.l;
        if (xiVar != null) {
            synchronized (xiVar) {
                this.l.notify();
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void onDestroy() {
        xi xiVar = this.l;
        if (xiVar != null) {
            xiVar.e();
        }
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void onPause() {
        xi xiVar = this.l;
        if (xiVar != null) {
            xiVar.f();
        }
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void onResume() {
        xi xiVar = this.l;
        if (xiVar != null) {
            xiVar.g();
        }
        a();
    }

    @Override // android.view.View, com.tencent.mapsdk.internal.x1
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        yi yiVar = this.h;
        if (yiVar != null) {
            this.j = i;
            this.k = i2;
            yiVar.a((GL10) null, i, i2);
            this.h.d(i, i2);
            this.h.a();
            this.m = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void onSurfaceChanged(Object obj, int i, int i2) {
        xi xiVar;
        if (this.h == null || (xiVar = this.l) == null || !xiVar.isAlive()) {
            return;
        }
        xi xiVar2 = this.l;
        if (xiVar2 != null) {
            this.i = obj;
            xiVar2.a(obj);
        }
        yi yiVar = this.h;
        if (yiVar != null) {
            yiVar.a((GL10) null, (EGLConfig) null);
            this.h.a((GL10) null, i, i2);
        }
    }

    @Override // android.view.View, com.tencent.mapsdk.internal.x1
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void setMapOpaque(boolean z) {
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void setZOrderMediaOverlay(boolean z) {
    }

    @Override // com.tencent.mapsdk.internal.x1
    public boolean z() {
        return false;
    }
}
