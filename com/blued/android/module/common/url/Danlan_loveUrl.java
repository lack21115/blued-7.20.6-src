package com.blued.android.module.common.url;

import com.blued.android.framework.urlmanager.HostConfig;
import com.blued.android.framework.urlmanager.UrlFormatUtil;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/url/Danlan_loveUrl.class */
public final class Danlan_loveUrl {
    private static final String[] a = {"0/?src=4%s"};

    private static String a() {
        return HostConfig.a("DANLAN_LOVE") + "";
    }

    public static String a(int i) {
        return UrlFormatUtil.a(a[i], a(), new Object[0]);
    }
}
