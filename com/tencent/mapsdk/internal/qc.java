package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qc.class */
public class qc {

    /* renamed from: a  reason: collision with root package name */
    private e1 f37719a;
    private ri b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<Integer, ue> f37720c = new HashMap<>();
    private HashMap<Integer, ue> d = new HashMap<>();

    public qc(e1 e1Var, cc ccVar, ri riVar) {
        this.f37719a = e1Var;
        this.b = riVar;
    }

    public static Bitmap a(String str) {
        return b7.e.a(str);
    }

    private void d() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, ue> entry : this.f37720c.entrySet()) {
            Integer key = entry.getKey();
            entry.getValue();
            if (!this.d.containsKey(key)) {
                arrayList.add(Integer.valueOf(key.intValue()));
            }
        }
        int size = arrayList.size();
        if (size <= 0) {
            return;
        }
        int[] iArr = new int[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.b.a(iArr, size);
                return;
            } else {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                i = i2 + 1;
            }
        }
    }

    private void e() {
        this.f37720c.clear();
        this.f37720c.putAll(this.d);
        this.d.clear();
    }

    public e1 a() {
        return this.f37719a;
    }

    public void a(ue ueVar) {
        int i = ueVar.w;
        if (i > 0 && this.f37720c.containsKey(Integer.valueOf(i))) {
            if (ueVar.y()) {
                this.b.b(ueVar);
                if (ueVar.C()) {
                    b7.e.a(ueVar.j(), ueVar.a(0));
                    ueVar.h(false);
                }
            }
            ueVar.d(false);
            this.d.put(Integer.valueOf(ueVar.w), ueVar);
            return;
        }
        int a2 = this.b.a(ueVar);
        ueVar.w = a2;
        if (a2 > 0) {
            b7.e.a(ueVar.j(), ueVar.a(0));
            ueVar.h(false);
            ueVar.d(false);
            this.d.put(Integer.valueOf(ueVar.w), ueVar);
        }
    }

    public float b() {
        return this.f37719a.h().q();
    }

    public void c() {
        d();
        e();
    }
}
