package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.map.lib.models.ScatterPlotInfo;
import com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ud.class */
public class ud extends ScatterPlotInfo implements vc {

    /* renamed from: a  reason: collision with root package name */
    private ScatterPlotOverlayProvider f24357a;

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0103, code lost:
        if (r5.mBitmapHeight != r0.getHeight()) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ud(android.content.Context r6, com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider r7) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.ud.<init>(android.content.Context, com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider):void");
    }

    public Bitmap a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = i / width;
        float f2 = i2 / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public ScatterPlotOverlayProvider a() {
        return this.f24357a;
    }
}
