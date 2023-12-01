package com.kwad.components.offline.api.core.utils;

import android.text.TextUtils;
import com.igexin.push.core.b;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/utils/LiveStringUtil.class */
public class LiveStringUtil {
    public static String emptyIfNull(String str) {
        return str != null ? str : "";
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || b.l.equalsIgnoreCase(str);
    }
}
