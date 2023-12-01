package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
import java.util.Locale;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/layer/Layer.class */
public class Layer {
    private final List<ContentModel> a;
    private final LottieComposition b;
    private final String c;
    private final long d;
    private final LayerType e;
    private final long f;
    private final String g;
    private final List<Mask> h;
    private final AnimatableTransform i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    private final AnimatableTextFrame q;
    private final AnimatableTextProperties r;
    private final AnimatableFloatValue s;
    private final List<Keyframe<Float>> t;
    private final MatteType u;
    private final boolean v;

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/layer/Layer$LayerType.class */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/layer/Layer$MatteType.class */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j, LayerType layerType, long j2, String str2, List<Mask> list2, AnimatableTransform animatableTransform, int i, int i2, int i3, float f, float f2, int i4, int i5, AnimatableTextFrame animatableTextFrame, AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType, AnimatableFloatValue animatableFloatValue, boolean z) {
        this.a = list;
        this.b = lottieComposition;
        this.c = str;
        this.d = j;
        this.e = layerType;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = animatableTransform;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = i4;
        this.p = i5;
        this.q = animatableTextFrame;
        this.r = animatableTextProperties;
        this.t = list3;
        this.u = matteType;
        this.s = animatableFloatValue;
        this.v = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LottieComposition a() {
        return this.b;
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(f());
        sb.append("\n");
        Layer a = this.b.a(m());
        if (a != null) {
            sb.append("\t\tParents: ");
            sb.append(a.f());
            Layer a2 = this.b.a(a.m());
            while (true) {
                Layer layer = a2;
                if (layer == null) {
                    break;
                }
                sb.append("->");
                sb.append(layer.f());
                a2 = this.b.a(layer.m());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!j().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(j().size());
            sb.append("\n");
        }
        if (r() != 0 && q() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (ContentModel contentModel : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(contentModel);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.n / this.b.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Keyframe<Float>> d() {
        return this.t;
    }

    public long e() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> j() {
        return this.h;
    }

    public LayerType k() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType l() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long m() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ContentModel> n() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatableTransform o() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatableTextFrame s() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatableTextProperties t() {
        return this.r;
    }

    public String toString() {
        return a("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatableFloatValue u() {
        return this.s;
    }

    public boolean v() {
        return this.v;
    }
}
