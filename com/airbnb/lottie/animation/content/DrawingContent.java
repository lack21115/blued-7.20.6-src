package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/DrawingContent.class */
public interface DrawingContent extends Content {
    void a(Canvas canvas, Matrix matrix, int i);

    void a(RectF rectF, Matrix matrix, boolean z);
}
