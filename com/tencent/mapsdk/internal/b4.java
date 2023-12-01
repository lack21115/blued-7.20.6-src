package com.tencent.mapsdk.internal;

import android.provider.Downloads;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.internal.g4;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b4.class */
public final class b4 extends g4 {
    @Json(name = "detail")
    public a b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b4$a.class */
    public static class a extends g4.a {
        @Json(name = "styleTable")

        /* renamed from: c  reason: collision with root package name */
        public C0946a f37308c;

        /* renamed from: com.tencent.mapsdk.internal.b4$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b4$a$a.class */
        public static class C0946a extends g4.c {
            @Json(name = "theme")

            /* renamed from: c  reason: collision with root package name */
            public b f37309c;
            @Json(name = Downloads.Impl.COLUMN_CONTROL)
            public C0947a d;

            /* renamed from: com.tencent.mapsdk.internal.b4$a$a$a  reason: collision with other inner class name */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b4$a$a$a.class */
            public static final class C0947a extends g4.c.a {
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

            /* renamed from: com.tencent.mapsdk.internal.b4$a$a$b */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b4$a$a$b.class */
            public static class b extends JsonComposer {
                @Json(name = "standard")

                /* renamed from: a  reason: collision with root package name */
                public C0949b f37310a;

                /* renamed from: com.tencent.mapsdk.internal.b4$a$a$b$a  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b4$a$a$b$a.class */
                public static final class C0948a extends g4.c.AbstractC0959c {
                    @Json(name = "gap")

                    /* renamed from: a  reason: collision with root package name */
                    public int f37311a;
                    @Json(name = "radius")
                    public int b;
                    @Json(name = "shapeType")

                    /* renamed from: c  reason: collision with root package name */
                    public String f37312c;
                    @Json(name = "gradient")
                    public g4.c.e d;
                    @Json(name = ReqAckPackage.REQ_RESPONSE_KEY.ANIMATION)
                    public g4.c.d e;
                }

                /* renamed from: com.tencent.mapsdk.internal.b4$a$a$b$b  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b4$a$a$b$b.class */
                public static class C0949b extends JsonComposer {
                    @Json(name = "defaultStyle")

                    /* renamed from: a  reason: collision with root package name */
                    public C0948a f37313a;
                }
            }

            @Override // com.tencent.mapsdk.internal.g4.c
            public boolean a() {
                return (!super.a() || this.f37309c == null || this.d == null) ? false : true;
            }
        }

        @Override // com.tencent.mapsdk.internal.g4.a
        public boolean a() {
            C0946a c0946a;
            return super.a() && a4.Aggregation.b(this.f37457a) && (c0946a = this.f37308c) != null && c0946a.a();
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
            return this.b.f37308c.f37465a;
        }
        return 0;
    }
}
