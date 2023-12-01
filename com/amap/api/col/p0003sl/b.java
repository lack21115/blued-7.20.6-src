package com.amap.api.col.p0003sl;

import android.content.Context;
import android.provider.Contacts;
import android.provider.SearchIndexablesContract;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.anythink.expressad.foundation.g.f.g.c;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.b  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    ju f4769a;

    public b(Context context) {
        this.f4769a = null;
        try {
            hu.a().a(context);
        } catch (Throwable th) {
        }
        this.f4769a = ju.a();
    }

    private String a(Context context, String str, Map<String, String> map) {
        try {
            HashMap hashMap = new HashMap(16);
            com.autonavi.aps.amapapi.trans.b bVar = new com.autonavi.aps.amapapi.trans.b();
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", c.f7906c);
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.1.0");
            String a2 = hr.a();
            String a3 = hr.a(context, a2, ib.b(map));
            map.put("ts", a2);
            map.put("scode", a3);
            bVar.b(map);
            bVar.a(hashMap);
            bVar.a(str);
            bVar.setProxy(hz.a(context));
            bVar.setConnectionTimeout(com.autonavi.aps.amapapi.utils.b.i);
            bVar.setSoTimeout(com.autonavi.aps.amapapi.utils.b.i);
            return new String(ju.a(bVar).f5264a, "utf-8");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Map<String, String> b(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", ho.f(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            hashMap.put("location", str6 + "," + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(DistrictSearchQuery.KEYWORDS_CITY, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("offset", str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("radius", str7);
        }
        return hashMap;
    }

    public final String a(Context context, String str, String str2) {
        Map<String, String> b = b(context, str2, null, null, null, null, null, null);
        b.put(Contacts.People.Extensions.CONTENT_DIRECTORY, "all");
        b.put("subdistrict", "0");
        return a(context, str, b);
    }

    public final String a(Context context, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> b = b(context, str2, str3, str4, str5, null, null, null);
        b.put("children", "1");
        b.put(WBPageConstants.ParamKey.PAGE, "1");
        b.put(Contacts.People.Extensions.CONTENT_DIRECTORY, "base");
        return a(context, str, b);
    }

    public final String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map<String, String> b = b(context, str2, str3, null, str4, str5, str6, str7);
        b.put("children", "1");
        b.put(WBPageConstants.ParamKey.PAGE, "1");
        b.put(Contacts.People.Extensions.CONTENT_DIRECTORY, "base");
        return a(context, str, b);
    }
}
