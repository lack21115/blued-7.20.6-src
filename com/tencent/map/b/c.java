package com.tencent.map.b;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f23514a;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private List<a> f23515c = new ArrayList();
    private List<b> d = new ArrayList();
    private String e;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/c$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f23516a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f23517c;
        public int d;

        private a() {
            this.f23516a = -1;
            this.b = -1;
            this.f23517c = -1;
            this.d = -1;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/b/c$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f23518a;

        private b() {
            this.f23518a = null;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public static c a() {
        if (f23514a == null) {
            f23514a = new c();
        }
        return f23514a;
    }

    private static boolean a(StringBuffer stringBuffer) {
        try {
            return new JSONObject(stringBuffer.toString()).getJSONObject("location").getDouble("accuracy") < 5000.0d;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean a(List<ScanResult> list) {
        int i;
        int i2;
        if (list == null) {
            return false;
        }
        if (this.d != null) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                i = i5;
                if (i3 >= this.d.size()) {
                    break;
                }
                String str = this.d.get(i3).f23518a;
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    i2 = i5;
                    if (str != null) {
                        i2 = i5;
                        if (i7 >= list.size()) {
                            break;
                        } else if (str.equals(list.get(i7).BSSID)) {
                            i2 = i5 + 1;
                            break;
                        } else {
                            i6 = i7 + 1;
                        }
                    }
                }
                i3++;
                i4 = i2;
            }
        } else {
            i = 0;
        }
        int size = list.size();
        if (size < 6 || i < (size / 2) + 1) {
            if (size >= 6 || i < 2) {
                return this.d.size() <= 2 && list.size() <= 2 && Math.abs(System.currentTimeMillis() - this.b) <= 30000;
            }
            return true;
        }
        return true;
    }

    public final void a(int i, int i2, int i3, int i4, List<ScanResult> list) {
        this.b = System.currentTimeMillis();
        this.e = null;
        this.f23515c.clear();
        a aVar = new a((byte) 0);
        aVar.f23516a = i;
        aVar.b = i2;
        aVar.f23517c = i3;
        aVar.d = i4;
        this.f23515c.add(aVar);
        if (list == null) {
            return;
        }
        this.d.clear();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= list.size()) {
                return;
            }
            b bVar = new b((byte) 0);
            bVar.f23518a = list.get(i6).BSSID;
            int i7 = list.get(i6).level;
            this.d.add(bVar);
            i5 = i6 + 1;
        }
    }

    public final void a(String str) {
        this.e = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r10.size() > 2) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
        if (r10.size() <= 2) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
        if (a(new java.lang.StringBuffer(r13)) == false) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(int r6, int r7, int r8, int r9, java.util.List<android.net.wifi.ScanResult> r10) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.b.c.b(int, int, int, int, java.util.List):java.lang.String");
    }

    public final void b() {
        this.e = null;
    }
}
