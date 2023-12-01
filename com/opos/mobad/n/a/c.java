package com.opos.mobad.n.a;

import android.animation.TypeEvaluator;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/c.class */
public class c<T> implements TypeEvaluator<T> {

    /* renamed from: a  reason: collision with root package name */
    private long f26495a = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f26496c = 0;
    private List<a<T>> b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/c$a.class */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private long f26497a;
        private TypeEvaluator<T> b;

        /* renamed from: c  reason: collision with root package name */
        private long f26498c;

        public a(TypeEvaluator<T> typeEvaluator, long j, long j2) {
            this.f26497a = j;
            this.b = typeEvaluator;
            this.f26498c = j2;
        }
    }

    private a a(float f) {
        float f2 = ((float) this.f26495a) * f;
        int i = this.f26496c;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                if (this.f26496c <= 0) {
                    return null;
                }
                this.f26496c = 0;
                return a(f);
            }
            a<T> aVar = this.b.get(i2);
            if (f2 >= ((float) ((a) aVar).f26498c) && f2 <= ((float) (((a) aVar).f26497a + ((a) aVar).f26498c))) {
                this.f26496c = i2;
                return aVar;
            }
            i = i2 + 1;
        }
    }

    public long a() {
        return this.f26495a;
    }

    public c a(TypeEvaluator<T> typeEvaluator, long j) {
        if (j > 0) {
            if (typeEvaluator == null) {
                return this;
            }
            this.b.add(new a<>(typeEvaluator, j, this.f26495a));
            this.f26495a += j;
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
            return (T) a2.b.evaluate((float) (((f * this.f26495a) - a2.f26498c) / a2.f26497a), t, t2);
        }
        Log.d("", "null node:" + f);
        return t2;
    }
}
