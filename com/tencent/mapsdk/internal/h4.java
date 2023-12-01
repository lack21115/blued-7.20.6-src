package com.tencent.mapsdk.internal;

import android.os.BatteryManager;
import android.provider.BrowserContract;
import android.provider.Downloads;
import com.blued.android.chat.core.pack.ReqAckPackage;
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
        public C0961a f37512c;

        /* renamed from: com.tencent.mapsdk.internal.h4$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h4$a$a.class */
        public static class C0961a extends g4.c {
            @Json(name = "theme")

            /* renamed from: c  reason: collision with root package name */
            public b f37513c;
            @Json(name = Downloads.Impl.COLUMN_CONTROL)
            public C0962a d;

            /* renamed from: com.tencent.mapsdk.internal.h4$a$a$a  reason: collision with other inner class name */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h4$a$a$a.class */
            public static final class C0962a extends g4.c.a {
            }

            /* renamed from: com.tencent.mapsdk.internal.h4$a$a$b */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h4$a$a$b.class */
            public static class b extends JsonComposer {
                @Json(name = "standard")

                /* renamed from: a  reason: collision with root package name */
                public C0964b f37514a;

                /* renamed from: com.tencent.mapsdk.internal.h4$a$a$b$a  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h4$a$a$b$a.class */
                public static final class C0963a extends g4.c.AbstractC0959c {
                    @Json(deserializer = LatLngDeserializer.class, name = BrowserContract.Bookmarks.POSITION)

                    /* renamed from: a  reason: collision with root package name */
                    public LatLng f37515a;
                    @Json(name = "rotate")
                    public List<Double> b;
                    @Json(name = BatteryManager.EXTRA_SCALE)

                    /* renamed from: c  reason: collision with root package name */
                    public double f37516c;
                    @Json(name = "autoScale")
                    public boolean d;
                    @Json(name = "pixelBound")
                    public List<Integer> e;
                    @Json(deserializer = LatLngListDeserializer.class, name = "pedestal")
                    public List<LatLng> f;
                    @Json(name = ReqAckPackage.REQ_RESPONSE_KEY.ANIMATION)
                    public g4.c.f g;
                    @Json(name = "exposure")
                    public double h;
                }

                /* renamed from: com.tencent.mapsdk.internal.h4$a$a$b$b  reason: collision with other inner class name */
                /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h4$a$a$b$b.class */
                public static class C0964b extends JsonComposer {
                    @Json(name = "defaultStyle")

                    /* renamed from: a  reason: collision with root package name */
                    public C0963a f37517a;
                }
            }

            @Override // com.tencent.mapsdk.internal.g4.c
            public boolean a() {
                return (!super.a() || this.f37513c == null || this.d == null) ? false : true;
            }
        }

        @Override // com.tencent.mapsdk.internal.g4.a
        public boolean a() {
            C0961a c0961a;
            return super.a() && a4.GLModel.b(this.f37457a) && (c0961a = this.f37512c) != null && c0961a.a();
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
            return this.b.f37512c.f37465a;
        }
        return 0;
    }
}
