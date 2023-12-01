package com.zk_oaction.adengine.lk_view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.zk_oaction.adengine.lk_expression.a;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/a.class */
public class a implements a.w {

    /* renamed from: a  reason: collision with root package name */
    protected com.zk_oaction.adengine.lk_sdk.c f42014a;
    public Paint b;

    /* renamed from: c  reason: collision with root package name */
    private String f42015c;
    private com.zk_oaction.adengine.lk_expression.a d;
    private int e;
    private String f;
    private com.zk_oaction.adengine.lk_expression.a g;
    private Canvas h;
    private Bitmap i;
    private g j;
    private boolean l;
    private HandlerThread m;
    private Handler n;
    private boolean p;
    private volatile boolean k = false;
    private Runnable o = new RunnableC1113a();

    /* renamed from: com.zk_oaction.adengine.lk_view.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/a$a.class */
    class RunnableC1113a implements Runnable {
        RunnableC1113a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.i == null || a.this.i.isRecycled() || a.this.j == null) {
                return;
            }
            int width = a.this.i.getWidth();
            int height = a.this.i.getHeight();
            int i = width * height;
            float f = i;
            int[] iArr = new int[i];
            a.this.i.getPixels(iArr, 0, width, 0, 0, width, height);
            float f2 = 0.0f;
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = 0;
                while (i3 < height) {
                    float f3 = f2;
                    if (iArr[(i3 * width) + i2] == 0) {
                        f3 = f2 + 1.0f;
                    }
                    i3++;
                    f2 = f3;
                }
            }
            if (f2 <= 0.0f || f <= 0.0f) {
                return;
            }
            int i4 = (int) ((f2 * 100.0f) / f);
            a.this.a(i4);
            if (i4 >= a.this.g.a()) {
                a.this.k = true;
                a.this.j.postInvalidate();
                a.this.a(100);
            }
        }
    }

    public a(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f42014a = cVar;
        cVar.h.add(this);
        HandlerThread handlerThread = new HandlerThread("brush_paint");
        this.m = handlerThread;
        handlerThread.start();
        this.n = new Handler(this.m.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (TextUtils.isEmpty(this.f42015c)) {
            return;
        }
        this.f42014a.n.a(this.f42015c + ".wipe", "" + i);
    }

    public void a() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setAlpha(0);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.b.setStrokeJoin(Paint.Join.ROUND);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.d.a());
        this.b.setXfermode(com.zk_oaction.adengine.lk_util.a.a(this.f));
        com.zk_oaction.adengine.lk_interfaces.b bVar = this.j.V;
        if (bVar != null) {
            this.i = Bitmap.createBitmap(bVar.d(), this.j.V.c(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.i);
            this.h = canvas;
            int i = this.e;
            if (i != 0) {
                canvas.drawColor(i);
            } else {
                Bitmap b = this.j.V.b();
                if (b != null) {
                    this.h.drawBitmap(b, 0.0f, 0.0f, (Paint) null);
                    this.p = true;
                }
            }
        }
        this.j.invalidate();
    }

    public void a(g gVar) {
        this.j = gVar;
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
        if (str == null || !str.equals("weight") || this.d == null) {
            return;
        }
        this.b.setStrokeWidth(f);
    }

    public boolean a(XmlPullParser xmlPullParser) {
        try {
            this.f42015c = xmlPullParser.getAttributeValue(null, "name");
            this.d = new com.zk_oaction.adengine.lk_expression.a(this.f42014a, "weight", xmlPullParser.getAttributeValue(null, "weight"), 0.0f, this, true);
            this.g = new com.zk_oaction.adengine.lk_expression.a(this.f42014a, "clear_percent", xmlPullParser.getAttributeValue(null, "clear_percent"), 60.0f, this, false);
            String attributeValue = xmlPullParser.getAttributeValue(null, "color");
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "xfermode");
            if (!TextUtils.isEmpty(attributeValue)) {
                this.e = Color.parseColor(attributeValue);
            }
            if (this.g.a() > 100.0f) {
                this.g.a(100.0f);
            } else if (this.g.a() == 0.0f) {
                this.g.a(60.0f);
            }
            if (TextUtils.isEmpty(attributeValue2)) {
                return true;
            }
            this.f = attributeValue2;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public Canvas b() {
        return this.h;
    }

    public Bitmap c() {
        Bitmap b;
        if (!this.p && (b = this.j.V.b()) != null) {
            this.h.drawBitmap(b, 0.0f, 0.0f, (Paint) null);
            this.p = true;
        }
        return this.i;
    }

    public Paint d() {
        return this.b;
    }

    public void e() {
        this.n.removeCallbacksAndMessages(null);
        this.n.postDelayed(this.o, 50L);
    }

    public boolean f() {
        return this.k;
    }

    public void g() {
        if (this.l) {
            return;
        }
        Bitmap bitmap = this.i;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.i.recycle();
        }
        this.h = null;
        this.l = true;
    }
}
