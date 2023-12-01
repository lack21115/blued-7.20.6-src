package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/layer/SolidLayer.class */
public class SolidLayer extends BaseLayer {
    private final RectF e;
    private final Paint f;
    private final float[] g;
    private final Path h;
    private final Layer i;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.e = new RectF();
        this.f = new LPaint();
        this.g = new float[8];
        this.h = new Path();
        this.i = layer;
        this.f.setAlpha(0);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setColor(layer.p());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.e.set(0.0f, 0.0f, this.i.r(), this.i.q());
        this.a.mapRect(this.e);
        rectF.set(this.e);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        super.a((SolidLayer) t, (LottieValueCallback<SolidLayer>) lottieValueCallback);
        if (t == LottieProperty.B) {
            if (lottieValueCallback == null) {
                this.j = null;
            } else {
                this.j = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void b(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.i.p());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i / 255.0f) * (((alpha / 255.0f) * (this.d.a() == null ? 100 : this.d.a().g().intValue())) / 100.0f) * 255.0f);
        this.f.setAlpha(intValue);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.j;
        if (baseKeyframeAnimation != null) {
            this.f.setColorFilter(baseKeyframeAnimation.g());
        }
        if (intValue > 0) {
            float[] fArr = this.g;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.i.r();
            float[] fArr2 = this.g;
            fArr2[3] = 0.0f;
            fArr2[4] = this.i.r();
            this.g[5] = this.i.q();
            float[] fArr3 = this.g;
            fArr3[6] = 0.0f;
            fArr3[7] = this.i.q();
            matrix.mapPoints(this.g);
            this.h.reset();
            Path path = this.h;
            float[] fArr4 = this.g;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.h;
            float[] fArr5 = this.g;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.h;
            float[] fArr6 = this.g;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.h;
            float[] fArr7 = this.g;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.h;
            float[] fArr8 = this.g;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.h.close();
            canvas.drawPath(this.h, this.f);
        }
    }
}
