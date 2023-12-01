package com.zk_oaction.adengine.lk_view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import com.zk_oaction.adengine.lk_expression.c;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/g.class */
public class g extends com.zk_oaction.adengine.lk_view.b implements c.b, com.zk_oaction.adengine.lk_sdk.interfaces.a {
    protected String T;
    protected String U;
    protected com.zk_oaction.adengine.lk_interfaces.b V;
    protected Bitmap W;
    protected Paint aa;
    protected Bitmap ab;
    protected h ac;
    protected String ad;
    protected Bitmap ae;
    protected Bitmap af;
    protected BitmapFactory.Options ag;
    protected HandlerThread ah;
    protected Handler ai;
    protected boolean aj;
    protected int ak;
    ViewTreeObserver.OnGlobalLayoutListener al;
    private com.zk_oaction.adengine.lk_view.a am;
    private Path an;
    private float ao;
    private float ap;
    private float aq;

    /* renamed from: ar  reason: collision with root package name */
    private float f28375ar;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/g$a.class */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                com.zk_oaction.adengine.lk_sdk.c cVar = g.this.t;
                if (cVar == null || cVar.k == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(g.this.u)) {
                    hashMap.put("name", g.this.u);
                }
                hashMap.put("type", "onGlobalLayout");
                g gVar = g.this;
                gVar.t.k.a(gVar, hashMap);
                g.this.getViewTreeObserver().removeOnGlobalLayoutListener(g.this.al);
                g.this.al = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/g$b.class */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                synchronized (g.this) {
                    g gVar = g.this;
                    gVar.af = BitmapFactory.decodeFile(g.this.t.l + message.obj, g.this.ag);
                }
                g.this.postInvalidate();
            } catch (Throwable th) {
            }
        }
    }

    public g(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.W = null;
        this.aa = null;
        this.ak = 3;
    }

    private void a(Canvas canvas) {
        h hVar = this.ac;
        if (hVar != null) {
            hVar.c();
            canvas.drawBitmap(this.ac.d(), (Rect) null, this.s, (Paint) null);
            return;
        }
        Bitmap n = n();
        if (i()) {
            a(canvas, n);
        } else if (n != null) {
            canvas.drawBitmap(n, (Rect) null, this.s, this.aa);
            this.W = n;
        } else {
            Bitmap bitmap = this.W;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(this.W, (Rect) null, this.s, this.aa);
        }
    }

    private void a(Canvas canvas, Bitmap bitmap) {
        if (bitmap != null) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, com.zk_oaction.adengine.lk_sdk.c.f28239a, com.zk_oaction.adengine.lk_sdk.c.b, this.aa, 31);
            f fVar = this.e;
            if (fVar != null && fVar.s().size() > 0) {
                Iterator<g> it = this.e.s().iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    Bitmap n = next.n();
                    Rect p = next.p();
                    if (n != null) {
                        canvas.drawBitmap(n, (Rect) null, p, (Paint) null);
                    }
                }
            }
            if (!TextUtils.isEmpty(this.ad)) {
                this.aa.setXfermode(com.zk_oaction.adengine.lk_util.a.a(this.ad));
            }
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, p(), this.aa);
            }
            this.aa.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        }
    }

    private boolean b(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.a aVar = new com.zk_oaction.adengine.lk_view.a(this.t);
        if (aVar.a(xmlPullParser)) {
            aVar.a(this);
            aVar.a();
            a(aVar);
            return true;
        }
        return false;
    }

    private boolean c(XmlPullParser xmlPullParser) {
        this.U = this.T;
        return m();
    }

    private void f(String str) {
        try {
            if (TextUtils.isEmpty(str) || !"1".equals(str)) {
                return;
            }
            this.al = new a();
            getViewTreeObserver().addOnGlobalLayoutListener(this.al);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Rect p() {
        Rect rect = new Rect(this.s);
        float a2 = this.v.a();
        float a3 = this.w.a();
        rect.left = (int) (rect.left + a2);
        rect.top = (int) (rect.top + a3);
        rect.right = (int) (a2 + rect.right);
        rect.bottom = (int) (rect.bottom + a3);
        return rect;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void a() {
    }

    public void a(com.zk_oaction.adengine.lk_view.a aVar) {
        this.am = aVar;
        this.an = new Path();
        this.aq = this.v.a();
        this.f28375ar = this.w.a();
        this.t.q.add(this);
    }

    @Override // com.zk_oaction.adengine.lk_view.b, com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
        if (str == null) {
            return;
        }
        if (!str.equals("srcid")) {
            super.a(str, f);
            return;
        }
        int lastIndexOf = this.T.lastIndexOf(46);
        this.U = this.T.substring(0, lastIndexOf) + "_" + ((int) f) + this.T.substring(lastIndexOf);
        m();
    }

    public void a(String str, Bitmap bitmap) {
        this.T = str;
        this.ab = bitmap;
        invalidate();
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean a(float f, float f2) {
        return true;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void b(float f, float f2) {
        if (this.am == null || getVisibility() != 0) {
            return;
        }
        this.ao = f;
        this.ap = f2;
        this.an.moveTo(f - this.aq, f2 - this.f28375ar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x014e, code lost:
        if (b(r10) == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(org.xmlpull.v1.XmlPullParser r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_view.g.b(org.xmlpull.v1.XmlPullParser, java.lang.String):boolean");
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void c(float f, float f2) {
        if (this.am == null || getVisibility() != 0) {
            return;
        }
        float abs = Math.abs(f - this.ao);
        float abs2 = Math.abs(f2 - this.ap);
        if (abs > 3.0f || abs2 > 3.0f) {
            this.an.lineTo(f - this.aq, f2 - this.f28375ar);
        }
        this.ao = f;
        this.ap = f2;
        invalidate();
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean c() {
        return false;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void d() {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void d(float f, float f2) {
        if (this.am == null || getVisibility() != 0) {
            return;
        }
        this.am.e();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.zk_oaction.adengine.lk_view.a aVar;
        try {
            synchronized (this) {
                Bitmap bitmap = this.af;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, (Rect) null, this.s, this.aa);
                    return;
                }
                com.zk_oaction.adengine.lk_interfaces.b bVar = this.V;
                if (bVar == null && this.ab == null) {
                    return;
                }
                if (bVar == null || (aVar = this.am) == null) {
                    a(canvas);
                } else if (!aVar.f()) {
                    this.am.b().drawPath(this.an, this.am.d());
                    canvas.drawBitmap(this.am.c(), 0.0f, 0.0f, (Paint) null);
                } else {
                    this.am.g();
                    this.am = null;
                    setVisibility(8);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void e(float f, float f2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0165 A[Catch: all -> 0x01ad, TryCatch #2 {all -> 0x01b2, blocks: (B:3:0x0001, B:5:0x0003, B:8:0x000a, B:10:0x000c, B:12:0x0018, B:15:0x0027, B:17:0x002e, B:19:0x0071, B:21:0x007d, B:23:0x00a7, B:27:0x0157, B:29:0x015f, B:31:0x0165, B:32:0x018f, B:33:0x0192, B:24:0x00af, B:26:0x0119), top: B:41:0x0001 }] */
    @Override // com.zk_oaction.adengine.lk_view.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_view.g.e(java.lang.String):void");
    }

    @Override // com.zk_oaction.adengine.lk_expression.c.b
    public void h_(String str) {
        this.U = str;
        m();
    }

    @Override // com.zk_oaction.adengine.lk_view.b
    protected boolean i() {
        return (this.e == null || TextUtils.isEmpty(this.ad)) ? false : true;
    }

    protected boolean m() {
        try {
            this.V = this.t.a(this.U, this, this.ak);
            if (this.x.a() == 0.0f || this.y.a() == 0.0f) {
                a(this.V.d(), this.V.c());
            }
            invalidate();
            return true;
        } catch (Exception e) {
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public Bitmap n() {
        Bitmap bitmap = this.ab;
        return bitmap != null ? bitmap : this.V.b();
    }

    public String o() {
        return this.ad;
    }

    @Override // android.view.View
    protected boolean onSetAlpha(int i) {
        if (Build.VERSION.SDK_INT <= 19) {
            return false;
        }
        if (this.aa == null) {
            Paint paint = new Paint();
            this.aa = paint;
            paint.setAntiAlias(true);
        }
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        int i3 = i2;
        if (i2 > 255) {
            i3 = 255;
        }
        this.aa.setAlpha(i3);
        return true;
    }

    @Override // com.zk_oaction.adengine.lk_view.b, android.view.View
    public void setTranslationX(float f) {
        if (i()) {
            f = 0.0f;
        }
        super.setTranslationX(f);
        h hVar = this.ac;
        if (hVar == null || hVar.a() != 1) {
            return;
        }
        invalidate();
    }

    @Override // com.zk_oaction.adengine.lk_view.b, android.view.View
    public void setTranslationY(float f) {
        if (i()) {
            f = 0.0f;
        }
        super.setTranslationY(f);
        h hVar = this.ac;
        if (hVar == null || hVar.a() != 1) {
            return;
        }
        invalidate();
    }
}
