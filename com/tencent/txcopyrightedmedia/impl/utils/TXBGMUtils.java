package com.tencent.txcopyrightedmedia.impl.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/TXBGMUtils.class */
public class TXBGMUtils {
    private static String getMusicURI(String str) {
        int indexOf;
        int i;
        String str2;
        m a2 = m.a();
        synchronized (m.class) {
            try {
                a2.e.h();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str == null || TXCopyrightedMedia.instance().getApplicationContext() == null || ap.a().a(TXCopyrightedMedia.instance().getApplicationContext()) != 0 || (indexOf = str.indexOf("://")) == -1) {
            return null;
        }
        String substring = str.substring(indexOf + 3);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        String[] split = substring.split(ContainerUtils.FIELD_DELIMITER);
        int length = split.length;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String[] a3 = aj.a(split[i2]);
            int i4 = i3;
            String str5 = str3;
            String str6 = str4;
            if (a3 != null) {
                if ("audiotype".equalsIgnoreCase(a3[0])) {
                    try {
                        i4 = Integer.parseInt(a3[1]);
                        str5 = str3;
                        str6 = str4;
                    } catch (Exception e) {
                        e.printStackTrace();
                        i4 = i3;
                        str5 = str3;
                        str6 = str4;
                    }
                } else if ("musicid".equalsIgnoreCase(a3[0])) {
                    str5 = a3[1];
                    i4 = i3;
                    str6 = str4;
                } else {
                    i4 = i3;
                    str5 = str3;
                    str6 = str4;
                    if ("musicparams".equalsIgnoreCase(a3[0])) {
                        str6 = a3[1];
                        str5 = str3;
                        i4 = i3;
                    }
                }
            }
            i2++;
            i3 = i4;
            str3 = str5;
            str4 = str6;
        }
        if (i3 == 0) {
            str2 = "_0";
            i = 1;
        } else if (i3 != 1) {
            return null;
        } else {
            i = 2;
            str2 = "_1";
        }
        Uri.Builder buildUpon = Uri.parse("http://" + v.e + ":" + v.d).buildUpon();
        buildUpon.appendQueryParameter("mid", str3).appendQueryParameter("bt", String.valueOf(i)).appendQueryParameter("mep", str4).appendQueryParameter("aid", aj.c(TXCopyrightedMedia.instance().getApplicationContext()) + "_" + System.currentTimeMillis() + str2);
        return buildUpon.build().toString();
    }

    private static void uploadMusicPlayInfo(String str, String str2, long j) {
        ah.a().a(new bf(str, str2, j));
    }
}
