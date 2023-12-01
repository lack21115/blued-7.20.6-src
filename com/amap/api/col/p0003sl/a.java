package com.amap.api.col.p0003sl;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.android.ims.ImsReasonInfo;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.a  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/a.class */
public final class a {
    private static boolean A = false;
    Context b;
    g a = null;
    PendingIntent c = null;
    String d = null;
    GeoFenceListener e = null;
    private Object z = new Object();
    volatile int f = 1;
    ArrayList<GeoFence> g = new ArrayList<>();
    c h = null;
    Object i = new Object();
    Object j = new Object();
    HandlerC0012a k = null;
    b l = null;
    volatile boolean m = false;
    volatile boolean n = false;
    volatile boolean o = false;
    com.amap.api.col.p0003sl.b p = null;
    com.amap.api.col.p0003sl.c q = null;
    AMapLocationClient r = null;
    volatile AMapLocation s = null;
    long t = 0;
    AMapLocationClientOption u = null;
    int v = 0;
    AMapLocationListener w = new AMapLocationListener() { // from class: com.amap.api.col.3sl.a.1
        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            boolean z;
            int i;
            try {
                if (!a.this.y && a.this.o) {
                    a.this.s = aMapLocation;
                    if (aMapLocation != null) {
                        i = aMapLocation.getErrorCode();
                        if (aMapLocation.getErrorCode() == 0) {
                            a.this.t = i.b();
                            a.this.a(5, (Bundle) null, 0L);
                            z = true;
                        } else {
                            a.a("定位失败", aMapLocation.getErrorCode(), aMapLocation.getErrorInfo(), "locationDetail:" + aMapLocation.getLocationDetail());
                            z = false;
                        }
                    } else {
                        z = false;
                        i = 8;
                    }
                    if (z) {
                        a.this.v = 0;
                        a.this.a(6, (Bundle) null, 0L);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (!a.this.m) {
                        a.this.b(7);
                        bundle.putLong("interval", 2000L);
                        a.this.a(8, bundle, 2000L);
                    }
                    a.this.v++;
                    if (a.this.v >= 3) {
                        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i);
                        a.this.a(1002, bundle);
                    }
                }
            } catch (Throwable th) {
            }
        }
    };
    final int x = 3;
    volatile boolean y = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/a$a.class */
    public final class HandlerC0012a extends Handler {
        public HandlerC0012a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.this.b(message.getData());
                        return;
                    case 1:
                        a.this.c(message.getData());
                        return;
                    case 2:
                        a.this.e(message.getData());
                        return;
                    case 3:
                        a.this.d(message.getData());
                        return;
                    case 4:
                        a.this.f(message.getData());
                        return;
                    case 5:
                        a.this.e();
                        return;
                    case 6:
                        a.this.a(a.this.s);
                        return;
                    case 7:
                        a.this.d();
                        return;
                    case 8:
                        a.this.j(message.getData());
                        return;
                    case 9:
                        a.this.a(message.getData());
                        return;
                    case 10:
                        a.this.c();
                        return;
                    case 11:
                        a.this.h(message.getData());
                        return;
                    case 12:
                        a.this.g(message.getData());
                        return;
                    case 13:
                        a.this.g();
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.a$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/a$b.class */
    public static final class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.a$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/a$c.class */
    public final class c extends Handler {
        public c() {
        }

        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        a.this.i(data);
                        return;
                    case 1001:
                        a.this.b((GeoFence) data.getParcelable("geoFence"));
                        return;
                    case 1002:
                        a.this.c(data.getInt(GeoFence.BUNDLE_KEY_LOCERRORCODE));
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
            }
        }
    }

    public a(Context context) {
        this.b = null;
        try {
            this.b = context.getApplicationContext();
            j();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManger", "<init>");
        }
    }

    private static float a(AMapLocation aMapLocation, List<GeoFence> list) {
        float f = Float.MAX_VALUE;
        float f2 = Float.MAX_VALUE;
        if (aMapLocation != null) {
            f2 = Float.MAX_VALUE;
            if (aMapLocation.getErrorCode() == 0) {
                f2 = Float.MAX_VALUE;
                if (list != null) {
                    f2 = Float.MAX_VALUE;
                    if (!list.isEmpty()) {
                        DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                        Iterator<GeoFence> it = list.iterator();
                        while (true) {
                            f2 = f;
                            if (!it.hasNext()) {
                                break;
                            }
                            GeoFence next = it.next();
                            if (next.isAble()) {
                                float a = i.a(dPoint, next.getCenter());
                                if (a > next.getMinDis2Center() && a < next.getMaxDis2Center()) {
                                    return 0.0f;
                                }
                                float f3 = f;
                                if (a > next.getMaxDis2Center()) {
                                    f3 = Math.min(f, a - next.getMaxDis2Center());
                                }
                                f = f3;
                                if (a < next.getMinDis2Center()) {
                                    f = Math.min(f3, next.getMinDis2Center() - a);
                                }
                            }
                        }
                    }
                }
            }
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(DPoint dPoint, List<DPoint> list) {
        float f = Float.MAX_VALUE;
        float f2 = Float.MAX_VALUE;
        if (dPoint != null) {
            f2 = Float.MAX_VALUE;
            if (list != null) {
                f2 = Float.MAX_VALUE;
                if (!list.isEmpty()) {
                    Iterator<DPoint> it = list.iterator();
                    while (true) {
                        f2 = f;
                        if (!it.hasNext()) {
                            break;
                        }
                        f = Math.min(f, i.a(dPoint, it.next()));
                    }
                }
            }
        }
        return f2;
    }

    private int a(List<GeoFence> list) {
        try {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            for (GeoFence geoFence : list) {
                c(geoFence);
            }
            return 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addGeoFenceList");
            a("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static Bundle a(GeoFence geoFence, String str, String str2, int i, int i2) {
        Bundle bundle = new Bundle();
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        bundle.putString(GeoFence.BUNDLE_KEY_FENCEID, str3);
        bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
        bundle.putInt(GeoFence.BUNDLE_KEY_FENCESTATUS, i);
        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i2);
        bundle.putParcelable(GeoFence.BUNDLE_KEY_FENCE, geoFence);
        return bundle;
    }

    private GeoFence a(Bundle bundle, boolean z) {
        GeoFence geoFence = new GeoFence();
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = new DPoint();
        if (z) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = b(arrayList);
            }
            geoFence.setMaxDis2Center(b(dPoint, arrayList));
            geoFence.setMinDis2Center(a(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f = 1000.0f;
            float f2 = bundle.getFloat("fenceRadius", 1000.0f);
            if (f2 > 0.0f) {
                f = f2;
            }
            geoFence.setRadius(f);
            geoFence.setMinDis2Center(f);
            geoFence.setMaxDis2Center(f);
        }
        geoFence.setActivatesAction(this.f);
        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.d);
        geoFence.setExpiration(-1L);
        geoFence.setPendingIntent(this.c);
        StringBuilder sb = new StringBuilder();
        sb.append(com.amap.api.col.p0003sl.c.a());
        geoFence.setFenceId(sb.toString());
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(this.b, 2);
        }
        return geoFence;
    }

    static void a(String str, int i, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append("\n");
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:".concat(String.valueOf(i)));
        stringBuffer.append("\n");
        stringBuffer.append("错误信息:".concat(String.valueOf(str2)));
        stringBuffer.append("\n");
        if (strArr.length > 0) {
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                stringBuffer.append(strArr[i3]);
                stringBuffer.append("\n");
                i2 = i3 + 1;
            }
        }
        stringBuffer.append("===========================================\n");
        Log.i("fenceErrLog", stringBuffer.toString());
    }

    private static boolean a(int i, String str, String str2, DPoint dPoint) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i == 1) {
            return !TextUtils.isEmpty(str2);
        } else if (i != 2) {
            return true;
        } else {
            if (dPoint == null) {
                return false;
            }
            if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                a("添加围栏失败", 0, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                return false;
            }
            return true;
        }
    }

    private static boolean a(GeoFence geoFence, int i) {
        boolean z = false;
        boolean z2 = false;
        if ((i & 1) == 1) {
            z2 = false;
            try {
                if (geoFence.getStatus() == 1) {
                    z2 = true;
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Utils", "remindStatus");
                return z;
            }
        }
        boolean z3 = z2;
        if ((i & 2) == 2) {
            z3 = z2;
            if (geoFence.getStatus() == 2) {
                z3 = true;
            }
        }
        if ((i & 4) == 4) {
            z = z3;
            if (geoFence.getStatus() == 3) {
                z3 = true;
            }
        }
        return z3;
    }

    private static boolean a(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z = false;
        try {
            if (!i.a(aMapLocation) || geoFence == null || geoFence.getPointList() == null || geoFence.getPointList().isEmpty()) {
                return false;
            }
            int type = geoFence.getType();
            if (type != 0) {
                if (type != 1) {
                    if (type != 2) {
                        if (type != 3) {
                            return false;
                        }
                    }
                }
                for (List<DPoint> list : geoFence.getPointList()) {
                    try {
                        if (b(aMapLocation, list)) {
                            z = true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.autonavi.aps.amapapi.utils.b.a(th, "Utils", "isInGeoFence");
                        return z;
                    }
                }
                return z;
            }
            return a(aMapLocation, geoFence.getCenter(), geoFence.getRadius());
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    private static boolean a(AMapLocation aMapLocation, DPoint dPoint, float f) {
        boolean z = false;
        if (i.a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= f) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(DPoint dPoint, List<DPoint> list) {
        float f = Float.MIN_VALUE;
        float f2 = Float.MIN_VALUE;
        if (dPoint != null) {
            f2 = Float.MIN_VALUE;
            if (list != null) {
                f2 = Float.MIN_VALUE;
                if (!list.isEmpty()) {
                    Iterator<DPoint> it = list.iterator();
                    while (true) {
                        f2 = f;
                        if (!it.hasNext()) {
                            break;
                        }
                        f = Math.max(f, i.a(dPoint, it.next()));
                    }
                }
            }
        }
        return f2;
    }

    private static DPoint b(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list != null) {
            try {
                double d = 0.0d;
                double d2 = 0.0d;
                for (DPoint dPoint2 : list) {
                    d += dPoint2.getLatitude();
                    d2 += dPoint2.getLongitude();
                }
                return new DPoint(i.b(d / list.size()), i.b(d2 / list.size()));
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceUtil", "getPolygonCenter");
            }
        }
        return dPoint;
    }

    private void b(int i, Bundle bundle) {
        String str;
        int i2;
        String str2;
        int i3;
        String a;
        Bundle bundle2 = new Bundle();
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (bundle == null || bundle.isEmpty()) {
                str2 = MyLocationStyle.ERROR_CODE;
                i3 = 1;
            } else {
                List<GeoFence> arrayList2 = new ArrayList<>();
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String string2 = bundle.getString("keyWords");
                String string3 = bundle.getString(DistrictSearchQuery.KEYWORDS_CITY);
                String string4 = bundle.getString("poiType");
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                int i4 = bundle.getInt("searchSize", 10);
                float f = bundle.getFloat("aroundRadius", 3000.0f);
                if (a(i, string2, string4, dPoint)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                    bundle3.putString("pendingIntentAction", this.d);
                    try {
                        bundle3.putLong("expiration", -1L);
                        bundle3.putInt("activatesAction", this.f);
                        if (i == 1) {
                            bundle3.putFloat("fenceRadius", 1000.0f);
                            a = this.p.a(this.b, "http://restsdk.amap.com/v3/place/text?", string2, string4, string3, String.valueOf(i4));
                        } else if (i != 2) {
                            a = i != 3 ? null : this.p.a(this.b, "http://restsdk.amap.com/v3/config/district?", string2);
                        } else {
                            double b2 = i.b(dPoint.getLatitude());
                            double b3 = i.b(dPoint.getLongitude());
                            int intValue = Float.valueOf(f).intValue();
                            bundle3.putFloat("fenceRadius", 200.0f);
                            a = this.p.a(this.b, "http://restsdk.amap.com/v3/place/around?", string2, string4, String.valueOf(i4), String.valueOf(b2), String.valueOf(b3), String.valueOf(intValue));
                        }
                        if (a != null) {
                            int a2 = 1 == i ? com.amap.api.col.p0003sl.c.a(a, arrayList2, bundle3) : 0;
                            if (2 == i) {
                                a2 = com.amap.api.col.p0003sl.c.b(a, arrayList2, bundle3);
                            }
                            if (3 == i) {
                                a2 = this.q.c(a, arrayList2, bundle3);
                            }
                            if (a2 != 10000) {
                                i3 = d(a2);
                            } else if (arrayList2.isEmpty()) {
                                i3 = 16;
                            } else {
                                int a3 = a(arrayList2);
                                i3 = a3;
                                if (a3 == 0) {
                                    i2 = a3;
                                    try {
                                        arrayList.addAll(arrayList2);
                                        i3 = a3;
                                    } catch (Throwable th) {
                                        th = th;
                                        str = MyLocationStyle.ERROR_CODE;
                                        try {
                                            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                            bundle2.putInt(str, 8);
                                            a(1000, bundle2);
                                            return;
                                        } finally {
                                            bundle2.putInt(str, i2);
                                            a(1000, bundle2);
                                        }
                                    }
                                }
                            }
                        } else {
                            i3 = 4;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str = MyLocationStyle.ERROR_CODE;
                        i2 = 0;
                        com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                        bundle2.putInt(str, 8);
                        a(1000, bundle2);
                        return;
                    }
                } else {
                    i3 = 1;
                }
                bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                i2 = i3;
                bundle2.putParcelableArrayList("resultList", arrayList);
                str2 = MyLocationStyle.ERROR_CODE;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static boolean b(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z = true;
        try {
            if (!a(aMapLocation, geoFence)) {
                if (geoFence.getStatus() != 2) {
                    try {
                        geoFence.setStatus(2);
                        geoFence.setEnterTime(-1L);
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        com.autonavi.aps.amapapi.utils.b.a(th, "Utils", "isFenceStatusChanged");
                        return z;
                    }
                }
                return false;
            } else if (geoFence.getEnterTime() == -1) {
                if (geoFence.getStatus() != 1) {
                    geoFence.setEnterTime(i.b());
                    geoFence.setStatus(1);
                    return true;
                }
                return false;
            } else if (geoFence.getStatus() == 3 || i.b() - geoFence.getEnterTime() <= 600000) {
                return false;
            } else {
                geoFence.setStatus(3);
                return true;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    private static boolean b(AMapLocation aMapLocation, List<DPoint> list) {
        if (list.size() < 3) {
            return false;
        }
        return com.autonavi.aps.amapapi.utils.b.a(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list);
    }

    private int c(GeoFence geoFence) {
        try {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            if (this.g.contains(geoFence)) {
                return 17;
            }
            this.g.add(geoFence);
            return 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addGeoFence2List");
            a("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static int d(int i) {
        int i2 = i;
        if (i != 1) {
            i2 = i;
            if (i != 7) {
                i2 = i;
                if (i != 4) {
                    i2 = i;
                    if (i != 5) {
                        i2 = i;
                        if (i != 16) {
                            i2 = i;
                            if (i != 17) {
                                switch (i) {
                                    case 10000:
                                        i2 = 0;
                                        break;
                                    case 10001:
                                    case 10002:
                                    case 10007:
                                    case 10008:
                                    case 10009:
                                    case 10012:
                                    case 10013:
                                        i2 = 7;
                                        break;
                                    case 10003:
                                    case ImsReasonInfo.CODE_CALL_DROP_IWLAN_TO_LTE_UNAVAILABLE /* 10004 */:
                                    case 10005:
                                    case 10006:
                                    case 10010:
                                    case 10011:
                                    case 10014:
                                    case 10015:
                                    case 10016:
                                    case 10017:
                                        i2 = 4;
                                        break;
                                    default:
                                        switch (i) {
                                            case Window.PROGRESS_SECONDARY_START /* 20000 */:
                                            case 20001:
                                            case 20002:
                                                i2 = 1;
                                                break;
                                            case 20003:
                                            default:
                                                i2 = 8;
                                                break;
                                        }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (i2 != 0) {
            a("添加围栏失败", i2, "searchErrCode is ".concat(String.valueOf(i2)), new String[0]);
        }
        return i2;
    }

    private void d(GeoFence geoFence) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("geoFence", geoFence);
        a(1001, bundle);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0040 -> B:38:0x0049). Please submit an issue!!! */
    private void j() {
        if (!this.o) {
            this.o = true;
        }
        if (this.n) {
            return;
        }
        try {
            if (Looper.myLooper() == null) {
                this.h = new c(this.b.getMainLooper());
            } else {
                this.h = new c();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManger", "init 1");
        }
        try {
            b bVar = new b("fenceActionThread");
            this.l = bVar;
            bVar.setPriority(5);
            this.l.start();
            this.k = new HandlerC0012a(this.l.getLooper());
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "GeoFenceManger", "init 2");
        }
        try {
            this.p = new com.amap.api.col.p0003sl.b(this.b);
            this.q = new com.amap.api.col.p0003sl.c();
            this.u = new AMapLocationClientOption();
            this.r = new AMapLocationClient(this.b);
            this.u.setLocationCacheEnable(true);
            this.u.setNeedAddress(false);
            this.r.setLocationListener(this.w);
            if (this.a == null) {
                this.a = new g();
            }
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "GeoFenceManger", "initBase");
        }
        this.n = true;
        try {
            if (this.d != null && this.c == null) {
                a(this.d);
            }
        } catch (Throwable th4) {
            com.autonavi.aps.amapapi.utils.b.a(th4, "GeoFenceManger", "init 4");
        }
        if (A) {
            return;
        }
        A = true;
        g.a(this.b, "O020", (JSONObject) null);
    }

    private boolean k() {
        ArrayList<GeoFence> arrayList = this.g;
        boolean z = true;
        if (arrayList != null) {
            if (!arrayList.isEmpty()) {
                Iterator<GeoFence> it = this.g.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().isAble()) {
                        z = false;
                        break;
                    }
                }
            } else {
                return true;
            }
        }
        return z;
    }

    private void l() {
        try {
            synchronized (this.j) {
                if (this.h != null) {
                    this.h.removeCallbacksAndMessages(null);
                }
                this.h = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "destroyResultHandler");
        }
    }

    private void m() {
        try {
            synchronized (this.i) {
                if (this.k != null) {
                    this.k.removeCallbacksAndMessages(null);
                }
                this.k = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "destroyActionHandler");
        }
    }

    private void n() {
        if (this.y || this.k == null) {
            return;
        }
        if (p()) {
            a(6, (Bundle) null, 0L);
            a(5, (Bundle) null, 0L);
            return;
        }
        b(7);
        a(7, (Bundle) null, 0L);
    }

    private void o() {
        try {
            if (this.m) {
                b(8);
            }
            if (this.r != null) {
                this.r.stopLocation();
            }
            this.m = false;
        } catch (Throwable th) {
        }
    }

    private boolean p() {
        return this.s != null && i.a(this.s) && i.b() - this.t < 10000;
    }

    public final PendingIntent a(String str) {
        synchronized (this.z) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(ho.c(this.b));
                if (Build.VERSION.SDK_INT < 31 || this.b.getApplicationInfo().targetSdkVersion < 31) {
                    this.c = PendingIntent.getBroadcast(this.b, 0, intent, 0);
                } else {
                    this.c = PendingIntent.getBroadcast(this.b, 0, intent, 33554432);
                }
                this.d = str;
                if (this.g != null && !this.g.isEmpty()) {
                    Iterator<GeoFence> it = this.g.iterator();
                    while (it.hasNext()) {
                        GeoFence next = it.next();
                        next.setPendingIntent(this.c);
                        next.setPendingIntentAction(this.d);
                    }
                }
            }
        }
        return this.c;
    }

    public final void a() {
        try {
            this.o = false;
            a(10, (Bundle) null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
        if (r7 <= 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r7) {
        /*
            r6 = this;
            r0 = r6
            r0.j()     // Catch: java.lang.Throwable -> L2c
            r0 = r7
            r1 = 7
            if (r0 > r1) goto L37
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 > 0) goto L13
            goto L37
        L13:
            android.os.Bundle r0 = new android.os.Bundle     // Catch: java.lang.Throwable -> L2c
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L2c
            r9 = r0
            r0 = r9
            java.lang.String r1 = "activatesAction"
            r2 = r8
            r0.putInt(r1, r2)     // Catch: java.lang.Throwable -> L2c
            r0 = r6
            r1 = 9
            r2 = r9
            r3 = 0
            r0.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L2c
            return
        L2c:
            r9 = move-exception
            r0 = r9
            java.lang.String r1 = "GeoFenceManager"
            java.lang.String r2 = "setActivateAction"
            com.autonavi.aps.amapapi.utils.b.a(r0, r1, r2)
            return
        L37:
            r0 = 1
            r8 = r0
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.a.a(int):void");
    }

    final void a(int i, Bundle bundle) {
        try {
            synchronized (this.j) {
                if (this.h != null) {
                    Message obtainMessage = this.h.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.setData(bundle);
                    this.h.sendMessage(obtainMessage);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    final void a(int i, Bundle bundle, long j) {
        try {
            synchronized (this.i) {
                if (this.k != null) {
                    Message obtainMessage = this.k.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.setData(bundle);
                    this.k.sendMessageDelayed(obtainMessage, j);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    final void a(Bundle bundle) {
        int i = 1;
        if (bundle != null) {
            try {
                i = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.f != i) {
            if (this.g != null && !this.g.isEmpty()) {
                Iterator<GeoFence> it = this.g.iterator();
                while (it.hasNext()) {
                    GeoFence next = it.next();
                    next.setStatus(0);
                    next.setEnterTime(-1L);
                }
            }
            n();
        }
        this.f = i;
    }

    public final void a(GeoFenceListener geoFenceListener) {
        try {
            this.e = geoFenceListener;
        } catch (Throwable th) {
        }
    }

    final void a(AMapLocation aMapLocation) {
        try {
            if (this.y || this.g == null || this.g.isEmpty() || aMapLocation == null || aMapLocation.getErrorCode() != 0) {
                return;
            }
            Iterator<GeoFence> it = this.g.iterator();
            while (it.hasNext()) {
                GeoFence next = it.next();
                if (next.isAble() && b(aMapLocation, next) && a(next, this.f)) {
                    next.setCurrentLocation(aMapLocation);
                    d(next);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doCheckFence");
        }
    }

    public final void a(DPoint dPoint, float f, String str) {
        try {
            j();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(0, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    public final void a(String str, String str2) {
        try {
            j();
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
            a(4, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r10 > 50000.0f) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r7, java.lang.String r8, com.amap.api.location.DPoint r9, float r10, int r11, java.lang.String r12) {
        /*
            r6 = this;
            r0 = r6
            r0.j()     // Catch: java.lang.Throwable -> L65
            r0 = r10
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L70
            r0 = r10
            r13 = r0
            r0 = r10
            r1 = 1195593728(0x47435000, float:50000.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L75
            goto L70
        L1b:
            android.os.Bundle r0 = new android.os.Bundle     // Catch: java.lang.Throwable -> L65
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L65
            r15 = r0
            r0 = r15
            java.lang.String r1 = "keyWords"
            r2 = r7
            r0.putString(r1, r2)     // Catch: java.lang.Throwable -> L65
            r0 = r15
            java.lang.String r1 = "poiType"
            r2 = r8
            r0.putString(r1, r2)     // Catch: java.lang.Throwable -> L65
            r0 = r15
            java.lang.String r1 = "centerPoint"
            r2 = r9
            r0.putParcelable(r1, r2)     // Catch: java.lang.Throwable -> L65
            r0 = r15
            java.lang.String r1 = "aroundRadius"
            r2 = r13
            r0.putFloat(r1, r2)     // Catch: java.lang.Throwable -> L65
            r0 = r15
            java.lang.String r1 = "searchSize"
            r2 = r11
            r0.putInt(r1, r2)     // Catch: java.lang.Throwable -> L65
            r0 = r15
            java.lang.String r1 = "customId"
            r2 = r12
            r0.putString(r1, r2)     // Catch: java.lang.Throwable -> L65
            r0 = r6
            r1 = 3
            r2 = r15
            r3 = 0
            r0.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L65
            return
        L65:
            r7 = move-exception
            r0 = r7
            java.lang.String r1 = "GeoFenceManager"
            java.lang.String r2 = "addNearbyGeoFence"
            com.autonavi.aps.amapapi.utils.b.a(r0, r1, r2)
            return
        L70:
            r0 = 1161527296(0x453b8000, float:3000.0)
            r13 = r0
        L75:
            r0 = r11
            r14 = r0
            r0 = r11
            if (r0 > 0) goto L82
            r0 = 10
            r14 = r0
        L82:
            r0 = r14
            r11 = r0
            r0 = r14
            r1 = 25
            if (r0 <= r1) goto L1b
            r0 = 25
            r11 = r0
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.a.a(java.lang.String, java.lang.String, com.amap.api.location.DPoint, float, int, java.lang.String):void");
    }

    public final void a(String str, String str2, String str3, int i, String str4) {
        try {
            j();
            int i2 = i;
            if (i <= 0) {
                i2 = 10;
            }
            int i3 = i2;
            if (i2 > 25) {
                i3 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString(DistrictSearchQuery.KEYWORDS_CITY, str3);
            bundle.putInt("searchSize", i3);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str4);
            a(2, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public final void a(String str, boolean z) {
        try {
            j();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z);
            a(12, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    public final void a(List<DPoint> list, String str) {
        try {
            j();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList<>(list));
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(1, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    public final boolean a(GeoFence geoFence) {
        try {
            if (this.g != null && !this.g.isEmpty()) {
                if (this.g.contains(geoFence)) {
                    if (this.g.size() == 1) {
                        this.o = false;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fc", geoFence);
                    a(11, bundle, 0L);
                    return true;
                }
                return false;
            }
            this.o = false;
            a(10, (Bundle) null, 0L);
            return true;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    public final List<GeoFence> b() {
        try {
            if (this.g == null) {
                this.g = new ArrayList<>();
            }
            return (ArrayList) this.g.clone();
        } catch (Throwable th) {
            return new ArrayList();
        }
    }

    final void b(int i) {
        try {
            synchronized (this.i) {
                if (this.k != null) {
                    this.k.removeMessages(i);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    final void b(Bundle bundle) {
        String str;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            int i = 1;
            String str2 = "";
            if (bundle != null) {
                str2 = "";
                if (!bundle.isEmpty()) {
                    DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                    str2 = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                    if (dPoint != null) {
                        if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d && dPoint.getLongitude() >= -180.0d) {
                            GeoFence a = a(bundle, false);
                            int c2 = c(a);
                            i = c2;
                            str = str2;
                            if (c2 == 0) {
                                arrayList.add(a);
                                i = c2;
                                str = str2;
                            }
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt(MyLocationStyle.ERROR_CODE, i);
                            bundle2.putParcelableArrayList("resultList", arrayList);
                            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                            a(1000, bundle2);
                        }
                        a("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                        str = str2;
                        Bundle bundle22 = new Bundle();
                        bundle22.putInt(MyLocationStyle.ERROR_CODE, i);
                        bundle22.putParcelableArrayList("resultList", arrayList);
                        bundle22.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                        a(1000, bundle22);
                    }
                }
            }
            str = str2;
            Bundle bundle222 = new Bundle();
            bundle222.putInt(MyLocationStyle.ERROR_CODE, i);
            bundle222.putParcelableArrayList("resultList", arrayList);
            bundle222.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(1000, bundle222);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceRound");
        }
    }

    final void b(GeoFence geoFence) {
        try {
            synchronized (this.z) {
                if (this.b != null) {
                    if (this.c == null && geoFence.getPendingIntent() == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(a(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                    if (this.d != null) {
                        intent.setAction(this.d);
                    }
                    intent.setPackage(ho.c(this.b));
                    if (geoFence.getPendingIntent() != null) {
                        geoFence.getPendingIntent().send(this.b, 0, intent);
                    } else {
                        this.c.send(this.b, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    final void c() {
        if (this.n) {
            if (this.g != null) {
                this.g.clear();
                this.g = null;
            }
            if (this.o) {
                return;
            }
            m();
            if (this.r != null) {
                this.r.stopLocation();
                this.r.onDestroy();
            }
            this.r = null;
            if (this.l != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.l.quitSafely();
                } else {
                    this.l.quit();
                }
            }
            this.l = null;
            this.p = null;
            synchronized (this.z) {
                if (this.c != null) {
                    this.c.cancel();
                }
                this.c = null;
            }
            l();
            if (this.a != null) {
                this.a.b(this.b);
            }
            this.m = false;
            this.n = false;
        }
    }

    final void c(int i) {
        try {
            if (this.b != null) {
                synchronized (this.z) {
                    if (this.c == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(a((GeoFence) null, (String) null, (String) null, 4, i));
                    this.c.send(this.b, 0, intent);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    final void c(Bundle bundle) {
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str = "";
            int i = 1;
            if (bundle != null) {
                str = "";
                i = 1;
                if (!bundle.isEmpty()) {
                    ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointList");
                    str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                    i = 1;
                    if (parcelableArrayList != null) {
                        if (parcelableArrayList.size() <= 2) {
                            i = 1;
                        } else {
                            GeoFence a = a(bundle, true);
                            int c2 = c(a);
                            i = c2;
                            if (c2 == 0) {
                                arrayList.add(a);
                                i = c2;
                            }
                        }
                    }
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle2.putInt(MyLocationStyle.ERROR_CODE, i);
            bundle2.putParcelableArrayList("resultList", arrayList);
            a(1000, bundle2);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFencePolygon");
        }
    }

    final void d() {
        try {
            if (this.r != null) {
                o();
                this.u.setOnceLocation(true);
                this.r.setLocationOption(this.u);
                this.r.startLocation();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doStartOnceLocation");
        }
    }

    final void d(Bundle bundle) {
        b(2, bundle);
    }

    final void e() {
        try {
            if (!this.y && i.a(this.s)) {
                float a = a(this.s, this.g);
                if (a == Float.MAX_VALUE) {
                    return;
                }
                if (a < 1000.0f) {
                    b(7);
                    Bundle bundle = new Bundle();
                    bundle.putLong("interval", 2000L);
                    a(8, bundle, 500L);
                } else if (a < 5000.0f) {
                    o();
                    b(7);
                    a(7, (Bundle) null, 10000L);
                } else {
                    o();
                    b(7);
                    a(7, (Bundle) null, ((a - 4000.0f) / 100.0f) * 1000.0f);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    final void e(Bundle bundle) {
        b(1, bundle);
    }

    public final void f() {
        try {
            j();
            this.y = true;
            a(13, (Bundle) null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    final void f(Bundle bundle) {
        b(3, bundle);
    }

    final void g() {
        try {
            b(7);
            b(8);
            if (this.r != null) {
                this.r.stopLocation();
            }
            this.m = false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    final void g(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                String string = bundle.getString("fid");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                boolean z = bundle.getBoolean("ab", true);
                if (this.g != null && !this.g.isEmpty()) {
                    Iterator<GeoFence> it = this.g.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        GeoFence next = it.next();
                        if (next.getFenceId().equals(string)) {
                            next.setAble(z);
                            break;
                        }
                    }
                }
                if (z) {
                    n();
                } else if (k()) {
                    g();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    public final void h() {
        try {
            j();
            if (this.y) {
                this.y = false;
                n();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    final void h(Bundle bundle) {
        try {
            if (this.g != null) {
                GeoFence geoFence = (GeoFence) bundle.getParcelable("fc");
                if (this.g.contains(geoFence)) {
                    this.g.remove(geoFence);
                }
                if (this.g.size() <= 0) {
                    c();
                } else {
                    n();
                }
            }
        } catch (Throwable th) {
        }
    }

    final void i(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                int i = bundle.getInt(MyLocationStyle.ERROR_CODE);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("resultList");
                ArrayList arrayList = parcelableArrayList;
                if (parcelableArrayList == null) {
                    arrayList = new ArrayList();
                }
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String str = string;
                if (string == null) {
                    str = "";
                }
                if (this.e != null) {
                    this.e.onGeoFenceCreateFinished((ArrayList) arrayList.clone(), i, str);
                }
                if (i == 0) {
                    n();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultAddGeoFenceFinished");
            }
        }
    }

    public final boolean i() {
        return this.y;
    }

    final void j(Bundle bundle) {
        try {
            if (this.r != null) {
                long j = 2000;
                if (bundle != null) {
                    j = 2000;
                    if (!bundle.isEmpty()) {
                        j = bundle.getLong("interval", 2000L);
                    }
                }
                this.u.setOnceLocation(false);
                this.u.setInterval(j);
                this.r.setLocationOption(this.u);
                if (this.m) {
                    return;
                }
                this.r.stopLocation();
                this.r.startLocation();
                this.m = true;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doStartContinueLocation");
        }
    }
}
