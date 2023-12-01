package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/layer/ImageLayer.class */
public class ImageLayer extends BaseLayer {
    private final Paint e;
    private final Rect f;
    private final Rect g;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.e = new LPaint(3);
        this.f = new Rect();
        this.g = new Rect();
    }

    private Bitmap f() {
        return this.b.e(this.f4380c.g());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        Bitmap f = f();
        if (f != null) {
            rectF.set(0.0f, 0.0f, f.getWidth() * Utils.a(), f.getHeight() * Utils.a());
            this.f4379a.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        super.a((ImageLayer) t, (LottieValueCallback<ImageLayer>) lottieValueCallback);
        if (t == LottieProperty.B) {
            if (lottieValueCallback == null) {
                this.h = null;
            } else {
                this.h = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void b(Canvas canvas, Matrix matrix, int i) {
        Bitmap f = f();
        if (f == null || f.isRecycled()) {
            return;
        }
        float a2 = Utils.a();
        this.e.setAlpha(i);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.h;
        if (baseKeyframeAnimation != null) {
            this.e.setColorFilter(baseKeyframeAnimation.g());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f.set(0, 0, f.getWidth(), f.getHeight());
        this.g.set(0, 0, (int) (f.getWidth() * a2), (int) (f.getHeight() * a2));
        canvas.drawBitmap(f, this.f, this.g, this.e);
        canvas.restore();
    }
}
