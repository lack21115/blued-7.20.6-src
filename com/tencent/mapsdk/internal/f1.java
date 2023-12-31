package com.tencent.mapsdk.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f1.class */
public class f1 {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<u4> f23734a = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<u4> b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final CopyOnWriteArrayList<u4> f23735c = new CopyOnWriteArrayList<>();
    private final e1 d;

    public f1(e1 e1Var) {
        this.d = e1Var;
    }

    private void a() {
        int N;
        synchronized (this.f23734a) {
            ArrayList arrayList = new ArrayList();
            int size = this.f23735c.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                u4 u4Var = this.f23735c.get(i2);
                if ((u4Var instanceof ig) && (N = ((ig) u4Var).N()) >= 0) {
                    arrayList.add(Integer.valueOf(N));
                }
                i = i2 + 1;
            }
            int size2 = arrayList.size();
            int[] iArr = new int[size2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < size2) {
                    iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
                    i3 = i4 + 1;
                } else {
                    this.d.f().a(iArr, size2);
                    this.f23735c.clear();
                }
            }
        }
    }

    public void a(u4 u4Var) {
        synchronized (this.f23734a) {
            if (this.f23734a.contains(u4Var)) {
                return;
            }
            this.f23734a.add(u4Var);
            this.d.h().a();
        }
    }

    public boolean a(float f, float f2) {
        synchronized (this.f23734a) {
            int size = this.f23734a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                u4 u4Var = this.f23734a.get(i);
                if (u4Var != null && u4Var.onTap(f, f2)) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Deprecated
    public boolean a(GL10 gl10) {
        a();
        this.b.clear();
        synchronized (this.f23734a) {
            this.b.addAll(this.f23734a);
        }
        Iterator<u4> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(gl10);
        }
        return true;
    }

    public void b(u4 u4Var) {
        if (u4Var == null) {
            return;
        }
        synchronized (this.f23734a) {
            if (this.f23734a.remove(u4Var)) {
                this.d.h().a();
            }
            this.f23735c.add(u4Var);
        }
    }
}
