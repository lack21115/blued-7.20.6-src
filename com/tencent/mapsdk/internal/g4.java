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
    public b f23765a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a.class */
    public static class a extends JsonComposer {
        @Json(name = "layerType")

        /* renamed from: a  reason: collision with root package name */
        public String f23766a;
        @Json(name = "data")
        public C0787a b;

        /* renamed from: com.tencent.mapsdk.internal.g4$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a$a.class */
        public static class C0787a extends JsonComposer {
            @Json(name = "version")

            /* renamed from: a  reason: collision with root package name */
            public int f23767a;
            @Json(name = "default")
            public List<AbstractC0788a> b;

            @JsonType(deserializer = d4.class)
            /* renamed from: com.tencent.mapsdk.internal.g4$a$a$a  reason: collision with other inner class name */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a$a$a.class */
            public static abstract class AbstractC0788a extends JsonComposer {
                @Json(name = "type")

                /* renamed from: a  reason: collision with root package name */
                public String f23768a;
                public String b;
            }

            /* renamed from: com.tencent.mapsdk.internal.g4$a$a$b */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a$a$b.class */
            public static class b extends AbstractC0788a {
                @Json(deserializer = LatLngListDeserializer.class, name = "coordinates")

                /* renamed from: c  reason: collision with root package name */
                public List<LatLng> f23769c;
                @Json(name = "weight")
                public int d;
            }

            /* renamed from: com.tencent.mapsdk.internal.g4$a$a$c */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a$a$c.class */
            public static class c extends AbstractC0788a {
                @Json(name = "url")

                /* renamed from: c  reason: collision with root package name */
                public String f23770c;
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
            public static class d extends AbstractC0788a {
                @Json(deserializer = LatLngDeserializer.class, name = "coordinates")

                /* renamed from: c  reason: collision with root package name */
                public LatLng f23771c;
                @Json(name = "weight")
                public int d;
            }

            /* renamed from: com.tencent.mapsdk.internal.g4$a$a$e */
            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$a$a$e.class */
            public static class e extends AbstractC0788a {
                @Json(deserializer = j4.class, name = "coordinates")

                /* renamed from: c  reason: collision with root package name */
                public List<WeightedLatLng> f23772c;
            }

            public boolean a() {
                List<AbstractC0788a> list = this.b;
                return list != null && list.size() > 0;
            }
        }

        public boolean a() {
            C0787a c0787a = this.b;
            return c0787a != null && c0787a.a();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$b.class */
    public static class b extends JsonComposer {
        @Json(name = "error")

        /* renamed from: a  reason: collision with root package name */
        public int f23773a;
        @Json(name = "msg")
        public String b;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c.class */
    public static abstract class c extends JsonComposer {
        @Json(name = "version")

        /* renamed from: a  reason: collision with root package name */
        public int f23774a;
        @Json(name = "mapping")
        public b b;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$a.class */
        public static abstract class a extends JsonComposer {
            @Json(name = "displayLevel")

            /* renamed from: a  reason: collision with root package name */
            public int f23775a;
            @Json(name = "zIndex")
            public int b;
            @Json(name = CallMraidJS.h)

            /* renamed from: c  reason: collision with root package name */
            public boolean f23776c;
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
            public a f23777a;

            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$b$a.class */
            public static class a extends JsonComposer {
                @Json(name = "default")

                /* renamed from: a  reason: collision with root package name */
                public String f23778a;
            }
        }

        /* renamed from: com.tencent.mapsdk.internal.g4$c$c  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$c.class */
        public static abstract class AbstractC0789c extends JsonComposer {
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$d.class */
        public static class d extends JsonComposer {
            @Json(name = "duration")

            /* renamed from: a  reason: collision with root package name */
            public double f23779a;

            public boolean a() {
                return this.f23779a >= 0.0d;
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$e.class */
        public static class e extends JsonComposer {
            @Json(name = "points")

            /* renamed from: a  reason: collision with root package name */
            public List<Double> f23780a;
            @Json(name = "colors")
            public List<Integer> b;

            public boolean a() {
                List<Integer> list;
                List<Double> list2 = this.f23780a;
                return list2 != null && list2.size() > 0 && (list = this.b) != null && list.size() > 0;
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g4$c$f.class */
        public static class f extends JsonComposer {
            @Json(name = "type")

            /* renamed from: a  reason: collision with root package name */
            public int f23781a;

            public boolean a() {
                return true;
            }
        }

        public boolean a() {
            return true;
        }
    }

    public boolean a() {
        b bVar = this.f23765a;
        return bVar != null && bVar.f23773a == 0;
    }

    public abstract int b();

    public abstract int c();
}
