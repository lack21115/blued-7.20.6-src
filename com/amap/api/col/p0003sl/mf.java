package com.amap.api.col.p0003sl;

import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.mf  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/mf.class */
public final class mf {

    /* renamed from: com.amap.api.col.3sl.mf$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/mf$a.class */
    public static final class a implements md {

        /* renamed from: a  reason: collision with root package name */
        private int f5379a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f5380c;

        a(int i, int i2, int i3) {
            this.f5379a = i;
            this.b = i2;
            this.f5380c = i3;
        }

        @Override // com.amap.api.col.p0003sl.md
        public final long a() {
            return mf.a(this.f5379a, this.b);
        }

        @Override // com.amap.api.col.p0003sl.md
        public final int b() {
            return this.f5380c;
        }
    }

    /* renamed from: com.amap.api.col.3sl.mf$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/mf$b.class */
    public static final class b implements md {

        /* renamed from: a  reason: collision with root package name */
        private long f5381a;
        private int b;

        b(long j, int i) {
            this.f5381a = j;
            this.b = i;
        }

        @Override // com.amap.api.col.p0003sl.md
        public final long a() {
            return this.f5381a;
        }

        @Override // com.amap.api.col.p0003sl.md
        public final int b() {
            return this.b;
        }
    }

    public static long a(int i, int i2) {
        return (i2 & ExpandableListView.PACKED_POSITION_VALUE_NULL) | ((i & ExpandableListView.PACKED_POSITION_VALUE_NULL) << 32);
    }

    public static short a(long j) {
        short a2;
        synchronized (mf.class) {
            try {
                a2 = me.a().a(j);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    public static void a(List<mj> list) {
        synchronized (mf.class) {
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        ArrayList arrayList = new ArrayList(list.size());
                        for (mj mjVar : list) {
                            if (mjVar instanceof ml) {
                                ml mlVar = (ml) mjVar;
                                arrayList.add(new a(mlVar.j, mlVar.k, mlVar.f5384c));
                            } else if (mjVar instanceof mm) {
                                mm mmVar = (mm) mjVar;
                                arrayList.add(new a(mmVar.j, mmVar.k, mmVar.f5384c));
                            } else if (mjVar instanceof mn) {
                                mn mnVar = (mn) mjVar;
                                arrayList.add(new a(mnVar.j, mnVar.k, mnVar.f5384c));
                            } else if (mjVar instanceof mk) {
                                mk mkVar = (mk) mjVar;
                                arrayList.add(new a(mkVar.k, mkVar.l, mkVar.f5384c));
                            }
                        }
                        me.a().a(arrayList);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static short b(long j) {
        short b2;
        synchronized (mf.class) {
            try {
                b2 = me.a().b(j);
            } catch (Throwable th) {
                throw th;
            }
        }
        return b2;
    }

    public static void b(List<mq> list) {
        synchronized (mf.class) {
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        ArrayList arrayList = new ArrayList(list.size());
                        for (mq mqVar : list) {
                            arrayList.add(new b(mqVar.f5387a, mqVar.f5388c));
                        }
                        me.a().b(arrayList);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
