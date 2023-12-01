package com.zk_oaction.adengine.lk_view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.cdo.oaps.ad.OapsKey;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/h.class */
public class h extends b {
    private g T;
    private com.zk_oaction.adengine.lk_interfaces.b U;
    private Paint V;
    private String W;
    private int aa;
    private Canvas ab;
    private Bitmap ac;
    private com.zk_oaction.adengine.lk_interfaces.b ad;

    public h(com.zk_oaction.adengine.lk_sdk.c cVar, g gVar) {
        super(cVar);
        this.T = gVar;
    }

    private boolean m() {
        try {
            this.U = this.t.a(this.W, this.T, 3);
            if (this.x.a() == 0.0f || this.y.a() == 0.0f) {
                a(this.U.d(), this.U.c());
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int a() {
        return this.aa;
    }

    @Override // com.zk_oaction.adengine.lk_view.b, com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
        super.a(str, f);
        if (this.aa == 1 || str.equals("width") || str.equals("height")) {
            this.T.invalidate();
        }
    }

    public boolean b(XmlPullParser xmlPullParser, String str) {
        a(xmlPullParser);
        this.W = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SRC);
        String attributeValue = xmlPullParser.getAttributeValue(null, "xfermode");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "align");
        if (attributeValue2 == null || !attributeValue2.equals("absolute")) {
            this.aa = 0;
        } else {
            this.aa = 1;
        }
        if (m()) {
            Paint paint = new Paint();
            this.V = paint;
            paint.setAntiAlias(true);
            this.V.setXfermode(com.zk_oaction.adengine.lk_util.a.a(attributeValue));
            this.ad = this.t.k.a((int) this.T.x.a(), (int) this.T.y.a(), Bitmap.Config.ARGB_8888);
            return true;
        }
        return false;
    }

    public void c() {
        Canvas canvas;
        float a2;
        float a3;
        Bitmap b = this.ad.b();
        if (b == null) {
            return;
        }
        if (b != this.ac) {
            this.ac = b;
            this.ab = new Canvas(this.ac);
        }
        this.ac.eraseColor(0);
        Bitmap n = this.T.n();
        if (n != null) {
            this.ab.drawBitmap(n, (Rect) null, this.T.s, (Paint) null);
        }
        this.ab.save();
        if (this.aa == 1) {
            canvas = this.ab;
            a2 = this.v.a() - this.T.getTranslationX();
            a3 = this.w.a() - this.T.getTranslationY();
        } else {
            canvas = this.ab;
            a2 = this.v.a();
            a3 = this.w.a();
        }
        canvas.translate(a2, a3);
        this.ab.rotate(this.B.a(), this.z.a(), this.A.a());
        Bitmap b2 = this.U.b();
        if (b2 != null) {
            this.ab.drawBitmap(b2, (Rect) null, this.s, this.V);
        }
        this.ab.restore();
    }

    public Bitmap d() {
        return this.ac;
    }
}
