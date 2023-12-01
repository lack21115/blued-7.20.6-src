package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.amap.api.col.3sl.ek  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ek.class */
public final class ek extends View {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f4912a;
    private Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f4913c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Paint h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private Context t;
    private boolean u;
    private float v;
    private float w;
    private boolean x;
    private boolean y;

    public ek(Context context) {
        super(context);
        InputStream inputStream;
        this.h = new Paint();
        this.i = false;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 10;
        this.n = 0;
        this.o = 0;
        this.p = 10;
        this.q = 8;
        this.r = false;
        this.s = false;
        this.u = true;
        this.v = 0.0f;
        this.w = 0.0f;
        this.x = true;
        this.y = false;
        if (1 == 0) {
            return;
        }
        InputStream inputStream2 = null;
        try {
            this.t = context.getApplicationContext();
            InputStream open = dq.a(context).open("ap.data");
            InputStream inputStream3 = null;
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                this.f = decodeStream;
                this.f4912a = dw.a(decodeStream, w.f5439a);
                open.close();
                InputStream open2 = dq.a(context).open("ap1.data");
                Bitmap decodeStream2 = BitmapFactory.decodeStream(open2);
                this.g = decodeStream2;
                this.b = dw.a(decodeStream2, w.f5439a);
                open2.close();
                this.k = this.b.getWidth();
                this.j = this.b.getHeight();
                this.h.setAntiAlias(true);
                this.h.setColor(-16777216);
                this.h.setStyle(Paint.Style.STROKE);
                StringBuilder sb = new StringBuilder();
                sb.append(context.getFilesDir());
                sb.append("/icon_web_day.data");
                AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(context.getFilesDir());
                sb2.append("/icon_web_night.data");
                AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = sb2.toString();
                inputStream3 = open2;
                du.a().a(new lc() { // from class: com.amap.api.col.3sl.ek.1
                    @Override // com.amap.api.col.p0003sl.lc
                    public final void runTask() {
                        ek.this.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME, 0);
                        ek.this.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME, 1);
                        if ("".equals(dm.a(ek.this.t, "amap_web_logo", "md5_day", ""))) {
                            if (ek.this.f4913c == null || ek.this.d == null) {
                                dm.a(ek.this.t, "amap_web_logo", "md5_day", (Object) "0b718b5f291b09d2b62be725dfb977b3");
                                dm.a(ek.this.t, "amap_web_logo", "md5_night", (Object) "4b1405462a5c910de0e0723ffd96c018");
                                return;
                            }
                            dm.a(ek.this.t, "amap_web_logo", "md5_day", (Object) hw.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME));
                            String a2 = hw.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME);
                            if (!"".equals(a2)) {
                                dm.a(ek.this.t, "amap_web_logo", "md5_night", (Object) a2);
                            }
                            ek.this.d(true);
                        }
                    }
                });
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (open2 != null) {
                    try {
                        open2.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                inputStream = inputStream3;
                inputStream2 = open;
                th = th3;
                try {
                    iw.c(th, "WaterMarkerView", "create");
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                } catch (Throwable th6) {
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                    throw th6;
                }
            }
        } catch (Throwable th9) {
            th = th9;
            inputStream = null;
        }
    }

    private Bitmap e() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        return (!this.y || (bitmap3 = this.e) == null) ? this.i ? (!this.s || (bitmap2 = this.d) == null) ? this.b : bitmap2 : (!this.s || (bitmap = this.f4913c) == null) ? this.f4912a : bitmap : bitmap3;
    }

    private void f() {
        int i = this.o;
        if (i == 0) {
            h();
        } else if (i == 2) {
            g();
        }
        this.m = this.p;
        this.n = (getHeight() - this.q) - this.j;
        if (this.m < 0) {
            this.m = 0;
        }
        if (this.n < 0) {
            this.n = 0;
        }
    }

    private void g() {
        if (this.x) {
            this.p = (int) (getWidth() * this.v);
        } else {
            this.p = (int) ((getWidth() * this.v) - this.k);
        }
        this.q = (int) (getHeight() * this.w);
    }

    private void h() {
        int i = this.l;
        if (i == 1) {
            this.p = (getWidth() - this.k) / 2;
        } else if (i == 2) {
            this.p = (getWidth() - this.k) - 10;
        } else {
            this.p = 10;
        }
        this.q = 8;
    }

    public final void a() {
        try {
            if (this.f4912a != null) {
                dw.a(this.f4912a);
                this.f4912a = null;
            }
            if (this.b != null) {
                dw.a(this.b);
                this.b = null;
            }
            this.f4912a = null;
            this.b = null;
            if (this.f != null) {
                dw.a(this.f);
                this.f = null;
            }
            if (this.g != null) {
                dw.a(this.g);
                this.g = null;
            }
            if (this.f4913c != null) {
                dw.a(this.f4913c);
            }
            this.f4913c = null;
            if (this.d != null) {
                dw.a(this.d);
            }
            this.d = null;
            if (this.e != null) {
                this.e.recycle();
            }
            this.h = null;
        } catch (Throwable th) {
            iw.c(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public final void a(int i) {
        this.o = 0;
        this.l = i;
        c();
    }

    public final void a(int i, float f) {
        if (this.u) {
            this.o = 2;
            float max = Math.max(0.0f, Math.min(f, 1.0f));
            if (i == 0) {
                this.v = max;
                this.x = true;
            } else if (i == 1) {
                this.v = 1.0f - max;
                this.x = false;
            } else if (i == 2) {
                this.w = 1.0f - max;
            }
            c();
        }
    }

    public final void a(String str, int i) {
        try {
            if (this.u && new File(str).exists()) {
                if (i == 0) {
                    Bitmap bitmap = this.f4913c;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    this.f = decodeFile;
                    this.f4913c = dw.a(decodeFile, w.f5439a);
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    dw.a(bitmap);
                } else if (i == 1) {
                    Bitmap bitmap2 = this.d;
                    Bitmap decodeFile2 = BitmapFactory.decodeFile(str);
                    this.f = decodeFile2;
                    this.d = dw.a(decodeFile2, w.f5439a);
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    dw.a(bitmap2);
                }
            }
        } catch (Throwable th) {
            iw.c(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (this.u) {
            try {
                this.i = z;
                if (z) {
                    this.h.setColor(-1);
                } else {
                    this.h.setColor(-16777216);
                }
            } catch (Throwable th) {
                iw.c(th, "WaterMarkerView", "changeBitmap");
                th.printStackTrace();
            }
        }
    }

    public final Point b() {
        return new Point(this.m, this.n - 2);
    }

    public final void b(int i) {
        this.o = 1;
        this.q = i;
        c();
    }

    public final void b(boolean z) {
        if (this.u) {
            this.y = z;
            if (!z) {
                this.k = this.f4912a.getWidth();
                this.j = this.f4912a.getHeight();
                return;
            }
            Bitmap bitmap = this.e;
            if (bitmap != null) {
                this.k = bitmap.getWidth();
                this.j = this.e.getHeight();
            }
        }
    }

    public final void c() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        f();
        postInvalidate();
    }

    public final void c(int i) {
        this.o = 1;
        this.p = i;
        c();
    }

    public final void c(boolean z) {
        this.u = z;
    }

    public final float d(int i) {
        float f;
        if (this.u) {
            if (i != 0) {
                if (i == 1) {
                    f = this.v;
                } else if (i != 2) {
                    return 0.0f;
                } else {
                    f = this.w;
                }
                return 1.0f - f;
            }
            return this.v;
        }
        return 0.0f;
    }

    public final void d(boolean z) {
        if (this.u && this.s != z) {
            this.s = z;
            if (!z) {
                this.k = this.f4912a.getWidth();
                this.j = this.f4912a.getHeight();
            } else if (this.i) {
                Bitmap bitmap = this.d;
                if (bitmap != null) {
                    this.k = bitmap.getWidth();
                    this.j = this.d.getHeight();
                }
            } else {
                Bitmap bitmap2 = this.f4913c;
                if (bitmap2 != null) {
                    this.k = bitmap2.getWidth();
                    this.j = this.f4913c.getHeight();
                }
            }
        }
    }

    public final boolean d() {
        return this.i;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        try {
            if (!this.u || getWidth() == 0 || getHeight() == 0 || this.b == null) {
                return;
            }
            if (!this.r) {
                f();
                this.r = true;
            }
            canvas.drawBitmap(e(), this.m, this.n, this.h);
        } catch (Throwable th) {
            iw.c(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }
}
