package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.BaseObj;
import com.huawei.hms.ads.ge;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/w.class */
public class w {
    private static final String Code = "BlurUtil";

    /* JADX WARN: Removed duplicated region for block: B:46:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap Code(android.content.Context r5, android.graphics.Bitmap r6, float r7, float r8) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.w.Code(android.content.Context, android.graphics.Bitmap, float, float):android.graphics.Bitmap");
    }

    private static Drawable Code(Context context, Bitmap bitmap) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static Drawable Code(Context context, Drawable drawable, float f, float f2) {
        String str;
        Drawable drawable2 = null;
        Drawable drawable3 = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Drawable Code2 = Code(context, Code(context, y.Code(drawable), f, f2));
            drawable2 = Code2;
            drawable3 = Code2;
            ge.Code(Code, "blurDrawable: duration %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return Code2;
        } catch (OutOfMemoryError e) {
            str = "OOM blur image";
            drawable2 = drawable3;
            ge.I(Code, str);
            return drawable2;
        } catch (Throwable th) {
            str = "blur drawable exception " + th.getClass().getSimpleName();
            ge.I(Code, str);
            return drawable2;
        }
    }

    private static void Code(BaseObj baseObj) {
        if (baseObj != null) {
            baseObj.destroy();
        }
    }
}
