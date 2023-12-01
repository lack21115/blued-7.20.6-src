package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dj.class */
public class dj extends ShapeDrawable {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dj$a.class */
    static class a extends RoundRectShape {
        private int Code;
        private int I;
        private int V;

        a(float[] fArr, int i, int i2, int i3) {
            super(fArr, null, null);
            this.Code = i;
            this.I = i2;
            this.V = i3;
        }

        @Override // android.graphics.drawable.shapes.RoundRectShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.V);
            super.draw(canvas, paint);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeWidth(this.I);
            paint.setColor(this.Code);
            paint.setAntiAlias(true);
            super.draw(canvas, paint);
        }
    }

    public dj(Context context, JSONObject jSONObject) {
        int i;
        int i2;
        int i3 = 0;
        float[] fArr = null;
        if (jSONObject != null) {
            String optString = jSONObject.optString("cornerRadius");
            fArr = null;
            if (!TextUtils.isEmpty(optString)) {
                int Code = com.huawei.hms.ads.template.util.a.Code(optString, context);
                fArr = null;
                if (Code > 0) {
                    fArr = new float[8];
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= 8) {
                            break;
                        }
                        fArr[i5] = Code;
                        i4 = i5 + 1;
                    }
                }
            }
            String optString2 = jSONObject.optString("strokeColor");
            i3 = !TextUtils.isEmpty(optString2) ? com.huawei.hms.ads.template.util.a.Code(optString2, 0) : 0;
            String optString3 = jSONObject.optString("fillColor");
            int Code2 = !TextUtils.isEmpty(optString3) ? com.huawei.hms.ads.template.util.a.Code(optString3, 0) : 0;
            String optString4 = jSONObject.optString("strokeWidth");
            if (TextUtils.isEmpty(optString4)) {
                i2 = Code2;
                i = 0;
            } else {
                i2 = Code2;
                i = com.huawei.hms.ads.template.util.a.Code(optString4, context);
            }
        } else {
            i = 0;
            i2 = 0;
        }
        setShape(new a(fArr, i3, i, i2));
    }
}
