package com.tencent.cloud.huiyansdkface.okhttp3;

import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/CacheControl.class */
public final class CacheControl {

    /* renamed from: a  reason: collision with root package name */
    public static final CacheControl f35821a = new Builder().noCache().build();
    public static final CacheControl b = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    /* renamed from: c  reason: collision with root package name */
    String f35822c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/CacheControl$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        boolean f35823a;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        int f35824c = -1;
        int d = -1;
        int e = -1;
        boolean f;
        boolean g;
        boolean h;

        public CacheControl build() {
            return new CacheControl(this);
        }

        public Builder immutable() {
            this.h = true;
            return this;
        }

        public Builder maxAge(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.f35824c = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxAge < 0: " + i);
        }

        public Builder maxStale(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public Builder minFresh(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.e = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("minFresh < 0: " + i);
        }

        public Builder noCache() {
            this.f35823a = true;
            return this;
        }

        public Builder noStore() {
            this.b = true;
            return this;
        }

        public Builder noTransform() {
            this.g = true;
            return this;
        }

        public Builder onlyIfCached() {
            this.f = true;
            return this;
        }
    }

    CacheControl(Builder builder) {
        this.d = builder.f35823a;
        this.e = builder.b;
        this.f = builder.f35824c;
        this.g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = builder.d;
        this.l = builder.e;
        this.m = builder.f;
        this.n = builder.g;
        this.o = builder.h;
    }

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.d = z;
        this.e = z2;
        this.f = i;
        this.g = i2;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = i3;
        this.l = i4;
        this.m = z6;
        this.n = z7;
        this.o = z8;
        this.f35822c = str;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.d) {
            sb.append("no-cache, ");
        }
        if (this.e) {
            sb.append("no-store, ");
        }
        if (this.f != -1) {
            sb.append("max-age=");
            sb.append(this.f);
            sb.append(", ");
        }
        if (this.g != -1) {
            sb.append("s-maxage=");
            sb.append(this.g);
            sb.append(", ");
        }
        if (this.h) {
            sb.append("private, ");
        }
        if (this.i) {
            sb.append("public, ");
        }
        if (this.j) {
            sb.append("must-revalidate, ");
        }
        if (this.k != -1) {
            sb.append("max-stale=");
            sb.append(this.k);
            sb.append(", ");
        }
        if (this.l != -1) {
            sb.append("min-fresh=");
            sb.append(this.l);
            sb.append(", ");
        }
        if (this.m) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (this.o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.cloud.huiyansdkface.okhttp3.CacheControl parse(com.tencent.cloud.huiyansdkface.okhttp3.Headers r16) {
        /*
            Method dump skipped, instructions count: 1268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.CacheControl.parse(com.tencent.cloud.huiyansdkface.okhttp3.Headers):com.tencent.cloud.huiyansdkface.okhttp3.CacheControl");
    }

    public boolean immutable() {
        return this.o;
    }

    public boolean isPrivate() {
        return this.h;
    }

    public boolean isPublic() {
        return this.i;
    }

    public int maxAgeSeconds() {
        return this.f;
    }

    public int maxStaleSeconds() {
        return this.k;
    }

    public int minFreshSeconds() {
        return this.l;
    }

    public boolean mustRevalidate() {
        return this.j;
    }

    public boolean noCache() {
        return this.d;
    }

    public boolean noStore() {
        return this.e;
    }

    public boolean noTransform() {
        return this.n;
    }

    public boolean onlyIfCached() {
        return this.m;
    }

    public int sMaxAgeSeconds() {
        return this.g;
    }

    public String toString() {
        String str = this.f35822c;
        if (str != null) {
            return str;
        }
        String a2 = a();
        this.f35822c = a2;
        return a2;
    }
}
