package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/UTHybridHelper.class */
public class UTHybridHelper {

    /* renamed from: a  reason: collision with root package name */
    private static UTHybridHelper f27325a = new UTHybridHelper();

    private void a(Date date, Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        String b = b(map.get("urlpagename"), map.get("url"));
        if (b == null || TextUtils.isEmpty(b)) {
            i.a("h5Ctrl", new String[]{"pageName is null,return"});
            return;
        }
        String str = map.get("logkey");
        if (str == null || TextUtils.isEmpty(str)) {
            i.a("h5Ctrl", new String[]{"logkey is null,return"});
            return;
        }
        Map<String, String> map2 = null;
        String str2 = map.get("utjstype");
        map.remove("utjstype");
        if (str2 == null || str2.equals("0")) {
            map2 = e(map);
        } else if (str2.equals("1")) {
            map2 = f(map);
        }
        UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(b, 2101, str, null, null, map2);
        UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
        if (defaultTracker != null) {
            defaultTracker.send(uTOriginalCustomHitBuilder.build());
        } else {
            i.a("h5Ctrl event error", "Fatal Error,must call setRequestAuthentication method first.");
        }
    }

    private void a(Date date, Map<String, String> map, Object obj) {
        if (map == null || map.size() == 0) {
            return;
        }
        String b = b(map.get("urlpagename"), map.get("url"));
        if (b == null || TextUtils.isEmpty(b)) {
            i.a("h5Page", "pageName is null,return");
            return;
        }
        String refPage = UTMIVariables.getInstance().getRefPage();
        String str = map.get("utjstype");
        map.remove("utjstype");
        Map<String, String> c2 = (str == null || str.equals("0")) ? c(map) : str.equals("1") ? d(map) : null;
        int i = 2006;
        if (UTPageHitHelper.getInstance().m8287a(obj)) {
            i = 2001;
        }
        UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(b, i, refPage, null, null, c2);
        if (2001 == i) {
            UTMIVariables.getInstance().setRefPage(b);
        }
        Map<String, String> c3 = UTPageHitHelper.getInstance().c();
        if (c3 != null && c3.size() > 0) {
            uTOriginalCustomHitBuilder.setProperties(c3);
        }
        UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
        if (defaultTracker != null) {
            defaultTracker.send(uTOriginalCustomHitBuilder.build());
        } else {
            i.a("h5Page event error", "Fatal Error,must call setRequestAuthentication method first.");
        }
        UTPageHitHelper.getInstance().m8286a(obj);
    }

    private String b(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            int indexOf = str2.indexOf("?");
            return indexOf == -1 ? str2 : str2.substring(0, indexOf);
        }
        return str;
    }

    private Map<String, String> c(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("url");
        hashMap.put("_h5url", str == null ? "" : str);
        if (str != null) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("spm");
            if (queryParameter == null || TextUtils.isEmpty(queryParameter)) {
                hashMap.put("spm", "0.0.0.0");
            } else {
                hashMap.put("spm", queryParameter);
            }
            String queryParameter2 = parse.getQueryParameter("scm");
            if (queryParameter2 != null && !TextUtils.isEmpty(queryParameter2)) {
                hashMap.put("scm", queryParameter2);
            }
        } else {
            hashMap.put("spm", "0.0.0.0");
        }
        String str2 = map.get("spmcnt");
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        hashMap.put("_spmcnt", str3);
        String str4 = map.get("spmpre");
        String str5 = str4;
        if (str4 == null) {
            str5 = "";
        }
        hashMap.put("_spmpre", str5);
        String str6 = map.get("lzsid");
        String str7 = str6;
        if (str6 == null) {
            str7 = "";
        }
        hashMap.put("_lzsid", str7);
        String str8 = map.get("extendargs");
        String str9 = str8;
        if (str8 == null) {
            str9 = "";
        }
        hashMap.put("_h5ea", str9);
        String str10 = map.get("cna");
        if (str10 == null) {
            str10 = "";
        }
        hashMap.put("_cna", str10);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private Map<String, String> d(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("url");
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        hashMap.put("_h5url", str2);
        String str3 = map.get("extendargs");
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("_h5ea", str3);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private Map<String, String> e(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("logkeyargs");
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        hashMap.put("_lka", str2);
        String str3 = map.get("cna");
        String str4 = str3;
        if (str3 == null) {
            str4 = "";
        }
        hashMap.put("_cna", str4);
        String str5 = map.get("extendargs");
        if (str5 == null) {
            str5 = "";
        }
        hashMap.put("_h5ea", str5);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private Map<String, String> f(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("extendargs");
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        hashMap.put("_h5ea", str2);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    public static UTHybridHelper getInstance() {
        return f27325a;
    }

    public void h5UT(Map<String, String> map, Object obj) {
        if (map == null || map.size() == 0) {
            i.a("h5UT", "dataMap is empty");
            return;
        }
        String str = map.get("functype");
        if (str == null) {
            i.a("h5UT", "funcType is null");
            return;
        }
        String str2 = map.get("utjstype");
        if (str2 != null && !str2.equals("0") && !str2.equals("1")) {
            i.a("h5UT", "utjstype should be 1 or 0 or null");
            return;
        }
        map.remove("functype");
        Date date = new Date();
        if (str.equals("2001")) {
            a(date, map, obj);
        } else if (str.equals("2101")) {
            a(date, map);
        }
    }

    public void setH5Url(String str) {
        if (str != null) {
            UTMIVariables.getInstance().setH5Url(str);
        }
    }
}
