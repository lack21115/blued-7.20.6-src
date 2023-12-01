package com.opos.cmn.an.d.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.igexin.push.core.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/d/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static AssetManager f24490a;

    public static AssetManager a(Context context) {
        if (f24490a == null && context != null) {
            f24490a = context.getApplicationContext().getAssets();
        }
        return f24490a;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.InputStream a(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = r4
            if (r0 == 0) goto L29
            r0 = r5
            boolean r0 = com.opos.cmn.an.c.a.a(r0)
            if (r0 != 0) goto L29
            r0 = r4
            android.content.res.AssetManager r0 = a(r0)     // Catch: java.lang.Exception -> L17 java.io.IOException -> L1e
            r1 = r5
            java.io.InputStream r0 = r0.open(r1)     // Catch: java.lang.Exception -> L17 java.io.IOException -> L1e
            r4 = r0
            goto L2b
        L17:
            r6 = move-exception
            java.lang.String r0 = "copyFile2Sdcard"
            r4 = r0
            goto L22
        L1e:
            r6 = move-exception
            java.lang.String r0 = "open"
            r4 = r0
        L22:
            java.lang.String r0 = "AssetsTool"
            r1 = r4
            r2 = r6
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L29:
            r0 = 0
            r4 = r0
        L2b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "open fileName="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "null"
            r6 = r0
            r0 = r5
            if (r0 == 0) goto L44
            goto L47
        L44:
            java.lang.String r0 = "null"
            r5 = r0
        L47:
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = ",inputStream="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L5c
            r0 = r4
            r5 = r0
        L5c:
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "AssetsTool"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.a.a.a(android.content.Context, java.lang.String):java.io.InputStream");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap b(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = r4
            if (r0 == 0) goto L26
            r0 = r5
            boolean r0 = com.opos.cmn.an.c.a.a(r0)
            if (r0 != 0) goto L26
            r0 = r4
            r1 = r5
            java.io.InputStream r0 = a(r0, r1)     // Catch: java.lang.Exception -> L1d
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L26
            r0 = r4
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch: java.lang.Exception -> L1d
            r4 = r0
            goto L28
        L1d:
            r4 = move-exception
            java.lang.String r0 = "AssetsTool"
            java.lang.String r1 = "getBitmap"
            r2 = r4
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L26:
            r0 = 0
            r4 = r0
        L28:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "getBitmap fileName="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "null"
            r6 = r0
            r0 = r5
            if (r0 == 0) goto L41
            goto L44
        L41:
            java.lang.String r0 = "null"
            r5 = r0
        L44:
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = ",bitmap="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L59
            r0 = r4
            r5 = r0
        L59:
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "AssetsTool"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.a.a.b(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public static Drawable c(Context context, String str) {
        NinePatchDrawable ninePatchDrawable = null;
        if (context != null) {
            ninePatchDrawable = null;
            if (!com.opos.cmn.an.c.a.a(str)) {
                try {
                    Bitmap b = b(context, str);
                    ninePatchDrawable = null;
                    if (b != null) {
                        byte[] ninePatchChunk = b.getNinePatchChunk();
                        StringBuilder sb = new StringBuilder();
                        sb.append("getNinePatchChunk=");
                        sb.append(ninePatchChunk != null ? Integer.valueOf(ninePatchChunk.length) : b.l);
                        com.opos.cmn.an.f.a.b("AssetsTool", sb.toString());
                        ninePatchDrawable = (ninePatchChunk == null || ninePatchChunk.length <= 0) ? new BitmapDrawable(b) : new NinePatchDrawable(b, ninePatchChunk, new Rect(), null);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("AssetsTool", "getDrawable", e);
                    ninePatchDrawable = null;
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getDrawable fileName=");
        if (str == null) {
            str = b.l;
        }
        sb2.append(str);
        sb2.append(",drawable=");
        NinePatchDrawable ninePatchDrawable2 = b.l;
        if (ninePatchDrawable != null) {
            ninePatchDrawable2 = ninePatchDrawable;
        }
        sb2.append(ninePatchDrawable2);
        com.opos.cmn.an.f.a.b("AssetsTool", sb2.toString());
        return ninePatchDrawable;
    }
}
