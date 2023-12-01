package com.tencent.mapsdk.internal;

import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.heytap.mcssdk.constant.IntentConstant;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.json.annotation.JsonType;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngDeserializer;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngListDeserializer;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4.class */
public abstract class g4 extends JsonComposer {
    @Json(name = "info")

    /* renamed from: a  reason: collision with root package name */
    public b f37456a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a.class */
    public static class a extends JsonComposer {
        @Json(name = "layerType")

        /* renamed from: a  reason: collision with root package name */
        public String f37457a;
        @Json(name = "data")
        public C0957a b;

        /* renamed from: com.tencent.mapsdk.internal.g4$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a$a.class */
        public static class C0957a extends JsonComposer {
            @Json(name = "version")

            /* renamed from: a  reason: collision with root package name */
            public int f37458a;
            @Json(name = "default")
            public List<AbstractC0958a> b;

            @JsonType(deserializer = d4.class)
            /* renamed from: com.tencent.mapsdk.internal.g4$a$a$a  reason: collision with other inner class name */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a$a$a.class */
            public static abstract class AbstractC0958a extends JsonComposer {
                @Json(name = "type")

                /* renamed from: a  reason: collision with root package name */
                public String f37459a;
                public String b;
            }

            /* renamed from: com.tencent.mapsdk.internal.g4$a$a$b */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a$a$b.class */
            public static class b extends AbstractC0958a {
                @Json(deserializer = LatLngListDeserializer.class, name = "coordinates")

                /* renamed from: c  reason: collision with root package name */
                public List<LatLng> f37460c;
                @Json(name = "weight")
                public int d;
            }

            /* renamed from: com.tencent.mapsdk.internal.g4$a$a$c */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a$a$c.class */
            public static class c extends AbstractC0958a {
                @Json(name = "url")

                /* renamed from: c  reason: collision with root package name */
                public String f37461c;
                @Json(name = "astcUrl")
                public String d;
                @Json(name = "format")
                public String e;
                @Json(name = "name")
                public String f;
                @Json(name = "targetName")
                public String g;
                @Json(name = "id")
                public String h;
            }

            /* renamed from: com.tencent.mapsdk.internal.g4$a$a$d */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a$a$d.class */
            public static class d extends AbstractC0958a {
                @Json(deserializer = LatLngDeserializer.class, name = "coordinates")

                /* renamed from: c  reason: collision with root package name */
                public LatLng f37462c;
                @Json(name = "weight")
                public int d;
            }

            /* renamed from: com.tencent.mapsdk.internal.g4$a$a$e */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a$a$e.class */
            public static class e extends AbstractC0958a {
                @Json(deserializer = j4.class, name = "coordinates")

                /* renamed from: c  reason: collision with root package name */
                public List<WeightedLatLng> f37463c;
            }

            public boolean a() {
                List<AbstractC0958a> list = this.b;
                return list != null && list.size() > 0;
            }
        }

        public boolean a() {
            C0957a c0957a = this.b;
            return c0957a != null && c0957a.a();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$b.class */
    public static class b extends JsonComposer {
        @Json(name = "error")

        /* renamed from: a  reason: collision with root package name */
        public int f37464a;
        @Json(name = "msg")
        public String b;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c.class */
    public static abstract class c extends JsonComposer {
        @Json(name = "version")

        /* renamed from: a  reason: collision with root package name */
        public int f37465a;
        @Json(name = "mapping")
        public b b;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$a.class */
        public static abstract class a extends JsonComposer {
            @Json(name = "displayLevel")

            /* renamed from: a  reason: collision with root package name */
            public int f37466a;
            @Json(name = "zIndex")
            public int b;
            @Json(name = CallMraidJS.h)

            /* renamed from: c  reason: collision with root package name */
            public boolean f37467c;
            @Json(name = "opacity")
            public double d;
            @Json(name = "maxZoom")
            public int e;
            @Json(name = "minZoom")
            public int f;
            @Json(name = "themeName")
            public String g;

            public boolean a() {
                return true;
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$b.class */
        public static class b extends JsonComposer {
            @Json(name = IntentConstant.RULE)

            /* renamed from: a  reason: collision with root package name */
            public a f37468a;

            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$b$a.class */
            public static class a extends JsonComposer {
                @Json(name = "default")

                /* renamed from: a  reason: collision with root package name */
                public String f37469a;
            }
        }

        /* renamed from: com.tencent.mapsdk.internal.g4$c$c  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$c.class */
        public static abstract class AbstractC0959c extends JsonComposer {
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$d.class */
        public static class d extends JsonComposer {
            @Json(name = "duration")

            /* renamed from: a  reason: collision with root package name */
            public double f37470a;

            public boolean a() {
                return this.f37470a >= 0.0d;
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$e.class */
        public static class e extends JsonComposer {
            @Json(name = "points")

            /* renamed from: a  reason: collision with root package name */
            public List<Double> f37471a;
            @Json(name = "colors")
            public List<Integer> b;

            public boolean a() {
                List<Integer> list;
                List<Double> list2 = this.f37471a;
                return list2 != null && list2.size() > 0 && (list = this.b) != null && list.size() > 0;
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$f.class */
        public static class f extends JsonComposer {
            @Json(name = "type")

            /* renamed from: a  reason: collision with root package name */
            public int f37472a;

            public boolean a() {
                return true;
            }
        }

        public boolean a() {
            return true;
        }
    }

    public boolean a() {
        b bVar = this.f37456a;
        return bVar != null && bVar.f37464a == 0;
    }

    public abstract int b();

    public abstract int c();
}
