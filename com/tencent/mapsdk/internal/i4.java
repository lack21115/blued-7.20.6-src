package com.tencent.mapsdk.internal;

import android.provider.Downloads;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.internal.g4;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i4.class */
public final class i4 extends g4 {
    @Json(name = "detail")
    public a b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i4$a.class */
    public static class a extends g4.a {
        @Json(name = "styleTable")

        /* renamed from: c  reason: collision with root package name */
        public C0795a f23854c;

        /* renamed from: com.tencent.mapsdk.internal.i4$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i4$a$a.class */
        public static class C0795a extends g4.c {
            @Json(name = "theme")

            /* renamed from: c  reason: collision with root package name */
            public b f23855c;
            @Json(name = Downloads.Impl.COLUMN_CONTROL)
            public C0796a d;

            /* renamed from: com.tencent.mapsdk.internal.i4$a$a$a  reason: collision with other inner class name */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i4$a$a$a.class */
            public static final class C0796a extends g4.c.a {
                @Json(name = "maxIntensity")
                public double h;
                @Json(name = "minIntensity")
                public double i;
                @Json(name = "enable3D")
                public boolean j;
                @Json(name = "heightRange")
                public List<Double> k;
                @Json(name = "animated")
                public boolean l;

                @Override // com.tencent.mapsdk.internal.g4.c.a
                public boolean a() {
                    List<Double> list;
                    return super.a() && (list = this.k) != null && list.size() > 0;
                }
            }

            /* renamed from: com.tencent.mapsdk.internal.i4$a$a$b */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i4$a$a$b.class */
            public static class b extends JsonComposer {
                @Json(name = "standard")

                /* renamed from: a  reason: collision with root package name */
                public C0798b f23856a;

                /* renamed from: com.tencent.mapsdk.internal.i4$a$a$b$a  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i4$a$a$b$a.class */
                public static final class C0797a extends g4.c.AbstractC0789c {
                    @Json(name = "radius")

                    /* renamed from: a  reason: collision with root package name */
                    public int f23857a;
                    @Json(name = "gradient")
                    public g4.c.e b;
                    @Json(name = "animation")

                    /* renamed from: c  reason: collision with root package name */
                    public g4.c.d f23858c;

                    public boolean a() {
                        g4.c.e eVar;
                        g4.c.d dVar;
                        return this.f23857a > 0 && (eVar = this.b) != null && eVar.a() && (dVar = this.f23858c) != null && dVar.a();
                    }
                }

                /* renamed from: com.tencent.mapsdk.internal.i4$a$a$b$b  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i4$a$a$b$b.class */
                public static class C0798b extends JsonComposer {
                    @Json(name = "defaultStyle")

                    /* renamed from: a  reason: collision with root package name */
                    public C0797a f23859a;

                    public boolean a() {
                        C0797a c0797a = this.f23859a;
                        return c0797a != null && c0797a.a();
                    }
                }

                public boolean a() {
                    C0798b c0798b = this.f23856a;
                    return c0798b != null && c0798b.a();
                }
            }

            @Override // com.tencent.mapsdk.internal.g4.c
            public boolean a() {
                b bVar;
                C0796a c0796a;
                return super.a() && (bVar = this.f23855c) != null && bVar.a() && (c0796a = this.d) != null && c0796a.a();
            }
        }

        @Override // com.tencent.mapsdk.internal.g4.a
        public boolean a() {
            C0795a c0795a;
            return super.a() && a4.Gradient.b(this.f23766a) && (c0795a = this.f23854c) != null && c0795a.a();
        }
    }

    @Override // com.tencent.mapsdk.internal.g4
    public boolean a() {
        a aVar;
        return super.a() && (aVar = this.b) != null && aVar.a();
    }

    @Override // com.tencent.mapsdk.internal.g4
    public int b() {
        if (a()) {
            return this.b.b.f23767a;
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.g4
    public int c() {
        if (a()) {
            return this.b.f23854c.f23774a;
        }
        return 0;
    }
}
