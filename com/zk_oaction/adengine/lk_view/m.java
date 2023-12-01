package com.zk_oaction.adengine.lk_view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.zk_oaction.adengine.lk_expression.c;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/m.class */
public class m extends b implements c.b {
    protected TextPaint T;
    protected Paint.FontMetrics U;
    protected String V;
    private StaticLayout W;
    private boolean aa;
    private Layout.Alignment ab;
    private com.zk_oaction.adengine.lk_expression.a ac;
    private com.zk_oaction.adengine.lk_expression.a ad;
    private com.zk_oaction.adengine.lk_expression.a ae;
    private int af;
    private com.zk_oaction.adengine.lk_expression.a ag;
    private com.zk_oaction.adengine.lk_expression.a ah;

    public m(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.aa = false;
        TextPaint textPaint = new TextPaint();
        this.T = textPaint;
        textPaint.setFlags(1);
    }

    private void f(String str) {
        int parseColor;
        int i = 0;
        try {
            parseColor = Color.parseColor("#20000000");
        } catch (Throwable th) {
        }
        try {
            String[] split = str.split("\\|");
            this.ac = new com.zk_oaction.adengine.lk_expression.a(this.t, "shadowRadius", split[0], 2.0f, this, true);
            this.ad = new com.zk_oaction.adengine.lk_expression.a(this.t, "shadowDx", split[1], 1.0f, this, true);
            this.ae = new com.zk_oaction.adengine.lk_expression.a(this.t, "shadowDy", split[1], 1.0f, this, true);
            this.af = split.length == 4 ? Color.parseColor(split[3].replace(" ", "")) : Color.parseColor("#20000000");
        } catch (Throwable th2) {
            i = parseColor;
            this.af = i;
        }
    }

    @Override // com.zk_oaction.adengine.lk_view.b, com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
        com.zk_oaction.adengine.lk_expression.a aVar;
        if (str != null && str.equals("size")) {
            this.T.setTextSize(f);
        } else if ((str.equals("shadowRadius") && this.ac != null) || ((str.equals("shadowDx") && this.ad != null) || (str.equals("shadowDy") && this.ae != null))) {
            TextPaint textPaint = this.T;
            float f2 = 0.0f;
            if (this.n > 0.0f) {
                f2 = this.ac.a() / 2.0f;
            }
            textPaint.setShadowLayer(f2, this.ad.a(), this.ae.a(), this.af);
        } else if (str.equals("bold") && (aVar = this.ag) != null) {
            this.T.setFakeBoldText(aVar.a() == 1.0f);
        } else if (str != null) {
            super.a(str, f);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(17:2|3|(1:5)|6|7|(1:9)|10|11|(1:13)|14|15|(1:69)(1:19)|20|21|(2:63|(1:68)(1:67))(1:25)|26|27)|(1:29)(7:56|57|(1:59)|60|(1:62)|52|53)|30|31|32|(5:34|35|(1:37)|38|39)|40|41|(5:43|44|45|(2:47|48)|49)|51|52|53) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(org.xmlpull.v1.XmlPullParser r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_view.m.b(org.xmlpull.v1.XmlPullParser, java.lang.String):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void draw(Canvas canvas) {
        this.T.setAlpha((int) (this.n * this.j));
        if (!this.aa) {
            canvas.drawText(this.V, 0.0f, -this.U.top, this.T);
            return;
        }
        StaticLayout staticLayout = this.W;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
    }

    @Override // com.zk_oaction.adengine.lk_expression.c.b
    public void h_(String str) {
        int a2;
        int i;
        int a3;
        try {
            if (str.equals(com.igexin.push.core.b.l)) {
                str = "";
            }
            this.V = str;
            com.zk_oaction.adengine.lk_expression.a aVar = this.ah;
            if (aVar != null && aVar.a() > 0.0f && this.V.length() > (a3 = (int) this.ah.a())) {
                this.V = this.V.substring(0, a3) + "...";
            }
            if (this.aa) {
                if (this.x.a() <= 0.0f) {
                    a2 = (int) this.T.measureText(this.V);
                    Paint.FontMetrics fontMetrics = this.U;
                    i = (int) (fontMetrics.bottom - fontMetrics.top);
                } else {
                    int measureText = (int) this.T.measureText(this.V.substring(0, 1));
                    int i2 = 1;
                    while (i2 < this.V.length() - 1) {
                        int i3 = i2 + 1;
                        int measureText2 = (int) this.T.measureText(this.V.substring(i2, i3));
                        int i4 = measureText;
                        if (measureText < measureText2) {
                            i4 = measureText2;
                        }
                        i2 = i3;
                        measureText = i4;
                    }
                    int a4 = (int) (this.x.a() / measureText);
                    if (a4 <= 0) {
                        a4 = 1;
                    }
                    int ceil = (int) Math.ceil((this.V.length() * 1.0f) / a4);
                    a2 = (int) this.x.a();
                    Paint.FontMetrics fontMetrics2 = this.U;
                    i = ceil * ((int) (fontMetrics2.bottom - fontMetrics2.top));
                }
                a(a2, i);
                this.W = new StaticLayout(this.V, this.T, (int) this.x.a(), this.ab, 1.0f, 0.0f, true);
                forceLayout();
                postInvalidate();
            } else {
                int measureText3 = (int) this.T.measureText(this.V);
                Paint.FontMetrics fontMetrics3 = this.U;
                a(measureText3, (int) (fontMetrics3.bottom - fontMetrics3.top));
            }
            if (this.u != null) {
                this.t.a(this.u + ".text_width", "" + (this.x.a() / this.t.t));
                this.t.a(this.u + ".text_height", "" + (this.y.a() / this.t.t));
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected boolean onSetAlpha(int i) {
        if (Build.VERSION.SDK_INT <= 19) {
            return false;
        }
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        int i3 = i2;
        if (i2 > 255) {
            i3 = 255;
        }
        this.T.setAlpha(i3);
        return true;
    }
}
