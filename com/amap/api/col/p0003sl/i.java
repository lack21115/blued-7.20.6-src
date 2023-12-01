package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.anythink.core.common.l;
import com.autonavi.aps.amapapi.utils.b;
import com.bytedance.applog.tracker.Tracker;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.i  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/i.class */
public final class i {

    /* renamed from: c  reason: collision with root package name */
    a f5130c;
    private Context d;
    private WebView f;

    /* renamed from: a  reason: collision with root package name */
    Object f5129a = new Object();
    private AMapLocationClient e = null;
    private String g = "AMap.Geolocation.cbk";
    AMapLocationClientOption b = null;
    private volatile boolean h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.i$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/i$a.class */
    public final class a implements AMapLocationListener {
        a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (i.this.h) {
                i.this.b(i.b(aMapLocation));
            }
        }
    }

    public i(Context context, WebView webView) {
        this.f = null;
        this.f5130c = null;
        this.d = context.getApplicationContext();
        this.f = webView;
        this.f5130c = new a();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c0 A[Catch: all -> 0x0114, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0114, blocks: (B:35:0x00b2, B:37:0x00c0, B:40:0x00da, B:43:0x00e5, B:45:0x00f0, B:38:0x00ce), top: B:58:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ce A[Catch: all -> 0x0114, TRY_ENTER, TryCatch #1 {all -> 0x0114, blocks: (B:35:0x00b2, B:37:0x00c0, B:40:0x00da, B:43:0x00e5, B:45:0x00f0, B:38:0x00ce), top: B:58:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0 A[Catch: all -> 0x0114, TRY_ENTER, TryCatch #1 {all -> 0x0114, blocks: (B:35:0x00b2, B:37:0x00c0, B:40:0x00da, B:43:0x00e5, B:45:0x00f0, B:38:0x00ce), top: B:58:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x010d -> B:58:0x00b2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.i.a(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(AMapLocation aMapLocation) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (aMapLocation == null) {
                jSONObject.put("errorCode", -1);
                jSONObject.put(MyLocationStyle.ERROR_INFO, "unknownError");
            } else if (aMapLocation.getErrorCode() == 0) {
                jSONObject.put("errorCode", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", aMapLocation.getLongitude());
                jSONObject2.put("y", aMapLocation.getLatitude());
                jSONObject2.put(l.P, aMapLocation.getAccuracy());
                jSONObject2.put("type", aMapLocation.getLocationType());
                jSONObject2.put("country", aMapLocation.getCountry());
                jSONObject2.put(DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince());
                jSONObject2.put(DistrictSearchQuery.KEYWORDS_CITY, aMapLocation.getCity());
                jSONObject2.put("cityCode", aMapLocation.getCityCode());
                jSONObject2.put(DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict());
                jSONObject2.put("adCode", aMapLocation.getAdCode());
                jSONObject2.put("street", aMapLocation.getStreet());
                jSONObject2.put("streetNum", aMapLocation.getStreetNum());
                jSONObject2.put("floor", aMapLocation.getFloor());
                jSONObject2.put("address", aMapLocation.getAddress());
                jSONObject.put("result", jSONObject2);
            } else {
                jSONObject.put("errorCode", aMapLocation.getErrorCode());
                jSONObject.put(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo());
                jSONObject.put("locationDetail", aMapLocation.getLocationDetail());
            }
        } catch (Throwable th) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str) {
        try {
            if (this.f != null) {
                if (Build.VERSION.SDK_INT < 19) {
                    this.f.post(new Runnable() { // from class: com.amap.api.col.3sl.i.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            WebView webView = i.this.f;
                            Tracker.loadUrl(webView, "javascript:" + i.this.g + "('" + str + "')");
                        }
                    });
                    return;
                }
                WebView webView = this.f;
                webView.evaluateJavascript("javascript:" + this.g + "('" + str + "')", new ValueCallback<String>() { // from class: com.amap.api.col.3sl.i.1
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
        } catch (Throwable th) {
            b.a(th, "H5LocationClient", "callbackJs()");
        }
    }

    public final void a() {
        if (this.f == null || this.d == null || Build.VERSION.SDK_INT < 17 || this.h) {
            return;
        }
        try {
            this.f.getSettings().setJavaScriptEnabled(true);
            this.f.addJavascriptInterface(this, "AMapAndroidLoc");
            if (!TextUtils.isEmpty(this.f.getUrl())) {
                this.f.reload();
            }
            if (this.e == null) {
                AMapLocationClient aMapLocationClient = new AMapLocationClient(this.d);
                this.e = aMapLocationClient;
                aMapLocationClient.setLocationListener(this.f5130c);
            }
            this.h = true;
        } catch (Throwable th) {
        }
    }

    public final void b() {
        synchronized (this.f5129a) {
            this.h = false;
            if (this.e != null) {
                this.e.unRegisterLocationListener(this.f5130c);
                this.e.stopLocation();
                this.e.onDestroy();
                this.e = null;
            }
            this.b = null;
        }
    }

    @JavascriptInterface
    public final void getLocation(String str) {
        synchronized (this.f5129a) {
            if (this.h) {
                a(str);
                if (this.e != null) {
                    this.e.setLocationOption(this.b);
                    this.e.stopLocation();
                    this.e.startLocation();
                }
            }
        }
    }

    @JavascriptInterface
    public final void stopLocation() {
        AMapLocationClient aMapLocationClient;
        if (this.h && (aMapLocationClient = this.e) != null) {
            aMapLocationClient.stopLocation();
        }
    }
}
