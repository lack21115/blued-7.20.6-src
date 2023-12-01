package com.tencent.mapsdk.internal;

import android.provider.Downloads;
import com.blued.android.chat.core.pack.ReqAckPackage;
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
        public C0951a f37339c;

        /* renamed from: com.tencent.mapsdk.internal.c4$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a.class */
        public static class C0951a extends g4.c {
            @Json(name = "theme")

            /* renamed from: c  reason: collision with root package name */
            public b f37340c;
            @Json(name = Downloads.Impl.COLUMN_CONTROL)
            public C0952a d;

            /* renamed from: com.tencent.mapsdk.internal.c4$a$a$a  reason: collision with other inner class name */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a$a.class */
            public static final class C0952a extends g4.c.a {
                @Json(name = "enable3D")
                public boolean h;
                @Json(name = "animated")
                public boolean i;
                @Json(name = ReqAckPackage.REQ_RESPONSE_KEY.ANIMATION)
                public C0953a j;

                /* renamed from: com.tencent.mapsdk.internal.c4$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a$a$a.class */
                public static class C0953a extends JsonComposer {
                    @Json(name = "highlightDuration")

                    /* renamed from: a  reason: collision with root package name */
                    public double f37341a;
                    @Json(name = "highlightColor")
                    public int b;
                    @Json(name = "duration")

                    /* renamed from: c  reason: collision with root package name */
                    public double f37342c;
                }
            }

            /* renamed from: com.tencent.mapsdk.internal.c4$a$a$b */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a$b.class */
            public static class b extends JsonComposer {
                @Json(name = "standard")

                /* renamed from: a  reason: collision with root package name */
                public C0956b f37343a;

                /* renamed from: com.tencent.mapsdk.internal.c4$a$a$b$a  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a$b$a.class */
                public static final class C0954a extends g4.c.AbstractC0959c {
                    @Json(name = "width")

                    /* renamed from: a  reason: collision with root package name */
                    public int f37344a;
                    @Json(name = "radian")
                    public double b;
                    @Json(name = "gradient")

                    /* renamed from: c  reason: collision with root package name */
                    public g4.c.e f37345c;
                    @Json(name = ReqAckPackage.REQ_RESPONSE_KEY.ANIMATION)
                    public C0955a d;

                    /* renamed from: com.tencent.mapsdk.internal.c4$a$a$b$a$a  reason: collision with other inner class name */
                    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a$b$a$a.class */
                    public static final class C0955a extends g4.c.d {
                        @Json(name = "highlightDuration")
                        public double b;
                        @Json(name = "highlightColor")

                        /* renamed from: c  reason: collision with root package name */
                        public int f37346c;
                    }
                }

                /* renamed from: com.tencent.mapsdk.internal.c4$a$a$b$b  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c4$a$a$b$b.class */
                public static class C0956b extends JsonComposer {
                    @Json(name = "defaultStyle")

                    /* renamed from: a  reason: collision with root package name */
                    public C0954a f37347a;
                }
            }
        }

        @Override // com.tencent.mapsdk.internal.g4.a
        public boolean a() {
            C0951a c0951a;
            return super.a() && a4.ArcLine.b(this.f37457a) && (c0951a = this.f37339c) != null && c0951a.a();
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
            return this.b.f37339c.f37465a;
        }
        return 0;
    }
}
