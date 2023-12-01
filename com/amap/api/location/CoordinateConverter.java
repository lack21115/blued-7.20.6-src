package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.i;
import com.kwad.sdk.api.model.AdnName;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/location/CoordinateConverter.class */
public class CoordinateConverter {
    private static int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f5486c = 1;
    private static int d = 2;
    private static int e = 4;
    private static int f = 8;
    private static int g = 16;
    private static int h = 32;
    private static int i = 64;
    private Context j;
    private CoordType k = null;
    private DPoint l = null;

    /* renamed from: a  reason: collision with root package name */
    DPoint f5487a = null;

    /* renamed from: com.amap.api.location.CoordinateConverter$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/location/CoordinateConverter$1.class */
    static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5488a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:33:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:43:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:39:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:31:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:41:0x004c). Please submit an issue!!! */
        static {
            int[] iArr = new int[CoordType.values().length];
            f5488a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5488a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5488a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5488a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5488a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5488a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5488a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/location/CoordinateConverter$CoordType.class */
    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public CoordinateConverter(Context context) {
        this.j = context;
    }

    public static float calculateLineDistance(DPoint dPoint, DPoint dPoint2) {
        try {
            return i.a(dPoint, dPoint2);
        } catch (Throwable th) {
            return 0.0f;
        }
    }

    public static boolean isAMapDataAvailable(double d2, double d3) {
        return b.a(d2, d3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v102, types: [java.lang.CharSequence] */
    public DPoint convert() throws Exception {
        DPoint dPoint;
        synchronized (this) {
            if (this.k == null) {
                throw new IllegalArgumentException("转换坐标类型不能为空");
            }
            if (this.l == null) {
                throw new IllegalArgumentException("转换坐标源不能为空");
            }
            if (this.l.getLongitude() > 180.0d || this.l.getLongitude() < -180.0d) {
                throw new IllegalArgumentException("请传入合理经度");
            }
            if (this.l.getLatitude() > 90.0d || this.l.getLatitude() < -90.0d) {
                throw new IllegalArgumentException("请传入合理纬度");
            }
            boolean z = false;
            Object obj = null;
            switch (AnonymousClass1.f5488a[this.k.ordinal()]) {
                case 1:
                    this.f5487a = d.a(this.l);
                    z = false;
                    obj = null;
                    if ((b & f5486c) == 0) {
                        obj = AdnName.BAIDU;
                        b |= f5486c;
                        z = true;
                        break;
                    }
                    break;
                case 2:
                    this.f5487a = d.b(this.j, this.l);
                    z = false;
                    obj = null;
                    if ((b & d) == 0) {
                        obj = "mapbar";
                        b |= d;
                        z = true;
                        break;
                    }
                    break;
                case 3:
                    z = false;
                    obj = null;
                    if ((b & e) == 0) {
                        obj = "mapabc";
                        b |= e;
                        z = true;
                    }
                    this.f5487a = this.l;
                    break;
                case 4:
                    z = false;
                    obj = null;
                    if ((b & f) == 0) {
                        obj = "sosomap";
                        b |= f;
                        z = true;
                    }
                    this.f5487a = this.l;
                    break;
                case 5:
                    z = false;
                    obj = null;
                    if ((b & g) == 0) {
                        obj = "aliyun";
                        b |= g;
                        z = true;
                    }
                    this.f5487a = this.l;
                    break;
                case 6:
                    z = false;
                    obj = null;
                    if ((b & h) == 0) {
                        obj = "google";
                        b |= h;
                        z = true;
                    }
                    this.f5487a = this.l;
                    break;
                case 7:
                    if ((b & i) == 0) {
                        obj = "gps";
                        b |= i;
                        z = true;
                    }
                    this.f5487a = d.a(this.j, this.l);
                    break;
                default:
                    z = false;
                    obj = null;
                    break;
            }
            if (z) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(obj)) {
                    jSONObject.put("amap_loc_coordinate", obj);
                }
                g.a(this.j, "O021", jSONObject);
            }
            dPoint = this.f5487a;
        }
        return dPoint;
    }

    public CoordinateConverter coord(DPoint dPoint) throws Exception {
        synchronized (this) {
            if (dPoint == null) {
                throw new IllegalArgumentException("传入经纬度对象为空");
            }
            if (dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                throw new IllegalArgumentException("请传入合理经度");
            }
            if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d) {
                throw new IllegalArgumentException("请传入合理纬度");
            }
            this.l = dPoint;
        }
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        synchronized (this) {
            this.k = coordType;
        }
        return this;
    }
}
