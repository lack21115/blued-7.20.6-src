package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/xf.class */
public class xf implements w4 {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<w4> f24422a = new ArrayList<>();

    public void a(w4 w4Var) {
        synchronized (this) {
            if (w4Var != null) {
                if (!this.f24422a.contains(w4Var)) {
                    this.f24422a.add(w4Var);
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a() {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).a()) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a(float f) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).a(f)) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a(float f, float f2) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).a(f, f2)) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a(PointF pointF, PointF pointF2, double d, double d2) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).a(pointF, pointF2, d, d2)) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a(PointF pointF, PointF pointF2, float f) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).a(pointF, pointF2, f)) {
                    return true;
                }
                size = i;
            }
        }
    }

    public void b(w4 w4Var) {
        synchronized (this) {
            this.f24422a.remove(w4Var);
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean b() {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).b()) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean b(float f) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).b(f)) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean b(float f, float f2) {
        int size = this.f24422a.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return false;
            }
            if (this.f24422a.get(i).b(f, f2)) {
                return true;
            }
            size = i;
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public void c() {
        int size = this.f24422a.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            this.f24422a.get(i).c();
            size = i;
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean c(float f, float f2) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).c(f, f2)) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean d() {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).d()) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean d(float f, float f2) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).d(f, f2)) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onDoubleTap(float f, float f2) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).onDoubleTap(f, f2)) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onDown(float f, float f2) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).onDown(f, f2)) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onFling(float f, float f2) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).onFling(f, f2)) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onLongPress(float f, float f2) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).onLongPress(f, f2)) {
                    return true;
                }
                size = i;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onScroll(float f, float f2) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).onScroll(f, f2)) {
                    return true;
                }
                size = i;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
        com.tencent.mapsdk.internal.na.c("notify onSingleTap");
        r0 = r4.f24422a.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r0 < 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
        r4.f24422a.get(r0).c();
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
        return false;
     */
    @Override // com.tencent.mapsdk.internal.w4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onSingleTap(float r5, float r6) {
        /*
            r4 = this;
            r0 = r4
            monitor-enter(r0)
            r0 = r4
            java.util.ArrayList<com.tencent.mapsdk.internal.w4> r0 = r0.f24422a     // Catch: java.lang.Throwable -> L62
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L62
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
        Lc:
            r0 = r7
            if (r0 < 0) goto L34
            r0 = r4
            java.util.ArrayList<com.tencent.mapsdk.internal.w4> r0 = r0.f24422a     // Catch: java.lang.Throwable -> L62
            r1 = r7
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L62
            com.tencent.mapsdk.internal.w4 r0 = (com.tencent.mapsdk.internal.w4) r0     // Catch: java.lang.Throwable -> L62
            r1 = r5
            r2 = r6
            boolean r0 = r0.onSingleTap(r1, r2)     // Catch: java.lang.Throwable -> L62
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L2d
            r0 = r4
            monitor-exit(r0)
            r0 = 1
            return r0
        L2d:
            r0 = r7
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
            goto Lc
        L34:
            java.lang.String r0 = "notify onSingleTap"
            com.tencent.mapsdk.internal.na.c(r0)     // Catch: java.lang.Throwable -> L62
            r0 = r4
            java.util.ArrayList<com.tencent.mapsdk.internal.w4> r0 = r0.f24422a     // Catch: java.lang.Throwable -> L62
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L62
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
        L43:
            r0 = r7
            if (r0 < 0) goto L5e
            r0 = r4
            java.util.ArrayList<com.tencent.mapsdk.internal.w4> r0 = r0.f24422a     // Catch: java.lang.Throwable -> L62
            r1 = r7
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L62
            com.tencent.mapsdk.internal.w4 r0 = (com.tencent.mapsdk.internal.w4) r0     // Catch: java.lang.Throwable -> L62
            r0.c()     // Catch: java.lang.Throwable -> L62
            r0 = r7
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
            goto L43
        L5e:
            r0 = r4
            monitor-exit(r0)
            r0 = 0
            return r0
        L62:
            r9 = move-exception
            r0 = r4
            monitor-exit(r0)
            r0 = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.xf.onSingleTap(float, float):boolean");
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onUp(float f, float f2) {
        synchronized (this) {
            int size = this.f24422a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                if (this.f24422a.get(i).onUp(f, f2)) {
                    return true;
                }
                size = i;
            }
        }
    }
}
