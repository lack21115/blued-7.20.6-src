package com.zk_oaction.adengine.lk_view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.view.ViewGroup;
import com.zk_oaction.adengine.lk_view.n;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/c.class */
public class c extends ViewGroup implements com.zk_oaction.adengine.lk_sdk.interfaces.f {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f42040a;
    private n b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f42041c;
    private String d;

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/c$a.class */
    class a implements n.i {

        /* renamed from: com.zk_oaction.adengine.lk_view.c$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/c$a$a.class */
        class RunnableC1115a implements Runnable {
            RunnableC1115a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.invalidate();
            }
        }

        a() {
        }

        @Override // com.zk_oaction.adengine.lk_view.n.i
        public void a() {
            if (c.this.f42041c != null && !c.this.f42041c.isRecycled()) {
                c.this.f42041c.recycle();
                c.this.f42041c = null;
            }
            Handler handler = c.this.getHandler();
            if (handler != null) {
                handler.postDelayed(new RunnableC1115a(), 0L);
            }
        }
    }

    public c(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar.j);
        this.f42040a = cVar;
        n nVar = new n(cVar, new a());
        this.b = nVar;
        addView(nVar);
    }

    public void a() {
        n nVar = this.b;
        if (nVar != null) {
            nVar.d();
            this.b = null;
        }
    }

    public void a(float f) {
        this.b.a(f);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void a(String str) {
        this.b.a(str);
    }

    public void a(String str, int i, String str2, String str3, String str4) {
        this.b.a(str, i, str2, str3, str4);
    }

    public void a(boolean z) {
        this.b.a(z);
    }

    public void a(boolean z, boolean z2) {
        this.b.a(z, z2);
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        return this.b.a(xmlPullParser);
    }

    public void b() {
        this.b.b();
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void b(String str) {
    }

    public void c() {
        this.b.c();
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void c(String str) {
    }

    public float d() {
        return this.b.e();
    }

    public void d(String str) {
        this.d = this.f42040a.l + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        String str;
        super.dispatchDraw(canvas);
        if (this.b.l || (str = this.d) == null) {
            return;
        }
        if (this.f42041c == null) {
            this.f42041c = BitmapFactory.decodeFile(str);
        }
        Bitmap bitmap = this.f42041c;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight()), (Paint) null);
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public String e() {
        return this.b.a();
    }

    public void e(String str) {
        this.b.b(str);
    }

    public float f() {
        return this.b.f();
    }

    public float g() {
        return this.b.g();
    }

    public float h() {
        return this.b.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.b.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.b.measure(i, i2);
        setMeasuredDimension(this.b.getMeasuredWidth(), this.b.getMeasuredHeight());
    }
}
