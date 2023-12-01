package com.tencent.mapsdk.internal;

import android.os.BatteryManager;
import android.text.TextUtils;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngDeserializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/jf.class */
public final class jf extends JsonComposer {
    @Json(name = "detail")

    /* renamed from: a  reason: collision with root package name */
    public d f37568a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/jf$a.class */
    public static final class a extends JsonComposer {
        @Json(name = "aoi_latitude")

        /* renamed from: a  reason: collision with root package name */
        public String f37569a;
        @Json(name = "aoi_longitude")
        public String b;
        @Json(name = "area")

        /* renamed from: c  reason: collision with root package name */
        public b f37570c;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("PoiArea{");
            stringBuffer.append("latitude=");
            stringBuffer.append(this.f37569a);
            stringBuffer.append(", longitude=");
            stringBuffer.append(this.b);
            stringBuffer.append(", area=");
            stringBuffer.append(this.f37570c);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/jf$b.class */
    public static final class b extends JsonComposer implements JsonParser.Deserializer<List<List<LatLng>>> {
        @Json(name = "type")

        /* renamed from: a  reason: collision with root package name */
        public String f37571a;
        @Json(deserializer = b.class, name = "coordinates")
        public List<List<LatLng>> b;

        @Override // com.tencent.map.tools.json.JsonParser.Deserializer
        /* renamed from: a */
        public List<List<LatLng>> deserialize(Object obj, String str, Object obj2) throws JSONException {
            ArrayList arrayList = null;
            if (obj2 == null) {
                return null;
            }
            if (obj2 instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj2;
                ArrayList arrayList2 = new ArrayList();
                int length = jSONArray.length();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    Object obj3 = jSONArray.get(i2);
                    ArrayList arrayList3 = new ArrayList();
                    if (obj3 instanceof JSONArray) {
                        JSONArray jSONArray2 = (JSONArray) obj3;
                        int length2 = jSONArray2.length();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= length2) {
                                break;
                            }
                            Object obj4 = jSONArray2.get(i4);
                            if (obj4 instanceof JSONArray) {
                                JSONArray jSONArray3 = (JSONArray) obj4;
                                if (jSONArray3.length() == 2) {
                                    arrayList3.add(new LatLng(jSONArray3.optDouble(1), jSONArray3.optDouble(0)));
                                }
                            }
                            i3 = i4 + 1;
                        }
                        if (arrayList3.size() != length2) {
                            na.b("coordinates's data deserialize error!!");
                        }
                    }
                    arrayList2.add(arrayList3);
                    i = i2 + 1;
                }
                arrayList = arrayList2;
                if (arrayList2.size() != length) {
                    na.b("coordinates's area deserialize error!!");
                    arrayList = arrayList2;
                }
            }
            return arrayList;
        }

        public String toString() {
            int[] iArr;
            int i;
            List<List<LatLng>> list = this.b;
            if (list != null) {
                int size = list.size();
                iArr = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr[i2] = this.b.get(i2).size();
                }
                i = size;
            } else {
                iArr = null;
                i = 0;
            }
            StringBuffer stringBuffer = new StringBuffer("AreaData{");
            stringBuffer.append("type='");
            stringBuffer.append(this.f37571a);
            stringBuffer.append('\'');
            stringBuffer.append(", coordinates=");
            stringBuffer.append(i);
            stringBuffer.append("#");
            stringBuffer.append(Arrays.toString(iArr));
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/jf$c.class */
    public static class c extends JsonComposer {
        @Json(name = "fill_color")

        /* renamed from: a  reason: collision with root package name */
        public String f37572a;
        @Json(name = "stroke_color")
        public String b;
        @Json(name = "stroke_width")

        /* renamed from: c  reason: collision with root package name */
        public int f37573c;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("AoiStyle{");
            stringBuffer.append("fillColor='");
            stringBuffer.append(this.f37572a);
            stringBuffer.append('\'');
            stringBuffer.append(", strokeColor='");
            stringBuffer.append(this.b);
            stringBuffer.append('\'');
            stringBuffer.append(", strokeWidth=");
            stringBuffer.append(this.f37573c);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/jf$d.class */
    public static class d extends JsonComposer {
        @Json(ignore = true)

        /* renamed from: a  reason: collision with root package name */
        public int f37574a = -1;
        @Json(name = "uid")
        public String b;
        @Json(name = "name")

        /* renamed from: c  reason: collision with root package name */
        public String f37575c;
        @Json(name = "alias")
        public String d;
        @Json(name = "type")
        public String e;
        @Json(name = "styles")
        public List<e> f;
        @Json(name = "shinei_id")
        public String g;
        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng h;
        @Json(name = "aoi_info")
        public a i;
        @Json(name = "sub_pois")
        public List<d> j;

        public String a() {
            return !TextUtils.isEmpty(this.d) ? this.d : this.f37575c;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("PoiDetail{");
            stringBuffer.append("displayId=");
            stringBuffer.append(this.f37574a);
            stringBuffer.append(", poiId='");
            stringBuffer.append(this.b);
            stringBuffer.append('\'');
            stringBuffer.append(", name='");
            stringBuffer.append(this.f37575c);
            stringBuffer.append('\'');
            stringBuffer.append(", alias='");
            stringBuffer.append(this.d);
            stringBuffer.append('\'');
            stringBuffer.append(", type='");
            stringBuffer.append(this.e);
            stringBuffer.append('\'');
            stringBuffer.append(", poiStyles=");
            stringBuffer.append(this.f);
            stringBuffer.append(", indoorId='");
            stringBuffer.append(this.g);
            stringBuffer.append('\'');
            stringBuffer.append(", point=");
            stringBuffer.append(this.h);
            stringBuffer.append(", poiArea=");
            stringBuffer.append(this.i);
            stringBuffer.append(", subPois=");
            stringBuffer.append(this.j);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/jf$e.class */
    public static class e extends JsonComposer {
        @Json(ignore = true)

        /* renamed from: a  reason: collision with root package name */
        public BitmapDescriptor f37576a;
        @Json(ignore = true)
        public BitmapDescriptor b;
        @Json(name = "style_class")

        /* renamed from: c  reason: collision with root package name */
        public int f37577c;
        @Json(name = "icon_url")
        public String d;
        @Json(name = com.anythink.expressad.d.a.b.cf)
        public int e;
        @Json(name = "font_color")
        public String f;
        @Json(name = "font_size")
        public int g;
        @Json(name = "font_stroke_color")
        public String h;
        @Json(name = "font_stroke_width")
        public int i;
        @Json(name = BatteryManager.EXTRA_LEVEL)
        public int j;
        @Json(name = "zindex")
        public int k;
        @Json(name = "aoi")
        public c l;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("PoiStyle{");
            stringBuffer.append("icon=");
            stringBuffer.append(this.f37576a);
            stringBuffer.append(", type=");
            stringBuffer.append(this.f37577c);
            stringBuffer.append(", iconUrl='");
            stringBuffer.append(this.d);
            stringBuffer.append('\'');
            stringBuffer.append(", iconDisplayType=");
            stringBuffer.append(this.e);
            stringBuffer.append(", fontColor='");
            stringBuffer.append(this.f);
            stringBuffer.append('\'');
            stringBuffer.append(", fontSize=");
            stringBuffer.append(this.g);
            stringBuffer.append(", fontStrokeColor='");
            stringBuffer.append(this.h);
            stringBuffer.append('\'');
            stringBuffer.append(", fontStrokeWidth=");
            stringBuffer.append(this.i);
            stringBuffer.append(", level=");
            stringBuffer.append(this.j);
            stringBuffer.append(", zindex=");
            stringBuffer.append(this.k);
            stringBuffer.append(", aoiStyle=");
            stringBuffer.append(this.l);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AoiInfo{");
        stringBuffer.append("poiDetail=");
        stringBuffer.append(this.f37568a);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
