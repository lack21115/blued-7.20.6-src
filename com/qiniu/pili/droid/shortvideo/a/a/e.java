package com.qiniu.pili.droid.shortvideo.a.a;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import com.qiniu.pili.droid.shortvideo.PLFocusListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/a/a/e.class */
public class e {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f13828c;
    private String g;
    private List<Camera.Area> i;
    private List<Camera.Area> j;
    private PLFocusListener k;

    /* renamed from: a  reason: collision with root package name */
    private int f13827a = 0;
    private boolean d = false;
    private boolean e = false;
    private long f = 0;
    private Matrix h = new Matrix();
    private final Camera.AutoFocusCallback l = new Camera.AutoFocusCallback() { // from class: com.qiniu.pili.droid.shortvideo.a.a.e.1
        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
            eVar.c("FocusManager", "manual focus cost time: " + (System.currentTimeMillis() - e.this.f) + "Ms, result: " + z);
            e.this.f13827a = z ? 2 : 3;
            if (e.this.k != null) {
                e.this.k.onManualFocusStop(z);
            }
            e.this.f();
        }
    };
    private final Camera.AutoFocusMoveCallback m = new Camera.AutoFocusMoveCallback() { // from class: com.qiniu.pili.droid.shortvideo.a.a.e.2
        @Override // android.hardware.Camera.AutoFocusMoveCallback
        public void onAutoFocusMoving(boolean z, Camera camera) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
            eVar.c("FocusManager", "auto focus move: " + z);
            if (e.this.k != null) {
                if (z) {
                    e.this.k.onAutoFocusStart();
                } else {
                    e.this.k.onAutoFocusStop();
                }
            }
        }
    };

    public e(Context context, String str, int i, int i2) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
        eVar.c("FocusManager", "default focus mode: " + str + " preview width: " + i + " preview height: " + i2);
        this.g = str;
        this.b = i;
        this.f13828c = i2;
        b();
        c();
        a(context);
    }

    private String a(Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String str = (!this.d || this.i == null) ? this.g : "auto";
        String focusMode = !c.a(str, supportedFocusModes) ? c.a("auto", parameters.getSupportedFocusModes()) ? "auto" : parameters.getFocusMode() : str;
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
        eVar.c("FocusManager", "selected focus mode:" + focusMode);
        return focusMode;
    }

    private void a() {
        Camera.Parameters k = a.a().k();
        if (k == null) {
            com.qiniu.pili.droid.shortvideo.f.e.f.d("FocusManager", "param is null while getParameters");
            return;
        }
        if (this.d) {
            k.setFocusAreas(this.i);
        }
        if (this.e) {
            k.setMeteringAreas(this.j);
        }
        k.setFocusMode(a(k));
        a.a().a(k);
    }

    private void a(int i, int i2, float f, int i3, int i4, int i5, int i6, Rect rect) {
        int i7 = (int) (i * f);
        int i8 = (int) (i2 * f);
        int a2 = c.a(i3 - (i7 / 2), 0, i5 - i7);
        int a3 = c.a(i4 - (i8 / 2), 0, i6 - i8);
        RectF rectF = new RectF(a2, a3, a2 + i7, a3 + i8);
        this.h.mapRect(rectF);
        c.a(rectF, rect);
    }

    private void a(Context context) {
        Matrix matrix = new Matrix();
        c.a(matrix, a.a().j(), b(context), this.b, this.f13828c);
        matrix.invert(this.h);
    }

    private int b(Context context) {
        int b = c.b(context);
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
        eVar.c("FocusManager", "handle setting camera orientation, mCameraInfo.facing:" + a.a().c().facing + ",degrees:" + b + ",orientation:" + a.a().c().orientation);
        return a.a().j() ? (360 - ((a.a().c().orientation + b) % 360)) % 360 : ((a.a().c().orientation - b) + 360) % 360;
    }

    private void b() {
        Camera.Parameters k = a.a().k();
        if (k == null) {
            com.qiniu.pili.droid.shortvideo.f.e.f.d("FocusManager", "param is null while getParameters");
            return;
        }
        this.d = k.getMaxNumFocusAreas() > 0 && c.a("auto", k.getSupportedFocusModes());
        this.e = k.getMaxNumMeteringAreas() > 0;
    }

    private void c() {
        Camera.Parameters k = a.a().k();
        if (k == null) {
            com.qiniu.pili.droid.shortvideo.f.e.f.d("FocusManager", "param is null while getParameters");
            return;
        }
        String focusMode = k.getFocusMode();
        if ("continuous-video".equals(focusMode) || "continuous-picture".equals(focusMode)) {
            a.a().a(this.m);
        }
    }

    private void d() {
        com.qiniu.pili.droid.shortvideo.f.e.f.c("FocusManager", "start manual focus.");
        this.f13827a = 1;
        this.f = System.currentTimeMillis();
        a.a().a(this.l);
        PLFocusListener pLFocusListener = this.k;
        if (pLFocusListener != null) {
            pLFocusListener.onManualFocusStart(true);
        }
    }

    private void e() {
        com.qiniu.pili.droid.shortvideo.f.e.f.c("FocusManager", "cancel manual focus.");
        this.f13827a = 0;
        a.a().e();
        f();
        PLFocusListener pLFocusListener = this.k;
        if (pLFocusListener != null) {
            pLFocusListener.onManualFocusCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.i = null;
        this.j = null;
        a();
    }

    public void a(int i, int i2, int i3, int i4) {
        int i5;
        if (!this.d) {
            com.qiniu.pili.droid.shortvideo.f.e.f.d("FocusManager", "focus not supported on current camera.");
            PLFocusListener pLFocusListener = this.k;
            if (pLFocusListener != null) {
                pLFocusListener.onManualFocusStart(false);
                return;
            }
            return;
        }
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f;
        eVar.c("FocusManager", "focus on x: " + i3 + " y: " + i4 + " width: " + i + " height: " + i2);
        if (this.i != null && ((i5 = this.f13827a) == 1 || i5 == 2 || i5 == 3)) {
            e();
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        a(i, i2, 1.0f, i3, i4, this.b, this.f13828c, rect);
        a(i, i2, 1.5f, i3, i4, this.b, this.f13828c, rect2);
        if (this.i == null) {
            ArrayList arrayList = new ArrayList();
            this.i = arrayList;
            arrayList.add(new Camera.Area(rect, 1));
            ArrayList arrayList2 = new ArrayList();
            this.j = arrayList2;
            arrayList2.add(new Camera.Area(rect2, 1));
        }
        a();
        d();
    }

    public void a(PLFocusListener pLFocusListener) {
        this.k = pLFocusListener;
    }
}
