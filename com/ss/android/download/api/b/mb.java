package com.ss.android.download.api.b;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.s;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.socialbase.appdownloader.u.hj;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/b/mb.class */
public class mb {
    public static boolean mb(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        return x.lz().optInt("market_url_opt", 1) == 0 ? "market".equals(scheme) : "market".equals(scheme) || s.Code.equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || BaseConstants.MARKET_SCHEME_SAMSUNG.equals(scheme);
    }

    public static String ox(Uri uri) {
        String scheme = uri.getScheme();
        List<String> pathSegments = uri.getPathSegments();
        return (x.lz().optInt("market_scheme_opt") == 1 && hj.u() && BaseConstants.MARKET_SCHEME_SAMSUNG.equals(scheme) && pathSegments != null && pathSegments.size() == 1) ? pathSegments.get(0) : ox.mb(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter("pkg"), uri.getQueryParameter("package_name"), uri.getQueryParameter("appId"));
    }
}
