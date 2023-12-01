package com.zk_oaction.adengine.lk_view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.cdo.oaps.ad.OapsKey;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/i.class */
public class i extends b {
    private String T;
    private String U;
    private com.zk_oaction.adengine.lk_expression.a V;
    private com.zk_oaction.adengine.lk_interfaces.b[] W;
    private Paint aa;

    public i(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.aa = null;
        this.W = new com.zk_oaction.adengine.lk_interfaces.b[10];
    }

    private void a() {
        try {
            String str = "" + ((int) this.V.a());
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i >= str.length()) {
                    a(i2, i4);
                    return;
                }
                com.zk_oaction.adengine.lk_interfaces.b bVar = this.W[str.charAt(i) - '0'];
                int d = bVar.d();
                int i5 = i4;
                if (i4 < bVar.c()) {
                    i5 = bVar.c();
                }
                i++;
                i2 += d;
                i3 = i5;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zk_oaction.adengine.lk_view.b, com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
        if (str.equals("number")) {
            a();
        } else {
            super.a(str, f);
        }
    }

    public boolean b(XmlPullParser xmlPullParser, String str) {
        a(xmlPullParser);
        try {
            String attributeValue = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SRC);
            int lastIndexOf = attributeValue.lastIndexOf(46);
            this.T = attributeValue.substring(0, lastIndexOf);
            this.U = attributeValue.substring(lastIndexOf);
            this.V = new com.zk_oaction.adengine.lk_expression.a(this.t, "number", xmlPullParser.getAttributeValue(null, "number"), 0.0f, null, false);
            for (int i = 0; i < 10; i++) {
                try {
                    this.W[i] = this.t.a(this.T + BridgeUtil.UNDERLINE_STR + i + this.U, this, 3);
                } catch (Exception e) {
                }
            }
            this.V.a(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return a(xmlPullParser, str);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void draw(Canvas canvas) {
        try {
            String str = "" + ((int) this.V.a());
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= str.length()) {
                    return;
                }
                Bitmap b = this.W[str.charAt(i) - '0'].b();
                int i4 = i3;
                if (b != null) {
                    canvas.drawBitmap(b, i3, 0.0f, this.aa);
                    i4 = i3 + b.getWidth();
                }
                i++;
                i2 = i4;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
