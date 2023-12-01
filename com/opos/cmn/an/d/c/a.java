package com.opos.cmn.an.d.c;

import android.graphics.Bitmap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/d/c/a.class */
public final class a {
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
        if (r0 > r5) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(android.graphics.BitmapFactory.Options r4, int r5, int r6) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.c.a.a(android.graphics.BitmapFactory$Options, int, int):int");
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, int i3) {
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            bitmap2 = null;
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
                bitmap2 = createScaledBitmap;
                if (bitmap != createScaledBitmap) {
                    com.opos.cmn.an.f.a.b("BitmapTool", "src != dst,src.recycle()");
                    bitmap2 = createScaledBitmap;
                    bitmap.recycle();
                    return createScaledBitmap;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("BitmapTool", "", e);
            }
        }
        return bitmap2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(java.lang.String r5, int r6, int r7) {
        /*
            r0 = r5
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> L3b
            if (r0 != 0) goto L44
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L3b
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L3b
            r8 = r0
            r0 = r8
            r1 = 1
            r0.inJustDecodeBounds = r1     // Catch: java.lang.Exception -> L3b
            r0 = r5
            r1 = r8
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r1)     // Catch: java.lang.Exception -> L3b
            r0 = r8
            r1 = r8
            r2 = r6
            r3 = r7
            int r1 = a(r1, r2, r3)     // Catch: java.lang.Exception -> L3b
            r0.inSampleSize = r1     // Catch: java.lang.Exception -> L3b
            r0 = r8
            r1 = 0
            r0.inJustDecodeBounds = r1     // Catch: java.lang.Exception -> L3b
            r0 = r5
            r1 = r8
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r1)     // Catch: java.lang.Exception -> L3b
            r1 = r6
            r2 = r7
            r3 = r8
            int r3 = r3.inSampleSize     // Catch: java.lang.Exception -> L3b
            android.graphics.Bitmap r0 = a(r0, r1, r2, r3)     // Catch: java.lang.Exception -> L3b
            r8 = r0
            goto L46
        L3b:
            r8 = move-exception
            java.lang.String r0 = "BitmapTool"
            java.lang.String r1 = ""
            r2 = r8
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L44:
            r0 = 0
            r8 = r0
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            java.lang.String r1 = "decodeSampledBitmapFromFile pathName="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "null"
            r9 = r0
            r0 = r5
            if (r0 == 0) goto L62
            goto L65
        L62:
            java.lang.String r0 = "null"
            r5 = r0
        L65:
            r0 = r10
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = ",reqWidth="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = ",reqHeight="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = ",dst="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            r5 = r0
            r0 = r8
            if (r0 == 0) goto L9b
            r0 = r8
            r5 = r0
        L9b:
            r0 = r10
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "BitmapTool"
            r1 = r10
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.c.a.a(java.lang.String, int, int):android.graphics.Bitmap");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap b(java.lang.String r5, int r6, int r7) {
        /*
            r0 = r5
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> L32
            if (r0 != 0) goto L3b
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L32
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L32
            r8 = r0
            r0 = r8
            r1 = 1
            r0.inJustDecodeBounds = r1     // Catch: java.lang.Exception -> L32
            r0 = r5
            r1 = r8
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r1)     // Catch: java.lang.Exception -> L32
            r0 = r8
            r1 = r8
            r2 = r6
            r3 = r7
            int r1 = a(r1, r2, r3)     // Catch: java.lang.Exception -> L32
            r0.inSampleSize = r1     // Catch: java.lang.Exception -> L32
            r0 = r8
            r1 = 0
            r0.inJustDecodeBounds = r1     // Catch: java.lang.Exception -> L32
            r0 = r5
            r1 = r8
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r1)     // Catch: java.lang.Exception -> L32
            r8 = r0
            goto L3d
        L32:
            r8 = move-exception
            java.lang.String r0 = "BitmapTool"
            java.lang.String r1 = ""
            r2 = r8
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L3b:
            r0 = 0
            r8 = r0
        L3d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            java.lang.String r1 = "decodeBitmapFromFileWithoutScale pathName="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "null"
            r9 = r0
            r0 = r5
            if (r0 == 0) goto L59
            goto L5c
        L59:
            java.lang.String r0 = "null"
            r5 = r0
        L5c:
            r0 = r10
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = ",reqWidth="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = ",reqHeight="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = ",dst="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            r5 = r0
            r0 = r8
            if (r0 == 0) goto L92
            r0 = r8
            r5 = r0
        L92:
            r0 = r10
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "BitmapTool"
            r1 = r10
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.c.a.b(java.lang.String, int, int):android.graphics.Bitmap");
    }
}
