package com.tencent.mapsdk.internal;

import android.os.BatteryManager;
import android.provider.BrowserContract;
import android.provider.Downloads;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mapsdk.internal.g4;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngDeserializer;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngListDeserializer;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h4.class */
public class h4 extends g4 {
    @Json(name = "detail")
    public a b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h4$a.class */
    public static class a extends g4.a {
        @Json(name = "styleTable")

        /* renamed from: c  reason: collision with root package name */
        public C0791a f23821c;

        /* renamed from: com.tencent.mapsdk.internal.h4$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h4$a$a.class */
        public static class C0791a extends g4.c {
            @Json(name = "theme")

            /* renamed from: c  reason: collision with root package name */
            public b f23822c;
            @Json(name = Downloads.Impl.COLUMN_CONTROL)
            public C0792a d;

            /* renamed from: com.tencent.mapsdk.internal.h4$a$a$a  reason: collision with other inner class name */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h4$a$a$a.class */
            public static final class C0792a extends g4.c.a {
            }

            /* renamed from: com.tencent.mapsdk.internal.h4$a$a$b */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h4$a$a$b.class */
            public static class b extends JsonComposer {
                @Json(name = "standard")

                /* renamed from: a  reason: collision with root package name */
                public C0794b f23823a;

                /* renamed from: com.tencent.mapsdk.internal.h4$a$a$b$a  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h4$a$a$b$a.class */
                public static final class C0793a extends g4.c.AbstractC0789c {
                    @Json(deserializer = LatLngDeserializer.class, name = BrowserContract.Bookmarks.POSITION)

                    /* renamed from: a  reason: collision with root package name */
                    public LatLng f23824a;
                    @Json(name = "rotate")
                    public List<Double> b;
                    @Json(name = BatteryManager.EXTRA_SCALE)

                    /* renamed from: c  reason: collision with root package name */
                    public double f23825c;
                    @Json(name = "autoScale")
                    public boolean d;
                    @Json(name = "pixelBound")
                    public List<Integer> e;
                    @Json(deserializer = LatLngListDeserializer.class, name = "pedestal")
                    public List<LatLng> f;
                    @Json(name = "animation")
                    public g4.c.f g;
                    @Json(name = "exposure")
                    public double h;
                }

                /* renamed from: com.tencent.mapsdk.internal.h4$a$a$b$b  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h4$a$a$b$b.class */
                public static class C0794b extends JsonComposer {
                    @Json(name = "defaultStyle")

                    /* renamed from: a  reason: collision with root package name */
                    public C0793a f23826a;
                }
            }

            @Override // com.tencent.mapsdk.internal.g4.c
            public boolean a() {
                return (!super.a() || this.f23822c == null || this.d == null) ? false : true;
            }
        }

        @Override // com.tencent.mapsdk.internal.g4.a
        public boolean a() {
            C0791a c0791a;
            return super.a() && a4.GLModel.b(this.f23766a) && (c0791a = this.f23821c) != null && c0791a.a();
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
            return this.b.f23821c.f23774a;
        }
        return 0;
    }
}
