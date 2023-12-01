package com.tencent.mapsdk.internal;

import android.provider.Downloads;
import com.blued.android.chat.core.pack.ReqAckPackage;
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
        public C0965a f37545c;

        /* renamed from: com.tencent.mapsdk.internal.i4$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i4$a$a.class */
        public static class C0965a extends g4.c {
            @Json(name = "theme")

            /* renamed from: c  reason: collision with root package name */
            public b f37546c;
            @Json(name = Downloads.Impl.COLUMN_CONTROL)
            public C0966a d;

            /* renamed from: com.tencent.mapsdk.internal.i4$a$a$a  reason: collision with other inner class name */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i4$a$a$a.class */
            public static final class C0966a extends g4.c.a {
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
                public C0968b f37547a;

                /* renamed from: com.tencent.mapsdk.internal.i4$a$a$b$a  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i4$a$a$b$a.class */
                public static final class C0967a extends g4.c.AbstractC0959c {
                    @Json(name = "radius")

                    /* renamed from: a  reason: collision with root package name */
                    public int f37548a;
                    @Json(name = "gradient")
                    public g4.c.e b;
                    @Json(name = ReqAckPackage.REQ_RESPONSE_KEY.ANIMATION)

                    /* renamed from: c  reason: collision with root package name */
                    public g4.c.d f37549c;

                    public boolean a() {
                        g4.c.e eVar;
                        g4.c.d dVar;
                        return this.f37548a > 0 && (eVar = this.b) != null && eVar.a() && (dVar = this.f37549c) != null && dVar.a();
                    }
                }

                /* renamed from: com.tencent.mapsdk.internal.i4$a$a$b$b  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i4$a$a$b$b.class */
                public static class C0968b extends JsonComposer {
                    @Json(name = "defaultStyle")

                    /* renamed from: a  reason: collision with root package name */
                    public C0967a f37550a;

                    public boolean a() {
                        C0967a c0967a = this.f37550a;
                        return c0967a != null && c0967a.a();
                    }
                }

                public boolean a() {
                    C0968b c0968b = this.f37547a;
                    return c0968b != null && c0968b.a();
                }
            }

            @Override // com.tencent.mapsdk.internal.g4.c
            public boolean a() {
                b bVar;
                C0966a c0966a;
                return super.a() && (bVar = this.f37546c) != null && bVar.a() && (c0966a = this.d) != null && c0966a.a();
            }
        }

        @Override // com.tencent.mapsdk.internal.g4.a
        public boolean a() {
            C0965a c0965a;
            return super.a() && a4.Gradient.b(this.f37457a) && (c0965a = this.f37545c) != null && c0965a.a();
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
            return this.b.b.f37458a;
        }
        return 0;
    }

    @Override // com.tencent.mapsdk.internal.g4
    public int c() {
        if (a()) {
            return this.b.f37545c.f37465a;
        }
        return 0;
    }
}
