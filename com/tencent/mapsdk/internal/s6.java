package com.tencent.mapsdk.internal;

import com.baidu.mobads.sdk.internal.bw;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.shell.events.ReportEvent;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s6.class */
public class s6 extends x6 {
    @Json(name = "loadSuccess")
    private boolean b;
    @Json(name = "loadSuccessTime")

    /* renamed from: c  reason: collision with root package name */
    private long f37993c;
    @Json(name = "firstLoadTime")
    private long d;
    @Json(name = "configUpdate")
    private b e;
    @Json(name = "tileErrors")
    private Set<e> f;
    @Json(name = "configError")
    private a g;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s6$a.class */
    public static class a extends x6 {
        @Json(name = "failUpdates")
        private Set<c> b;
        @Json(name = "missFiles")

        /* renamed from: c  reason: collision with root package name */
        private Set<d> f37994c;

        public a(long j) {
            super(j);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s6$b.class */
    public static class b extends x6 {
        @Json(name = bw.o)
        private boolean b;
        @Json(name = "loadBeginTime")

        /* renamed from: c  reason: collision with root package name */
        private long f37995c;

        public b(long j) {
            super(j);
            this.b = false;
            this.f37995c = 0L;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s6$c.class */
    public static class c extends x6 {
        @Json(name = "name")
        public String b;
        @Json(name = "time")

        /* renamed from: c  reason: collision with root package name */
        public long f37996c;
        @Json(name = "expectMd5")
        public String d;
        @Json(name = "actualMd5")
        public String e;
        @Json(name = "localVer")
        public int f;
        @Json(name = "netError")
        public int g;

        public c() {
            this(0L);
        }

        public c(long j) {
            super(j);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                return f7.c(this.b, ((c) obj).b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.b;
            return str == null ? super.hashCode() : str.hashCode();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s6$d.class */
    public static class d extends x6 {
        @Json(name = "name")
        private String b;
        @Json(name = "time")

        /* renamed from: c  reason: collision with root package name */
        private long f37997c;

        public d(long j) {
            super(j);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof d) {
                return f7.c(this.b, ((d) obj).b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.b;
            return str == null ? super.hashCode() : str.hashCode();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s6$e.class */
    public static class e extends x6 {
        @Json(name = "time")
        private long b;
        @Json(name = "tid")

        /* renamed from: c  reason: collision with root package name */
        private String f37998c;
        @Json(name = "netError")
        private int d;

        public e(long j) {
            super(j);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof e) {
                return f7.c(this.f37998c, ((e) obj).f37998c);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f37998c;
            return str == null ? super.hashCode() : str.hashCode();
        }
    }

    public s6(long j) {
        super(j);
        this.b = false;
        this.f37993c = 0L;
        this.d = 0L;
    }

    public void a(long j, String str) {
        if (this.g == null) {
            this.g = new a(a());
        }
        if (this.g.f37994c == null) {
            this.g.f37994c = new CopyOnWriteArraySet();
        }
        if (this.g.f37994c.size() > 9) {
            return;
        }
        d dVar = new d(this.f38104a);
        dVar.f37997c = j - this.f38104a;
        dVar.b = str;
        this.g.f37994c.add(dVar);
        HashMap hashMap = new HashMap();
        hashMap.put("startTime", "" + this.f38104a);
        hashMap.put("endTime", "" + j);
        u.d().onReport(new ReportEvent("mapload-missfile", hashMap));
    }

    public void a(long j, String str, int i) {
        if (this.f == null) {
            this.f = new CopyOnWriteArraySet();
        }
        if (this.f.size() > 9) {
            return;
        }
        e eVar = new e(j);
        eVar.b = j - this.f38104a;
        eVar.f37998c = str;
        eVar.d = i;
        this.f.add(eVar);
        HashMap hashMap = new HashMap();
        hashMap.put("tid", str);
        hashMap.put("netError", "" + i);
        hashMap.put("startTime", "" + this.f38104a);
        hashMap.put("endTime", "" + j);
        u.d().onReport(new ReportEvent("mapload-tile", hashMap));
    }

    public void a(c cVar) {
        if (this.g == null) {
            this.g = new a(a());
        }
        if (this.g.b == null) {
            this.g.b = new CopyOnWriteArraySet();
        }
        if (this.g.b.size() > 9) {
            return;
        }
        this.g.b.add(cVar);
        HashMap hashMap = new HashMap();
        hashMap.put("name", cVar.b);
        hashMap.put("localVer", "" + cVar.f);
        hashMap.put("netError", "" + cVar.g);
        hashMap.put("expectMd5", cVar.d);
        hashMap.put("actualMd5", cVar.e);
        hashMap.put("startTime", "" + this.f38104a);
        hashMap.put("endTime", "" + this.f38104a + cVar.f37996c);
        u.d().onReport(new ReportEvent("mapload-configfile", hashMap));
    }

    public void a(boolean z, long j) {
        b bVar = new b(a());
        this.e = bVar;
        bVar.b = z;
        long j2 = j - this.f38104a;
        if (j2 > 0) {
            this.e.f37995c = j2;
        }
    }

    public void b(boolean z, long j) {
        this.b = z;
        if (this.d > 0) {
            this.f37993c = j - this.f38104a;
        } else {
            this.d = j - this.f38104a;
        }
        this.f37993c = j;
        HashMap hashMap = new HashMap();
        hashMap.put(bw.o, z + "");
        hashMap.put("startTime", this.f38104a + "");
        hashMap.put("endTime", j + "");
        hashMap.put("duration", this.f37993c + "");
        hashMap.put("firstDuration", this.d + "");
        u.d().onReport(new ReportEvent("mapload", hashMap));
    }
}
