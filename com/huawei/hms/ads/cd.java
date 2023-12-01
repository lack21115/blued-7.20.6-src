package com.huawei.hms.ads;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.template.DTManager;
import com.huawei.hms.ads.template.IImageLoader;
import com.huawei.hms.ads.template.util.b;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cd.class */
public class cd {
    private Drawable B;
    private View C;
    private Drawable Z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cd$a.class */
    public static class a implements com.huawei.openalliance.ad.utils.aj {
        private dk Code;

        a(dk dkVar) {
            this.Code = dkVar;
        }

        @Override // com.huawei.openalliance.ad.utils.aj
        public void Code() {
            ge.I("BackgroundAttrHandler", "asset img load failed");
        }

        @Override // com.huawei.openalliance.ad.utils.aj
        public void Code(String str, final Drawable drawable) {
            ge.V("BackgroundAttrHandler", "asset img load success");
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.cd.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.Code.setDrawable(drawable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(View view) {
        this.C = view;
    }

    private Drawable Code(Object obj) {
        if (obj != null) {
            if (obj instanceof JSONObject) {
                return new dj(this.C.getContext(), (JSONObject) obj);
            }
            if (obj instanceof String) {
                return I((String) obj);
            }
            return null;
        }
        return null;
    }

    private void Code(Drawable drawable) {
        if (drawable == null || !(drawable instanceof dk)) {
            return;
        }
        dk dkVar = (dk) drawable;
        if (dkVar.V() != null) {
            ge.V("BackgroundAttrHandler", "actual drawable is already loaded");
            return;
        }
        String Code = dkVar.Code();
        if (Code != null) {
            if (Code.startsWith("http")) {
                V(dkVar);
            } else if (Code.startsWith(com.huawei.openalliance.ad.constant.bm.ASSET.toString())) {
                Code(dkVar);
            }
        }
    }

    private void Code(dk dkVar) {
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(dkVar.Code());
        com.huawei.openalliance.ad.utils.y.Code(this.C.getContext(), sourceParam, new a(dkVar));
    }

    private Drawable I(String str) {
        if (!str.startsWith("#")) {
            if (str.startsWith("http") || str.startsWith(com.huawei.openalliance.ad.constant.bm.ASSET.toString())) {
                return new dk(this.C, str);
            }
            if (str.startsWith("@")) {
                return b.Code(this.C.getContext(), str);
            }
            return null;
        }
        try {
            return new ColorDrawable(Color.parseColor(str));
        } catch (IllegalArgumentException e) {
            ge.I("BackgroundAttrHandler", "parse color error " + e.getClass().getSimpleName());
            return null;
        }
    }

    private void V(dk dkVar) {
        IImageLoader Code = DTManager.getInstance().Code();
        if (Code != null) {
            Code.loadDrawable(dkVar, dkVar.Code());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065 A[Catch: JSONException -> 0x00b1, TRY_ENTER, TryCatch #0 {JSONException -> 0x00b1, blocks: (B:2:0x0000, B:9:0x0036, B:11:0x0040, B:13:0x0046, B:19:0x0065, B:21:0x0074, B:24:0x0088, B:26:0x008f, B:28:0x009e, B:14:0x004d, B:16:0x0057), top: B:34:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean V(java.lang.String r7) {
        /*
            r6 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> Lb1
            r1 = r0
            r2 = r7
            r1.<init>(r2)     // Catch: org.json.JSONException -> Lb1
            r7 = r0
            r0 = r6
            r1 = r6
            r2 = r7
            java.lang.String r3 = "normal"
            java.lang.Object r2 = r2.opt(r3)     // Catch: org.json.JSONException -> Lb1
            android.graphics.drawable.Drawable r1 = r1.Code(r2)     // Catch: org.json.JSONException -> Lb1
            r0.Z = r1     // Catch: org.json.JSONException -> Lb1
            r0 = r6
            r1 = r7
            java.lang.String r2 = "pressed"
            java.lang.Object r1 = r1.opt(r2)     // Catch: org.json.JSONException -> Lb1
            android.graphics.drawable.Drawable r0 = r0.Code(r1)     // Catch: org.json.JSONException -> Lb1
            r7 = r0
            r0 = r6
            r1 = r7
            r0.B = r1     // Catch: org.json.JSONException -> Lb1
            r0 = r6
            android.graphics.drawable.Drawable r0 = r0.Z     // Catch: org.json.JSONException -> Lb1
            if (r0 != 0) goto L34
            r0 = r7
            if (r0 != 0) goto L34
            r0 = 0
            return r0
        L34:
            r0 = 0
            r7 = r0
            r0 = r6
            android.graphics.drawable.Drawable r0 = r0.Z     // Catch: org.json.JSONException -> Lb1
            boolean r0 = r0 instanceof android.graphics.drawable.StateListDrawable     // Catch: org.json.JSONException -> Lb1
            if (r0 == 0) goto L4d
            r0 = r6
            android.graphics.drawable.Drawable r0 = r0.Z     // Catch: org.json.JSONException -> Lb1
            r7 = r0
        L45:
            r0 = r7
            android.graphics.drawable.StateListDrawable r0 = (android.graphics.drawable.StateListDrawable) r0     // Catch: org.json.JSONException -> Lb1
            r7 = r0
            goto L5f
        L4d:
            r0 = r6
            android.graphics.drawable.Drawable r0 = r0.B     // Catch: org.json.JSONException -> Lb1
            boolean r0 = r0 instanceof android.graphics.drawable.StateListDrawable     // Catch: org.json.JSONException -> Lb1
            if (r0 == 0) goto L5f
            r0 = r6
            android.graphics.drawable.Drawable r0 = r0.B     // Catch: org.json.JSONException -> Lb1
            r7 = r0
            goto L45
        L5f:
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 != 0) goto L9e
            android.graphics.drawable.StateListDrawable r0 = new android.graphics.drawable.StateListDrawable     // Catch: org.json.JSONException -> Lb1
            r1 = r0
            r1.<init>()     // Catch: org.json.JSONException -> Lb1
            r7 = r0
            r0 = r6
            android.graphics.drawable.Drawable r0 = r0.B     // Catch: org.json.JSONException -> Lb1
            if (r0 == 0) goto L86
            r0 = r6
            android.graphics.drawable.Drawable r0 = r0.B     // Catch: org.json.JSONException -> Lb1
            r8 = r0
            r0 = r7
            r1 = 1
            int[] r1 = new int[r1]     // Catch: org.json.JSONException -> Lb1
            r2 = r1
            r3 = 0
            r4 = 16842919(0x10100a7, float:2.3694026E-38)
            r2[r3] = r4     // Catch: org.json.JSONException -> Lb1
            r2 = r8
            r0.addState(r1, r2)     // Catch: org.json.JSONException -> Lb1
        L86:
            r0 = r7
            r8 = r0
            r0 = r6
            android.graphics.drawable.Drawable r0 = r0.Z     // Catch: org.json.JSONException -> Lb1
            if (r0 == 0) goto L9e
            r0 = r6
            android.graphics.drawable.Drawable r0 = r0.Z     // Catch: org.json.JSONException -> Lb1
            r8 = r0
            r0 = r7
            r1 = 0
            int[] r1 = new int[r1]     // Catch: org.json.JSONException -> Lb1
            r2 = r8
            r0.addState(r1, r2)     // Catch: org.json.JSONException -> Lb1
            r0 = r7
            r8 = r0
        L9e:
            r0 = r6
            android.view.View r0 = r0.C     // Catch: org.json.JSONException -> Lb1
            r1 = r8
            r0.setBackground(r1)     // Catch: org.json.JSONException -> Lb1
            r0 = 1
            return r0
        La8:
            java.lang.String r0 = "BackgroundAttrHandler"
            java.lang.String r1 = "parseStateBackground is not valid json"
            com.huawei.hms.ads.ge.I(r0, r1)
            r0 = 0
            return r0
        Lb1:
            r7 = move-exception
            goto La8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.cd.V(java.lang.String):boolean");
    }

    public void Code(JSONObject jSONObject) {
        Code(this.Z);
        Code(this.B);
    }

    public boolean Code(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.Z = null;
        this.B = null;
        if (str.startsWith("#")) {
            try {
                this.C.setBackgroundColor(Color.parseColor(str));
                return true;
            } catch (IllegalArgumentException e) {
                ge.I("BackgroundAttrHandler", "parse color error " + e.getClass().getSimpleName());
                return false;
            }
        } else if (str.startsWith("http") || str.startsWith(com.huawei.openalliance.ad.constant.bm.ASSET.toString())) {
            dk dkVar = new dk(this.C, str);
            this.Z = dkVar;
            this.C.setBackground(dkVar);
            return true;
        } else if (!str.startsWith("@")) {
            if (str.length() > 2 && str.startsWith("{") && str.endsWith("}")) {
                return V(str);
            }
            return false;
        } else {
            Drawable Code = b.Code(this.C.getContext(), str);
            this.Z = Code;
            if (Code != null) {
                this.C.setBackground(Code);
                return true;
            }
            return false;
        }
    }
}
