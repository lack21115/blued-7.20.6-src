package com.huawei.hms.ads.template.dtimageview;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.ImageView;
import com.huawei.hms.ads.cc;
import com.huawei.hms.ads.ci;
import com.huawei.hms.ads.ck;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/dtimageview/DTImageView.class */
public class DTImageView extends ImageView implements com.huawei.hms.ads.template.view.a {
    private static final String V = DTImageView.class.getSimpleName();
    private cc B;
    private Context C;
    final Rect Code;
    private float D;
    private boolean F;
    private ArrayMap<String, String> L;
    private boolean S;

    /* renamed from: a  reason: collision with root package name */
    private int f8916a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private a f8917c;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/dtimageview/DTImageView$a.class */
    public enum a {
        DEFAULT(0),
        CIRCLE(1),
        ROUND_CORNER(2);
        
        final int Z;

        a(int i) {
            this.Z = i;
        }
    }

    public DTImageView(Context context) {
        super(context);
        this.Code = new Rect();
    }

    public DTImageView(Context context, AttributeSet attributeSet) {
        super(context);
        this.Code = new Rect();
        this.C = context;
        this.L = new ArrayMap<>();
        if (attributeSet == null) {
            return;
        }
        cc ccVar = new cc(this);
        this.B = ccVar;
        ccVar.Code((ci) new ck(this));
        this.B.Code(attributeSet);
        Pair<Integer, Integer> Code = com.huawei.hms.ads.template.util.a.Code(attributeSet, this.C);
        this.f8916a = Code.first.intValue();
        this.b = Code.second.intValue();
        int attributeCount = attributeSet.getAttributeCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= attributeCount) {
                Code();
                return;
            } else {
                Code(attributeSet, i2);
                i = i2 + 1;
            }
        }
    }

    private void Code() {
        float f;
        String str;
        if (this.L.isEmpty()) {
            return;
        }
        String str2 = this.L.get("shape");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        boolean z = true;
        int hashCode = str2.hashCode();
        if (hashCode != -1360216880) {
            if (hashCode != -1035129469) {
                if (hashCode == 1544803905 && str2.equals("default")) {
                    z = true;
                }
            } else if (str2.equals("roundCorner")) {
                z = true;
            }
        } else if (str2.equals("circle")) {
            z = false;
        }
        if (!z) {
            int i = this.f8916a;
            int i2 = this.b;
            f = (i > i2 ? i2 : i) / 2.0f;
        } else if (!z) {
            return;
        } else {
            f = !TextUtils.isEmpty(this.L.get("cornerRadius")) ? com.huawei.hms.ads.template.util.a.Code(str, this.C) : 0.0f;
        }
        this.D = f;
        V();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
        if (r0.equals("scaleType") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Code(android.util.AttributeSet r8, int r9) {
        /*
            r7 = this;
            r0 = r8
            r1 = r9
            java.lang.String r0 = r0.getAttributeName(r1)
            r11 = r0
            r0 = r8
            r1 = r9
            java.lang.String r0 = r0.getAttributeValue(r1)
            r8 = r0
            java.lang.String r0 = com.huawei.hms.ads.template.dtimageview.DTImageView.V
            r12 = r0
            r0 = 0
            r9 = r0
            r0 = r12
            java.lang.String r1 = "processAttribute name: %s value: %s"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r11
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = r8
            r3[r4] = r5
            com.huawei.hms.ads.ge.Code(r0, r1, r2)
            r0 = r11
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L35
            return
        L35:
            r0 = r11
            int r0 = r0.hashCode()
            r10 = r0
            r0 = r10
            r1 = -1877911644(0xffffffff901157a4, float:-2.8663724E-29)
            if (r0 == r1) goto L6e
            r0 = r10
            r1 = 109399969(0x6854fa1, float:5.0146044E-35)
            if (r0 == r1) goto L5f
            r0 = r10
            r1 = 583595847(0x22c8f747, float:5.4471924E-18)
            if (r0 == r1) goto L50
            goto L7b
        L50:
            r0 = r11
            java.lang.String r1 = "cornerRadius"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7b
            r0 = 2
            r9 = r0
            goto L7d
        L5f:
            r0 = r11
            java.lang.String r1 = "shape"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7b
            r0 = 1
            r9 = r0
            goto L7d
        L6e:
            r0 = r11
            java.lang.String r1 = "scaleType"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7b
            goto L7d
        L7b:
            r0 = -1
            r9 = r0
        L7d:
            r0 = r9
            if (r0 == 0) goto L98
            r0 = r9
            r1 = 1
            if (r0 == r1) goto L8c
            r0 = r9
            r1 = 2
            if (r0 == r1) goto L8c
            return
        L8c:
            r0 = r7
            android.util.ArrayMap<java.lang.String, java.lang.String> r0 = r0.L
            r1 = r11
            r2 = r8
            java.lang.Object r0 = r0.put(r1, r2)
            return
        L98:
            r0 = r7
            r1 = r8
            r0.Code(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.template.dtimageview.DTImageView.Code(android.util.AttributeSet, int):void");
    }

    private void Code(String str) {
        ImageView.ScaleType scaleType;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    z = false;
                    break;
                }
                break;
            case -1274298614:
                if (str.equals("fitEnd")) {
                    z = true;
                    break;
                }
                break;
            case -522179887:
                if (str.equals("fitStart")) {
                    z = true;
                    break;
                }
                break;
            case -340708175:
                if (str.equals("centerInside")) {
                    z = true;
                    break;
                }
                break;
            case 97441490:
                if (str.equals("fitXY")) {
                    z = true;
                    break;
                }
                break;
            case 520762310:
                if (str.equals("fitCenter")) {
                    z = true;
                    break;
                }
                break;
            case 1161480325:
                if (str.equals("centerCrop")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                scaleType = ImageView.ScaleType.CENTER;
                break;
            case true:
                scaleType = ImageView.ScaleType.CENTER_CROP;
                break;
            case true:
                scaleType = ImageView.ScaleType.CENTER_INSIDE;
                break;
            case true:
                scaleType = ImageView.ScaleType.FIT_CENTER;
                break;
            case true:
                scaleType = ImageView.ScaleType.FIT_START;
                break;
            case true:
                scaleType = ImageView.ScaleType.FIT_END;
                break;
            case true:
                scaleType = ImageView.ScaleType.FIT_XY;
                break;
            default:
                return;
        }
        setScaleType(scaleType);
    }

    private void V() {
    }

    @Override // com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        cc ccVar = this.B;
        if (ccVar != null) {
            ccVar.Code(jSONObject);
        }
    }

    public a getDtShape() {
        return this.f8917c;
    }

    public boolean getPreventCornerOverlap() {
        return this.F;
    }

    public boolean getUseCompatPadding() {
        return this.S;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setDtShape(a aVar) {
        this.f8917c = aVar;
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.F) {
            this.F = z;
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.S != z) {
            this.S = z;
        }
    }
}
