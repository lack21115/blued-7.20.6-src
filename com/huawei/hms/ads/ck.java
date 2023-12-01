package com.huawei.hms.ads;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.template.DTManager;
import com.huawei.hms.ads.template.b;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ck.class */
public class ck extends cp<ImageView> {
    private String B;
    private String C;
    private String D;
    private String F;
    private String I;
    private String L;
    private String S;
    private String Z;

    /* renamed from: a  reason: collision with root package name */
    private int f8837a;

    public ck(ImageView imageView) {
        super(imageView);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Code(java.lang.String r7, java.lang.Runnable r8) {
        /*
            r6 = this;
            r0 = r7
            java.lang.String r1 = "http"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L78
            com.huawei.hms.ads.template.DTManager r0 = com.huawei.hms.ads.template.DTManager.getInstance()
            com.huawei.hms.ads.template.IImageLoader r0 = r0.Code()
            r8 = r0
            r0 = r6
            java.lang.String r0 = r0.L
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L34
            r0 = r6
            r1 = 0
            r0.f8837a = r1
            r0 = r6
            java.lang.String r0 = r0.D
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L5d
            r0 = r6
            java.lang.String r0 = r0.D     // Catch: java.lang.NumberFormatException -> Lc6
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> Lc6
            r9 = r0
            goto L46
        L34:
            r0 = r6
            java.lang.String r0 = r0.D
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L58
            r0 = r6
            java.lang.String r0 = r0.D     // Catch: java.lang.NumberFormatException -> Lc6
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> Lc6
            r9 = r0
        L46:
            r0 = r6
            r1 = r9
            r0.f8837a = r1     // Catch: java.lang.NumberFormatException -> Lc6
            goto L5d
        L4e:
            java.lang.String r0 = "ImageSrcHandler"
            java.lang.String r1 = "checkSha256FlagData format exception"
            com.huawei.hms.ads.ge.I(r0, r1)
            goto L5d
        L58:
            r0 = r6
            r1 = 1
            r0.f8837a = r1
        L5d:
            r0 = r8
            if (r0 == 0) goto Lc5
            r0 = r8
            r1 = r6
            V extends android.view.View r1 = r1.Code
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r2 = r7
            r3 = r6
            java.lang.String r3 = r3.L
            r4 = r6
            int r4 = r4.f8837a
            r0.load(r1, r2, r3, r4)
            return
        L78:
            r0 = r7
            com.huawei.openalliance.ad.constant.bm r1 = com.huawei.openalliance.ad.constant.bm.ASSET
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L8c
            r0 = r6
            r1 = r7
            r2 = r8
            r0.V(r1, r2)
            return
        L8c:
            r0 = r7
            java.lang.String r1 = "@drawable/"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto Lbb
            r0 = r6
            V extends android.view.View r0 = r0.Code
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.content.Context r0 = r0.getContext()
            r1 = r7
            android.graphics.drawable.Drawable r0 = com.huawei.hms.ads.template.util.b.Code(r0, r1)
            r7 = r0
            r0 = r7
            if (r0 == 0) goto Lb4
            r0 = r6
            V extends android.view.View r0 = r0.Code
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1 = r7
            r0.setImageDrawable(r1)
            return
        Lb4:
            r0 = r8
            if (r0 == 0) goto Lc5
            goto Lbf
        Lbb:
            r0 = r8
            if (r0 == 0) goto Lc5
        Lbf:
            r0 = r8
            r0.run()
        Lc5:
            return
        Lc6:
            r10 = move-exception
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.ck.Code(java.lang.String, java.lang.Runnable):void");
    }

    private void Code(JSONObject jSONObject, Runnable runnable) {
        String str;
        if (!TextUtils.isEmpty(this.Z)) {
            Code(this.Z, runnable);
        } else if (TextUtils.isEmpty(this.I) || jSONObject == null) {
        } else {
            try {
                String Code = DTManager.getInstance().Code(this.I, jSONObject);
                if (!TextUtils.isEmpty(Code)) {
                    Code(Code, runnable);
                } else if (runnable != null) {
                    runnable.run();
                }
            } catch (b e) {
                str = "bindDataForNormalSrc PlacementParseException";
                ge.I("ImageSrcHandler", str);
            } catch (JSONException e2) {
                str = "bindDataForNormalSrc json exception";
                ge.I("ImageSrcHandler", str);
            } catch (Exception e3) {
                str = "bindDataForNormalSrc " + e3.getClass().getSimpleName();
                ge.I("ImageSrcHandler", str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(JSONObject jSONObject) {
        String str;
        if (!TextUtils.isEmpty(this.C)) {
            Code(this.C, (Runnable) null);
        } else if (TextUtils.isEmpty(this.B) || jSONObject == null) {
        } else {
            try {
                Code(DTManager.getInstance().Code(this.B, jSONObject), (Runnable) null);
            } catch (b e) {
                str = "bindDataForDefaultSrc PlacementParseException";
                ge.I("ImageSrcHandler", str);
            } catch (JSONException e2) {
                str = "bindDataForDefaultSrc json exception";
                ge.I("ImageSrcHandler", str);
            } catch (Exception e3) {
                str = "bindDataForDefaultSrc " + e3.getClass().getSimpleName();
                ge.I("ImageSrcHandler", str);
            }
        }
    }

    private void V(String str, final Runnable runnable) {
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(str);
        com.huawei.openalliance.ad.utils.y.Code(((ImageView) this.Code).getContext(), sourceParam, new com.huawei.openalliance.ad.utils.aj() { // from class: com.huawei.hms.ads.ck.2
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                if (runnable != null) {
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ck.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            runnable.run();
                        }
                    });
                }
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str2, final Drawable drawable) {
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ck.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((ImageView) ck.this.Code).setImageDrawable(drawable);
                    }
                });
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void V(org.json.JSONObject r6) {
        /*
            r5 = this;
            r0 = r5
            java.lang.String r0 = r0.S
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Laf
            r0 = r5
            java.lang.String r0 = r0.F
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L15
            return
        L15:
            r0 = r5
            com.huawei.hms.ads.template.DTManager r1 = com.huawei.hms.ads.template.DTManager.getInstance()     // Catch: java.lang.Exception -> L27 com.huawei.hms.ads.template.b -> Lb0 org.json.JSONException -> Lb4
            r2 = r5
            java.lang.String r2 = r2.F     // Catch: java.lang.Exception -> L27 com.huawei.hms.ads.template.b -> Lb0 org.json.JSONException -> Lb4
            r3 = r6
            java.lang.String r1 = r1.Code(r2, r3)     // Catch: java.lang.Exception -> L27 com.huawei.hms.ads.template.b -> Lb0 org.json.JSONException -> Lb4
            r0.D = r1     // Catch: java.lang.Exception -> L27 com.huawei.hms.ads.template.b -> Lb0 org.json.JSONException -> Lb4
            goto L5a
        L27:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "bindDataForSha256Flag "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r7
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r0 = r0.toString()
            r7 = r0
            goto L54
        L4b:
            java.lang.String r0 = "bindDataForSha256Flag json exception"
            r7 = r0
            goto L54
        L51:
            java.lang.String r0 = "bindDataForSha256Flag PlacementParseException"
            r7 = r0
        L54:
            java.lang.String r0 = "ImageSrcHandler"
            r1 = r7
            com.huawei.hms.ads.ge.I(r0, r1)
        L5a:
            r0 = r5
            java.lang.String r0 = r0.D
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L6c
            r0 = r7
            int r0 = java.lang.Integer.parseInt(r0)
            r1 = 1
            if (r0 != r1) goto L6c
            return
        L6c:
            r0 = r5
            com.huawei.hms.ads.template.DTManager r1 = com.huawei.hms.ads.template.DTManager.getInstance()     // Catch: java.lang.Exception -> L7c com.huawei.hms.ads.template.b -> Lb8 org.json.JSONException -> Lbc
            r2 = r5
            java.lang.String r2 = r2.S     // Catch: java.lang.Exception -> L7c com.huawei.hms.ads.template.b -> Lb8 org.json.JSONException -> Lbc
            r3 = r6
            java.lang.String r1 = r1.Code(r2, r3)     // Catch: java.lang.Exception -> L7c com.huawei.hms.ads.template.b -> Lb8 org.json.JSONException -> Lbc
            r0.L = r1     // Catch: java.lang.Exception -> L7c com.huawei.hms.ads.template.b -> Lb8 org.json.JSONException -> Lbc
            return
        L7c:
            r6 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "bindDataForSha256 "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r6
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r0 = r0.toString()
            r6 = r0
            goto La9
        La0:
            java.lang.String r0 = "bindDataForSha256 json exception"
            r6 = r0
            goto La9
        La6:
            java.lang.String r0 = "bindDataForSha256 PlacementParseException"
            r6 = r0
        La9:
            java.lang.String r0 = "ImageSrcHandler"
            r1 = r6
            com.huawei.hms.ads.ge.I(r0, r1)
        Laf:
            return
        Lb0:
            r7 = move-exception
            goto L51
        Lb4:
            r7 = move-exception
            goto L4b
        Lb8:
            r6 = move-exception
            goto La6
        Lbc:
            r6 = move-exception
            goto La0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.ck.V(org.json.JSONObject):void");
    }

    @Override // com.huawei.hms.ads.ci
    public void Code(AttributeSet attributeSet) {
        String attributeValue = attributeSet.getAttributeValue(null, OapsKey.KEY_SRC);
        String attributeValue2 = attributeSet.getAttributeValue(null, "defaultSrc");
        if (TextUtils.isEmpty(attributeValue) && TextUtils.isEmpty(attributeValue2)) {
            return;
        }
        String I = com.huawei.hms.ads.template.util.a.I(attributeValue);
        this.I = I;
        if (I == null) {
            this.Z = attributeValue;
        }
        String I2 = com.huawei.hms.ads.template.util.a.I(attributeValue2);
        this.B = I2;
        if (I2 == null) {
            this.C = attributeValue2;
        }
        String attributeValue3 = attributeSet.getAttributeValue(null, com.huawei.openalliance.ad.constant.at.aq);
        String attributeValue4 = attributeSet.getAttributeValue(null, "checkSha256Flag");
        this.S = com.huawei.hms.ads.template.util.a.I(attributeValue3);
        this.F = com.huawei.hms.ads.template.util.a.I(attributeValue4);
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.ce
    public void Code(final JSONObject jSONObject) {
        V(jSONObject);
        if (TextUtils.isEmpty(this.Z) && TextUtils.isEmpty(this.I)) {
            I(jSONObject);
        } else {
            Code(jSONObject, new Runnable() { // from class: com.huawei.hms.ads.ck.1
                @Override // java.lang.Runnable
                public void run() {
                    ck.this.I(jSONObject);
                }
            });
        }
    }
}
