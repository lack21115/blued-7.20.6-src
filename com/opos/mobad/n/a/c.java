package com.opos.mobad.n.a;

import android.animation.TypeEvaluator;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/c.class */
public class c<T> implements TypeEvaluator<T> {

    /* renamed from: a  reason: collision with root package name */
    private long f12807a = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f12808c = 0;
    private List<a<T>> b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/c$a.class */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private long f12809a;
        private TypeEvaluator<T> b;

        /* renamed from: c  reason: collision with root package name */
        private long f12810c;

        public a(TypeEvaluator<T> typeEvaluator, long j, long j2) {
            this.f12809a = j;
            this.b = typeEvaluator;
            this.f12810c = j2;
        }
    }

    private a a(float f) {
        float f2 = ((float) this.f12807a) * f;
        int i = this.f12808c;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                if (this.f12808c <= 0) {
                    return null;
                }
                this.f12808c = 0;
                return a(f);
            }
            a<T> aVar = this.b.get(i2);
            if (f2 >= ((float) ((a) aVar).f12810c) && f2 <= ((float) (((a) aVar).f12809a + ((a) aVar).f12810c))) {
                this.f12808c = i2;
                return aVar;
            }
            i = i2 + 1;
        }
    }

    public long a() {
        return this.f12807a;
    }

    public c a(TypeEvaluator<T> typeEvaluator, long j) {
        if (j > 0) {
            if (typeEvaluator == null) {
                return this;
            }
            this.b.add(new a<>(typeEvaluator, j, this.f12807a));
            this.f12807a += j;
        }
        return this;
    }

    @Override // android.animation.TypeEvaluator
    public T evaluate(float f, T t, T t2) {
        List<a<T>> list = this.b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        a a2 = a(f);
        if (a2 != null) {
            return (T) a2.b.evaluate((float) (((f * this.f12807a) - a2.f12810c) / a2.f12809a), t, t2);
        }
        Log.d("", "null node:" + f);
        return t2;
    }
}
