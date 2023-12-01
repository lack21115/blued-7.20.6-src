package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/layer/CompositionLayer.class */
public class CompositionLayer extends BaseLayer {
    private BaseKeyframeAnimation<Float, Float> e;
    private final List<BaseLayer> f;
    private final RectF g;
    private final RectF h;

    /* renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/layer/CompositionLayer$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4383a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f4383a = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4383a[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        int i;
        BaseLayer baseLayer;
        this.f = new ArrayList();
        this.g = new RectF();
        this.h = new RectF();
        AnimatableFloatValue u = layer.u();
        if (u != null) {
            BaseKeyframeAnimation<Float, Float> a2 = u.a();
            this.e = a2;
            a(a2);
            this.e.a(this);
        } else {
            this.e = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.i().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            BaseLayer a3 = BaseLayer.a(layer2, lottieDrawable, lottieComposition);
            if (a3 != null) {
                longSparseArray.put(a3.c().e(), a3);
                if (baseLayer2 != null) {
                    baseLayer2.a(a3);
                    baseLayer2 = null;
                } else {
                    this.f.add(0, a3);
                    int i2 = AnonymousClass1.f4383a[layer2.l().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        baseLayer2 = a3;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.get(longSparseArray.keyAt(i));
            if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.get(baseLayer3.c().m())) != null) {
                baseLayer3.b(baseLayer);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void a(float f) {
        super.a(f);
        if (this.e != null) {
            f = (this.e.g().floatValue() * 1000.0f) / this.b.r().e();
        }
        float f2 = f;
        if (this.f4380c.b() != 0.0f) {
            f2 = f / this.f4380c.b();
        }
        float c2 = this.f4380c.c();
        int size = this.f.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            this.f.get(i).a(f2 - c2);
            size = i;
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        int size = this.f.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            this.g.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f.get(i).a(this.g, this.f4379a, true);
            rectF.union(this.g);
            size = i;
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        super.a((CompositionLayer) t, (LottieValueCallback<CompositionLayer>) lottieValueCallback);
        if (t == LottieProperty.A) {
            if (lottieValueCallback == null) {
                this.e = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.e = valueCallbackKeyframeAnimation;
            a(valueCallbackKeyframeAnimation);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void b(Canvas canvas, Matrix matrix, int i) {
        L.a("CompositionLayer#draw");
        canvas.save();
        this.h.set(0.0f, 0.0f, this.f4380c.h(), this.f4380c.i());
        matrix.mapRect(this.h);
        int size = this.f.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                canvas.restore();
                L.b("CompositionLayer#draw");
                return;
            }
            if (!this.h.isEmpty() ? canvas.clipRect(this.h) : true) {
                this.f.get(i2).a(canvas, matrix, i);
            }
            size = i2;
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void b(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f.size()) {
                return;
            }
            this.f.get(i3).a(keyPath, i, list, keyPath2);
            i2 = i3 + 1;
        }
    }
}
