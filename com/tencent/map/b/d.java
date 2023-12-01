package com.tencent.map.b;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f23519a = null;
    private TelephonyManager b = null;

    /* renamed from: c  reason: collision with root package name */
    private a f23520c = null;
    private c d = null;
    private b e = null;
    private boolean f = false;
    private List<NeighboringCellInfo> g = new LinkedList();
    private byte[] h = new byte[0];
    private byte[] i = new byte[0];
    private boolean j = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/d$a.class */
    public final class a extends PhoneStateListener {

        /* renamed from: a  reason: collision with root package name */
        private int f23522a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f23523c = 0;
        private int d = 0;
        private int e = 0;
        private int f = -1;
        private int g = Integer.MAX_VALUE;
        private int h = Integer.MAX_VALUE;
        private Method i = null;
        private Method j = null;
        private Method k = null;
        private Method l = null;
        private Method m = null;

        public a(int i, int i2) {
            this.f23522a = 0;
            this.b = 0;
            this.b = i;
            this.f23522a = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x01f2  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
        @Override // android.telephony.PhoneStateListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onCellLocationChanged(android.telephony.CellLocation r14) {
            /*
                Method dump skipped, instructions count: 537
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.b.d.a.onCellLocationChanged(android.telephony.CellLocation):void");
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i) {
            if (this.f23522a == 1) {
                d.c(d.this);
            }
            if (Math.abs(i - ((this.f + 113) / 2)) > 3) {
                int i2 = i << 1;
                if (this.f == -1) {
                    this.f = i2 - 113;
                    return;
                }
                int i3 = i2 - 113;
                this.f = i3;
                d dVar = d.this;
                dVar.e = new b(dVar, this.f23522a, this.b, this.f23523c, this.d, this.e, i3, this.g, this.h);
                if (d.this.d != null) {
                    d.this.d.a(d.this.e);
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/d$b.class */
    public final class b implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        public int f23524a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f23525c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;

        public b(d dVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f23524a = 0;
            this.b = 0;
            this.f23525c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = Integer.MAX_VALUE;
            this.h = Integer.MAX_VALUE;
            this.f23524a = i;
            this.b = i2;
            this.f23525c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
        }

        public final Object clone() {
            try {
                return (b) super.clone();
            } catch (Exception e) {
                return null;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/d$c.class */
    public interface c {
        void a(b bVar);
    }

    private int a(int i) {
        int i2;
        String networkOperator = this.b.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() >= 3) {
            try {
                i2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
            } catch (Exception e) {
            }
            if (i == 2 || i2 != -1) {
                return i2;
            }
            return 0;
        }
        i2 = -1;
        if (i == 2) {
        }
        return i2;
    }

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.j = false;
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.map.b.d$1] */
    static /* synthetic */ void c(d dVar) {
        if (!dVar.j) {
            dVar.j = true;
            new Thread() { // from class: com.tencent.map.b.d.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    if (d.this.b != null) {
                        List<NeighboringCellInfo> neighboringCellInfo = d.this.b.getNeighboringCellInfo();
                        synchronized (d.this.i) {
                            if (neighboringCellInfo != null) {
                                d.this.g.clear();
                                d.this.g.addAll(neighboringCellInfo);
                            }
                        }
                    }
                    d.a(d.this, false);
                }
            }.start();
        }
    }

    public final void a() {
        synchronized (this.h) {
            if (this.f) {
                if (this.b != null && this.f23520c != null) {
                    try {
                        this.b.listen(this.f23520c, 0);
                    } catch (Exception e) {
                        this.f = false;
                    }
                }
                this.f = false;
            }
        }
    }

    public final boolean a(Context context, c cVar) {
        synchronized (this.h) {
            if (this.f) {
                return true;
            }
            if (context == null || cVar == null) {
                return false;
            }
            this.f23519a = context;
            this.d = cVar;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                this.b = telephonyManager;
                if (telephonyManager == null) {
                    return false;
                }
                int phoneType = telephonyManager.getPhoneType();
                a aVar = new a(a(phoneType), phoneType);
                this.f23520c = aVar;
                if (aVar == null) {
                    return false;
                }
                this.b.listen(aVar, 18);
                this.f = true;
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public final List<NeighboringCellInfo> b() {
        LinkedList linkedList;
        synchronized (this.i) {
            if (this.g != null) {
                linkedList = new LinkedList();
                linkedList.addAll(this.g);
            } else {
                linkedList = null;
            }
        }
        return linkedList;
    }
}
