package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/layer/ShapeLayer.class */
public class ShapeLayer extends BaseLayer {
    private final ContentGroup e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.n(), false));
        this.e = contentGroup;
        contentGroup.a(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.e.a(rectF, this.f4379a, z);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void b(Canvas canvas, Matrix matrix, int i) {
        this.e.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void b(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        this.e.a(keyPath, i, list, keyPath2);
    }
}
