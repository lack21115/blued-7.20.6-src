package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.StrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/ShapeStroke.class */
public class ShapeStroke implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f4368a;
    private final AnimatableFloatValue b;

    /* renamed from: c  reason: collision with root package name */
    private final List<AnimatableFloatValue> f4369c;
    private final AnimatableColorValue d;
    private final AnimatableIntegerValue e;
    private final AnimatableFloatValue f;
    private final LineCapType g;
    private final LineJoinType h;
    private final float i;
    private final boolean j;

    /* renamed from: com.airbnb.lottie.model.content.ShapeStroke$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/ShapeStroke$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4370a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0055 -> B:32:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0059 -> B:28:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005d -> B:8:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0061 -> B:34:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0065 -> B:30:0x0049). Please submit an issue!!! */
        static {
            int[] iArr = new int[LineJoinType.values().length];
            b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f4370a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4370a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4370a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/ShapeStroke$LineCapType.class */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap a() {
            int i = AnonymousClass1.f4370a[ordinal()];
            return i != 1 ? i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/ShapeStroke$LineJoinType.class */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join a() {
            int i = AnonymousClass1.b[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    public ShapeStroke(String str, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, LineCapType lineCapType, LineJoinType lineJoinType, float f, boolean z) {
        this.f4368a = str;
        this.b = animatableFloatValue;
        this.f4369c = list;
        this.d = animatableColorValue;
        this.e = animatableIntegerValue;
        this.f = animatableFloatValue2;
        this.g = lineCapType;
        this.h = lineJoinType;
        this.i = f;
        this.j = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new StrokeContent(lottieDrawable, baseLayer, this);
    }

    public String a() {
        return this.f4368a;
    }

    public AnimatableColorValue b() {
        return this.d;
    }

    public AnimatableIntegerValue c() {
        return this.e;
    }

    public AnimatableFloatValue d() {
        return this.f;
    }

    public List<AnimatableFloatValue> e() {
        return this.f4369c;
    }

    public AnimatableFloatValue f() {
        return this.b;
    }

    public LineCapType g() {
        return this.g;
    }

    public LineJoinType h() {
        return this.h;
    }

    public float i() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }
}
