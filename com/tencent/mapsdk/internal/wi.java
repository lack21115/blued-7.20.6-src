package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/wi.class */
public class wi implements w4 {

    /* renamed from: a  reason: collision with root package name */
    private yi f38100a;

    public wi(yi yiVar) {
        this.f38100a = yiVar;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a(float f) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a(float f, float f2) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a(PointF pointF, PointF pointF2, double d, double d2) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a(PointF pointF, PointF pointF2, float f) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean b() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean b(float f) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean b(float f, float f2) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public void c() {
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean c(float f, float f2) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean d() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean d(float f, float f2) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onDoubleTap(float f, float f2) {
        boolean z;
        TencentMapGestureListenerList tencentMapGestureListenerList;
        yi yiVar = this.f38100a;
        if (yiVar != null && (z = yiVar.p) && (tencentMapGestureListenerList = yiVar.o) != null && z) {
            return tencentMapGestureListenerList.onDoubleTap(f, f2);
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onDown(float f, float f2) {
        yi yiVar = this.f38100a;
        if (yiVar != null && yiVar.p) {
            yiVar.t++;
            TencentMapGestureListenerList tencentMapGestureListenerList = yiVar.o;
            if (tencentMapGestureListenerList != null) {
                return tencentMapGestureListenerList.onDown(f, f2);
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onFling(float f, float f2) {
        TencentMapGestureListenerList tencentMapGestureListenerList;
        yi yiVar = this.f38100a;
        if (yiVar == null || !yiVar.p || (tencentMapGestureListenerList = yiVar.o) == null) {
            return false;
        }
        return tencentMapGestureListenerList.onFling(f, f2);
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onLongPress(float f, float f2) {
        yi yiVar = this.f38100a;
        if (yiVar != null && yiVar.p) {
            yiVar.f(f, f2);
            TencentMapGestureListenerList tencentMapGestureListenerList = this.f38100a.o;
            if (tencentMapGestureListenerList != null) {
                return tencentMapGestureListenerList.onLongPress(f, f2);
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onScroll(float f, float f2) {
        TencentMapGestureListenerList tencentMapGestureListenerList;
        yi yiVar = this.f38100a;
        if (yiVar == null || !yiVar.p || (tencentMapGestureListenerList = yiVar.o) == null) {
            return false;
        }
        return tencentMapGestureListenerList.onScroll(f, f2);
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onSingleTap(float f, float f2) {
        yi yiVar = this.f38100a;
        if (yiVar != null && yiVar.p) {
            if (yiVar.e(f, f2)) {
                return true;
            }
            if (!this.f38100a.d(f, f2)) {
                this.f38100a.b(f, f2);
            }
            yi yiVar2 = this.f38100a;
            TencentMapGestureListenerList tencentMapGestureListenerList = yiVar2.o;
            if (tencentMapGestureListenerList == null || !yiVar2.p) {
                return false;
            }
            return tencentMapGestureListenerList.onSingleTap(f, f2);
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onUp(float f, float f2) {
        int i;
        yi yiVar = this.f38100a;
        if (yiVar != null && yiVar.p) {
            int i2 = yiVar.t;
            if (i2 > 0) {
                i = i2 - 1;
                yiVar.t = i;
            } else {
                i = 0;
            }
            yiVar.t = i;
            if (yiVar.s && this.f38100a.r) {
                yi yiVar2 = this.f38100a;
                if (yiVar2.t == 0) {
                    CameraPosition J = yiVar2.J();
                    if (J == null) {
                        return false;
                    }
                    this.f38100a.s = false;
                    this.f38100a.onCameraChangeFinished(J);
                }
            }
            TencentMapGestureListenerList tencentMapGestureListenerList = this.f38100a.o;
            if (tencentMapGestureListenerList != null) {
                return tencentMapGestureListenerList.onUp(f, f2);
            }
            return false;
        }
        return false;
    }
}
