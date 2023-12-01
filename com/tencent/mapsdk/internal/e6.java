package com.tencent.mapsdk.internal;

import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/e6.class */
public class e6 {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<d6> f37407a = new ArrayList<>();

    public d6 a(int i) {
        return this.f37407a.get(i);
    }

    public void a(d6 d6Var) {
        this.f37407a.add(d6Var);
    }

    public void a(e6 e6Var) {
        this.f37407a.addAll(e6Var.f37407a);
    }

    public float[] a() {
        float[] fArr = new float[this.f37407a.size() * 3];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f37407a.size()) {
                return fArr;
            }
            int i3 = i2 * 3;
            fArr[i3 + 0] = this.f37407a.get(i2).f37388a;
            fArr[i3 + 1] = this.f37407a.get(i2).b;
            fArr[i3 + 2] = this.f37407a.get(i2).f37389c;
            i = i2 + 1;
        }
    }

    public int b() {
        return this.f37407a.size();
    }
}
