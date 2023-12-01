package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieComposition.class */
public class LottieComposition {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<Layer>> f4215c;
    private Map<String, LottieImageAsset> d;
    private Map<String, Font> e;
    private List<Marker> f;
    private SparseArrayCompat<FontCharacter> g;
    private LongSparseArray<Layer> h;
    private List<Layer> i;
    private Rect j;
    private float k;
    private float l;
    private float m;
    private boolean n;

    /* renamed from: a  reason: collision with root package name */
    private final PerformanceTracker f4214a = new PerformanceTracker();
    private final HashSet<String> b = new HashSet<>();
    private int o = 0;

    @Deprecated
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieComposition$Factory.class */
    public static class Factory {

        /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieComposition$Factory$ListenerAdapter.class */
        static final class ListenerAdapter implements Cancellable, LottieListener<LottieComposition> {

            /* renamed from: a  reason: collision with root package name */
            private final OnCompositionLoadedListener f4216a;
            private boolean b;

            @Override // com.airbnb.lottie.LottieListener
            public void a(LottieComposition lottieComposition) {
                if (this.b) {
                    return;
                }
                this.f4216a.a(lottieComposition);
            }
        }

        private Factory() {
        }
    }

    public Layer a(long j) {
        return this.h.get(j);
    }

    public void a(int i) {
        this.o += i;
    }

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2, SparseArrayCompat<FontCharacter> sparseArrayCompat, Map<String, Font> map3, List<Marker> list2) {
        this.j = rect;
        this.k = f;
        this.l = f2;
        this.m = f3;
        this.i = list;
        this.h = longSparseArray;
        this.f4215c = map;
        this.d = map2;
        this.g = sparseArrayCompat;
        this.e = map3;
        this.f = list2;
    }

    public void a(String str) {
        Logger.b(str);
        this.b.add(str);
    }

    public void a(boolean z) {
        this.n = z;
    }

    public boolean a() {
        return this.n;
    }

    public int b() {
        return this.o;
    }

    public List<Layer> b(String str) {
        return this.f4215c.get(str);
    }

    public void b(boolean z) {
        this.f4214a.a(z);
    }

    public PerformanceTracker c() {
        return this.f4214a;
    }

    public Marker c(String str) {
        this.f.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f.size()) {
                return null;
            }
            Marker marker = this.f.get(i2);
            if (marker.a(str)) {
                return marker;
            }
            i = i2 + 1;
        }
    }

    public Rect d() {
        return this.j;
    }

    public float e() {
        return (m() / this.m) * 1000.0f;
    }

    public float f() {
        return this.k;
    }

    public float g() {
        return this.l;
    }

    public float h() {
        return this.m;
    }

    public List<Layer> i() {
        return this.i;
    }

    public SparseArrayCompat<FontCharacter> j() {
        return this.g;
    }

    public Map<String, Font> k() {
        return this.e;
    }

    public Map<String, LottieImageAsset> l() {
        return this.d;
    }

    public float m() {
        return this.l - this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.i) {
            sb.append(layer.a("\t"));
        }
        return sb.toString();
    }
}
