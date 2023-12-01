package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/dh.class */
public class dh implements l5, TencentMap.OnCameraChangeListener {
    private rc g;
    private ch h = null;
    private ib i;

    public dh(rc rcVar, ib ibVar) {
        this.g = null;
        this.i = null;
        this.g = rcVar;
        this.i = ibVar;
    }

    public void a() {
        rc rcVar = this.g;
        if (rcVar == null) {
            return;
        }
        rcVar.h().b(this);
        ch chVar = this.h;
        if (chVar != null) {
            chVar.g();
            this.h = null;
        }
    }

    public void a(ah ahVar) {
        ch chVar = this.h;
        if (chVar == null || ahVar == null) {
            return;
        }
        chVar.a(ahVar);
    }

    @Override // com.tencent.mapsdk.internal.l5
    public void b() {
        ch chVar = this.h;
        if (chVar != null) {
            synchronized (chVar) {
                this.h.notify();
            }
        }
    }

    public void b(ah ahVar) {
        ch chVar = this.h;
        if (chVar == null || ahVar == null) {
            return;
        }
        chVar.b(ahVar);
    }

    public void c() {
        a();
    }

    public void d() {
        rc rcVar = this.g;
        if (rcVar == null) {
            return;
        }
        rcVar.h().a(this);
        if (this.h == null) {
            this.h = new ch(this.g, this.i);
        }
        try {
            this.h.start();
        } catch (Exception e) {
        }
    }

    public void e() {
        ch chVar = this.h;
        if (chVar != null) {
            chVar.e();
        }
    }

    public void f() {
        ch chVar = this.h;
        if (chVar != null) {
            chVar.c();
            b();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChange(CameraPosition cameraPosition) {
        ch chVar = this.h;
        if (chVar != null) {
            synchronized (chVar) {
                this.h.notify();
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChangeFinished(CameraPosition cameraPosition) {
    }
}
