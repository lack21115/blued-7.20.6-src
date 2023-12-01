package com.tencent.mapsdk.internal;

import android.provider.Downloads;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.internal.g4;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4.class */
public final class c4 extends g4 {
    @Json(name = "detail")
    public a b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a.class */
    public static class a extends g4.a {
        @Json(name = "styleTable")

        /* renamed from: c  reason: collision with root package name */
        public C0781a f23648c;

        /* renamed from: com.tencent.mapsdk.internal.c4$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a.class */
        public static class C0781a extends g4.c {
            @Json(name = "theme")

            /* renamed from: c  reason: collision with root package name */
            public b f23649c;
            @Json(name = Downloads.Impl.COLUMN_CONTROL)
            public C0782a d;

            /* renamed from: com.tencent.mapsdk.internal.c4$a$a$a  reason: collision with other inner class name */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a$a.class */
            public static final class C0782a extends g4.c.a {
                @Json(name = "enable3D")
                public boolean h;
                @Json(name = "animated")
                public boolean i;
                @Json(name = "animation")
                public C0783a j;

                /* renamed from: com.tencent.mapsdk.internal.c4$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a$a$a.class */
                public static class C0783a extends JsonComposer {
                    @Json(name = "highlightDuration")

                    /* renamed from: a  reason: collision with root package name */
                    public double f23650a;
                    @Json(name = "highlightColor")
                    public int b;
                    @Json(name = "duration")

                    /* renamed from: c  reason: collision with root package name */
                    public double f23651c;
                }
            }

            /* renamed from: com.tencent.mapsdk.internal.c4$a$a$b */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a$b.class */
            public static class b extends JsonComposer {
                @Json(name = "standard")

                /* renamed from: a  reason: collision with root package name */
                public C0786b f23652a;

                /* renamed from: com.tencent.mapsdk.internal.c4$a$a$b$a  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a$b$a.class */
                public static final class C0784a extends g4.c.AbstractC0789c {
                    @Json(name = "width")

                    /* renamed from: a  reason: collision with root package name */
                    public int f23653a;
                    @Json(name = "radian")
                    public double b;
                    @Json(name = "gradient")

                    /* renamed from: c  reason: collision with root package name */
                    public g4.c.e f23654c;
                    @Json(name = "animation")
                    public C0785a d;

                    /* renamed from: com.tencent.mapsdk.internal.c4$a$a$b$a$a  reason: collision with other inner class name */
                    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a$b$a$a.class */
                    public static final class C0785a extends g4.c.d {
                        @Json(name = "highlightDuration")
                        public double b;
                        @Json(name = "highlightColor")

                        /* renamed from: c  reason: collision with root package name */
                        public int f23655c;
                    }
                }

                /* renamed from: com.tencent.mapsdk.internal.c4$a$a$b$b  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a$b$b.class */
                public static class C0786b extends JsonComposer {
                    @Json(name = "defaultStyle")

                    /* renamed from: a  reason: collision with root package name */
                    public C0784a f23656a;
                }
            }
        }

        @Override // com.tencent.mapsdk.internal.g4.a
        public boolean a() {
            C0781a c0781a;
            return super.a() && a4.ArcLine.b(this.f23766a) && (c0781a = this.f23648c) != null && c0781a.a();
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
            return this.b.f23648c.f23774a;
        }
        return 0;
    }
}
