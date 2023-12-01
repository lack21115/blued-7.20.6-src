package com.huawei.hms.ads.template.view;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/view/c.class */
public class c {
    private Path I;
    private View Z;
    private final RectF Code = new RectF();
    private float V = 0.0f;

    public c(View view) {
        this.Z = view;
        view.setWillNotDraw(false);
        this.I = new Path();
    }

    private void Code() {
        Path path = this.I;
        RectF rectF = this.Code;
        float f = this.V;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
    }

    public void Code(float f) {
        this.V = f;
        Code();
        this.Z.postInvalidate();
    }

    public void Code(Canvas canvas) {
        if (this.V > 0.01f) {
            canvas.clipPath(this.I);
        }
    }

    public void Code(boolean z, int i, int i2, int i3, int i4) {
        this.Code.set(0.0f, 0.0f, this.Z.getMeasuredWidth(), this.Z.getMeasuredHeight());
        Code();
    }
}
