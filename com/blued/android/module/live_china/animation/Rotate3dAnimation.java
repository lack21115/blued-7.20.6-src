package com.blued.android.module.live_china.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/animation/Rotate3dAnimation.class */
public class Rotate3dAnimation extends Animation {
    public static final Byte a = (byte) 0;
    public static final Byte b = (byte) 1;
    public static final Byte c = (byte) 2;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final boolean i;
    private Camera j;
    private Byte k;

    public Rotate3dAnimation(float f, float f2, float f3, float f4, float f5, Byte b2, boolean z) {
        this.d = f;
        this.e = f2;
        this.f = f3;
        this.g = f4;
        this.h = f5;
        this.k = b2;
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        float f2 = this.d;
        float f3 = f2 + ((this.e - f2) * f);
        float f4 = this.f;
        float f5 = this.g;
        Camera camera = this.j;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.i) {
            camera.translate(0.0f, 0.0f, this.h * f);
        } else {
            camera.translate(0.0f, 0.0f, this.h * (1.0f - f));
        }
        if (a.equals(this.k)) {
            camera.rotateX(f3);
        } else if (b.equals(this.k)) {
            camera.rotateY(f3);
        } else {
            camera.rotateZ(f3);
        }
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.j = new Camera();
    }
}
