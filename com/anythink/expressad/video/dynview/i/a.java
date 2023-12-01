package com.anythink.expressad.video.dynview.i;

import android.graphics.PointF;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/i/a.class */
public final class a {
    private static PointF a(float f, PointF pointF, PointF pointF2, PointF pointF3) {
        PointF pointF4 = new PointF();
        float f2 = 1.0f - f;
        float f3 = f2 * f2;
        float f4 = 2.0f * f * f2;
        float f5 = f * f;
        pointF4.x = (pointF.x * f3) + (pointF2.x * f4) + (pointF3.x * f5);
        pointF4.y = (f3 * pointF.y) + (f4 * pointF2.y) + (f5 * pointF3.y);
        return pointF4;
    }

    private static PointF a(float f, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        PointF pointF5 = new PointF();
        float f2 = 1.0f - f;
        pointF5.x = (pointF.x * f2 * f2 * f2) + (pointF2.x * 3.0f * f * f2 * f2) + (pointF3.x * 3.0f * f * f * f2) + (pointF4.x * f * f * f);
        pointF5.y = (pointF.y * f2 * f2 * f2) + (pointF2.y * 3.0f * f * f2 * f2) + (pointF3.y * 3.0f * f * f * f2) + (pointF4.y * f * f * f);
        return pointF5;
    }
}
