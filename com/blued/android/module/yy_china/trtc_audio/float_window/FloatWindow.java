package com.blued.android.module.yy_china.trtc_audio.float_window;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import com.blued.android.core.AppInfo;
import com.blued.android.module.yy_china.trtc_audio.float_window.IFloatWindow;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/trtc_audio/float_window/FloatWindow.class */
public class FloatWindow implements IFloatWindow {
    public int a;
    private View c;
    private IFloatWindow.IFloatWindowCallback f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private int p;
    private int q;
    private int r;
    private int w;
    private int x;
    private int y;
    private boolean z;
    private float m = 0.0f;
    private float n = 0.0f;
    private boolean o = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = true;
    private Context b = AppInfo.d();
    private WindowManager.LayoutParams d = new WindowManager.LayoutParams();
    private WindowManager e = (WindowManager) AppInfo.d().getSystemService("window");

    public FloatWindow(Context context, int i, int i2, int i3, int i4, boolean z, IFloatWindow.IFloatWindowCallback iFloatWindowCallback) {
        this.y = i;
        this.a = i2;
        this.w = i3;
        this.x = i4;
        this.f = iFloatWindowCallback;
        this.z = z;
        this.c = iFloatWindowCallback.a();
        if (Build.VERSION.SDK_INT >= 26) {
            this.d.type = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 23) {
            this.d.type = 2003;
        } else {
            this.d.type = 2005;
        }
        this.d.format = 1;
        this.d.flags = 8;
        this.d.gravity = 51;
        this.d.width = -2;
        this.d.height = -2;
        d();
        c();
    }

    private void c() {
        e();
        this.c.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.yy_china.trtc_audio.float_window.FloatWindow.1
            /* JADX WARN: Removed duplicated region for block: B:113:0x0533 A[Catch: Exception -> 0x0582, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0582, blocks: (B:2:0x0000, B:11:0x001c, B:16:0x0077, B:26:0x00d0, B:31:0x00eb, B:41:0x014b, B:43:0x016d, B:45:0x018e, B:47:0x01a0, B:49:0x01b1, B:51:0x01d3, B:53:0x01f4, B:55:0x020e, B:57:0x0227, B:59:0x025d, B:61:0x0267, B:32:0x00f8, B:34:0x010e, B:36:0x012c, B:39:0x0140, B:17:0x0084, B:19:0x0092, B:21:0x00b0, B:24:0x00c4, B:63:0x027d, B:65:0x0292, B:67:0x02a7, B:69:0x02b1, B:71:0x02bb, B:73:0x02d2, B:75:0x0308, B:86:0x03ec, B:97:0x04bd, B:99:0x04e7, B:101:0x04f1, B:103:0x0506, B:76:0x0332, B:78:0x0340, B:80:0x0356, B:82:0x0368, B:83:0x038a, B:84:0x03bc, B:105:0x0514, B:107:0x051a, B:113:0x0533, B:88:0x0401, B:90:0x0413, B:92:0x045e, B:94:0x0470), top: B:126:0x0000, inners: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onTouch(final android.view.View r8, android.view.MotionEvent r9) {
                /*
                    Method dump skipped, instructions count: 1425
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.trtc_audio.float_window.FloatWindow.AnonymousClass1.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    private void d() {
        Point point = new Point();
        ((WindowManager) AppInfo.d().getSystemService("window")).getDefaultDisplay().getSize(point);
        this.p = point.x;
        this.q = point.y;
    }

    private void e() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            this.r = AppInfo.d().getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ float g(FloatWindow floatWindow, float f) {
        float f2 = floatWindow.k + f;
        floatWindow.k = f2;
        return f2;
    }

    static /* synthetic */ float h(FloatWindow floatWindow, float f) {
        float f2 = floatWindow.l + f;
        floatWindow.l = f2;
        return f2;
    }

    public void a() {
        synchronized (this) {
            this.s = true;
            try {
                if (!this.t && this.u) {
                    this.e.addView(this.c, this.d);
                    this.t = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(int i) {
        int i2;
        if (this.v) {
            if (this.z) {
                this.d.x = this.y - i;
            } else {
                this.d.x = ((this.p - this.y) - this.w) - i;
            }
            this.d.y = ((this.q - this.r) - this.x) - this.a;
            this.m = this.d.x;
            this.n = this.d.y;
            this.v = false;
        } else {
            float f = this.m;
            float f2 = this.w / 2;
            float f3 = this.n;
            int i3 = this.x;
            float f4 = f3 + (i3 / 2);
            if (f4 <= i3) {
                this.n = this.y + this.r;
            } else if (f4 <= i3 || f4 >= this.q - i3) {
                this.n = (this.q - this.y) - this.x;
            } else {
                int i4 = this.p;
                if (f + f2 <= i4 / 2) {
                    this.m = this.y;
                } else {
                    this.m = (i4 - this.y) - i2;
                }
            }
            this.d.x = (int) this.m;
            this.d.y = (int) (this.n - this.r);
        }
        if (this.s && this.t) {
            this.e.updateViewLayout(this.c, this.d);
        }
    }

    public void a(boolean z) {
        this.u = z;
    }

    public void b() {
        synchronized (this) {
            this.s = false;
            try {
                if (this.t) {
                    this.e.removeView(this.c);
                    this.t = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
