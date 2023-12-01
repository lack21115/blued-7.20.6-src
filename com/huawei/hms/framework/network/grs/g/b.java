package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.tencent.mapsdk.internal.k2;
import org.json.JSONException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/g/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f9091a;
    private final GrsBaseInfo b;

    /* renamed from: c  reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.a f9092c;

    public b(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo) {
        this.f9091a = context;
        this.b = grsBaseInfo;
        this.f9092c = aVar;
    }

    public String a(boolean z) {
        String str;
        String str2 = com.huawei.hms.framework.network.grs.a.a(this.f9092c.a().a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        Logger.i("GeoipCountry", "geoIpCountry is: " + str2);
        String a2 = this.f9092c.a().a("geoipCountryCodetime", "0");
        long j = 0L;
        if (!TextUtils.isEmpty(a2)) {
            j = 0;
            if (a2.matches("\\d+")) {
                try {
                    j = Long.parseLong(a2);
                } catch (NumberFormatException e) {
                    Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e);
                    j = 0;
                }
            }
        }
        if (TextUtils.isEmpty(str2) || com.huawei.hms.framework.network.grs.h.e.a(Long.valueOf(j))) {
            com.huawei.hms.framework.network.grs.g.k.c cVar = new com.huawei.hms.framework.network.grs.g.k.c(this.b, this.f9091a);
            cVar.a("geoip.countrycode");
            com.huawei.hms.framework.network.grs.e.c c2 = this.f9092c.c();
            if (c2 != null) {
                try {
                    str = i.a(c2.a(k2.d, ""), cVar.c());
                } catch (JSONException e2) {
                    Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e2.getMessage()));
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    c2.b(k2.d, str);
                }
            }
            if (z) {
                d a3 = this.f9092c.b().a(cVar, "geoip.countrycode", c2);
                String str3 = str2;
                if (a3 != null) {
                    str3 = com.huawei.hms.framework.network.grs.a.a(a3.j(), "geoip.countrycode").get("ROOT");
                }
                Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + str3);
                return str3;
            }
            Logger.i("GeoipCountry", "async request to query geoip.countrycode");
            this.f9092c.b().a(cVar, null, "geoip.countrycode", c2);
        }
        return str2;
    }
}
