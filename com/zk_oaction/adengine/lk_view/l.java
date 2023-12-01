package com.zk_oaction.adengine.lk_view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.zk_oaction.adengine.lk_expression.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/l.class */
public class l extends View implements a.w, com.zk_oaction.adengine.lk_sdk.interfaces.a {

    /* renamed from: a  reason: collision with root package name */
    public com.zk_oaction.adengine.lk_expression.a f42072a;
    public com.zk_oaction.adengine.lk_expression.a b;

    /* renamed from: c  reason: collision with root package name */
    public com.zk_oaction.adengine.lk_expression.a f42073c;
    public com.zk_oaction.adengine.lk_expression.a d;
    protected com.zk_oaction.adengine.lk_sdk.c e;
    public int f;
    private List<j> g;
    private List<Rect> h;
    private boolean i;
    private com.zk_oaction.adengine.lk_expression.a j;
    private com.zk_oaction.adengine.lk_expression.a k;
    private com.zk_oaction.adengine.lk_expression.a l;
    private com.zk_oaction.adengine.lk_interfaces.b m;
    private k n;
    private Thread o;
    private float p;
    private float q;
    private boolean r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/l$b.class */
    public class b implements View.OnTouchListener {
        private b() {
        }

        private void a(MotionEvent motionEvent) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float f = l.this.p;
            float f2 = l.this.q;
            if (Math.abs(x - f) > 40.0f || Math.abs(y - f2) > 40.0f) {
                if (l.this.r) {
                    com.zk_oaction.adengine.lk_expression.a aVar = l.this.d;
                    if (aVar == null || aVar.a() != 1.0f || l.this.h(x, y)) {
                        l.this.f(x, y);
                        return;
                    }
                    return;
                }
                int childCount = l.this.e.m.getChildCount();
                boolean z = false;
                for (int i = 0; i < childCount; i++) {
                    if (l.this.e.m.getChildAt(i) instanceof l) {
                        z = true;
                    }
                }
                if (z) {
                    return;
                }
                l lVar = l.this;
                lVar.e.m.a(lVar);
                l.this.r = true;
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 2) {
                    return true;
                }
                a(motionEvent);
                return true;
            }
            l.this.p = motionEvent.getX();
            l.this.q = motionEvent.getY();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/l$c.class */
    public class c extends Thread {
        private c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            while (l.this.i) {
                synchronized (l.this.g) {
                    l.this.n.a(l.this.g, l.this);
                    if (l.this.g.size() == 0) {
                        l.this.i = false;
                        if (l.this.r) {
                            l lVar = l.this;
                            lVar.e.m.b(lVar);
                            l.this.r = false;
                        }
                    }
                }
                l.this.postInvalidate();
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public l(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar.j);
        this.i = false;
        this.r = false;
        this.e = cVar;
        this.f = com.zk_oaction.adengine.lk_sdk.c.f41930a;
        b();
    }

    private void b() {
        this.g = Collections.synchronizedList(new ArrayList());
        this.h = new ArrayList();
        this.n = new k();
        this.e.m.a(new b());
        setLayerType(1, null);
    }

    private boolean b(XmlPullParser xmlPullParser, String str) {
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return false;
                }
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals(str)) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("PathData") && c(xmlPullParser, "PathData")) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    private boolean c(XmlPullParser xmlPullParser, String str) {
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return false;
                }
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals(str)) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("Range")) {
                    String attributeValue = xmlPullParser.getAttributeValue(null, "rect");
                    if (!TextUtils.isEmpty(attributeValue)) {
                        String[] split = attributeValue.split(",");
                        if (split.length == 4) {
                            Rect rect = new Rect();
                            rect.left = (int) (Float.parseFloat(split[0]) * this.e.t);
                            rect.top = (int) (Float.parseFloat(split[1]) * this.e.t);
                            rect.right = (int) (Float.parseFloat(split[2]) * this.e.t);
                            rect.bottom = (int) (Float.parseFloat(split[3]) * this.e.t);
                            this.h.add(rect);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(float f, float f2) {
        int size = this.g.size();
        g(f, f2);
        if (size == 0) {
            this.i = true;
            c cVar = new c();
            this.o = cVar;
            cVar.start();
        }
    }

    private void g(float f, float f2) {
        synchronized (this.g) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < ((int) this.l.a())) {
                    j jVar = new j();
                    jVar.f42069a = f;
                    jVar.b = f2;
                    jVar.f42070c = this.j.a();
                    jVar.d = this.k.a();
                    jVar.g = new Rect((int) f, (int) f2, (int) (jVar.f42070c + f), (int) (jVar.d + f2));
                    jVar.h = this.n.a();
                    this.g.add(jVar);
                    i = i2 + 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(float f, float f2) {
        if (this.h.size() > 0) {
            for (Rect rect : this.h) {
                if (f >= rect.left && f <= rect.right && f2 >= rect.top && f2 <= rect.bottom) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void a() {
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean a(float f, float f2) {
        return true;
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, IAdInterListener.AdReqParam.WIDTH);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "h");
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "count");
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "move_radius");
        String attributeValue5 = xmlPullParser.getAttributeValue(null, "speek_sec");
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "reduce_size");
        String attributeValue7 = xmlPullParser.getAttributeValue(null, "set_path");
        String attributeValue8 = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SRC);
        this.j = new com.zk_oaction.adengine.lk_expression.a(this.e, IAdInterListener.AdReqParam.WIDTH, attributeValue, 60.0f, this, true);
        this.k = new com.zk_oaction.adengine.lk_expression.a(this.e, "h", attributeValue2, 60.0f, this, true);
        this.l = new com.zk_oaction.adengine.lk_expression.a(this.e, "count", attributeValue3, 6.0f, this, false);
        this.f42072a = new com.zk_oaction.adengine.lk_expression.a(this.e, "speek_sec", attributeValue5, 2.5f, this, true);
        this.f42073c = new com.zk_oaction.adengine.lk_expression.a(this.e, "move_radius", attributeValue4, 16.0f, this, true);
        this.b = new com.zk_oaction.adengine.lk_expression.a(this.e, "reduce_size", attributeValue6, 3.0f, this, true);
        this.d = new com.zk_oaction.adengine.lk_expression.a(this.e, "set_path", attributeValue7, 0.0f, this, false);
        if (!TextUtils.isEmpty(attributeValue8)) {
            String str2 = attributeValue8;
            if (attributeValue8.charAt(0) == '@') {
                str2 = this.e.n.b(attributeValue8.substring(1));
            }
            this.m = this.e.a(str2, this, 3);
        }
        if (this.d.a() == 1.0f) {
            b(xmlPullParser, str);
            return true;
        }
        return true;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void b(float f, float f2) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void c(float f, float f2) {
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
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void e(float f, float f2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g.clear();
        this.o = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        synchronized (this.g) {
            Bitmap b2 = this.m.b();
            if (b2 != null && !b2.isRecycled()) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.g.size()) {
                        break;
                    }
                    j jVar = this.g.get(i2);
                    canvas.drawBitmap(b2, (Rect) null, jVar.g, jVar.h);
                    i = i2 + 1;
                }
            }
        }
    }
}
